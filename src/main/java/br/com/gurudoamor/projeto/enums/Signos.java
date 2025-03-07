package br.com.gurudoamor.projeto.enums;

public enum Signos {
    ARIES("Fogo"), TOURO("Terra"), GEMEOS("Ar"), CANCER("Água"),
    LEAO("Fogo"), VIRGEM("Terra"), LIBRA("Ar"), ESCORPIAO("Água"),
    SAGITARIO("Fogo"), CAPRICORNIO("Terra"), AQUARIO("Ar"), PEIXES("Água");

    private final String elemento;

    Signos(String elemento) {
        this.elemento = elemento;
    }

    public String getElemento() {
        return elemento;
    }
}
