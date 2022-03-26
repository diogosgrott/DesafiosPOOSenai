package ListaDeExercicios1;

import javax.swing.JOptionPane;

public class Exercicio03 {

	public static void main(String[] args) {
		int menor;
		int posicaoMenor;
		int[] vetor = new int[3];

		do {
			for (int i = 0; i < 3; i++) {
				vetor[i] = Integer
						.parseInt(JOptionPane.showInputDialog("Digite um valor para valor " + (i + 1) + ": "));
			}

			if ((vetor[0] == vetor[1] || vetor[1] == vetor[2])) {
				JOptionPane.showMessageDialog(null, "Os valores devem ser diferentes!", "Erro!",
						JOptionPane.ERROR_MESSAGE);
			}

		} while ((vetor[0] == vetor[1] || vetor[1] == vetor[2]));

		menor = vetor[0];
		posicaoMenor = 1;
		for (int i = 1; i < 3; i++) {
			if (vetor[i] < menor) {
				menor = vetor[i];
				posicaoMenor = i + 1;
			}
		}
		JOptionPane.showMessageDialog(null, "O menor valor é " + menor, "Posição " + (posicaoMenor),
				JOptionPane.INFORMATION_MESSAGE);

	}

}
