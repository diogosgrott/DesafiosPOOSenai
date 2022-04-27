package Model;

public class Produto {

	private String codigo;
	private String descricao;
	private double preco;
	private int qtde;

	public Produto(String codigo, String descricao, double preco) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.qtde = 0;
	}
	
	public Produto(String codigo, String descricao, double preco, int qtdeVenda) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
		this.qtde = qtdeVenda;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}


}
