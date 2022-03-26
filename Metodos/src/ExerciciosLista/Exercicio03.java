package ExerciciosLista;

import javax.swing.JOptionPane;

public class Exercicio03 {

	public static void main(String[] args) {
		//solicitar valor de compra
		double valorTotal = solicitarValorTotal();
		
		//mostra valor total
		mostraValorFinal(valorTotal);
	}
	
	public static double solicitarValorTotal() {
		double valorTotal;
		do {
			valorTotal = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor total da compra em R$"));
			if(valorTotal<=0)
				JOptionPane.showMessageDialog(null, "Digite um valor de compra válido","Erro",JOptionPane.ERROR_MESSAGE);
		}while(valorTotal<=0);
		return valorTotal;
	}
	
	public static void mostraValorFinal(double valorTotal) {
		/**Até R$100 - sem desconto, o valor permanece o mesmo
		 * De R$100,01 a R$200 - desconto de 20%
		 * Acima de R$200 - desconto de 30%
		 * */
		String valorFinal;
		if (valorTotal<=100) {
			valorFinal = String.format("%.2f", valorTotal);
			JOptionPane.showMessageDialog(null, "Não atingiu valor mínimo para desconto.\n\n"
					+ "Valor final da compra: R$ " + valorFinal);
		}else if(valorTotal>200) {
			valorFinal = String.format("%.2f", (valorTotal - valorTotal*0.3));
			JOptionPane.showMessageDialog(null, "Desconto de 30%.\n\n"
					+ "Valor final da compra: R$ " + valorFinal);
		}else {
			valorFinal = String.format("%.2f", (valorTotal - valorTotal*0.2));
			JOptionPane.showMessageDialog(null, "Desconto de 20%.\n\n"
					+ "Valor final da compra: R$ " + valorFinal);
		}
	}

}
