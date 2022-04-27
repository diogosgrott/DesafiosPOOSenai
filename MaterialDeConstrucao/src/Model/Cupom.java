package Model;

import java.util.Date;

public class Cupom {

	private Date data;
	private Produto produto;
	private int qtdeVenda;

	public Cupom(String codigo, String descricao, double preco, int qtdeVenda) {
		this.data = new Date();
		produto = new Produto(codigo, descricao, preco, qtdeVenda);
		this.qtdeVenda = qtdeVenda;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getQtdeVenda() {
		return qtdeVenda;
	}

	public void setQtdeVenda(int qtdeVenda) {
		this.qtdeVenda = qtdeVenda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
