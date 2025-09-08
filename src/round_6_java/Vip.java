package round_6_java;

import java.util.Scanner;

public class Vip extends Jogador {
	private String tipoMasc;
	private double saldo;

	public String getTipoMasc() {
		return tipoMasc;
	}

	public void setTipoMasc(String tipoMasc) {
		this.tipoMasc = tipoMasc;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void VipJogo(Scanner sc) {
		System.out.println(
				"Bem-vindo a ilha, VIP! \nEsperamos que você aproveite muito bem os 6 jogos que preparamos para você!");

		System.out.println("\nPor favor, informe qual o animal da máscara que está utilizando para te entregarmos.");
		tipoMasc = sc.next();

		System.out.println(
				"\nInforme para nós o saldo que o senhor deseja reservar para apostar nos jogos. \nLembre-se que não é permitido realizar depósitos durante o jogo!");
		saldo = sc.nextDouble();

		System.out.println("\nMaravilha! Vamos para o salão, os jogos já irão iniciar!");

		Jogador jogador[] = new Jogador[457];
		for (int i = 1; i < 457; i++) {
			jogador[i] = new Jogador();
			jogador[i].setNumJogador(i);
		}

		// Dia 1 - arrumar
		System.out.println("\nDia 1.");

		while (true) {
			System.out.println(
					"\nSelecione o que deseja fazer: \n1 - Ver o que o jogo me aguarda. \n2 - Verificar meu perfil. \n3 - Verificar meu saldo.");
			int menu = sc.nextInt();

			switch (menu) {
			case 1:
				System.out.println("Maravilha! \nO jogo do dia 1 é.... \nBATATINHA FRITA!");
				System.out.println("O senhor deseja apostar em qual jogador?");
				int jogadoraposta = sc.nextInt();
				System.out.println("Quanto o senhor deseja apostar?");
				double valorapostado = sc.nextDouble();

				System.out.println("Maravilha! O jogo irá iniciar! \nBoa-sorte e bom divertimento!");
				break;

			case 2:
				System.out.println(
						"Ah, o senhor não lembra sua máscara? O senhor está com a máscara de " + tipoMasc + ".");
				break;

			case 3:
				System.out.println("Verificamos aqui e o senhor está com " + saldo
						+ " de saldo. \nUse com sabedoria, não pode ser depositado mais nenhum valor aqui. Regras da casa!");
				break;
			default:
				System.out.println(
						"Sei que o senhor pode tudo por aqui, mas esse comando é impossível de ser ralizado. \nNão deseja tentar outro pedido?");
				break;

			}

		}
	}
}
