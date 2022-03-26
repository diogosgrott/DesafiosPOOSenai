package ListaDeExercicios1;

import javax.swing.JOptionPane;

public class Exercicio05 {

	public static void main(String[] args) {
		int tamanhoVetor = 10;
		int[] vetor = new int[tamanhoVetor];
		int somaPar = 0;
		int somaImpar = 0;
		int quantidadePar = 0;
		int quantidadeImpar = 0;

		for (int i = 0; i < tamanhoVetor; i++) {
			vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor " + (i + 1) + " : "));
			if (vetor[i] % 2 == 0) {
				somaPar += vetor[i];
				quantidadePar++;
			} else {
				somaImpar += vetor[i];
				quantidadeImpar++;
			}
		}
		
		JOptionPane.showMessageDialog(null, "Soma dos Números Pares: " + somaPar + 
				"\nQuantidade de Números Pares: " + quantidadePar + 
				"\n\nSoma dos Números Ímpares: " + somaImpar + 
				"\nQuantidade de Números Ímpares: " + quantidadeImpar,"Resultado",JOptionPane.INFORMATION_MESSAGE);

	}

}
