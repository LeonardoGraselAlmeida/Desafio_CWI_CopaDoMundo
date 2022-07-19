package Enum;

public enum ResultadoEnum {

    VITORIA(3),
    EMPATE(1),
    DERROTA(0);

    private int pontos;

    ResultadoEnum(int pontos) {
        this.pontos = pontos;
    }

    public int getPontos() {
        return this.pontos;
    }
}
