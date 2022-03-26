package Desafios;

import javax.swing.JOptionPane;

public class Exercicio02 {

	public static void main(String[] args) {
		int tamanhoVetor = 3;
		String repetir;
		int[] vetor = new int[tamanhoVetor];
		int pergunta = 0;
		int j = 0;
		JOptionPane.showMessageDialog(null, "O programa aceita apenas valores positivos!");
		/*
		 * for (int i = 0; i<tamanhoVetor ; i++) { vetor[i] =
		 * Integer.parseInt(JOptionPane.showInputDialog("Informar " + (i+1)
		 * +"º valor: ")); }
		 */
		while (j < tamanhoVetor) {
			vetor[j] = Integer.parseInt(JOptionPane.showInputDialog("Informar " + (j + 1) + "º valor: "));
			if (vetor[j] % 2 == 0) {
				j++;
			}
		}

		do {
			pergunta = Integer.parseInt(
					JOptionPane.showInputDialog("Escolha uma das opções" + "\n\nDigite 1 - Ver todos os valores"
							+ "\nDigite 2 - Somente o primeiro valor" + "\nDigite 3 - Somente o último valor"
							+ "\nDigite 4 - Mostrar somente os valores pares, separando por vírgula"));
			switch (pergunta) {
			case 1:
				for (int i = 0; i < tamanhoVetor; i++) {
					JOptionPane.showMessageDialog(null, vetor[i], "Valor " + (i + 1), JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			case 2:
				JOptionPane.showMessageDialog(null, vetor[0], "Valor 1", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, vetor[0], "Valor " + (tamanhoVetor - 1),
						JOptionPane.INFORMATION_MESSAGE);
				break;
			case 4:
				for (int i = 0; i < tamanhoVetor; i++) {
					if (vetor[i] % 2 == 0) {
						JOptionPane.showMessageDialog(null, vetor[i], "Valor " + (i + 1),
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida", "Erro!", JOptionPane.WARNING_MESSAGE);

			}

			repetir = JOptionPane.showInputDialog(
					"Deseja voltar ao menu principal?" + "\n\nDigite S para sim ou qualquer outro caractere para não");

		} while (repetir.equals("S") || repetir.equals("s"));
	}

}