package round_6_java;

import java.util.*;

public class Vip extends Jogador {
	private String tipoMasc;
	private double saldo;
	private Jogador[] jogadores = new Jogador[457];
	private int diaAtual = 1;

	public void VipJogo(Scanner sc) {
		System.out.println("Bem-vindo a ilha, VIP!");
		System.out.println("Esperamos que você aproveite muito bem os 6 jogos que preparamos para você!");

		System.out.println("\nPor favor, informe qual o animal da máscara que está utilizando para te entregarmos.");
		tipoMasc = sc.next();

		System.out.println("\nInforme para nós o saldo que o senhor deseja reservar para apostar nos jogos. "
				+ "\nLembre-se que não é permitido realizar depósitos durante o jogo!");
		saldo = sc.nextDouble();

		System.out.println("\nMaravilha! Vamos para o salão, os jogos já irão iniciar!");

		for (int i = 1; i < 457; i++) {
			jogadores[i] = new Jogador();
			jogadores[i].setNumJogador(i);
			jogadores[i].setStatus(true);
		}

		while (diaAtual <= 6) {
			int eliminacoes = getEliminacoesDia(diaAtual);
			String nomeJogo = getNomeJogo(diaAtual);
			int vivosRestantes = contarVivos();

			System.out.println("\nDia " + diaAtual + " - " + nomeJogo + " (" + vivosRestantes + " vivos).");

			// Menu
			while (true) {
				System.out.println("\nSelecione o que deseja fazer: ");
				System.out.println("1 - Assistir e apostar o dia " + diaAtual + ".");
				System.out.println("2 - Verificar meu perfil.");
				System.out.println("3 - Verificar meu saldo.");
				System.out.println("4 - Listar jogadores vivos.");

				int menu = sc.nextInt();

				switch (menu) {
				case 1:
					jogarDia(sc, eliminacoes, nomeJogo);
					diaAtual++;
					if (diaAtual > 6) {
						declararCampeao();
						return;
					}
					break;

				case 2:
					System.out.println(
							"Ah, o senhor não lembra sua máscara? O senhor está com a máscara de " + tipoMasc + ".");
					break;

				case 3:
					System.out.println("Verificamos aqui e o senhor está com " + saldo
							+ " de saldo. \nUse com sabedoria, não pode ser depositado mais nenhum valor aqui. Regras da casa!");
					break;

				case 4:
					listarVivos();
					break;

				default:
					System.out.println(
							"Sei que o senhor pode tudo por aqui, mas esse comando é impossível de ser realizado. "
									+ "\nNão deseja tentar outro pedido?");
					break;
				}

				if (menu == 1)
					break;
			}
		}
	}

	private void jogarDia(Scanner sc, int eliminacoes, String nomeJogo) {
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
			} else if (valorApostado > saldo) {
				System.out.println("Saldo insuficiente! Seu saldo atual é: " + saldo);
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
		    saldo -= valorApostado;
		    System.out.println("Infelizmente, o jogador " + jogadorAposta + " foi eliminado.");
		    System.out.println("Você perdeu a aposta de " + valorApostado + ". Novo saldo: " + saldo);

		    if (saldo <= 0) {
		        System.out.println("\nSeu saldo zerou. O senhor não pode mais continuar no jogo.");
		        System.exit(0);
		    }
		} else {
		    saldo += valorApostado;
		    System.out.println("Boa notícia! O jogador " + jogadorAposta + " sobreviveu.");
		    System.out.println("Você ganhou " + valorApostado + "! Novo saldo: " + saldo);
		}

	}

	private void listarVivos() {
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

	    System.out.println("\n\nTotal de jogadores vivos: " + contarVivos());
	}


	private int contarVivos() {
		int vivos = 0;
		for (int i = 1; i < 457; i++) {
			if (jogadores[i].isStatus())
				vivos++;
		}
		return vivos;
	}

	private int getEliminacoesDia(int dia) {
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

	private String getNomeJogo(int dia) {
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
			return "Desconhecido";
		}
	}

	private void declararCampeao() {
		for (int i = 1; i < 457; i++) {
			if (jogadores[i].isStatus()) {
				System.out.println("\nO campeão do jogo é o Jogador " + i + "!");
				return;
			}
		}
	}
}
