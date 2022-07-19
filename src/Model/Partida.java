package Model;

import Enum.ResultadoEnum;

public class Partida {
    private Selecao selecao1;
    private Selecao selecao2;

    public Partida(String[] selecoesJSON) {
        setSelecoes(selecoesJSON);
        setResultado();
        setSaldosGols();
    }

    private void setSelecoes(String[] selecoesJSON) {
        this.selecao1 = new Selecao(selecoesJSON[0]);
        this.selecao2 = new Selecao(selecoesJSON[1]);
    }

    private void setSaldosGols() {
        var selecao1Gols = selecao1.getGols();
        var selecao2Gols = selecao2.getGols();

        selecao1.setSaldoDeGols(selecao1Gols - selecao2Gols);
        selecao2.setSaldoDeGols(selecao2Gols - selecao1Gols);
    }

    private void setResultado() {
        var selecao1Gols = selecao1.getGols();
        var selecao2Gols = selecao2.getGols();

        if (selecao1Gols > selecao2Gols) {
            selecao1.setResultado(ResultadoEnum.VITORIA);
            selecao2.setResultado(ResultadoEnum.DERROTA);
        } else if (selecao2Gols > selecao1Gols) {
            selecao2.setResultado(ResultadoEnum.VITORIA);
            selecao1.setResultado(ResultadoEnum.DERROTA);
        } else {
            selecao2.setResultado(ResultadoEnum.EMPATE);
            selecao1.setResultado(ResultadoEnum.EMPATE);
        }
    }

    public Selecao getSelecao1() {
        return selecao1;
    }

    public Selecao getSelecao2() {
        return selecao2;
    }
}
