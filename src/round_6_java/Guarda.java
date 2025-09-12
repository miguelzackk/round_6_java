// Superclasse das classes Supervisor, Soldado e Trabalhador
package round_6_java;

abstract class Guarda {
	// Atributos
	private boolean estaVivo;
	private String tipoMascara;
	private String[] tipoMascaraLista = {"Quadrado □", "Triângulo △",
		"Círculo ○"};
	private String regrasGuarda = "\nLeia com atenção as regras: \n"
		+ "1. SEMPRE USE A SUA MÁSCARA QUANDO ESTIVER FORA DO SEU QUARTO\n"
		+ "2. NÃO CONVERSE SEM PERMISSÃO\n"
		+ "3. NÃO SAIA DO SEU QUARTO SEM PERMISSÃO";
	private String[] testeLista = {"\nUm jogador pediu a sua ajuda. Deseja "
		+ "ajudar?",
		"\nDeseja olhar a sala do jogo de hoje antes de ser chamado?",
		"\nO seu olho está coçando, deseja tirar a máscara?",
		"\nDeseja contar uma piada para outro guarda?"};
	private int descansoConsecutivo;

	// Construtor
	public Guarda() {
		this.estaVivo = true;
	}

	// Getters
	public boolean getEstaVivo() {
		return estaVivo;
	}

	public String getTipoMascara() {
		return tipoMascara;
	}

	public String getRegrasGuarda() {
		return regrasGuarda;
	}

	// Setters
	public void setEstaVivo(boolean estaVivo) {
		this.estaVivo = estaVivo;
	}

	public void setTipoMascara(int tipoMascara) {
		this.tipoMascara = tipoMascaraLista[tipoMascara];
	}

	public void setDescansoConsecutivo(int descansoConsecutivo) {
		this.descansoConsecutivo = descansoConsecutivo;
	}

	// Métodos
	public abstract void trabalhar(int dia, int executadosDiaJogo);

	public String descansar() {
		String guardaEscolha;
		descansoConsecutivo++;
		if (descansoConsecutivo < 2) {
			guardaEscolha = "Você escolheu descansar hoje.";
		} else {
			this.setEstaVivo(false);
			guardaEscolha = "Você descansou por tempo demais e foi executado "
				+ "\npor outro guarda.";
		}
		return guardaEscolha;
	}

	public String escolherTeste (int escolha) {
		String teste = testeLista[escolha];
		return teste;
	}
}