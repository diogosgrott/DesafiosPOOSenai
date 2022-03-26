package BatalhaNaval;

import javax.swing.JOptionPane;

public class BatalhaNaval {

	public static void main(String[] args) {
		// variáveis
		int quantidadeColLinhas = 5;
		int[][] tabuleiroJogador1 = new int[quantidadeColLinhas][quantidadeColLinhas];
		int[][] tabuleiroJogador2 = new int[quantidadeColLinhas][quantidadeColLinhas];
		String[][] tabuleiroImpressao1 = new String[quantidadeColLinhas][quantidadeColLinhas];
		String[][] tabuleiroImpressao2 = new String[quantidadeColLinhas][quantidadeColLinhas];
		boolean vitoria = false;
		int contador = 1;
		int posicaoTiro[];

		for (int i = 0; i < quantidadeColLinhas; i++) {
			for (int j = 0; j < quantidadeColLinhas; j++) {
				tabuleiroJogador1[i][j] = 0;
				tabuleiroJogador2[i][j] = 0;
				tabuleiroImpressao1[i][j] = "-";
				tabuleiroImpressao2[i][j] = "-";
			}
		}

		String[] jogador = new String[2];

		JOptionPane.showMessageDialog(null, "Sejam bem vindos ao jogo Batalha Naval em um tabuleiro 5x5!\n\n"
				+ "Cada competidor terá 2 navios:\n" + " - 1 Contratorpedeiro (3 casas)\n - 1 Submarino (2 casas)");

		// Cadastrar jogadores e posicionar navios
		jogador[0] = cadastrarJogador(1);
		tabuleiroJogador1 = posicionarNavio(3, tabuleiroJogador1);
		tabuleiroJogador1 = posicionarNavio(2, tabuleiroJogador1);

		jogador[1] = cadastrarJogador(2);
		tabuleiroJogador2 = posicionarNavio(3, tabuleiroJogador2);
		tabuleiroJogador2 = posicionarNavio(2, tabuleiroJogador2);

		// começar o jogo
		do {
			do {
				if (contador % 2 != 0) {
					// jogador 1
					posicaoTiro = atirar(jogador[0], tabuleiroImpressao2, contador);
					if (tabuleiroJogador2[posicaoTiro[0]][posicaoTiro[1]] == 1) {
						JOptionPane.showMessageDialog(null, "Você acertou uma parte do navio!");
						tabuleiroJogador2[posicaoTiro[0]][posicaoTiro[1]] = 0;
						tabuleiroImpressao2[posicaoTiro[0]][posicaoTiro[1]] = "*";
					} else {
						JOptionPane.showMessageDialog(null, "Você acertou a água!");
						tabuleiroImpressao2[posicaoTiro[0]][posicaoTiro[1]] = " ";
					}
					vitoria = verificarVitoria(tabuleiroJogador2);
					if (vitoria == true) {
						JOptionPane.showMessageDialog(null, "O jogador " + jogador[0] + " venceu!!");
						System.exit(0);
					}

				} else {
					// jogador 2
					posicaoTiro = atirar(jogador[1], tabuleiroImpressao1, contador);
					if (tabuleiroJogador1[posicaoTiro[0]][posicaoTiro[1]] == 1) {
						JOptionPane.showMessageDialog(null, "Você acertou uma parte do navio!");
						tabuleiroJogador1[posicaoTiro[0]][posicaoTiro[1]] = 0;
						tabuleiroImpressao1[posicaoTiro[0]][posicaoTiro[1]] = "*";
					} else {
						JOptionPane.showMessageDialog(null, "Você acertou a água!");
						tabuleiroImpressao1[posicaoTiro[0]][posicaoTiro[1]] = " ";
					}
					vitoria = verificarVitoria(tabuleiroJogador1);
					if (vitoria == true) {
						JOptionPane.showMessageDialog(null, "O jogador " + jogador[1] + " venceu!!");
						System.exit(0);
					}
				}
				contador++;
			} while (false);

		} while (vitoria == false);
	}

	public static String cadastrarJogador(int jogador) {
		return JOptionPane.showInputDialog("Digite o nome do jogador " + jogador);
	}

