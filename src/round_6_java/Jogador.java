package round_6_java;
import java.util.*;
public class Jogador {
    private int numJogador;
    private boolean status = true;
    private double valorDivida;
    private int idJogador;

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
    
    
    public double getValorDivida() {
		return valorDivida;
	}

	public void setValorDivida(double valorDivida) {
		this.valorDivida = valorDivida;
	}

	public int getIdJogador() {
		return idJogador;
	}

	public void setIdJogador(int idJogador) {
		this.idJogador = idJogador;
	}

	public boolean menuJogador(Scanner sc) {
        System.out.println("Você foi convidado a ser jogador!");
        System.out.print("Informe a quantia de sua divida\nR$: ");
        valorDivida = sc.nextDouble();
        sc.nextLine(); 

        if (valorDivida <= 1000) {
            System.out.println("Quantia muito baixa.\nVocê está fora do perfil de jogador\n>> Você não jogará. Boa sorte!");
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
                
                while (true) {
                    String participacaoJogador = sc.nextLine().toLowerCase();
                    
                    switch (participacaoJogador) {
                        case "s":
                            Random rdm = new Random();
                            idJogador = rdm.nextInt(456) + 1;
                            System.out.printf("Você é o jogador %d. Boa sorte!%n", idJogador);
                            return true;
                        case "n":
                            System.out.println("Você não participará do jogo.\nAté mais.");
                            return false;
                        default:
                            System.out.println("Opção inválida! Digite S - Sim ou N - Não:");
                            System.out.print("Gostaria de participar como jogador? [S/N]: ");
                            break;
                    }
                }
            }
        }
    }
    
}
