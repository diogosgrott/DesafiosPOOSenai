package ExerciciosLista;

import javax.swing.JOptionPane;

public class Exercicio02 {

	public static void main(String[] args) {
		int quantidadeNotas = 3;
		double[] notas = new double[quantidadeNotas];
		double[] peso = new double[quantidadeNotas];
		double media;
		int opcaoMedia;

		// escrever notas
		for (int i = 0; i < quantidadeNotas; i++) {
			do {
				notas[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite a nota " + (i + 1)));
				if (notas[i] < 0)
					JOptionPane.showMessageDialog(null, "Nota inválida!");
			} while (notas[i] < 0);
		}

		// decidir qual media
		do {
			opcaoMedia = Integer
					.parseInt(JOptionPane.showInputDialog("Digite 1 para média Aritmética ou 2 para média ponderada"));
			if (opcaoMedia != 1 && opcaoMedia != 2)
				JOptionPane.showMessageDialog(null, "Opção inválida!");
		} while (opcaoMedia != 1 && opcaoMedia != 2);

		// definir apenas uma variável média que vai ser usada para os dois metodos
		if (opcaoMedia == 1) {
			media = mediaAritmetica(notas[0], notas[1], notas[2]);
		} else {
			for (int i = 0; i < quantidadeNotas; i++) {
				do {
					peso[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso da prova " + (i + 1)));
				} while (peso[i] <= 0);
			}
			media = mediaPonderada(notas[0], notas[1], notas[2], peso[0], peso[1], peso[2]);
		}
		mostraAprovacao(media);
	}

	public static double mediaAritmetica(double nota1, double nota2, double nota3) {
		double soma = nota1 + nota2 + nota3;
		return (soma) / 3;
	}

	public static double mediaPonderada(double nota1, double nota2, double nota3, double peso1, double peso2,
			double peso3) {
		double media = nota1 * peso1 + nota2 * peso2 + nota3 * peso3;
		return media;
	}

	public static void mostraAprovacao(double media) {
		String mediaFinal = String.format("%.1f", media);
		if (media >= 7) {
			JOptionPane.showMessageDialog(null, "Parabéns, você foi aprovado!\n\n"
					+ "Média = " + mediaFinal, "Resultado",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Você foi reprovado\n\n"
					+ "Média = " + mediaFinal, "Resultado", JOptionPane.WARNING_MESSAGE);
		}

	}

}
