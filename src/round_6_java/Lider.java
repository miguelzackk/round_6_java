package round_6_java;

import java.util.Random;
import java.util.Scanner;

class Lider extends Jogo {
	public void iniciarJogo() {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		startJogador();

		String[] jogos = { "Batatinha Frita", "Colmeia", "Cabo de Guerra", "Bolinha de Gude", "Ponte de Cristal",
				"Lula" };

		int jogadoresRestantes = 456;
		boolean liderInfiltrado;

		System.out.println("Bem-vindo! Você é o líder.");
		System.out.println("Deseja começar os jogos?");
		System.out.println("1 - Sim");
		System.out.println("2 - Não");
		System.out.print("Escolha uma opção: ");
		int inicio = scanner.nextInt();

		if (inicio != 1) {
			System.out.println("Jogo não iniciado.");
			scanner.close();
			return;
		}

		for (int dia = 1; dia <= 6; dia++) {
			jogadoresRestantes = contarVivos();
			System.out.println("\n=== Dia " + dia + " ===");
			System.out.println("Jogadores restantes: " + jogadoresRestantes);
			System.out.println("Jogo do dia: " + jogos[dia - 1]);

			liderInfiltrado = false;
			if (dia == 2 || dia == 4) {
				System.out.println("Deseja jogar hoje como participante infiltrado?");
				System.out.println("1 - Sim");
				System.out.println("2 - Não");
				System.out.print("Escolha uma opção: ");
				int jogarHoje = scanner.nextInt();
				if (jogarHoje == 1) {
					liderInfiltrado = true;
					System.out.println("O líder decidiu se juntar ao jogo como participante infiltrado!");
				} else {
					System.out.println("O líder preferiu não se juntar ao jogo hoje.");
				}
			}

			int jogadoresAlvo = 0;
			if (jogos[dia - 1].equals("Batatinha Frita")) {
				jogadoresAlvo = 201;
			} else if (jogos[dia - 1].equals("Colmeia")) {
				jogadoresAlvo = 80;
			} else if (jogos[dia - 1].equals("Cabo de Guerra")) {
				jogadoresAlvo = 40;
			} else if (jogos[dia - 1].equals("Bolinha de Gude")) {
				jogadoresAlvo = 17;
			} else if (jogos[dia - 1].equals("Ponte de Cristal")) {
				jogadoresAlvo = 2;
			} else if (jogos[dia - 1].equals("Lula")) {
				jogadoresAlvo = 1;
			}

			int eliminacoesNecessarias = jogadoresRestantes - jogadoresAlvo;
			int eliminadosContador = 0;

			while (eliminadosContador < eliminacoesNecessarias) {
				int idParaEliminar = random.nextInt(456) + 1;
				if (jogadores[idParaEliminar].isStatus()) {
					jogadores[idParaEliminar].setStatus(false);
					eliminadosContador++;
				}
			}

			jogadoresRestantes = contarVivos();

			if (liderInfiltrado) {
				System.out.println("Você está participando infiltrado no jogo...");
				System.out.println("Hoje, o líder sobreviveu. Jogadores restantes: " + jogadoresRestantes);
			} else {
				System.out.println("1 - Assistir");
				System.out.println("2 - Dormir");
				System.out.print("Escolha uma opção: ");
				int opcao = scanner.nextInt();

				if (opcao == 1) {
					System.out.println("Você está assistindo o jogo...");
					System.out.println("Jogadores restantes hoje: " + jogadoresRestantes);
				} else {
					System.out.println("Você decidiu dormir hoje...");
					System.out.println("Mesmo dormindo, jogadores restantes hoje: " + jogadoresRestantes);
				}
			}

			System.out.println("Fim do dia " + dia + ".");
		}

		declararCampeao();

		System.out.println("\nFim do jogo! Todos os 6 dias se passaram.");
		scanner.close();
	}
}