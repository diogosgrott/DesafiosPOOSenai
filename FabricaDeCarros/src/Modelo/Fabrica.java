package Modelo;

import java.util.ArrayList;

public class Fabrica {

	private ArrayList<Carro> listaDeCarros = new ArrayList<Carro>();

	public ArrayList<Carro> getListaDeCarros() {
		return listaDeCarros;
	}

	public void setListaDeCarros(ArrayList<Carro> listaDeCarros) {
		this.listaDeCarros = listaDeCarros;
	}

	public Carro fabricarCarro(String modelo, String cor) {
		Carro carro = new Carro();
		carro.setModelo(modelo);
		carro.setCor(cor);
		return carro;
	}

	public void venderCarro (int posicao) {
		listaDeCarros.remove(posicao);
	}

	public String imprimirInfoCarros() {
		String informacoes = "A fábrica possui " + listaDeCarros.size() + " carro(s), listados por modelo e cor\n";
		
		for (Carro carro : listaDeCarros) {
			informacoes += "\n" + carro.getModelo() + " - " + carro.getCor();
		}
		
		return informacoes;
	}

}
