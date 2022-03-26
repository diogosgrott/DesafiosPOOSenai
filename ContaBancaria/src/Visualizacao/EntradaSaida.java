package Visualizacao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

	public static int solicitaOpcao() {
		String[] opcao = { "Depositar", "Sacar", "Ver saldo", "Ver dados da conta", "Ver extrato",
				"Ver extrato de depósitos", "Ver extrato de saques", "Sair" };
		JComboBox<String> menu = new JComboBox<String>(opcao);
		int escolha = JOptionPane.showConfirmDialog(null, menu, "Qual operação deseja realizar?",
				JOptionPane.OK_CANCEL_OPTION);
		if (escolha == 0) {
			return menu.getSelectedIndex();
		} else {
			return -1;
		}
	}

	public static void encerrarPrograma() {
		JOptionPane.showMessageDialog(null, "O programa foi encerrado");
	}

	public static String solicitaTitular() {
		return JOptionPane.showInputDialog("Digite o nome do titular da conta");
	}

	public static String solicitaTipoDeConta() {
		String[] tiposDeConta = { "Poupança", "Corrente" };
		int tipoDeConta = JOptionPane.showOptionDialog(null, "Qual tipo de conta deseja criar", "Tipo de Conta",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tiposDeConta, tiposDeConta[0]);
		return tiposDeConta[tipoDeConta];
	}

	public static double solicitaInfoDeposito() {
		double valor;
		do {
			valor = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor para depósito?"));
			if (valor <= 0) {
				JOptionPane.showMessageDialog(null, "O valor deve ser maior que R$ 0,00");
			}
		} while (valor <= 0);
		return valor;
	}

	public static double solicitaInfoSaque() {
		double valor;
		do {
			valor = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor para saque?"));
			if (valor <= 0) {
				JOptionPane.showMessageDialog(null, "O valor deve ser maior que R$ 0,00");
			}
		} while (valor <= 0);
		return valor;
	}

	public static String solicitaData() {
		return JOptionPane.showInputDialog("Digite a data da movimentação: DD/MM/AAAA");
	}

	public static void exibirSaldo(double valor) {
		JOptionPane.showMessageDialog(null, "Seu saldo atual é de: R$ " + valor);
	}

	public static void exibirDadosDaConta(String dadosDaConta) {
		JOptionPane.showMessageDialog(null, dadosDaConta);
	}

	public static void exibirExtratoCompleto(String infoMovimentacao) {
		JOptionPane.showMessageDialog(null, infoMovimentacao);
	}

	public static void exibirExtratoSeparado(String infoMovimentacao) {
		JOptionPane.showMessageDialog(null, infoMovimentacao);
	}

}
