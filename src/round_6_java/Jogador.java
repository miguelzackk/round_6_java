package round_6_java;

import java.util.*;

public class Jogador {

	private int numJogador;
	private boolean status = true;
	private double valorDivida;
	private int idJogador;
	protected static Jogador[] jogadores = new Jogador[457];

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

	public void startJogador() {
		for (int i = 1; i < 457; i++) {
			jogadores[i] = new Jogador();
			jogadores[i].setNumJogador(i);
			jogadores[i].setStatus(true);
		}
	}

	
	//vai para jogo
	public void menuJogador(Scanner sc) {
		System.out.println("Você foi convidado a ser jogador!");
		System.out.print("Informe a quantia de sua divida\nR$: ");
		valorDivida = sc.nextDouble();
		sc.nextLine();

		if (valorDivida <= 1000) {
			System.out.println(
					"Quantia muito baixa.\nVocê está fora do perfil de jogador\n>> Você não jogará. Boa sorte!");
			
		} else {
			System.out.print("O quão desesperado você está?\n[1 - 5]: ");
			int nivelDesespero = sc.nextInt();
			sc.nextLine();

			if (nivelDesespero < 3) {
				System.out.println("Você não participará do jogo.");
				
			} else {
				System.out.println(
						"\n>> REGRAS\nAo entrar no jogo:\nSe perder, será eliminado.\nPoderá sair através de interrupção voluntária.");
				System.out.println("\n>> PRÊMIO\nR$1.000.000.");
				
				
			}
		}
	}
}