// Subclasse da classe Guarda
package round_6_java;

public class Trabalhador extends Guarda {
	// Atributos
	String[] tarefaCirculoLista = {"ajudar a preparar o jogo do dia.\n",
		"alimentar os jogadores vivos.\n",
		"ajudar a organizar as dependências da ilha.\n",
		"limpar o sangue do chão.\n",
		"recolher os corpos dos jogadores executados.\n",
		"ajudar a queimar os corpos dos jogadores executados.\n",
		"recolher e queimar o corpo desse jogador.\n"};

	// Construtor
	public Trabalhador() {
		this.setTipoMascara(2);
		System.out.printf("Você é um Trabalhador e a sua máscara é o %s.\n\n"
			+ "O seu trabalho é auxiliar na preparação dos jogos, \nmanter os "
			+ "ambientes limpos, distribuir alimentos \npara os jogadores "
			+ "vivos e recolher e queimar os \ncorpos dos jogadores "
			+ "executados. \n\nVocê faz parte da hierarquia mais baixa entre "
			+ "\nos guardas.\n", this.getTipoMascara());
		System.out.println(super.getRegrasGuarda());
	}

	// Getter
	public String getTarefaCirculoLista(int tarefa) {
		return tarefaCirculoLista[tarefa];
	}

	// Método
	public void trabalhar(int dia, int executadosDiaJogo) {
		this.setDescansoConsecutivo(0);

		int tarefaCirculoDia = (int)(Math.random() * 6);

		if (dia == 6) {
			System.out.println("Hoje apenas 1 jogador foi eliminado.");
			System.out.print("A sua tarefa foi ");
			System.out.print(this.getTarefaCirculoLista(6));
		} else {
			System.out.printf("Hoje %d jogadores foram executados.\n",
				executadosDiaJogo);
			System.out.print("A sua tarefa foi ");
			System.out.print(this.getTarefaCirculoLista(tarefaCirculoDia));
		}
	}
}