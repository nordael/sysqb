package models.formulario;

public class DadoAlunoModel {
   private String nome;
   private String email;
   private String grr;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getName() {
        return nome;
    }
    
    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setGrr(String grr) {
        this.grr = grr;
    }

    public String getGrr(){
        return grr;
    }

    
}