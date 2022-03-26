package Controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Modelo.*;
import Visualizacao.EntradaSaida;

public class Controladora {

	private Conta conta = null;
	private ArrayList<Movimentacao> movimentacao = null;

	public void exibirMenu() {
		int opcao;

		do {
			if (conta == null) {
				this.conta = new Conta();
				this.conta.setTitular(EntradaSaida.solicitaTitular());
				this.conta.setTipoDeConta(EntradaSaida.solicitaTipoDeConta());
				movimentacao = new ArrayList<Movimentacao>();
				this.conta.setListaDeMovimentacao(movimentacao);
			}

			opcao = EntradaSaida.solicitaOpcao();

			switch (opcao) {
			case 0:
				double valor = EntradaSaida.solicitaInfoDeposito();
				conta.deposito(valor, conta);
				Movimentacao novaMovimentacao = new Movimentacao("Depósito", valor);
				movimentacao.add(novaMovimentacao);
				break;

			case 1:
				double valorAposSaque;
				do {
					valor = EntradaSaida.solicitaInfoSaque();
					valorAposSaque = conta.getSaldo() - valor;
					if (valorAposSaque < -1000)
						JOptionPane.showMessageDialog(null,
								"Não há crédito disponível. Seu limite máximo é de  R$ -1000,00 ");
				} while (valorAposSaque < -1000);
				conta.saque(valor, conta);
				novaMovimentacao = new Movimentacao("Saque", valor);
				movimentacao.add(novaMovimentacao);
				break;

			case 2:
				EntradaSaida.exibirSaldo(conta.getSaldo());
				break;

			case 3:
				EntradaSaida.exibirDadosDaConta(conta.gerarDadosConta());
				break;

			case 4:
				String infoMovimentacao = conta.geraExtratoCompleto();
				EntradaSaida.exibirExtratoCompleto(infoMovimentacao);
				break;

			case 5:
				infoMovimentacao = conta.geraExtratoSeparado("Depósito");
				EntradaSaida.exibirExtratoSeparado(infoMovimentacao);
				break;

			case 6:
				infoMovimentacao = conta.geraExtratoSeparado("Saque");
				EntradaSaida.exibirExtratoSeparado(infoMovimentacao);
				break;
			}

		} while (opcao != 7 && opcao != -1);

		EntradaSaida.encerrarPrograma();

	}

}
