package br.com.entra21.model;

import java.util.ArrayList;

public class MaturidadeNivel3Richardson {
	private ArrayList<ItemNivel3> links;

	public MaturidadeNivel3Richardson(ArrayList<ItemNivel3> links) {
		super();
		this.links = links;
	}

	public MaturidadeNivel3Richardson() {}

	public ArrayList<ItemNivel3> getLinks() {
		return links;
	}

	public void setLinks(ArrayList<ItemNivel3> links) {
		this.links = links;
	}
}
