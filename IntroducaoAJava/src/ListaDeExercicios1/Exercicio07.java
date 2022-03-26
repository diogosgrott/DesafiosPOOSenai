package ListaDeExercicios1;

import java.util.Random;

import javax.swing.JOptionPane;

public class Exercicio07 {

	public static void main(String[] args) {

		Random random = new Random();
		int tamanhoVetor = 10;
		int[] vetor = new int[tamanhoVetor];
		int contador = 0;
		int numeroEscolhido = Integer.parseInt(JOptionPane.showInputDialog("Digite um número de 0 a 10: "));
		String encontrado = "nao";
		int posicao = 0;

		while (contador < tamanhoVetor) {
			String comparador = "diferente";
			vetor[contador] = random.nextInt(11);
			for (int i = 0; i < contador; i++) {
				if (vetor[contador] == vetor[i]) {
					comparador = "igual";
				}
			}
			if (comparador.equals("diferente")) {
				contador++;
			}
		}

		for (int i = 0; i < tamanhoVetor; i++) {
			if (numeroEscolhido == vetor[i]) {
				encontrado = "sim";
				posicao = (i+1);
			}
		}

		if (encontrado.equals("nao")) {
			JOptionPane.showMessageDialog(null, "Número não encontrado");
		}else {
			JOptionPane.showMessageDialog(null, "Número encontrado na posição " + posicao);			
		}

	}

}
