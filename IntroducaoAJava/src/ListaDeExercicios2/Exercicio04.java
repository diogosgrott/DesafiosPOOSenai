package ListaDeExercicios2;

import javax.swing.JOptionPane;

public class Exercicio04 {

	public static void main(String[] args) {
		double quantidadeLatao;
		do {
			quantidadeLatao = Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de lat�o em kg"));			
		}while(quantidadeLatao<0);
		
		double quantidadeCobre = quantidadeLatao*0.7;
		double quantidadeZinco = quantidadeLatao*0.3;
		String quantidadeCobreFormatado = String.format("%.2f", quantidadeCobre);
		String quantidadeZincoFormatado = String.format("%.2f", quantidadeZinco);
		
		JOptionPane.showMessageDialog(null, "Ser� necess�rio: \n\n"
				+ quantidadeCobreFormatado + "kg de Cobre\n"
				+ quantidadeZincoFormatado + "kg de Zinco");

	}

}
