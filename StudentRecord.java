package Labs.Lab08;

public class StudentRecord {
    private String studentID;
    private Float assignmentMark;
    private Float midtermMark;
    private Float finalExamMark;

    public StudentRecord(String studentID, Float assignmentMark, Float midtermMark, Float finalExamMark){
        super();
        this.studentID = studentID;
        this.assignmentMark = assignmentMark;
        this.midtermMark = midtermMark;
        this.finalExamMark = finalExamMark;
    }

    public String getStudentID(){
        return studentID;
    }

    public float getAssignmentMark(){
        return assignmentMark;
    }

    public float getMidtermMark() {
        return midtermMark;
    }

    public float getFinalExamMark() {
        return finalExamMark;
    }

    public double getFinalMark(){
        double finalMark = (assignmentMark*.2) + (midtermMark*.3) + (finalExamMark*.5);
        return finalMark;
    }

    public String getLetterGrade(){
        if(getFinalMark() < 49){
            return "F";
        }
        else if(getFinalMark() < 59){
            return "D";
        }
        else if(getFinalMark() < 69){
            return "C";
        }
        else if(getFinalMark() < 79){
            return "B";
        }
        else if(getFinalMark() < 100){
            return "A";
        }

        return "E";
    }
}
