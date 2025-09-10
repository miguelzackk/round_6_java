package round_6_java;

import java.util.*;

public class Jogo {
    private List<Jogador> jogadores = new ArrayList<>();
    private int valorPremio = 0;

    public void criarJogadores() {
        for (int i = 1; i <= 456; i++) {
            jogadores.add(new Jogador(i));
        }
    }

    public void listarVivos() {
        System.out.println("\nJogadores vivos:");
        int count = 0;
        for (Jogador j : jogadores) {
            if (j.isStatus()) {
                System.out.printf("%-5d", j.getIdJogador());
                count++;
                if (count % 20 == 0) System.out.println();
            }
        }
        System.out.println("\nTotal: " + contarVivos());
    }

    public int contarVivos() {
        int vivos = 0;
        for (Jogador j : jogadores) {
            if (j.isStatus()) vivos++;
        }
        return vivos;
    }

    public void eliminar(int qtd) {
        Random r = new Random();
        int eliminados = 0;
        while (eliminados < qtd) {
            int escolhido = r.nextInt(456);
            Jogador j = jogadores.get(escolhido);
            if (j.isStatus()) {
                j.setStatus(false);
                eliminados++;
            }
        }
        valorPremio += qtd * 39000;
    }

    public void eliminarJogador(int id) {
        for (Jogador j : jogadores) {
            if (j.getIdJogador() == id) {
                j.setStatus(false);
                return;
            }
        }
    }

    private int getEliminacoesDia(int dia) {
        switch (dia) {
            case 1: return 201;
            case 2: return 80;
            case 3: return 87;
            case 4: return 58;
            case 5: return 28;
            case 6: return 1;
            default: return 0;
        }
    }

    private String getNomeJogo(int dia) {
        switch (dia) {
            case 1: return "Batatinha Frita";
            case 2: return "Colmeia";
            case 3: return "Cabo de Guerra";
            case 4: return "Bolinha de Gude";
            case 5: return "Ponte de Cristal";
            case 6: return "Jogo da Lula (Final)";
            default: return "???";
        }
    }

    public void jogarComVip(Vip vip, Scanner sc) {
        for (int dia = 1; dia <= 6; dia++) {
            System.out.println("\nDia " + dia + ": " + getNomeJogo(dia));
            listarVivos();

            vip.apostar(sc, this, dia);

            eliminar(getEliminacoesDia(dia));
            if (contarVivos() <= 1) break;
        }
        declararCampeao();
    }

    public void declararCampeao() {
        for (Jogador j : jogadores) {
            if (j.isStatus()) {
                System.out.println("\nO campeão do jogo é o Jogador " + j.getIdJogador() + "!");
                System.out.println("Prêmio final: R$" + valorPremio);
                return;
            }
        }
    }
}
