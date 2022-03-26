package ListaDeExercicios1;

import javax.swing.JOptionPane;
//fazer o mesmo do while do exercicio 1 para validacao
public class Exercicio02 {

	public static void main(String[] args) {
		int maioridade;;
		int idade;
		
		
		do {
			maioridade = Integer.parseInt(JOptionPane.showInputDialog("Qual a maioridade no civil do seu País/Estado: "));
		}while (maioridade<0);
		
		do {
			idade = Integer.parseInt(JOptionPane.showInputDialog("Qual a sua idade: "));
		}while (idade<0);
		
		
		if (idade>=maioridade) {
			JOptionPane.showMessageDialog(null, "Você é maior de idade");
		} else {
			JOptionPane.showMessageDialog(null, "Você não é maior de idade");
		}

	}

}
