package Labs.Lab08;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class MainView {

    private Stage stage;
    private static Scene mainScene;
    private static GridPane root;
    private Button fileButton;
    private  TableView<StudentRecord> table;
    FileChooser fil_chooser = new FileChooser();

    private Scene fileScene;
    private GridPane fileGrid;
    private Button backButton;
    private Button newButton;
    private Button openButton;
    private Button saveButton;
    private Button saveAsButton;
    private Button exitButton;

    String currentFileName;

    public MainView(Stage primaryStage) throws IOException, SAXException, ParserConfigurationException {
        stage = primaryStage;
        root = new GridPane();
        DataSource.initList();

        currentFileName ="C:\\Users\\jaden\\IdeaProjects\\CSCI2020U\\src\\main\\java\\Labs\\Lab08\\studentRecord.csv";

        //Main Scene
        fileButton = new Button("File");
        root.add(fileButton, 0, 0);
        fileButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(fileScene);
            }
        });

        makeTable();

        //File scene
        fileGrid = new GridPane();

        //Back
        backButton = new Button("Back");
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(mainScene);
            }
        });

        //New
        newButton = new Button("New");
        newButton.setOnAction(e -> table.getItems().clear());

        //Open
        openButton = new Button("Open");
        openButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File file = fil_chooser.showOpenDialog(stage);
                try {
                    fileMethods.load(file.getAbsolutePath());
                    currentFileName = file.getAbsolutePath();
                    table.getItems().clear();
                    makeTable();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //Save
        saveButton = new Button("Save");
        saveButton.setOnAction(e-> {
            try {
                fileMethods.save(currentFileName);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        //Save As
        saveAsButton = new Button("Save As");
        saveAsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File file = fil_chooser.showSaveDialog(stage);
                currentFileName = file.getAbsolutePath();
                try {
                    fileMethods.save(file.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //Exit
        exitButton = new Button("Exit");
        exitButton.setOnAction(e->stage.close());

        //Buttons
        fileGrid.addRow(0, backButton);
        fileGrid.addRow(1, newButton);
        fileGrid.addRow(2, openButton);
        fileGrid.addRow(3, saveButton);
        fileGrid.addRow(4, saveAsButton);
        fileGrid.addRow(5, exitButton);

        fileScene = new Scene(fileGrid, 100, 200);
        stage.setScene(mainScene);
        stage.setTitle("A simple TableView Example");

    }

    public void makeTable(){
        table = new TableView<>();
        table.getItems().addAll(DataSource.getAllMarks());
        table.getColumns().addAll(DataSource.getIDColumn(), DataSource.getAssignmentColumn(), DataSource.getMidtermColumn(), DataSource.getFinalExamColumn(), DataSource.getFinalColumn(), DataSource.getLetterColumn());
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPlaceholder(new Label("No visible columns and/or data exist."));
        root.add(table, 0 , 1);
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        mainScene = new Scene(root, 515, 500);
    }

    public void show() {
        this.stage.show();
    }


}