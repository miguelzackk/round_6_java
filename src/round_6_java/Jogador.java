package round_6_java;

public class Jogador {
    private int numJogador;
    private boolean status = true;

    public int getNumJogador() {
        return numJogador;
    }

    public void setNumJogador(int numJogador) {
        this.numJogador = numJogador;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean statusVivo) {
        this.status = statusVivo;
    }
}
