package Visualizacao;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import Modelo.Carro;

public class EntradaSaida {

	public static int solicitaOpcao() {
		String[] opcoes = { "Fabricar carros", "Vender um carro", "Ver informações dos carros", "Sair" };
		JComboBox<String> menuPrincipal = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menuPrincipal, "Selecione a função desejada", JOptionPane.CLOSED_OPTION);
		return menuPrincipal.getSelectedIndex();
	}

	public static int solicitaQtdeCarros() {
		int qtde;
		do {
			qtde = Integer.parseInt(JOptionPane.showInputDialog("Quantos carros serão fabricados?"));
			if (qtde <= 0)
				JOptionPane.showMessageDialog(null, "A quantidade deve ser maior que zero!");
		} while (qtde <= 0);
		return qtde;
	}

	public static String solicitaModelo() {
		return JOptionPane.showInputDialog("Digite o modelo do carro");
	}

	public static String solicitaCor() {
		return JOptionPane.showInputDialog("Digite a cor do carro");
	}

	public static int solicitaPosicaoVenda(ArrayList<Carro> listaDeCarros) {
		String[] conteudoListaDeCarros = new String[listaDeCarros.size()];
		for (int i = 0; i < listaDeCarros.size(); i++) {
			conteudoListaDeCarros[i] = listaDeCarros.get(i).getModelo() + " - " + listaDeCarros.get(i).getCor();
		}
		
		JComboBox mostraListaDeCarros = new JComboBox(conteudoListaDeCarros);
		return JOptionPane.showConfirmDialog(null, mostraListaDeCarros,"Escolha qual carro foi vendido", JOptionPane.CLOSED_OPTION);
	}
	
	public static void geraInfoCarros(String informacoes) {
		JOptionPane.showMessageDialog(null, informacoes, "Inventário de Carros", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void exibeMsgFinal() {
		JOptionPane.showMessageDialog(null, "O programa foi encerrado!");
	}
	
	public static void exibeMsgBemVindo() {
		JOptionPane.showMessageDialog(null, "Bem vindo a fábrica de carros!");
	}
	
	public static void exibeMsgSemCarro() {
		JOptionPane.showMessageDialog(null, "Não há carros no estoque para venda. Fabrique novos carros.");
	}

}
