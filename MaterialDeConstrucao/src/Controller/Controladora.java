package Controller;

import Model.*;
import View.EntradaSaida;

public class Controladora {

	Loja loja = new Loja();

	public void exibirMenu() {

		int opcao;
		do {
			if (loja.getListaDeProdutos().isEmpty()) {
				EntradaSaida.msgListaVazia();
				cadastrarProduto();
			}

			opcao = EntradaSaida.solicitarOpcaoMenu();
			switch (opcao) {

			case 0:
				cadastrarProduto();
				break;

			case 1:
				EntradaSaida.mostrarListaProdutos(loja.gerarListaProdutos());
				break;

			case 2:
				int opcaoAdd = EntradaSaida.solicitarProdutoAddEstoque(loja.getListaDeProdutos());
				if (opcaoAdd != -2) {
					int qtdeAdd = EntradaSaida.solicitarQtdeAddEstoque();
					loja.adicionarProdutoEstoque(opcaoAdd, qtdeAdd);
				} else {
					EntradaSaida.msgAcaoNaoFeita();
				}
				break;

			case 3:
				int opcaoVenda = EntradaSaida.solicitarProdutoVender(loja.getListaDeProdutos());
				if (opcaoVenda != -2) {
					int qtdeVenda;
					do {
						qtdeVenda = EntradaSaida.solicitaQtdeVenda();
						if ((loja.getListaDeProdutos().get(opcaoVenda).getQtde() - qtdeVenda) < 0) {
							EntradaSaida.estoqueNaoSuficiente();
						}
					} while ((loja.getListaDeProdutos().get(opcaoVenda).getQtde() - qtdeVenda) < 0);
					loja.venderProduto(opcaoVenda, qtdeVenda);
					Cupom cupom = new Cupom(loja.getListaDeProdutos().get(opcaoVenda).getCodigo(),
							loja.getListaDeProdutos().get(opcaoVenda).getDescricao(),
							loja.getListaDeProdutos().get(opcaoVenda).getPreco(), qtdeVenda);
					loja.adicionarCupom(cupom);

				} else {
					EntradaSaida.msgAcaoNaoFeita();
				}
				break;

			case 4:
				EntradaSaida.mostrarListaEstoque(loja.gerarProdutosEstoque());
				break;

			case 5:
				EntradaSaida.mostrarCupons(loja.gerarListaCupons());
				break;

			case 6:
				EntradaSaida.mostrarTotalVendas(loja.getValorTotalVendas());
				break;
			}

		} while (opcao != 7 && opcao != -1);

	}

	public void cadastrarProduto() {
		int qtdeProdutosDiferentes = EntradaSaida.solicitarQtdeProdutosDiferentes();
		for (int i = 0; i < qtdeProdutosDiferentes; i++) {
			String codigo;
			String descricao;
			boolean validacao;
			do {
				validacao = true;
				codigo = EntradaSaida.cadastrarCodigoProduto(i);
				for (int j = 0; j < loja.getListaDeProdutos().size(); j++) {
					String comparacao = loja.getListaDeProdutos().get(j).getCodigo();
					if (codigo.equals(comparacao)) {
						EntradaSaida.msgProdutoRepetido("codigo");
						validacao = false;
					}
				}

			} while (validacao == false);

			do {
				validacao = true;
				descricao = EntradaSaida.cadastrarDescricaoProduto();
				for (int j = 0; j < loja.getListaDeProdutos().size(); j++) {
					String comparacao = loja.getListaDeProdutos().get(j).getDescricao();
					if (descricao.equals(comparacao)) {
						EntradaSaida.msgProdutoRepetido("descrição");
						validacao = false;
					}
				}

			} while (validacao == false);

			double preco = EntradaSaida.cadastrarPrecoProduto();
			loja.criarProduto(codigo, descricao, preco);
		}
	}
}
