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
                    Jogador jogador = new Jogador();
                    if (jogador.menuJogador(sc)) {
                        Jogo jogo = new Jogo();
                        jogo.criarJogadores();
                        jogo.jogarComVip(null, sc); // sem VIP
                    }
                    entradaValida = true;
                    break;

                case 2:
                    System.out.println("Modo Soldado ainda não implementado.");
                    entradaValida = true;
                    break;

                case 3:
                    Vip vip = new Vip();
                    Jogo jogoVip = new Jogo();
                    jogoVip.criarJogadores();
                    vip.iniciar(sc, jogoVip);
                    entradaValida = true;
                    break;

                case 4:
                    System.out.println("Modo Líder ainda não implementado.");
                    entradaValida = true;
                    break;

                default:
                    System.out.println("Inválido! [1 - 4]");
                    break;
            }
        }
    }
}
