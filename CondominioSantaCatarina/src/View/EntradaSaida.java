package View;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Model.Apartamento;

public class EntradaSaida {

	public static String solicitaNumeroApto() {
		return JOptionPane.showInputDialog("Digite o número do apartamento");
	}

	public static String solicitaSobrenome() {
		return JOptionPane.showInputDialog("Digite o sobrenome da família");
	}

	public static int solicitaQtdeMoradores() {
		int qtdeMoradores;
		do {
			qtdeMoradores = Integer.parseInt(JOptionPane.showInputDialog("Quantos moradores há no apartamento?"));
			if (qtdeMoradores <= 0)
				JOptionPane.showMessageDialog(null, "O número de moradores deve ser maior que 0");
		} while (qtdeMoradores <= 0);
		return qtdeMoradores;
	}

	public static double solicitaRendaTotal() {
		double rendaTotal;
		do {
			rendaTotal = Double.parseDouble(JOptionPane.showInputDialog("Digite a renda total da família"));
			if (rendaTotal <= 0)
				JOptionPane.showMessageDialog(null, "A renda total deve ser maior que R$ 0,00");
		} while (rendaTotal <= 0);
		return rendaTotal;
	}

	public static void semAptoCadastrado() {
		JOptionPane.showMessageDialog(null, "Não há apartamentos cadastrados");

	}

	public static int solicitaOpcao() {
		String[] vetorOpcoes = { "Cadastrar novo apartamento", "Alterar dados de uma família",
				"Remover cadastro de apartamento", "Consultar dados gerais", "Consultar dados de um apartamento",
				"Encerrar" };
		JComboBox<String> listaOpcoes = new JComboBox<String>(vetorOpcoes);
		int opcao = JOptionPane.showConfirmDialog(null, listaOpcoes, "Menu", JOptionPane.OK_CANCEL_OPTION);
		if (opcao == 0)
			return listaOpcoes.getSelectedIndex();
		else
			return -1;
	}

	public static int solicitaApartamento(ArrayList<Apartamento> listaApto,String alterarRemover) {
		String[] aptos = new String[listaApto.size()];
		for (int i = 0; i < listaApto.size(); i++) {
			aptos[i] = listaApto.get(i).getNumeroApto();
		}
		JComboBox<String> listaAptos = new JComboBox<String>(aptos);
		JOptionPane.showConfirmDialog(null, listaAptos, "Qual apartamento deseja " + alterarRemover + " os dados.", JOptionPane.OK_CANCEL_OPTION);
		return listaAptos.getSelectedIndex();
	}

	public static int solicitaAlteracao(ArrayList<Apartamento> listaApto) {
		String[] opcoes = {"Sobrenome da Família","Quantidade de Moradores","Renda Total"};
		JComboBox<String> listaDeOpcoes = new JComboBox<String>(opcoes);
		int opcaoSelecionada = JOptionPane.showConfirmDialog(null, listaDeOpcoes, "Selecione qual item deve ser modificado", JOptionPane.OK_CANCEL_OPTION);
		if (opcaoSelecionada == 0)
			return listaDeOpcoes.getSelectedIndex();
		else
			return -2;
	}

	public static void exibirDadosGerais(String gerarDadosGeral) {
		JOptionPane.showMessageDialog(null, gerarDadosGeral);
	}

	public static void exibirDadosApartamento(String gerarDadosApartamento) {
		JOptionPane.showMessageDialog(null, gerarDadosApartamento);
		
	}

	public static void exibirMsgAptoExistente() {
		JOptionPane.showMessageDialog(null, "Apartamento já existente. Cadastre um novo apartamento");
		
	}

}
