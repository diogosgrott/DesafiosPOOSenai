package View;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Model.Produto;

public class EntradaSaida {

	public static void msgListaVazia() {
		JOptionPane.showMessageDialog(null, "Não há produtos cadastrados. Cadastre um novo produto.");
	}

	public static int solicitarOpcaoMenu() {
		String[] opcoes = { "Cadastrar Produtos", "Listar Produtos", "Adicionar estoque", "Vender Produto",
				"Lista de Produtos em Estoque", "Cupons Gerados", "Total de Vendas", "Sair" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		int opcao = JOptionPane.showConfirmDialog(null, menu, "Menu", JOptionPane.OK_CANCEL_OPTION);
		if (opcao == 0)
			return menu.getSelectedIndex();
		else
			return -1;
	}

	public static int solicitarQtdeProdutosDiferentes() {
		int qtde;
		do {
			qtde = Integer
					.parseInt(JOptionPane.showInputDialog("Digite quantos produtos diferentes gostaria de cadastrar"));
			if (qtde <= 0)
				JOptionPane.showMessageDialog(null, "Você deve cadastrar no mínimo um produto");
		} while (qtde <= 0);
		return qtde;
	}

	public static String cadastrarCodigoProduto(int i) {
		return JOptionPane.showInputDialog("Digite o código do produto " + (i + 1));
	}

	public static String cadastrarDescricaoProduto() {
		return JOptionPane.showInputDialog("Digite a descricao do produto");
	}

	public static double cadastrarPrecoProduto() {
		double preco;
		do {
			preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço unitário do produto"));
			if (preco <= 0)
				JOptionPane.showMessageDialog(null, "O preço do produto deve ser maior que R$ 0,00");
		} while (preco <= 0);
		return preco;
	}

	public static void mostrarListaProdutos(String gerarListaProdutos) {
		JOptionPane.showMessageDialog(null, gerarListaProdutos);			

	}

	public static void msgProdutoRepetido(String repetido) {
		JOptionPane.showMessageDialog(null, "Já existe um produto com esse(a) " + repetido);

	}

	public static int solicitarProdutoAddEstoque(ArrayList<Produto> listaDeProdutos) {
		String[] produtosCadastrados = new String[listaDeProdutos.size()];
		for (int i = 0; i < listaDeProdutos.size(); i++) {
			produtosCadastrados[i] = listaDeProdutos.get(i).getDescricao();
		}
		JComboBox<String> produtos = new JComboBox<String>(produtosCadastrados);
		int opcaoAdd = JOptionPane.showConfirmDialog(null, produtos, "Selecione um produto para adicionar estoque",
				JOptionPane.OK_CANCEL_OPTION);
		if (opcaoAdd == 0) {
			return produtos.getSelectedIndex();
		} else {
			return -2;
		}

	}

	public static int solicitarProdutoVender(ArrayList<Produto> listaDeProdutos) {
		String[] produtosCadastrados = new String[listaDeProdutos.size()];
		for (int i = 0; i < listaDeProdutos.size(); i++) {
			if (listaDeProdutos.get(i).getQtde() > 0) {
				produtosCadastrados[i] = listaDeProdutos.get(i).getDescricao();
			}
		}
		if(produtosCadastrados[0]!=null) {
			JComboBox<String> produtos = new JComboBox<String>(produtosCadastrados);
			int opcaoAdd = JOptionPane.showConfirmDialog(null, produtos, "Selecione um produto para vender",
					JOptionPane.OK_CANCEL_OPTION);
			if (opcaoAdd == 0) {
				return produtos.getSelectedIndex();
			} else {
				return -2;
			}			
		}else {
			JOptionPane.showMessageDialog(null, "Não há produtos com estoque");
			return -2;		
		}

	}

	public static int solicitarQtdeAddEstoque() {
		int qtdeAddEstoque;
		do {
			qtdeAddEstoque = Integer
					.parseInt(JOptionPane.showInputDialog("Digite quantas unidades entraram em estoque"));
			if (qtdeAddEstoque <= 0)
				JOptionPane.showMessageDialog(null, "A quantidade deve ser maior que 0");
		} while (qtdeAddEstoque <= 0);
		return qtdeAddEstoque;
	}

	public static void msgAcaoNaoFeita() {
		JOptionPane.showMessageDialog(null, "Nenhuma ação será feita");
	}

	public static void estoqueNaoSuficiente() {
		JOptionPane.showMessageDialog(null, "Estoque não suficiente. Nenhuma venda foi feita.");
	}

	public static int solicitaQtdeVenda() {
		int qtdeVenda;
		do {
			qtdeVenda = Integer.parseInt(JOptionPane.showInputDialog("Digite quantas unidades entraram em estoque"));
			if (qtdeVenda <= 0)
				JOptionPane.showMessageDialog(null, "A quantidade deve ser maior que 0");
		} while (qtdeVenda <= 0);
		return qtdeVenda;
	}

	public static void mostrarListaEstoque(String listaProdutosEstoque) {
		if (listaProdutosEstoque.equals("PRODUTOS EM ESTOQUE\n")) {
			JOptionPane.showMessageDialog(null, "Não há produtos em estoque");
		}else {
			JOptionPane.showMessageDialog(null, listaProdutosEstoque);
		}
	}

	public static void mostrarCupons(String gerarListaCupons) {
		if (gerarListaCupons.equals("LISTA DE CUPONS FISCAIS\n")) {
			JOptionPane.showMessageDialog(null, "Não há cupons gerados");
		}else {
			JOptionPane.showMessageDialog(null, gerarListaCupons);
		}
	}

	public static void mostrarTotalVendas(double valorTotalVendas) {
		DecimalFormat formatoValor = new DecimalFormat("R$ 0.00");
		JOptionPane.showMessageDialog(null, "VALOR TOTAL DE VENDAS\n\n" + formatoValor.format(valorTotalVendas));
		
	}

}
