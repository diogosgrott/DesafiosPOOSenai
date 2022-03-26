package ListaDeExercicios2;

import javax.swing.JOptionPane;

public class Exercicio03 {

	public static void main(String[] args) {
		int numeroInformado = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro: "));
		int opcao;
		while (true) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Digite a opção a ser escolhida" + "\n\n1. Verificar se o número é múltiplo de algum outro número;"
							+ "\n2. Verificar se o número é par;" + "\n3. Verificar se o número está entre 0 e 1000;"
							+ "\n4. Sair"));
			switch (opcao) {
			case 1:
				int numeroComparado = Integer.parseInt(JOptionPane
						.showInputDialog("Qual número você quer verificar se é múltiplo de " + numeroInformado));
				if (numeroInformado % numeroComparado == 0) {
					JOptionPane.showMessageDialog(null,
							"O número " + numeroInformado + " é múltiplo de " + numeroComparado, "Opção 1",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,
							"O número " + numeroInformado + " não é múltiplo de " + numeroComparado, "Opção 1",
							JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			case 2:
				if (numeroInformado % 2 == 0) {
					JOptionPane.showMessageDialog(null, "O número " + numeroInformado + " é par", "Opção 2",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "O número " + numeroInformado + " não é par", "Opção 2",
							JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			case 3:
				if (numeroInformado >= 0 && numeroInformado <= 1000) {
					JOptionPane.showMessageDialog(null, "O número " + numeroInformado + " está entre 0 e 1000",
							"Opção 3", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "O número " + numeroInformado + " não está entre 0 e 1000",
							"Opção 3", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			case 4:
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null, "Opção não encontrada", "Erro", JOptionPane.WARNING_MESSAGE);
			}
		}

	}

}
