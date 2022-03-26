package Controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Modelo.*;
import Visualizacao.EntradaSaida;

public class Controladora {

	public void exibeMenu() {

		Fabrica fabrica = new Fabrica();
		ArrayList<Carro> listaDeCarros = new ArrayList<Carro>();

		// set de lista de carros para não ser necessário passar os mesmos parâmetros
		// nos métodos
		fabrica.setListaDeCarros(listaDeCarros);
		EntradaSaida.exibeMsgBemVindo();

		int opcao;
		do {
			if (listaDeCarros.isEmpty()) {
				EntradaSaida.exibeMsgSemCarro();
				int qtdeCarros = EntradaSaida.solicitaQtdeCarros();
				for (int i = 0; i < qtdeCarros; i++) {
					String modelo = EntradaSaida.solicitaModelo();
					String cor = EntradaSaida.solicitaCor();
					listaDeCarros.add(fabrica.fabricarCarro(modelo, cor));
				}
			}

			opcao = EntradaSaida.solicitaOpcao();
			switch (opcao) {
			case 0:
				int qtdeCarros = EntradaSaida.solicitaQtdeCarros();
				for (int i = 0; i < qtdeCarros; i++) {
					String modelo = EntradaSaida.solicitaModelo();
					String cor = EntradaSaida.solicitaCor();
					listaDeCarros.add(fabrica.fabricarCarro(modelo, cor));
				}
				break;

			case 1:
				int posicao = EntradaSaida.solicitaPosicaoVenda(listaDeCarros);
				fabrica.venderCarro(posicao);
				break;

			case 2:
				String informacoes = fabrica.imprimirInfoCarros();
				EntradaSaida.geraInfoCarros(informacoes);
				break;
			}

		} while (opcao != 3);

		EntradaSaida.exibeMsgFinal();
		System.exit(0);
	}

}
