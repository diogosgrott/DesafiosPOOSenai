package Modelo;

import java.util.ArrayList;

public class Conta {

	private String titular;
	private String tipoDeConta;
	private double saldo;
	private ArrayList<Movimentacao> listaDeMovimentacao = new ArrayList<Movimentacao>();

	public Conta() {
		this.saldo = 0;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getTipoDeConta() {
		return tipoDeConta;
	}

	public void setTipoDeConta(String tipoDeConta) {
		this.tipoDeConta = tipoDeConta;
	}

	public double getSaldo() {
		return saldo;
	}

	private void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public ArrayList<Movimentacao> getListaDeMovimentacao() {
		return listaDeMovimentacao;
	}

	public void setListaDeMovimentacao(ArrayList<Movimentacao> listaDeMovimentacao) {
		this.listaDeMovimentacao = listaDeMovimentacao;
	}

	public void deposito(double valor, Conta conta) {
		this.saldo += valor;
		conta.setSaldo(this.saldo);
	}

	public void saque(double valor, Conta conta) {
		this.saldo -= valor;
		conta.setSaldo(this.saldo);
	}
	
	public String gerarDadosConta() {
		return "Titular: " + this.titular + "\nTipo de Conta: " + this.tipoDeConta + "\nSaldo Atual: R$ " + this.saldo;
	}

	public String geraExtratoCompleto() {
		String infoMovimentacao = "EXTRATO COMPLETO\n";
		for (Movimentacao cadaMovimentacao : listaDeMovimentacao) {
			infoMovimentacao += "\n" + cadaMovimentacao.getTipoDeMovimentacao() + " - R$ "
					+ cadaMovimentacao.getValor() + " - " + cadaMovimentacao.getData();
		}
		return infoMovimentacao;
	}
	
	public String geraExtratoSeparado(String tipoDeMovimentacao) {
		String infoMovimentacao = "Extrato de " + tipoDeMovimentacao + "\n";
		for (Movimentacao cadaMovimentacao : listaDeMovimentacao) {
			if(cadaMovimentacao.getTipoDeMovimentacao().equals(tipoDeMovimentacao)) {
				infoMovimentacao += "\n" + cadaMovimentacao.getTipoDeMovimentacao() + " - R$ "
						+ cadaMovimentacao.getValor() + " - " + cadaMovimentacao.getData();
			}
		}
		return infoMovimentacao;
	}
}
