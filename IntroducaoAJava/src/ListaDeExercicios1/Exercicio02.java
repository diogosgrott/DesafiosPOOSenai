package ListaDeExercicios1;

import javax.swing.JOptionPane;
//fazer o mesmo do while do exercicio 1 para validacao
public class Exercicio02 {

	public static void main(String[] args) {
		int maioridade;;
		int idade;
		
		
		do {
			maioridade = Integer.parseInt(JOptionPane.showInputDialog("Qual a maioridade no civil do seu Pa�s/Estado: "));
		}while (maioridade<0);
		
		do {
			idade = Integer.parseInt(JOptionPane.showInputDialog("Qual a sua idade: "));
		}while (idade<0);
		
		
		if (idade>=maioridade) {
			JOptionPane.showMessageDialog(null, "Voc� � maior de idade");
		} else {
			JOptionPane.showMessageDialog(null, "Voc� n�o � maior de idade");
		}

	}

}
