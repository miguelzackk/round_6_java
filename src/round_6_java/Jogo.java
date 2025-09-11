package round_6_java;

import java.util.Random;
import java.util.Scanner;

public class Jogo extends Jogador {
	protected int diaAtual = 1;

	public int listarVivos() {
		System.out.println("\nJogadores ainda vivos:");
		int count = 0;
		for (int i = 1; i < 457; i++) {
			if (jogadores[i].isStatus()) {
				System.out.printf("%-10s", i);
				count++;
				if (count % 5 == 0) {
					System.out.println();
				}
			}
		}
		return count;
	}

	public int contarVivos() {
		int count = 0;
		for (int i = 1; i < 457; i++) {
			if (jogadores[i].isStatus()) {
				count++;
			}
		}
		return count;
	}

	public void jogarDiaVip(Vip vip, Scanner sc, int eliminacoes, String nomeJogo) {
		System.out.println("O jogo do dia é: " + nomeJogo);
		int jogadorAposta;
		while (true) {
			System.out.println("O senhor deseja apostar em qual jogador? (1 a 456)");
			jogadorAposta = sc.nextInt();

			if (jogadorAposta < 1 || jogadorAposta > 456) {
				System.out.println("Jogador inválido! Escolha entre 1 e 456.");

			} else if (!jogadores[jogadorAposta].isStatus()) {
				System.out.println("Esse jogador já está morto! Escolha outro.");
			} else {
				break;
			}
		}

		double valorApostado;

		while (true) {
			System.out.println("Quanto o senhor deseja apostar?");
			valorApostado = sc.nextDouble();
			if (valorApostado <= 0) {
				System.out.println("Aposta inválida! Deve ser maior que 0.");

			} else if (valorApostado > vip.getSaldo()) {
				System.out.printf("Saldo insuficiente! Seu saldo atual é: %.2f\n", vip.getSaldo());
			} else {
				break;
			}
		}

		System.out.println("Maravilha! O jogo irá iniciar! Boa sorte!");

		Random rand = new Random();
		int eliminados = 0;

		while (eliminados < eliminacoes) {
			int escolhido = rand.nextInt(456) + 1;
			if (jogadores[escolhido].isStatus()) {
				jogadores[escolhido].setStatus(false);
				eliminados++;
			}
		}

		if (!jogadores[jogadorAposta].isStatus()) {
			vip.setSaldo(vip.getSaldo() - valorApostado);
			System.out.println("Infelizmente, o jogador " + jogadorAposta + " foi eliminado.");
			System.out.printf("Você perdeu a aposta de R$%.2f. Novo saldo: %.2f\n", valorApostado, vip.getSaldo());

			if (vip.getSaldo() <= 0) {
				System.out.println("\nSeu saldo zerou. O senhor não pode mais continuar no jogo.");
				System.exit(0);
			}

		} else {
			vip.setSaldo(vip.getSaldo() + valorApostado);
			System.out.println("Boa notícia! O jogador " + jogadorAposta + " sobreviveu.");
			System.out.printf("Você ganhou R$%.2f! Novo saldo: R$%.2f\n", valorApostado, vip.getSaldo());
		}
	}

	public void eliminarJogador(int id) {
		if (id > 0 && id < jogadores.length && jogadores[id] != null) {
			jogadores[id].setStatus(false);
		}
	}

	int getEliminacoesDia(int dia) {

		switch (dia) {

		case 1:
			return 201;

		case 2:
			return 80;

		case 3:
			return 87;

		case 4:
			return 58;

		case 5:
			return 28;

		case 6:
			return 1;

		default:
			return 0;

		}
	}

	String getNomeJogo(int dia) {

		switch (dia) {
		case 1:
			return "Batatinha Frita";

		case 2:
			return "Colmeia";

		case 3:
			return "Cabo de Guerra";

		case 4:
			return "Bolinha de Gude";

		case 5:
			return "Ponte de Cristal";

		case 6:
			return "Jogo da Lula (Final)";

		default:
			return "???";

		}
	}

	public void declararCampeao() {
		for (int i = 1; i < jogadores.length; i++) {
			Jogador j = jogadores[i];

			if (j != null && j.isStatus()) {
				System.out.println("\nO campeão do jogo é o Jogador " + i + "!");

				return;
			}
		}
	}
}