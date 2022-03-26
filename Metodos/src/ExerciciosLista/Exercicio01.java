package ExerciciosLista;

import javax.swing.JOptionPane;

public class Exercicio01 {

	public static void main(String[] args) {
		int anoNascimento = anoNascimento();
		mostraIdade(anoNascimento);

	}
	
	public static int anoNascimento() {
		int anoNascimento = Integer.parseInt(JOptionPane.showInputDialog("Digite seu ano de nascimento"));	
		return anoNascimento;
	}
	
	public static void mostraIdade(int anoNascimento) {
		int idade = 2021 - anoNascimento;
		JOptionPane.showMessageDialog(null, "O usuário tem " + idade + " anos em 2021");
	}

}
