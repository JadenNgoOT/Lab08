package Labs.Lab08;

import javafx.application.Application;
import javafx.stage.Stage;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws InterruptedException, IOException, ParserConfigurationException, SAXException {
        MainView mainView = new MainView(primaryStage);
        mainView.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}