package modelo;

import java.util.ArrayList;

public class Casa {

	private String descricao;
	private String cor;
	private ArrayList<Aberturas> listaDePortas = new ArrayList<Aberturas>();
	private ArrayList<Aberturas> listaDeJanelas = new ArrayList<Aberturas>();

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public ArrayList<Aberturas> getListaDePortas() {
		return listaDePortas;
	}

	public void setListaDePortas(ArrayList<Aberturas> listaDePortas) {
		this.listaDePortas = listaDePortas;
	}

	public ArrayList<Aberturas> getListaDeJanelas() {
		return listaDeJanelas;
	}

	public void setListaDeJanelas(ArrayList<Aberturas> listaDeJanelas) {
		this.listaDeJanelas = listaDeJanelas;
	}

	public void constroiCasa(String descricao, String cor, ArrayList<Aberturas> listaDePortas,
			ArrayList<Aberturas> listaDeJanelas) {
		this.descricao = descricao;
		this.cor = cor;
		this.listaDePortas = listaDePortas;
		this.listaDeJanelas = listaDeJanelas;

		/*
		 * setDescricao(descricao); 
		 * setCor(cor); 
		 * setListaDePortas(listaDePortas);
		 * setListaDeJanelas(listaDeJanelas);
		 */
	}

	public Aberturas retornaAbertura(int posicao, String tipoAbertura) {
		if (tipoAbertura.equals("porta")) {
			return this.listaDePortas.get(posicao);
		} else {
			return this.listaDeJanelas.get(posicao);
		}
	}
	
	public void moverAbertura(Aberturas abertura, int novoEstado) {
		abertura.setEstado(novoEstado);
	}

	public String geraInfoCasa() {
		String informacoes = "Descri��o: " + this.descricao + "\nCor: " + this.cor + "" + "\n\nLista de portas:\n";
		for (Aberturas abertura : this.listaDePortas) {
			int estado = abertura.getEstado();
			String estadoString = validacaoEstadoAbertura(estado);
			informacoes += "  " + abertura.getDescricao() + " - " + estadoString + "\n";
		}

		informacoes += "\nLista de janelas:\n";

		for (Aberturas abertura : this.listaDeJanelas) {
			int estado = abertura.getEstado();
			String estadoString = validacaoEstadoAbertura(estado);
			informacoes += "  " + abertura.getDescricao() + " - " + estadoString + "\n";
		}

		return informacoes;
	}

	public String validacaoEstadoAbertura(int estado) {
		if (estado == 0) {
			return "Fechada";
		} else {
			return "Aberta";
		}
	}

}
