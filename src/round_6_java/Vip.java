package round_6_java;

import java.util.*;

public class Vip extends Jogador {

// dados do vip
	private String tipoMasc;
	private double saldo;

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

// chamar classe jogo
	private Jogo jogo = new Jogo();

// start jogo vip
	public void VipJogo(Scanner sc) {
		System.out.println("Bem-vindo a ilha, VIP!");
		System.out.println("Esperamos que você aproveite muito bem os 6 jogos que preparamos para você!");
		System.out.println("\nPor favor, informe qual o animal da máscara que está utilizando para te entregarmos.");
		System.out.println("Para uma melhor experiência, recomendamos que indique o emoji de sua máscara.");
		tipoMasc = sc.next();
		System.out.println("\nInforme para nós o saldo que o senhor deseja reservar para apostar nos jogos. "
				+ "\nLembre-se que não é permitido realizar depósitos durante o jogo!");
		saldo = sc.nextDouble();
		System.out.println("\nMaravilha! Vamos para o salão, os jogos já irão iniciar!");

		startJogador();

		while (jogo.diaAtual <= 6) {
			String nomeJogo = jogo.getNomeJogo(jogo.diaAtual);
			int vivosRestantes = jogo.contarVivos();
			System.out.println("\nDia " + jogo.diaAtual + " - " + nomeJogo + " (" + vivosRestantes + " vivos).");

// Menu
			while (true) {
				System.out.println("\nSelecione o que deseja fazer: ");
				System.out.println("1 - Assistir e apostar o dia " + jogo.diaAtual + ".");
				System.out.println("2 - Verificar meu perfil.");
				System.out.println("3 - Verificar meu saldo.");
				System.out.println("4 - Listar jogadores vivos.");
				int menu = sc.nextInt();

				switch (menu) {
				case 1:
					jogardia(sc, jogo);
					jogo.diaAtual++;
					if (jogo.diaAtual > 6) {
						jogo.declararCampeao();
						System.out.println("Obrigado por assistir VIP! \nTe esperamos para a próxima edição!");
						return;
					}
					break;

				case 2:
					System.out.println("Você não lembra sua máscara? O é o VIP " + tipoMasc + ".");
					break;

				case 3:
					System.out.printf(
							"Verificamos aqui e o senhor está com R$%.2f de saldo. \nUse com sabedoria, não pode ser depositado mais nenhum valor aqui. Regras da casa!\n",
							saldo);
					break;

				case 4:
					jogo.listarVivos();
					break;

				default:
					System.out.println("Sei que o VIP " + tipoMasc
							+ " pode tudo por aqui, mas esse comando é impossível de ser realizado. "

							+ "\nNão deseja tentar outro pedido?");
					break;

				}

				if (menu == 1)
					break;
			}
		}
	}

	public void jogardia(Scanner sc, Jogo jogo) {
		int eliminacoes = jogo.getEliminacoesDia(jogo.diaAtual);
		String nomeJogo = jogo.getNomeJogo(jogo.diaAtual);
		jogo.jogarDiaVip(this, sc, eliminacoes, nomeJogo);

	}

}
