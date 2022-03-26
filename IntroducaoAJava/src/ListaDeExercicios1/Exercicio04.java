package ListaDeExercicios1;

//se for numero igual, digitar de novo
//fazer a inversao e nao o else if
import javax.swing.JOptionPane;

public class Exercicio04 {

	public static void main(String[] args) {
		int soma = 0;
		int menor;
		int maior;

		do {
			menor = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro valor: "));
			maior = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo valor: "));
		} while (menor == maior);

		if (menor > maior) {
			int temporaria = maior;
			maior = menor;
			menor = temporaria;
		}

		for (int i = menor; i <= maior; i++) {
			if (i % 2 == 0) {
				soma += i;
			}
		}

		JOptionPane.showMessageDialog(null, "Soma dos números pares do intervalo: " + soma);

	}

}
