package thiago.ppt.logica;

public class IA extends Usuario implements Juego{
    private int eleccionRandom;

    public IA(int estrellas, int eleccionJuego, String apodo, Carta[] cartas, int eleccionRandom) {
        super(estrellas, eleccionJuego, apodo, cartas);
        this.eleccionRandom = eleccionRandom;
    }

    public IA() {
        super();
    }

    public int getEleccionRandom() {
        return eleccionRandom;
    }

    public void setEleccionRandom(int eleccionRandom) {
        this.eleccionRandom = eleccionRandom;
    }
}
