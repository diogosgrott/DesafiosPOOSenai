package ListaDeExercicios2;

import javax.swing.JOptionPane;

public class Exercicio02 {

	public static void main(String[] args) {

		int quantidadeNotas = 4;
		double somaNotas = 0;
		double media;
		double[] notas = new double[quantidadeNotas];

		for (int i = 0; i < quantidadeNotas; i++) {
			do {
				notas[i] = Double.parseDouble(
						JOptionPane.showInputDialog("Digite a " + (i + 1) + "ª nota (decimal separado por ponto):"));				
			}while (notas[1]<0);
			somaNotas += notas[i];
		}

		media = somaNotas / quantidadeNotas;

		if (media >= 9) {
			JOptionPane.showMessageDialog(null, "Conceito A", "Resultado", JOptionPane.INFORMATION_MESSAGE);
		} else if (media >= 8) {
			JOptionPane.showMessageDialog(null, "Conceito B", "Resultado", JOptionPane.INFORMATION_MESSAGE);
		} else if (media >= 7) {
			JOptionPane.showMessageDialog(null, "Conceito C", "Resultado", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Conceito D", "Resultado", JOptionPane.WARNING_MESSAGE);
		}

	}

}
