package ListaDeExercicios2;

import javax.swing.JOptionPane;

public class Exercicio07 {

	public static void main(String[] args) {
		// Gera��o do vetor Materias e Matriz das notas
		String[] materias = { "Matem�tica", "F�sica", "Qu�mica" };
		Double[][] notas = { { 9.53, 8.66, 8.45 }, { 7.57, 9.00, 8.01 }, { 8.87, 9.44, 7.88 }, { 7.30, 6.77, 9.21 } };

		double maiorNota = 0;
		String disciplinaMaiorNota = "";
		double mediaDisciplina;
		int opcaoDisciplina;
		int escolhaBimestre;
		int opcao;
		String materiasImpressao;
		String notasImpressao;

		do {
			do {

				opcao = Integer.parseInt(JOptionPane.showInputDialog(
						"Escolha uma das op��es abaixo" + "\n\n1. Todas as notas de todas as disciplinas"
								+ "\n2. Qual a maior nota e em qual disciplina foi"
								+ "\n3. A m�dia das notas de alguma disciplina" + "\n4. As notas de um dos bimestres"
								+ "\n5. Encerrar" + ""));
			} while (opcao < 1 || opcao > 5);

			switch (opcao) {
			case 1:
				// Vari�vel para arrumar visualiza��o da matriz
				materiasImpressao = "";
				notasImpressao = "";

				for (int i = 0; i < 3; i++) {
					materiasImpressao += materias[i];
					materiasImpressao += "  ";
				}
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 3; j++) {
						notasImpressao += notas[i][j];
						notasImpressao += "               ";
					}
					notasImpressao += "\n";
				}
				JOptionPane.showMessageDialog(null, materiasImpressao + "\n" + notasImpressao);
				break;

			case 2:
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 3; j++) {
						if (notas[i][j] > maiorNota) {
							maiorNota = notas[i][j];
							disciplinaMaiorNota = materias[j];
						}
					}
				}
				JOptionPane.showMessageDialog(null, "A maior nota � " + maiorNota + " em " + disciplinaMaiorNota);
				break;

			case 3:
				// vari�vel para ser feita a soma e depois media
				mediaDisciplina = 0;
				do {
					opcaoDisciplina = Integer.parseInt(JOptionPane.showInputDialog(
							"Escolha uma disciplina para ver a m�dia:" + "\n\n1. Matem�tica\n2. F�sica\n3. Qu�mica"));
				} while (opcaoDisciplina < 1 || opcaoDisciplina > 3);

				for (int i = 0; i < 4; i++) {
					mediaDisciplina += notas[i][(opcaoDisciplina - 1)];
				}
				String mediaDisciplinaString = String.format("%.2f", (mediaDisciplina / 4));
				JOptionPane.showMessageDialog(null,
						"A m�dia de " + materias[(opcaoDisciplina - 1)] + " � " + (mediaDisciplinaString));
				break;

			case 4:
				do {
					escolhaBimestre = Integer
							.parseInt(JOptionPane.showInputDialog("Escolha um bimestre para ver as notas"));
				} while (escolhaBimestre < 1 || escolhaBimestre > 4);
				materiasImpressao = "";
				notasImpressao = "";

				for (int i = 0; i < 3; i++) {
					materiasImpressao += materias[i];
					materiasImpressao += "  ";
				}
				for (int i = 0; i < 3; i++) {
					notasImpressao += notas[(escolhaBimestre - 1)][i];
					notasImpressao += "               ";
				}
				JOptionPane.showMessageDialog(null, materiasImpressao + "\n" + notasImpressao);
				break;
			}

		} while (opcao != 5);
	}

}
