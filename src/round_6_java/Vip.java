package round_6_java;

import java.util.Random;
import java.util.Scanner;

public class Vip extends Jogador {
    private String tipoMasc;
    private double saldo;

    public void iniciar(Scanner sc, Jogo jogo) {
        System.out.println("Bem-vindo à ilha, VIP!");
        System.out.println("Esperamos que aproveite os 6 jogos que preparamos para você!");

        System.out.print("\nInforme o animal da sua máscara: ");
        tipoMasc = sc.next();

        System.out.print("Informe o saldo inicial para apostas: ");
        saldo = sc.nextDouble();

        System.out.println("\nMaravilha! Vamos para o salão, os jogos já irão iniciar!");

        jogo.jogarComVip(this, sc);
    }

    public String getTipoMasc() {
        return tipoMasc;
    }

    public double getSaldo() {
        return saldo;
    }

    public void addSaldo(double valor) {
        saldo += valor;
    }

    public void subSaldo(double valor) {
        saldo -= valor;
    }

    public void apostar(Scanner sc, Jogo jogo, int dia) {
        System.out.println("\nVIP " + tipoMasc + ", seu saldo: " + saldo);

        int jogadorEscolhido;
        while (true) {
            System.out.print("Escolha um jogador para apostar (1 a 456): ");
            jogadorEscolhido = sc.nextInt();
            if (jogadorEscolhido < 1 || jogadorEscolhido > 456) {
                System.out.println("Inválido. Tente de novo.");
            } else {
                break;
            }
        }

        System.out.print("Quanto deseja apostar? ");
        double valor = sc.nextDouble();
        if (valor <= 0 || valor > saldo) {
            System.out.println("Aposta inválida!");
            return;
        }

        Random rand = new Random();
        boolean sobrevive = rand.nextBoolean();

        if (sobrevive) {
            addSaldo(valor);
            System.out.println("Jogador " + jogadorEscolhido + " sobreviveu! Você ganhou a aposta. Saldo: " + saldo);
        } else {
            subSaldo(valor);
            jogo.eliminarJogador(jogadorEscolhido);
            System.out.println("Jogador " + jogadorEscolhido + " morreu! Você perdeu a aposta. Saldo: " + saldo);
        }

        if (saldo <= 0) {
            System.out.println("\nSeu saldo zerou. O senhor não pode mais continuar no jogo.");
            System.exit(0);
        }
    }
}
