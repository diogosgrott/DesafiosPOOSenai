package Model;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Loja {

	ArrayList<Produto> listaDeProdutos = new ArrayList<Produto>();
	ArrayList<Cupom> listaDeCupons = new ArrayList<Cupom>();

	public ArrayList<Produto> getListaDeProdutos() {
		return listaDeProdutos;
	}

	public void setListaDeProdutos(ArrayList<Produto> listaDeProdutos) {
		this.listaDeProdutos = listaDeProdutos;
	}

	public ArrayList<Cupom> getListaDeCupons() {
		return listaDeCupons;
	}

	public void setListaDeCupons(ArrayList<Cupom> listaDeCupons) {
		this.listaDeCupons = listaDeCupons;
	}

	public void criarProduto(String codigo, String descricao, double preco) {
		Produto produto = new Produto(codigo, descricao, preco);
		listaDeProdutos.add(produto);
	}

	public String gerarListaProdutos() {
		String listaDeProdutos = "LISTA DE PRODUTOS CADASTRADOS\n";
		for (Produto produto : this.listaDeProdutos) {
			listaDeProdutos += "\n" + produto.getCodigo() + "  -  " + produto.getDescricao();
		}
		return listaDeProdutos;
	}

	public void adicionarProdutoEstoque(int posicao, int qtde) {
		this.listaDeProdutos.get(posicao).setQtde(this.listaDeProdutos.get(posicao).getQtde() + qtde);
	}

	public void venderProduto(int posicao, int qtdeVenda) {
		this.listaDeProdutos.get(posicao).setQtde(this.listaDeProdutos.get(posicao).getQtde() - qtdeVenda);
	}

	public void adicionarCupom(Cupom cupom) {
		this.listaDeCupons.add(cupom);
	}

	public String gerarProdutosEstoque() {
		String produtosEstoque = "PRODUTOS EM ESTOQUE\n";
		for (Produto produto : listaDeProdutos) {
			if (produto.getQtde() > 0) {
				produtosEstoque += "\n" + produto.getCodigo() + " - " + produto.getDescricao() + " - "
						+ produto.getQtde() + "un";
			}
		}
		return produtosEstoque;
	}

	public String gerarListaCupons() {
		DecimalFormat formatoValor = new DecimalFormat("R$0.00");
		String listaCupons = "LISTA DE CUPONS FISCAIS\n";
		for (Cupom cupom : listaDeCupons) {
			listaCupons += "\n" + cupom.getProduto().getCodigo() + " - " + cupom.getProduto().getDescricao()
					 + " - " + formatoValor.format(cupom.getProduto().getPreco()) + "/un - " + cupom.getProduto().getQtde()
					 + "un - Total " + formatoValor.format((cupom.getProduto().getQtde()*cupom.getProduto().getPreco()));
		}
		return listaCupons;
	}

	public double getValorTotalVendas() {
		double soma = 0;
		for (Cupom cupom : listaDeCupons) {
			soma += (cupom.getProduto().getPreco()*cupom.getProduto().getQtde());
		}
		return soma;
	}

}
