package Model;

import java.util.ArrayList;

public class Condominio {

	private ArrayList<Apartamento> listaApto = new ArrayList<Apartamento>();

	public ArrayList<Apartamento> getListaApto() {
		return listaApto;
	}

	public void setListaApto(ArrayList<Apartamento> listaApto) {
		this.listaApto = listaApto;
	}

	public void cadastrarApto(String numeroApto, String sobrenomeFamilia, int qtdeMoradores, double rendaTotal) {
		Apartamento apartamento = new Apartamento(numeroApto, sobrenomeFamilia, qtdeMoradores, rendaTotal);
		listaApto.add(apartamento);
	}

	public String gerarDadosGeral() {
		String dadosGerais = "Dados Gerais do Condomínio:\n";
		dadosGerais += "\nApto - Sobrenome - Qtde de moradores - Renta Total - Renda Média";
		for (int i = 0; i<listaApto.size();i++) {
			dadosGerais+="\n" + listaApto.get(i).getNumeroApto()
					+ "   -   " + listaApto.get(i).getSobrenomeFamilia()
					+ "              -              " + listaApto.get(i).getQtdeMoradores()
					+ "        -        " + listaApto.get(i).getRendaTotal();
			String rendaMedia = String.format("%.2f", (listaApto.get(i).getRendaTotal()/listaApto.get(i).getQtdeMoradores()));
			dadosGerais += "        -        " + rendaMedia;
		}
		return dadosGerais;	
	}
	
	public String gerarDadosApartamento(int apartamentoSelecionado) {
		String dadosApto = "Dados do apartamento " + listaApto.get(apartamentoSelecionado).getNumeroApto() + "\n";
		dadosApto += "\nSobrenome: " + listaApto.get(apartamentoSelecionado).getSobrenomeFamilia()
				+ "\nQtde de moradores: " + listaApto.get(apartamentoSelecionado).getQtdeMoradores()
				+ "\nRenda Total: R$ " + listaApto.get(apartamentoSelecionado).getRendaTotal();
		String rendaMedia = String.format("%.2f", (listaApto.get(apartamentoSelecionado).getRendaTotal()/listaApto.get(apartamentoSelecionado).getQtdeMoradores()));
		dadosApto += "\nRenda Média: R$ " + rendaMedia;
		return dadosApto;
	}

}
