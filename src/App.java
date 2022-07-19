import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Enum.ResultadoEnum;
import Model.Classificacao;
import Model.Partida;
import Model.Selecao;

public class App {

    private static List<String> resultadosPartidas = new ArrayList<>();
    private static List<Classificacao> resultadosTabela = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Mock();

        for (String partidas : resultadosPartidas) {
            var resultados = partidas.split(":");
            var partida = new Partida(resultados);
            addClassificacaoTabela(partida.getSelecao1());
            addClassificacaoTabela(partida.getSelecao2());
        }

        Collections.sort(resultadosTabela,
                Comparator.comparing(Classificacao::getPontuacao)
                        .thenComparing(Classificacao::getSaldoDeGols)
                        .reversed());

        for (Classificacao classificacao : resultadosTabela) {
            System.out.print(classificacao.getSelecao() + " ");
            System.out.print(classificacao.getVitorias() + " ");
            System.out.print(classificacao.getPontuacao() + " ");
            System.out.print(classificacao.getSaldoDeGols() + " ");
            System.out.println();
        }

    }

    private static void addClassificacaoTabela(Selecao selecao) {
        var classificacao = hasSelecao(selecao);
        var selecaoGanhou = selecao.getResultado().equals(ResultadoEnum.VITORIA);

        var vitorias = selecaoGanhou ? 1 : 0;
        var pontos = selecao.getPontos();
        var saldoDeGols = selecao.getSaldoDeGols();

        if (classificacao == null) {

            resultadosTabela.add(new Classificacao(selecao.getNome(), vitorias, pontos, saldoDeGols));
            return;
        }

        classificacao.setVitorias(classificacao.getVitorias() + vitorias);
        classificacao.setPontuacao(classificacao.getPontuacao() + pontos);
        classificacao.setSaldoDeGols(classificacao.getSaldoDeGols() + saldoDeGols);
    }

    private static Classificacao hasSelecao(Selecao selecao) {
        return resultadosTabela.stream()
                .filter(resultado -> resultado.getSelecao().equals(selecao.getNome()))
                .findFirst()
                .orElse(null);
    }

    private static void Mock() {
        resultadosPartidas.add("brasil_3:croacia_1");
        resultadosPartidas.add("mexico_1:camaroes_0");
        resultadosPartidas.add("brasil_0:mexico_0");
        resultadosPartidas.add("camaroes_0:croacia_4");
        resultadosPartidas.add("croacia_1:mexico_3");
        resultadosPartidas.add("camaroes_1:brasil_4");
    }

}
