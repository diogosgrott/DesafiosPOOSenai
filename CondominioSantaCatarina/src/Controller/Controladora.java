package Controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Model.*;
import View.EntradaSaida;

public class Controladora {

	private Condominio condominio = new Condominio();

	public void exibeMenu() {
		int opcao;

		do {
			if (condominio.getListaApto().isEmpty()) {
				EntradaSaida.semAptoCadastrado();
				String numeroApto = EntradaSaida.solicitaNumeroApto();
				String sobrenomeFamilia = EntradaSaida.solicitaSobrenome();
				int qtdeMoradores = EntradaSaida.solicitaQtdeMoradores();
				double rendaTotal = EntradaSaida.solicitaRendaTotal();
				condominio.cadastrarApto(numeroApto, sobrenomeFamilia, qtdeMoradores, rendaTotal);
			}
			opcao = EntradaSaida.solicitaOpcao();
			switch (opcao) {
			case 0:
				String numeroApto;
				boolean validacao = true;
				do {
					validacao = true;
					numeroApto = EntradaSaida.solicitaNumeroApto();
					for (int i = 0; i < condominio.getListaApto().size(); i++) {
						String comparacao = condominio.getListaApto().get(i).getNumeroApto();
						if (numeroApto.equals(comparacao)) {
							EntradaSaida.exibirMsgAptoExistente();
							validacao = false;
						}
					}
				} while (validacao == false);
				String sobrenomeFamilia = EntradaSaida.solicitaSobrenome();
				int qtdeMoradores = EntradaSaida.solicitaQtdeMoradores();
				double rendaTotal = EntradaSaida.solicitaRendaTotal();
				condominio.cadastrarApto(numeroApto, sobrenomeFamilia, qtdeMoradores, rendaTotal);
				break;

			case 1:
				int apartamentoSelecionado = EntradaSaida.solicitaApartamento(condominio.getListaApto(), "alterar");
				int selecionarAlteracao = EntradaSaida.solicitaAlteracao(condominio.getListaApto());
				if (selecionarAlteracao == 0) {
					sobrenomeFamilia = EntradaSaida.solicitaSobrenome();
					condominio.getListaApto().get(apartamentoSelecionado).setSobrenomeFamilia(sobrenomeFamilia);
				} else if (selecionarAlteracao == 1) {
					qtdeMoradores = EntradaSaida.solicitaQtdeMoradores();
					condominio.getListaApto().get(apartamentoSelecionado).setQtdeMoradores(qtdeMoradores);
				} else if (selecionarAlteracao == 2) {
					rendaTotal = EntradaSaida.solicitaRendaTotal();
					condominio.getListaApto().get(apartamentoSelecionado).setRendaTotal(rendaTotal);
				} else {
					JOptionPane.showMessageDialog(null, "Nenhuma informação será alterada");
				}

				break;

			case 2:
				apartamentoSelecionado = EntradaSaida.solicitaApartamento(condominio.getListaApto(), "remover");
				condominio.getListaApto().remove(apartamentoSelecionado);
				break;

			case 3:
				EntradaSaida.exibirDadosGerais(condominio.gerarDadosGeral());
				break;

			case 4:
				apartamentoSelecionado = EntradaSaida.solicitaApartamento(condominio.getListaApto(), "remover");
				EntradaSaida.exibirDadosApartamento(condominio.gerarDadosApartamento(apartamentoSelecionado));
				break;
			}

		} while (opcao != 5 && opcao != -1);

	}

}
