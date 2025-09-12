package round_6_java;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean entradaValida = false;

		System.out.println("○ △ □      ○ △ □     ○ △ □   ○ △ ");
		System.out.println("Bem vindo ao Round Six");
		System.out.println("Gostaria de participar como:");
		while (!entradaValida) {
			System.out.println("‖ 1. Jogador                    ‖");
			System.out.println("‖ 2. Soldado                    ‖");
			System.out.println("‖ 3. VIP                        ‖");
			System.out.println("‖ 4. Líder                      ‖");
			System.out.printf("%n○ △ □      ○ △ □     ○ △ □   ○ △ ");

			int menuEscolha = sc.nextInt();
			switch (menuEscolha) {
			case 1:
				Jogo jogo = new Jogo();
				Jogador jogador1 = new Jogador(jogo);
				jogador1.menuJogador(sc);
				entradaValida = true;
				break;

			case 2:
//			Soldado soldado = new Solado();
				// Jogo objeto
				// jogo classe do objeto
				entradaValida = true;
				break;

			case 3:
				Vip vip = new Vip();
				vip.VipJogo(sc);
				entradaValida = true;
				break;

			case 4:
				Lider lider = new Lider();
				lider.iniciarJogo();
				entradaValida = true;
				break;
			default:
				System.out.println("Inválido! [1 - 4]");
				break;
			}
		}
	}

}