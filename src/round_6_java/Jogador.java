package round_6_java;

public class Jogador {
    private int idJogador;
    private boolean status = true;
    private double valorDivida;

    public Jogador() {}

    public Jogador(int id) {
        this.idJogador = id;
    }

    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(double valorDivida) {
        this.valorDivida = valorDivida;
    }

    public boolean menuJogador(java.util.Scanner sc) {
        System.out.println("Você foi convidado a ser jogador!");
        System.out.print("Informe a quantia de sua dívida\nR$: ");
        valorDivida = sc.nextDouble();
        sc.nextLine();

        if (valorDivida <= 1000) {
            System.out.println("Quantia muito baixa.\nVocê não jogará. Boa sorte!");
            return false;
        } else {
            System.out.print("O quão desesperado você está?\n[1 - 5]: ");
            int nivelDesespero = sc.nextInt();
            sc.nextLine();

            if (nivelDesespero < 3) {
                System.out.println("Você não participará do jogo.");
                return false;
            } else {
                System.out.println("\n>> REGRAS\nAo entrar no jogo:\nSe perder, será eliminado.\nPoderá sair através de interrupção voluntária.");
                System.out.println("\n>> PRÊMIO\nR$1.000.000.");
                System.out.print("\nGostaria de participar como jogador? [S/N]: ");
                String resp = sc.nextLine().toLowerCase();
                return resp.equals("s");
            }
        }
    }
}
