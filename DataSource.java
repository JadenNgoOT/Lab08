package Labs.Lab08;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;


public class DataSource {
    public static ObservableList<StudentRecord> marks= FXCollections.observableArrayList();

    public static void initList() {
        marks.add(new StudentRecord("100100100", 75.0f, 68.0f, 54.25f));
        marks.add(new StudentRecord("100100101", 70.0f, 69.25f, 51.5f));
        marks.add(new StudentRecord("100100102", 100.0f, 97.0f, 92.5f));
        marks.add(new StudentRecord("100100103", 90.0f, 88.5f, 68.75f));
        marks.add(new StudentRecord("100100104", 72.25f, 74.75f, 58.25f));
        marks.add(new StudentRecord("100100105", 85.0f, 56.0f, 62.5f));
        marks.add(new StudentRecord("100100106", 70.0f, 66.5f, 61.75f));
        marks.add(new StudentRecord("100100107", 55.0f, 47.0f, 50.5f));
        marks.add(new StudentRecord("100100108", 40.0f, 32.5f, 27.75f));
        marks.add(new StudentRecord("100100109", 82.5f, 77.0f, 74.25f));
    }
    public static ObservableList<StudentRecord> getAllMarks() {
        return marks;
    }

    public static TableColumn<StudentRecord, String> getIDColumn(){
        TableColumn<StudentRecord, String> IDCol = new TableColumn<>("Student ID");
        PropertyValueFactory<StudentRecord, String> idCellValueFactory = new PropertyValueFactory<>("studentID");
        IDCol.setCellValueFactory(idCellValueFactory);
        return IDCol;
    }

    public static TableColumn<StudentRecord, Float> getAssignmentColumn(){
        TableColumn<StudentRecord, Float> assignmentCol = new TableColumn<>("Assignment Mark");
        PropertyValueFactory<StudentRecord, Float> assignmentCellValueFactory = new PropertyValueFactory<>("assignmentMark");
        assignmentCol.setCellValueFactory(assignmentCellValueFactory);
        return assignmentCol;
    }

    public static TableColumn<StudentRecord, Float> getMidtermColumn(){
        TableColumn<StudentRecord, Float> midtermCol = new TableColumn<>("Midterm Mark");
        PropertyValueFactory<StudentRecord, Float> midtermCellValueFactory = new PropertyValueFactory<>("midtermMark");
        midtermCol.setCellValueFactory(midtermCellValueFactory);
        return midtermCol;
    }

    public static TableColumn<StudentRecord, Float> getFinalExamColumn(){
        TableColumn<StudentRecord, Float> finalExamCol = new TableColumn<>("Final Exam Mark");
        PropertyValueFactory<StudentRecord, Float> finalCellValueFactory = new PropertyValueFactory<>("finalExamMark");
        finalExamCol.setCellValueFactory(finalCellValueFactory);
        return finalExamCol;
    }

    public static TableColumn<StudentRecord, Double> getFinalColumn(){
        TableColumn<StudentRecord, Double> finalCol = new TableColumn<>("Final Mark");
        PropertyValueFactory<StudentRecord, Double> finalCellValueFactory = new PropertyValueFactory<>("finalMark");
        finalCol.setCellValueFactory(finalCellValueFactory);
        return finalCol;
    }

    public static TableColumn<StudentRecord, String> getLetterColumn(){
        TableColumn<StudentRecord, String> letterCol = new TableColumn<>("Letter Grade");
        PropertyValueFactory<StudentRecord, String> finalCellValueFactory = new PropertyValueFactory<>("LetterGrade");
        letterCol.setCellValueFactory(finalCellValueFactory);
        return letterCol;
    }
}
