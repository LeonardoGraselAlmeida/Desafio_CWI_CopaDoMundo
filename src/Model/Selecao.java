package Model;

import Enum.ResultadoEnum;

public class Selecao {
    private String nome;
    private int gols;
    private int saldoDeGols;
    private ResultadoEnum resultado;

    public Selecao(String json) {
        var selecao = json.split("_");
        var str = selecao[0];
        this.nome = str.substring(0, 1).toUpperCase() + str.substring(1);
        this.gols = Integer.parseInt(selecao[1]);
    }

    public String getNome() {
        return nome;
    }

    public int getGols() {
        return gols;
    }

    public int getSaldoDeGols() {
        return saldoDeGols;
    }

    public void setSaldoDeGols(int saldoDeGols) {
        this.saldoDeGols = saldoDeGols;
    }

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public int getPontos() {
        return this.resultado.getPontos();
    }
}
