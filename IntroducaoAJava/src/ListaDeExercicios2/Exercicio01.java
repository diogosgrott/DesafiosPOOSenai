package ListaDeExercicios2;

import javax.swing.JOptionPane;

public class Exercicio01 {

	public static void main(String[] args) {
		int quantidadeValores = Integer.parseInt(JOptionPane.showInputDialog("Quantos valores ser�o informados?"));
		int[] vetor = new int[quantidadeValores];
		int quantidadeNegativos = 0;

		for (int i = 0; i < quantidadeValores; i++) {
			vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o " + (i + 1) + "� valor:"));
			if (vetor[i] < 0) {
				quantidadeNegativos++;
			}
		}

		JOptionPane.showMessageDialog(null, "O vetor possui " + quantidadeNegativos + " n�meros negativos",
				"Quantidade de valores negativos", JOptionPane.INFORMATION_MESSAGE);

	}

}
