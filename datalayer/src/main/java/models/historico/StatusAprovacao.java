package models.historico;

public enum StatusAprovacao {
    APROVADO("Aprovado"),
    MATRICULA("Matrícula"),
    NONE("");

    private String status;

    StatusAprovacao(String status){
        this.status = status;
    }

    public String getStatusAprovacao() {
        return status;
    }

    public static StatusAprovacao fromString(String status){

        for(StatusAprovacao statusAprovacao : StatusAprovacao.values()){
            if(statusAprovacao.getStatusAprovacao().equals(status)){
                return statusAprovacao;
            }
        }
        return NONE;
    }
}
