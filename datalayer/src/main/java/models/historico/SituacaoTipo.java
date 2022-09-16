package models.historico;

public enum SituacaoTipo {
    APROVADO("aprovado"),
    REPNOTA("reprovado por nota"),
    REPFREQ("reprovado por frequência"),
    MATRICULA("matrícula"),
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
            if(situacaoTipo.getSituacao().equalsIgnoreCase(situacao)){
                return situacaoTipo;
            }
        }
        return NONE;
    }

}
