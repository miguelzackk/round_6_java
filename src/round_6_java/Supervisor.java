// Subclasse da classe Guarda
package round_6_java;

public class Supervisor extends Guarda {
	// Atributos
	// Acompanha os jogadores vivos (status 1) e executados (status 0)
	private int[] listaJogadores = new int[2];
	private String[] tarefaQuadradoLista = {"Você organizou uma votação para "
		+ "os jogadores \ndecidirem se continuam ou não no jogo.\n",
		"Você anunciou o número total de eliminações e o \nprêmio acumulado "
		+ "após o jogo.\n",
		"Você puniu um guarda que tentou ajudar um dos jogadores.\n",
		"Você analisou as informações pessoais e dívidas dos jogadores.\n",
		"Você monitorou as dependências da ilha.\n",
		"Você organizou o jogo final.\n"};

	// Construtor
	public Supervisor() {
		this.setTipoMascara(0);
		System.out.printf("Você é um Supervisor e a sua mácara é o %s. \n\nO "
			+ "seu trabalho é organizar, monitorar e impor os \njogos através "
			+ "de ordens direcionadas aos outros \nguardas, além de mantê-los "
			+ "na linha. Você também \ntem liberdade para comunicar "
			+ "informações sobre \nos jogos para os jogadores. \n\nVocê faz "
			+ "parte da hierarquia mais alta entre os \nguardas, agindo em "
			+ "nome do Líder.\n", this.getTipoMascara());
		System.out.println(super.getRegrasGuarda());
		this.setListaJogadores(1, 456);
		this.setListaJogadores(0, 0);
	}

	// Getters
	public int getListaJogadores(int status) {
		return listaJogadores[status];
	}

	public String getTarefaQuadradoLista(int tarefa) {
		return tarefaQuadradoLista[tarefa];
	}

	// Setters
	public void setListaJogadores(int status, int quantidade) {
		this.listaJogadores[status] = quantidade;
	}

	// Método
	@Override
	public void trabalhar(int dia, int executadosDiaJogo) {
		this.setDescansoConsecutivo(0);

		int tarefaQuadradoDia = (int)(Math.random() * 5);

		if (dia == 6) {
			System.out.println(this.getTarefaQuadradoLista(5));
		} else {
			System.out.println(this.getTarefaQuadradoLista(tarefaQuadradoDia));
		}

		System.out.printf("Jogadores vivos: %d\n", this.getListaJogadores(1));
		System.out.printf("Jogadores executados hoje: %d\n", executadosDiaJogo);
		System.out.printf("Jogadores executados no total: %d\n",
			this.getListaJogadores(0));
	}
}