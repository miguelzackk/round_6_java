// Subclasse da classe Guarda
package round_6_java;

public class Soldado extends Guarda {
	// Atributos
	private int[] execucoesDia = new int[6];
	private int execucoesTotal;
	private String[] tarefaTrianguloLista = {"Você executou %d dos %d "
		+ "jogadores que não conseguiram \npassar da linha dentro do tempo.\n",
		"Você executou %d dos %d jogadores que não conseguiram \ntirar o "
		+ "símbolo do doce com a agulha.\n",
		"As equipes eliminaram umas as outras e você não \nrealizou execuções "
		+ "hoje.\n",
		"Você executou %d dos %d jogadores eliminados hoje.\n",
		"Os jogadores morreram ao cair da ponte e \nvocê não realizou "
		+ "execuções hoje.\n",
		"Os 2 jogadores restantes foram colocados para matar \num ao outro e "
		+ "você não realizou execuções hoje.\n",
		"Você não executou jogadores hoje.\n",
		"%d jogadores foram eliminados.\n"};

	// Construtor
	public Soldado() {
		this.setTipoMascara(1);
		System.out.printf("Você é um Soldado e a sua máscara é o %s. \n\nO seu "
			+ "trabalho é executar os jogadores que fracassarem \nou forem "
			+ "derrotados nos jogos, garantir que as regras \nsejam seguidas e "
			+ "manter a ordem através da violência. \n\nVocê faz parte da "
			+ "hierarquia intermediária entre os \nguardas.\n",
			this.getTipoMascara());
			this.setExecucoesTotal(0);
		System.out.println(super.getRegrasGuarda());
	}

	// Getters
	// Getter para o array
	public int[] getExecucoesDia() {
		return execucoesDia;
	}

	// Getter para os elementos do array
	public int getExecucoesDia(int dia) {
		return execucoesDia[dia - 1];
	}

	public int getExecucoesTotal() {
		return execucoesTotal;
	}

	public String getTarefaTrianguloLista(int tarefa) {
		return tarefaTrianguloLista[tarefa];
	}

	// Setters
	public void setExecucoesDia(int dia, int execucoes) {
		this.execucoesDia[dia - 1] = execucoes;
	}

	public void setExecucoesTotal(int execucoesTotal) {
		this.execucoesTotal = execucoesTotal;
	}

	// Método
	@Override
	public void trabalhar(int dia, int executadosDiaJogo) {
		this.setDescansoConsecutivo(0);
		int quantidade = (int)(Math.random() *
			((double) executadosDiaJogo / 100) * 10);
		int[] contagem = new int[6];
		for (int i = 0; i < contagem.length; i++) {
			contagem[i] = i;
		}

		switch (dia) {
			case 1, 2, 4:
				this.setExecucoesDia(dia, quantidade);

				if (this.getExecucoesDia(dia) > 0) {
					System.out.printf(this.getTarefaTrianguloLista
						(contagem[dia - 1]), this.getExecucoesDia(dia),
						executadosDiaJogo);
				} else {
					System.out.print(this.getTarefaTrianguloLista(6));
					System.out.printf(this.getTarefaTrianguloLista(7),
						executadosDiaJogo);
				}

				this.setExecucoesTotal(this.getExecucoesTotal() +
					this.getExecucoesDia(dia));
				break;
			case 3, 5, 6:
				this.setExecucoesDia(dia, 0);

				System.out.printf(this.getTarefaTrianguloLista
					(contagem[dia - 1]), this.getExecucoesDia(dia),
					executadosDiaJogo);
				break;
		}
	}
}