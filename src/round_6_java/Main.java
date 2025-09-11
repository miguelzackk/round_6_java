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
			System.out.println("‖ 2. Supervisor □               ‖");
			System.out.println("‖ 3. Soldado △                  ‖");
			System.out.println("‖ 4. Trabalhador ○              ‖");
			System.out.println("‖ 5. VIP                        ‖");
			System.out.println("‖ 6. Líder                      ‖");
			System.out.printf("%n○ △ □      ○ △ □     ○ △ □   ○ △ ");

			int menuEscolha = sc.nextInt();
			switch (menuEscolha) {
			case 1:
				Jogador jogador = new Jogador();
				jogador.menuJogador(sc);
//			Jogo jogo = new Jogo();
				// Jogo objeto
				// jogo classe do objeto
				entradaValida = true;
				break;

			case 2:
				Jogo jogoGuarda01 = new Jogo();
				jogoGuarda01.jogarQuadrado(sc);
				entradaValida = true;
				break;

			case 3:
				Jogo jogoGuarda02 = new Jogo();
				jogoGuarda02.jogarTriangulo(sc);
				entradaValida = true;
				break;

			case 4:
				Jogo jogoGuarda03 = new Jogo();
				jogoGuarda03.jogarCirculo(sc);
				entradaValida = true;
				break;

			case 5:
				Vip vip = new Vip();
				vip.VipJogo(sc);
				entradaValida = true;
				break;

			case 6:
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
