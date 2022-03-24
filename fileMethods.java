package Labs.Lab08;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;

public class fileMethods {
    static int recordSize = DataSource.getAllMarks().size();

    public static void save(String fileName) throws IOException {
        File file = new File(fileName);
        if(file.createNewFile()){
            System.out.println("File Created: " + fileName);
        }
        FileWriter outputFile = new FileWriter(file);
        for(int i = 0; i < recordSize; i++){
            outputFile.write(DataSource.getAllMarks().get(i).getStudentID()+","+
                            DataSource.getAllMarks().get(i).getAssignmentMark()+","+
                            DataSource.getAllMarks().get(i).getMidtermMark()+","+
                            DataSource.getAllMarks().get(i).getFinalExamMark()+"\n");
        }
        outputFile.close();
        System.out.println("Successfully wrote to the file.");
    }

    public static void load(String fileName) throws IOException {
        System.out.println("Load Succsessful");
        String line = "";
        String splitBy = ",";

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        DataSource.marks.clear();
        while ((line = br.readLine()) != null)   //returns a Boolean value
        {
            String[] student = line.split(splitBy);    // use comma as separator
            DataSource.marks.add(new StudentRecord(student[0], Float.parseFloat(student[1]), Float.parseFloat(student[2]), Float.parseFloat(student[3])));
        }

    }


}
