package models.curso;

public class CursoModel {
    private String codigo;
    private String nomeCurso;
    private String description;

    public CursoModel() {
        codigo = "";
        nomeCurso = "";
        description = "";
    }

    public String getCodigo(){
        return  codigo;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public String getDescription() {
        return description;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
