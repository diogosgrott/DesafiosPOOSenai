package ListaDeExercicios1;

import javax.swing.JOptionPane;
//fazer do while
public class Exercicio01 {

	public static void main(String[] args) {
		int horas;
		int minutos;
		int segundos;

		do {
			horas = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de horas: "));
		}while (horas<0);
		
		do {
			minutos = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de minutos: "));
		}while (minutos<0);
		
		do {
			segundos = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de segundos: "));
		}while (segundos<0);
		

		segundos = segundos + minutos * 60 + horas * 60 * 60;

		JOptionPane.showMessageDialog(null, segundos + " segundos", "Quantidade de Segundos",
				JOptionPane.INFORMATION_MESSAGE);

	}

}
