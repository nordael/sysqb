package models.disciplina;

public enum GradeType{
    GRADE2011("2011"),
    GRADE2019("2019"),
    NONE("");

    private String grade;

    GradeType(String grade){
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public static GradeType fromString(String grade){
        for(GradeType gradeType : GradeType.values()){
            if(gradeType.getGrade().equalsIgnoreCase(grade)){
                return gradeType;
            }
        }
        return NONE;
    }

}
