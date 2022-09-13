package models.historico;

public enum SemestreTipo {
    SEMESTRE1("1o Semestre"),
    SEMESTRE2("2o Semestre"),
    NONE("");

    private String semestre;

    SemestreTipo(String semestre){
        this.semestre = semestre;
    }

    public String getSemestre() {
        return semestre;
    }

    public static SemestreTipo fromString(String grade){
        for(SemestreTipo gradeType : SemestreTipo.values()){
            if(gradeType.getSemestre().equalsIgnoreCase(grade)){
                return gradeType;
            }
        }
        return NONE;
    }

}
