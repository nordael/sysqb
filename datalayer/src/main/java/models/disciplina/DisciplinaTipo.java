package models.disciplina;

public enum DisciplinaTipo {
    ELETIVA("eletiva"),
    OBRIGATORIA("obrigatoria"),
    OPTATIVA("optativa"),
    ESTAGIO("estagio curricular"),
    NONE("");

    private String tipo;

    DisciplinaTipo(String value){
        this.tipo = value;
    }

    public String getTipo() {
        return tipo;
    }

    public static DisciplinaTipo fromString(String tipo){
        for(DisciplinaTipo disciplinaTipo : DisciplinaTipo.values()){
            if(disciplinaTipo.getTipo().equalsIgnoreCase(tipo)){
                return disciplinaTipo;
            }
        }
        return NONE;
    }
}
