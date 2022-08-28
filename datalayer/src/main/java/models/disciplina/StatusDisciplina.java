package models.disciplina;

public enum StatusDisciplina {
    ATIVA("ativa"),
    INATIVA("inativa"),
    NONE("");

    private String status;

    StatusDisciplina(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static StatusDisciplina fromString(String status){
        for(StatusDisciplina statusDisciplina : StatusDisciplina.values()){
            if(statusDisciplina.getStatus().equalsIgnoreCase(status)){
                return statusDisciplina;
            }
        }
        return NONE;
    }
}