	//metodo para posicionar o navio
	public static int[][] posicionarNavio(int tamanho, int[][] tabuleiro) {
		int linha;
		int coluna;
		do { //vai posicionar quando garantir que não tem navio nessa posição
			do {
				linha = Integer.parseInt(
						JOptionPane.showInputDialog("Digite a linha para posicionar o navio de " + tamanho + " casas"));
			} while (linha < 1 || linha > 5);
			linha -= 1;
			do {
				coluna = Integer.parseInt(JOptionPane
						.showInputDialog("Digite a coluna para posicionar o navio de " + tamanho + " casas"));
			} while (coluna < 1 || coluna > 5);
			coluna -= 1;
			if (tabuleiro[linha][coluna] == 1)
				JOptionPane.showMessageDialog(null, "Já há um navio nessa posição!");
		} while (tabuleiro[linha][coluna] == 1);
		tabuleiro[linha][coluna] = 1;

		//metodo para garantir que o navio será posicionado na mesma direção
		tabuleiro = posicionarRestoNavio(tamanho, linha, coluna, tabuleiro); 

		return tabuleiro;
	}

	public static int[][] posicionarRestoNavio(int tamanho, int linha, int coluna, int[][] tabuleiro) {
		boolean validacao = false;
		boolean validacaoEspaco;
		boolean validacaoNavio = true;
		int posicao;
		int necessidadeDeEspacos = (tamanho - 1);

		do {
			validacao = false;
			do {
				posicao = Integer
						.parseInt(JOptionPane.showInputDialog("Digite a direção para as próximas posições dos navios"
								+ "\n\n1 - Para cima\n2 - Para direita\n3 - Para baixo\n4 - Para esquerda"));
			} while (posicao < 1 && posicao > 4);

			
			switch (posicao) {
			// checagem de espaço, checagem de navios
			case 1:
				validacaoEspaco = checagemEspaco(necessidadeDeEspacos, tabuleiro, -1, linha);
				if(validacaoEspaco == true)
					validacaoNavio = checagemNavioColunaFixa(necessidadeDeEspacos, tabuleiro, -1, linha, coluna);

				if (validacaoEspaco == true && validacaoNavio == true) {
					for (int i = 1; i < (necessidadeDeEspacos + 1); i++) {
						tabuleiro[linha - i][coluna] = 1;
					}
					validacao = true;
				}
				break;

			case 2:
				validacaoEspaco = checagemEspaco(necessidadeDeEspacos, tabuleiro, 1, coluna);
				if(validacaoEspaco == true)
					validacaoNavio = checagemNavioLinhaFixa(necessidadeDeEspacos, tabuleiro, 1, linha, coluna);

				if (validacaoEspaco == true && validacaoNavio == true) {
					for (int i = 1; i < (necessidadeDeEspacos + 1); i++) {
						tabuleiro[linha][coluna + i] = 1;
					}
					validacao = true;
				}
				break;

			case 3:
				validacaoEspaco = checagemEspaco(necessidadeDeEspacos, tabuleiro, 1, linha);
				if(validacaoEspaco == true)
					validacaoNavio = checagemNavioColunaFixa(necessidadeDeEspacos, tabuleiro, 1, linha, coluna);

				if (validacaoEspaco == true && validacaoNavio == true) {
					for (int i = 1; i < (necessidadeDeEspacos + 1); i++) {
						tabuleiro[linha + i][coluna] = 1;
					}
					validacao = true;
				}
				break;

			case 4:
				validacaoEspaco = checagemEspaco(necessidadeDeEspacos, tabuleiro, -1, coluna);
				if(validacaoEspaco == true)
					validacaoNavio = checagemNavioLinhaFixa(necessidadeDeEspacos, tabuleiro, -1, linha, coluna);

				if (validacaoEspaco == true && validacaoNavio == true) {
					for (int i = 1; i < (necessidadeDeEspacos + 1); i++) {
						tabuleiro[linha][coluna - i] = 1;
					}
					validacao = true;
				}
				break;
			}

		} while (validacao == false);

		return tabuleiro;
	}

