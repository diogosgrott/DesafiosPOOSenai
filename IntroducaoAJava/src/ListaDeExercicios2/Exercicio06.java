package ListaDeExercicios2;

import javax.swing.JOptionPane;

public class Exercicio06 {

	public static void main(String[] args) {
		int tempoAnalise = 12;
		double[] totalVendasMes = new double[tempoAnalise];
		int maior = 0;
		int mesMaior = 0;
		int menor = 0;
		int mesMenor = 0;
		double somaVendasTotal = 0;
		double somaVendasMesPar = 0;
		double somaVendasSegundoSemestre = 0;

		//entrada das informações de venda
		for (int i = 0; i < tempoAnalise; i++) {
			totalVendasMes[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite o total de vendas no mês " + (i+1)));
			
			//padroniza o primeiro mes como maior e menor valor
			if (i == 0) {
				maior = (int) totalVendasMes[i];
				mesMaior = (i+1);
				menor = (int) totalVendasMes[i];
				mesMenor = (i+1);
			}
			
			//já faz a validação de maior e menor valor
			if (totalVendasMes[i]>maior) {
				maior = (int) totalVendasMes[i];
				mesMaior = (i+1);
			}else if(totalVendasMes[i]<menor) {
				menor = (int) totalVendasMes[i];
				mesMenor = (i+1);
			}
			somaVendasTotal += totalVendasMes[i];
			
			//se for mes par e se for do segundo semestre
			if ((i+1)%2==0) {
				somaVendasMesPar += totalVendasMes[i];
			}
			if (i>5) {
				somaVendasSegundoSemestre += totalVendasMes[i];
			}
		}
		
		String mediaTotal = String.format("%.2f", (somaVendasTotal/tempoAnalise));
		String mediaMesPar = String.format("%.2f", (somaVendasMesPar/(tempoAnalise/2)));
		String mediaSegundoSemestre = String.format("%.2f", (somaVendasSegundoSemestre/(tempoAnalise/2)));
		
		JOptionPane.showMessageDialog(null, "Relatório Anual"
				+ "\n\nMês com maior venda: " + mesMaior
				+ "\nMês com menor venda: " + mesMenor
				+ "\nMédia das vendas no ano: " + mediaTotal
				+ "\nMédia dos meses pares: " + mediaMesPar
				+ "\nMédia dos meses do segundo semestre: " + mediaSegundoSemestre);

	}

}
