package round_6_java;

import java.util.Random;
import java.util.Scanner;

class Lider {
    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] jogos = {
                "Batatinha Frita",
                "Colmeia",
                "Cabo de Guerra",
                "Bolinha de Gude",
                "Ponte de Cristal",
                "Lula"
        };

        int jogadoresRestantes = 456;
        boolean liderInfiltrado;

        System.out.println("Bem-vindo! Você é o líder.");
        System.out.println("Deseja começar os jogos?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");
        System.out.print("Escolha uma opção: ");
        int inicio = scanner.nextInt();

        if (inicio != 1) {
            System.out.println("Jogo encerrado antes de começar.");
            scanner.close();
            return;
        }

        for (int dia = 1; dia <= 6; dia++) {
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

            // Lógica de eliminados ajustada para cada jogo
            if (jogos[dia - 1].equals("Batatinha Frita")) {
                int eliminados = jogadoresRestantes - 201;
                jogadoresRestantes -= eliminados;
            } else if (jogos[dia - 1].equals("Colmeia")) {
                int eliminados = jogadoresRestantes - 80;
                jogadoresRestantes -= eliminados;
            } else if (jogos[dia - 1].equals("Cabo de Guerra")) {
                jogadoresRestantes = 80;
                int eliminados = jogadoresRestantes - 40;
                jogadoresRestantes -= eliminados;
            } else if (jogos[dia - 1].equals("Bolinha de Gude")) {
                int eliminados = jogadoresRestantes - 17;
                jogadoresRestantes -= eliminados;
            } else if (jogos[dia - 1].equals("Ponte de Cristal")) {
                int eliminados = jogadoresRestantes - 2;
                jogadoresRestantes -= eliminados;
            } else if (jogos[dia - 1].equals("Lula")) {
                int eliminados = jogadoresRestantes - 1;
                jogadoresRestantes -= eliminados;
            } else {
                int eliminados;
                if (dia < 5) {
                    eliminados = random.nextInt(jogadoresRestantes - 3) + 1;
                } else if (dia == 5) {
                    eliminados = jogadoresRestantes - 2;
                } else {
                    eliminados = jogadoresRestantes - 1;
                }

                if (eliminados > jogadoresRestantes) {
                    eliminados = jogadoresRestantes - 1;
                }

                jogadoresRestantes -= eliminados;
            }

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

        System.out.println("\nFim do jogo! Todos os 6 dias se passaram.");
        System.out.println("Jogadores restantes: " + jogadoresRestantes);
        scanner.close();
    }
}
