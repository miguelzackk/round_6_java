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

	public void jogarQuadrado(Scanner input) {
		Supervisor quadrado01 = new Supervisor();

		int escolhaMenu;
		boolean escolhaValida = false;

		for (int i = 1; i <= 6; i++) {
			int escolhaTeste = (int) (Math.random() * 3);

			// Atualiza a lista
			quadrado01.setListaJogadores(1, quadrado01.getListaJogadores(1) - this.getEliminacoesDia(i));
			quadrado01.setListaJogadores(0, quadrado01.getListaJogadores(0) + this.getEliminacoesDia(i));

			if (quadrado01.getEstaVivo()) {
				do {
					System.out.printf("\nDia: %d | Jogo: %s\n", i, this.getNomeJogo(i));
					System.out.printf("\nHoje é o %dº dia, o que você vai " + "fazer? \n", i);
					System.out.println("| 1 | - Trabalhar\n" + "| 2 | - Descansar");
					escolhaMenu = input.nextInt();

					switch (escolhaMenu) {
					case 1:
						quadrado01.trabalhar(i, this.getEliminacoesDia(i));
						escolhaValida = true;
						break;
					case 2:
						System.out.println(quadrado01.descansar());
						escolhaValida = true;
						break;
					default:
						System.out.printf("'%d' não é uma escolha " + "possível.\n", escolhaMenu);
						break;
					}
				} while (!escolhaValida);

				if (quadrado01.getEstaVivo() && (i == 2 || i == 4)) {
					do {
						System.out.println(quadrado01.escolherTeste(escolhaTeste));
						System.out.println("| 1 | - Sim\n" + "| 2 | - Não");
						escolhaMenu = input.nextInt();

						switch (escolhaMenu) {
						case 1:
							quadrado01.setEstaVivo(false);
							System.out.println("Você foi visto quebrando " + "as regras e executado.");
							break;
						case 2:
							System.out.println("Muito bem.");
							break;
						default:
							System.out.println("Digite uma das opções " + "disponíveis.");
							break;
						}
					} while (escolhaMenu < 1 || escolhaMenu > 2);
				}
			}
		}

		if (quadrado01.getEstaVivo()) {
			System.out.println("\nO jogo chegou ao fim!\n");
			System.out.println("Bom trabalho! Esteja preparado para retornar " + "em breve!");
		}
	}

	public void jogarTriangulo(Scanner input) {
		Soldado triangulo01 = new Soldado();

		int escolhaMenu;
		boolean escolhaValida = false;

		for (int i = 1; i <= 6; i++) {
			int escolhaTeste = (int) (Math.random() * 3);

			if (triangulo01.getEstaVivo()) {
				do {
					System.out.printf("\nDia: %d | Jogo: %s\n", i, this.getNomeJogo(i));
					System.out.printf("\nHoje é o %dº dia, o que você vai " + "fazer? \n", i);
					System.out.println("| 1 | - Trabalhar\n" + "| 2 | - Descansar");
					escolhaMenu = input.nextInt();

					switch (escolhaMenu) {
					case 1:
						triangulo01.trabalhar(i, this.getEliminacoesDia(i));
						escolhaValida = true;
						break;
					case 2:
						System.out.println(triangulo01.descansar());
						escolhaValida = true;
						break;
					default:
						System.out.printf("'%d' não é uma escolha " + "possível.\n", escolhaMenu);
						break;
					}
				} while (!escolhaValida);

				if (triangulo01.getEstaVivo() && (i == 2 || i == 4)) {
					do {
						System.out.println(triangulo01.escolherTeste(escolhaTeste));
						System.out.println("| 1 | - Sim\n" + "| 2 | - Não");
						escolhaMenu = input.nextInt();

						switch (escolhaMenu) {
						case 1:
							triangulo01.setEstaVivo(false);
							System.out.println("Você foi visto quebrando " + "as regras e executado.");
							break;
						case 2:
							System.out.println("Muito bem.");
							break;
						default:
							System.out.println("Digite uma das opções " + "disponíveis.");
							break;
						}
					} while (escolhaMenu < 1 || escolhaMenu > 2);
				}
			}
		}

		if (triangulo01.getEstaVivo()) {
			System.out.println("\nO jogo chegou ao fim!\n");
			System.out.println("Quantidade de jogadores que você executou " + "\nem cada dia: ");

			for (int i = 1; i <= triangulo01.getExecucoesDia().length; i++) {
				System.out.printf("Dia: %d: %d\n", i, triangulo01.getExecucoesDia(i));
			}

			System.out.printf("\nTotal de execuções no jogo: %d\n", triangulo01.getExecucoesTotal());

			System.out.println("Bom trabalho! Esteja preparado para retornar " + "em breve!");
		}
	}

	public void jogarCirculo(Scanner input) {
		Trabalhador circulo01 = new Trabalhador();

		int escolhaMenu;
		boolean escolhaValida = false;

		for (int i = 1; i <= 6; i++) {
			int escolhaTeste = (int) (Math.random() * 3);

			if (circulo01.getEstaVivo()) {
				do {
					System.out.printf("\nDia: %d | Jogo: %s\n", i, this.getNomeJogo(i));
					System.out.printf("\nHoje é o %dº dia, o que você vai " + "fazer? \n", i);
					System.out.println("| 1 | - Trabalhar\n" + "| 2 | - Descansar");
					escolhaMenu = input.nextInt();

					switch (escolhaMenu) {
					case 1:
						circulo01.trabalhar(i, this.getEliminacoesDia(i));
						escolhaValida = true;
						break;
					case 2:
						System.out.println(circulo01.descansar());
						escolhaValida = true;
						break;
					default:
						System.out.printf("'%d' não é uma escolha " + "possível.\n", escolhaMenu);
						break;
					}
				} while (!escolhaValida);

				if (circulo01.getEstaVivo() && (i == 2 || i == 4)) {
					do {
						System.out.println(circulo01.escolherTeste(escolhaTeste));
						System.out.println("| 1 | - Sim\n" + "| 2 | - Não");
						escolhaMenu = input.nextInt();

						switch (escolhaMenu) {
						case 1:
							circulo01.setEstaVivo(false);
							System.out.println("Você foi visto quebrando " + "as regras e executado.");
							break;
						case 2:
							System.out.println("Muito bem.");
							break;
						default:
							System.out.println("Digite uma das opções " + "disponíveis.");
							break;
						}
					} while (escolhaMenu < 1 || escolhaMenu > 2);
				}
			}
		}

		if (circulo01.getEstaVivo()) {
			System.out.println("\nO jogo chegou ao fim!\n");
			System.out.println("Bom trabalho! Esteja preparado para retornar " + "em breve!");
		}
	}
}
