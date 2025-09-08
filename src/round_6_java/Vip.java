package round_6_java;

import java.util.*;

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

        // Criando 456 jogadores
        Jogador[] jogadores = new Jogador[457];  // 1 a 456
        for (int i = 1; i <= 456; i++) {
            jogadores[i] = new Jogador();
            jogadores[i].setNumJogador(i);
            jogadores[i].setStatus(true); // Inicialmente todos os jogadores estão vivos
        }

        // Definindo os jogos para os 6 dias
        String[] jogos = {"Batatinha Frita", "Colmeia", "Cabo de Guerra", "Bolinha de Gude", "Ponte de Cristal", "Lula"};
        int jogadoresRestantes = 456;

        // Loop dos dias (1 a 6)
        for (int dia = 1; dia <= 6; dia++) {
            System.out.println("\nDia " + dia + ".");
            System.out.println("O jogo do dia é: " + jogos[dia - 1]);

            // Jogar o jogo
            int eliminados = 0;

            // Eliminar jogadores de acordo com o jogo
            if (jogos[dia - 1].equals("Batatinha Frita")) {
                eliminados = jogadoresRestantes - 300;
                jogadoresRestantes -= eliminados;
            } else if (jogos[dia - 1].equals("Colmeia")) {
                eliminados = jogadoresRestantes - 80;
                jogadoresRestantes -= eliminados;
            } else if (jogos[dia - 1].equals("Cabo de Guerra")) {
                jogadoresRestantes = 80;
                eliminados = 456 - 40;
                jogadoresRestantes -= eliminados;
            } else if (jogos[dia - 1].equals("Bolinha de Gude")) {
                eliminados = jogadoresRestantes - 17;
                jogadoresRestantes -= eliminados;
            } else if (jogos[dia - 1].equals("Ponte de Cristal")) {
                eliminados = jogadoresRestantes - 2;
                jogadoresRestantes -= eliminados;
            } else if (jogos[dia - 1].equals("Lula")) {
                eliminados = jogadoresRestantes - 1;
                jogadoresRestantes -= eliminados;
            }

            // Elimina jogadores aleatórios
            java.util.Random rand = new java.util.Random();
            java.util.Set<Integer> mortos = new java.util.HashSet<>();

            while (mortos.size() < eliminados) {
                int jogadorMortosIndex = rand.nextInt(456) + 1; // jogadores de 1 a 456
                if (jogadores[jogadorMortosIndex].isStatus()) {  // Elimina apenas jogadores vivos
                    jogadores[jogadorMortosIndex].setStatus(false);
                    mortos.add(jogadorMortosIndex);
                }
            }

            // Apostas do VIP
            System.out.println("Agora, vamos fazer a aposta do dia!");
            int jogadorApostado = 0;

            while (true) {
                // Pergunta qual jogador o VIP quer apostar
                System.out.println("O senhor deseja apostar em qual jogador? (1 a 456)");
                jogadorApostado = sc.nextInt();

                // Verifica se o jogador é válido e está vivo
                if (jogadorApostado < 1 || jogadorApostado > 456) {
                    System.out.println("Jogador inválido! Por favor, escolha um jogador entre 1 e 456.");
                } else if (!jogadores[jogadorApostado].isStatus()) {
                    System.out.println("Esse jogador já está morto. Escolha outro jogador.");
                } else {
                    break; // O jogador é válido e está vivo, então pode sair do loop
                }
            }

            // Pergunta o valor da aposta
            System.out.println("Quanto o senhor deseja apostar?");
            double valorApostado = sc.nextDouble();

            // Verifica se o saldo é suficiente
            if (valorApostado > saldo) {
                System.out.println("Saldo insuficiente para essa aposta.");
                break;
            }

            // Verifica se o jogador apostado sobreviveu ou morreu
            if (jogadores[jogadorApostado].isStatus()) {
                double ganho = valorApostado * 2;
                saldo += ganho;
                System.out.println("Parabéns! O jogador " + jogadorApostado + " sobreviveu. Você ganhou R$" + ganho);
            } else {
                saldo -= valorApostado;
                System.out.println("Que pena! O jogador " + jogadorApostado + " morreu. Você perdeu R$" + valorApostado);
            }

            // Exibe o saldo após a aposta
            System.out.println("Seu saldo agora é: R$" + saldo);

            if (jogadoresRestantes == 1) {
                System.out.println("\nFim do jogo! Só resta 1 jogador.");
                break;
            }
            
            // Menu de opções para o VIP
            while (true) {
                System.out.println("\nSelecione o que deseja fazer: \n1 - Ver o que o jogo me aguarda. \n2 - Verificar meu perfil. \n3 - Verificar meu saldo.");
                int menu = sc.nextInt();

                switch (menu) {
                    case 1:
                        System.out.println("Maravilha! O jogo do dia " + dia + " é: " + jogos[dia - 1]);
                        break;

                    case 2:
                        System.out.println("O senhor está com a máscara de " + tipoMasc + ".");
                        break;

                    case 3:
                        System.out.println("Verificamos aqui e o senhor está com R$" + saldo + " de saldo.");
                        break;

                    default:
                        System.out.println("Comando inválido! Tente novamente.");
                        continue;
                }

                break; // Sai do menu depois de uma opção válida
            }
        }
    }
}