	/*metodo que avalia se em algum momento o navio estaria para fora da matriz. 
	 * Multiplicador = -1 se for para cima ou para esquerda (sequencia da matriz)
	 * Multiplicador = 1 se for para direita ou para baixo (sequencia da matriz)
	 */
	public static boolean checagemEspaco(int necessidadeEspaco, int[][] tabuleiro, int multiplicador, int linhaColuna) {
		if ((linhaColuna + necessidadeEspaco * (multiplicador) < 0
				|| (linhaColuna + necessidadeEspaco * (multiplicador)) > 4)) {
			JOptionPane.showMessageDialog(null, "Direção Inválida");
			return false;
		} else
			return true;
	}

	/*Metodo para garantir que não tem outro navio na sequencia da coluna
	 * Multiplicador = -1 se for para cima  (sequencia da matriz)
	 * Multiplicador = 1 se for para baixo (sequencia da matriz)
	 */
	public static boolean checagemNavioColunaFixa(int necessidadeEspaco, int[][] tabuleiro, int multiplicador,
			int linha, int coluna) {
		boolean validacao = true;
		
		for (int i = 1; i < (necessidadeEspaco + 1); i++) {
			int j = i*multiplicador;
			if (tabuleiro[linha + j][coluna] == 1) {
				JOptionPane.showMessageDialog(null, "Já há um navio nessa direção");
				validacao = false;
			}
		}
		if (validacao == true) {
			return true;
		} else {
			return false;
		}
	}

	/*Metodo para garantir que não tem outro navio na sequencia da linha
	 * Multiplicador = -1 se for para esquerda (sequencia da matriz)
	 * Multiplicador = 1 se for para direita (sequencia da matriz)
	 */
	public static boolean checagemNavioLinhaFixa(int necessidadeEspaco, int[][] tabuleiro, int multiplicador, int linha,
			int coluna) {
		boolean validacao = true;
		for (int i = 1; i < (necessidadeEspaco + 1); i++) {
			int j = i*multiplicador;
			if (tabuleiro[linha][coluna + j] == 1) {
				JOptionPane.showMessageDialog(null, "Já há um navio nessa direção");
				validacao = false;
			}
		}
		if (validacao == true) {
			return true;
		} else {
			return false;
		}
	}

	public static int[] atirar(String jogador, String[][] tabuleiroImpressao, int contador) {
		/*impressao da matriz "oculta" para o jogador adversario ver opções de alvo
		 * sempre que um tiro é dado, a matriz é atualizada:
		 *    " " - se for água
		 *    "*" - se for em parte de um navio
		 */
		int posicao[] = new int[2];
		String impressao = "   1  2  3  4  5";
		for (int i = 0; i < 5; i++) {
			impressao += "\n";
			impressao += (i + 1) + " ";
			for (int j = 0; j < 5; j++) {
				impressao += tabuleiroImpressao[i][j] + "   ";
			}
		}

		do {
			do {
				posicao[0] = Integer.parseInt(JOptionPane.showInputDialog(
						"Vez do jogador " + jogador + ". Escolha a linha para ataque" + "\n\n" + impressao));
			} while (posicao[0] < 1 || posicao[0] > 5);
			do {
				posicao[1] = Integer.parseInt(JOptionPane.showInputDialog(
						"Vez do jogador " + jogador + ". Escolha a coluna para ataque" + "\n\n" + impressao));
			} while (posicao[1] < 1 || posicao[1] > 5);
			posicao[0] -= 1;
			posicao[1] -= 1;
			//garante que um tiro não será dado na mesma posição mais de uma vez
			if (!tabuleiroImpressao[posicao[0]][posicao[1]].equals("-"))
				JOptionPane.showMessageDialog(null, "Alvo já usado anteriormente, escolha um novo alvo!");
		} while (!tabuleiroImpressao[posicao[0]][posicao[1]].equals("-"));

		return posicao;
	}

	//como os espaços com navio são denominados com o número 1, caso não tenha 1 na matriz, não há parte boiando
	public static boolean verificarVitoria(int[][] tabuleiro) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (tabuleiro[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}

}
