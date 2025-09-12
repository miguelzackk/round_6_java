package round_6_java;

import java.util.Random;
import java.util.Scanner;

public class Jogador {

	Random rdm = new Random();
	private int numJogador;
	private boolean status = true;
	protected double valorDivida;
	private int idJogador = rdm.nextInt(456) + 1;
	protected static Jogador[] jogadores = new Jogador[457];
	private static final double premioTotal = 1000000.0;
	private Jogo jogo;

	private static final Random random = new Random();
	private boolean saiuPorVotacao = false;

	public Jogador(Jogo jogo) {
		this.jogo = jogo;
	}

	public Jogador() {
	}

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

	public void menuJogador(Scanner sc) {
		System.out.println("\nVocê foi convidado a ser jogador!");
		System.out.print("Informe a quantia de sua divida\nR$: ");
		valorDivida = sc.nextDouble();
		sc.nextLine();

		if (valorDivida <= 100) {
			System.out.println(
					"Quantia muito baixa.\nVocê está fora do perfil de jogador\n>> Você não jogará. Boa sorte!");
		} else {

			System.out.printf("Você é o jogador %d. Boa sorte!%n", getIdJogador());
		}
		startJogador();
		iniciarJogoComoJogador(sc);

	}

	private void iniciarJogoComoJogador(Scanner sc) {
		while (jogo.diaAtual <= 6 && status) {
			String nomeJogo = jogo.getNomeJogo(jogo.diaAtual);
			int vivosRestantes = jogo.contarVivos();
			double premioIndividual = premioTotal / vivosRestantes;

			System.out.printf("\n   -- DIA %d --    %n○ △ □ %s ○ △ □", jogo.diaAtual, nomeJogo.toUpperCase());
			System.out.printf("\nJogadores restantes: " + vivosRestantes + "\nPremio individual: R$%.2f \n",
					premioIndividual);

			System.out.println("O que deseja fazer?");
			System.out.println("1 - Jogar o jogo do dia");
			System.out.println("2 - Iniciar Votação para sair");
			System.out.println("3 - Ver jogadores vivos");

			int opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				jogarJogoDoDia(sc, premioIndividual);
				break;

			case 2:
				iniciarVotacaoSair(sc, premioIndividual);
				break;

			case 3:
				jogo.listarVivos();
				break;

			default:
				System.out.println("Opção inválida!");
			}

			if (!status) {
				if (!saiuPorVotacao) {
					System.out.println("\nVocê foi eliminado.\nFim de jogo.\n○ △ □      ○ △ □     ○ △ □   ○ △ ");
				}
				return;
			}
		}
	}

	private void jogarJogoDoDia(Scanner sc, double premioIndividual) {
		int eliminacoes = jogo.getEliminacoesDia(jogo.diaAtual);

		System.out.println("\n" + eliminacoes + " jogadores foram eliminados.");

		if (jogo.diaAtual == 6) {
			Random rnd = new Random();
			int ultimoEscolhido;

			do {
				ultimoEscolhido = rnd.nextInt(456) + 1;

			} while (!jogadores[ultimoEscolhido].isStatus() || ultimoEscolhido == idJogador);
			System.out.println();
			jogadores[ultimoEscolhido].setStatus(false);
			System.out.println("O jogador " + ultimoEscolhido + " foi eliminado no jogo final!");
			System.out.println("O ganhador foi o N° " + jogo.listarVivos()
					+ "\nPrêmio total de: R$ 1.000.000\n○ △ □      ○ △ □     ○ △ □   ○ △");
		} else {

			Random rand = new Random();
			int eliminados = 0;

			while (eliminados < eliminacoes) {
				int escolhido = rand.nextInt(456) + 1;
				if (jogadores[escolhido].isStatus()) {
					jogadores[escolhido].setStatus(false);
					eliminados++;

					if (escolhido == idJogador) {
						status = false;
						return;
					}
				}
			}

		}

		System.out.println("Você sobreviveu ao jogo de hoje!");
		jogo.diaAtual++;
	}

	private void iniciarVotacaoSair(Scanner sc, double premioIndividual) {
		System.out.println("Você escolheu sair da competição.");
		System.out.println("Tem certeza?");
		System.out.println("1 - Sim, quero sair   2 - Não, quero continuar");
		int continua = sc.nextInt();

		boolean maioriaContinua = random.nextBoolean();

		System.out.println("\n--- Resultado da votação ---");

		if (maioriaContinua) {
			System.out.println("A maioria decidiu que todos vão CONTINUAR!");
			System.out.println("Você permanece na competição. Boa sorte!");
			jogarJogoDoDia(sc, premioIndividual);
		} else {
			status = false;
			saiuPorVotacao = true;
			System.out.printf(
					"A maioria decidiu que todos devem SAIR!\nVocê abandonou a competição!\nPrêmio final de: R$%.2f",
					premioIndividual);
		}
	}

}