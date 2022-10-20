package br.com.entra21.model;

public class Pessoa extends MaturidadeNivel3Richardson {

	private String name;
	private int idade;

	public Pessoa(String name, int idade) {
		super();
		this.name = name;
		this.idade = idade;
	}

	public Pessoa() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}
