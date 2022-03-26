package Modelo;

import java.util.Date;

public class Movimentacao {

	private String tipoDeMovimentacao;
	private double valor;
	private Date data;

	public Movimentacao(String tipoDeMovimentacao, double valor) {
		this.tipoDeMovimentacao = tipoDeMovimentacao;
		this.valor = valor;
		this.data = new Date();
	}

	public String getTipoDeMovimentacao() {
		return tipoDeMovimentacao;
	}

	public void setTipoDeMovimentacao(String tipoDeMovimentacao) {
		this.tipoDeMovimentacao = tipoDeMovimentacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
