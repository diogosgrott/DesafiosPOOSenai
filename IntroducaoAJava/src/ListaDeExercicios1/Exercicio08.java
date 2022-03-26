package ListaDeExercicios1;

import java.util.Random;

import javax.swing.JOptionPane;

public class Exercicio08 {

	public static void main(String[] args) {
		Random random = new Random();

		int semanas = 4;
		int meses = 6;
		int somaSemestre = 0;
		int[] somaMes = new int[meses];
		int[][] tabelaSemestre = new int[meses][semanas];

		for (int i = 0; i < meses; i++) {
			somaMes[i] = 0;
			for (int j = 0; j < semanas; j++) {
				tabelaSemestre[i][j] = random.nextInt(10);
				somaSemestre += tabelaSemestre[i][j];
				somaMes[i] += tabelaSemestre[i][j];
				System.out.print(tabelaSemestre[i][j] + "  ");
			}
			System.out.println();
		}

		JOptionPane.showMessageDialog(null,
				"Total de Vendas no Semestre: " + somaSemestre + "\n\nTotal de Vendas no mês 1: " + somaMes[0]
						+ "\nTotal de Vendas no mês 2: " + somaMes[1] + "\nTotal de Vendas no mês 3: " + somaMes[2]
						+ "\nTotal de Vendas no mês 4: " + somaMes[3] + "\nTotal de Vendas no mês 5: " + somaMes[4]
						+ "\nTotal de Vendas no mês 6: " + somaMes[5]);

	}

}
