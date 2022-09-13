package models.historico;

public enum SituacaoTipo {
    APROVADO("Aprovado"),
    REPNOTA("Reprovado por nota"),
    REPFREQ("Reprovado por frequência"),
    MATRICULA("Matrícula"),
    NONE("");

    private String situacao;

    SituacaoTipo(String situacao){
        this.situacao = situacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public static SituacaoTipo fromString(String situacao){

        for(SituacaoTipo situacaoTipo : SituacaoTipo.values()){
            if(situacaoTipo.getSituacao().equals(situacao)){
                return situacaoTipo;
            }
        }
        return NONE;
    }

}
