package Model;

public class Classificacao {

    private String selecao;
    private int vitorias;
    private int pontuacao;
    private int saldoDeGols;

    public Classificacao(String selecao, int vitorias, int pontuacao, int saldoDeGols) {
        this.selecao = selecao;
        this.vitorias = vitorias;
        this.pontuacao = pontuacao;
        this.saldoDeGols = saldoDeGols;
    }

    public void setSelecao(String selecao) {
        this.selecao = selecao;
    }

    public String getSelecao() {
        return selecao;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setSaldoDeGols(int saldoDeGols) {
        this.saldoDeGols = saldoDeGols;
    }

    public int getSaldoDeGols() {
        return saldoDeGols;
    }
}
