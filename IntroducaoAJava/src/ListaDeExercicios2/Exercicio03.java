package ListaDeExercicios2;

import javax.swing.JOptionPane;

public class Exercicio03 {

	public static void main(String[] args) {
		int numeroInformado = Integer.parseInt(JOptionPane.showInputDialog("Digite um n�mero inteiro: "));
		int opcao;
		while (true) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Digite a op��o a ser escolhida" + "\n\n1. Verificar se o n�mero � m�ltiplo de algum outro n�mero;"
							+ "\n2. Verificar se o n�mero � par;" + "\n3. Verificar se o n�mero est� entre 0 e 1000;"
							+ "\n4. Sair"));
			switch (opcao) {
			case 1:
				int numeroComparado = Integer.parseInt(JOptionPane
						.showInputDialog("Qual n�mero voc� quer verificar se � m�ltiplo de " + numeroInformado));
				if (numeroInformado % numeroComparado == 0) {
					JOptionPane.showMessageDialog(null,
							"O n�mero " + numeroInformado + " � m�ltiplo de " + numeroComparado, "Op��o 1",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null,
							"O n�mero " + numeroInformado + " n�o � m�ltiplo de " + numeroComparado, "Op��o 1",
							JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			case 2:
				if (numeroInformado % 2 == 0) {
					JOptionPane.showMessageDialog(null, "O n�mero " + numeroInformado + " � par", "Op��o 2",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "O n�mero " + numeroInformado + " n�o � par", "Op��o 2",
							JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			case 3:
				if (numeroInformado >= 0 && numeroInformado <= 1000) {
					JOptionPane.showMessageDialog(null, "O n�mero " + numeroInformado + " est� entre 0 e 1000",
							"Op��o 3", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "O n�mero " + numeroInformado + " n�o est� entre 0 e 1000",
							"Op��o 3", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			case 4:
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null, "Op��o n�o encontrada", "Erro", JOptionPane.WARNING_MESSAGE);
			}
		}

	}

}
