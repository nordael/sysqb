package models.aluno;
public enum Situacao {
    APROVADO("aprovado"),
    REPROVADO("reprovado"),
    REPROVADO_FALTA("falta"),
    NONE("");

    private String situacao;

    Situacao(String situacao){
        this.situacao = situacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public static Situacao fromString(String situacao){
        for(Situacao situacaoAluno : Situacao.values()){
            if(situacaoAluno.getSituacao().equalsIgnoreCase(situacao)){
                return situacaoAluno;
            }
        }
        return NONE;
    }
}
