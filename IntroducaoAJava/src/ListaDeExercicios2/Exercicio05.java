package ListaDeExercicios2;

import javax.swing.JOptionPane;

public class Exercicio05 {

	public static void main(String[] args) {
		double somaIdade = 0;
		double idade;
		int quantidadeFumante = 0;
		String fumante;
		double somaSalario = 0;
		double salario;
		int mesesDeClube;
		double contadorAcima3Meses = 0;
		int contador = 0;
		String encerrar = "";

		//Cadastro dos usu�rios
		do {
			JOptionPane.showMessageDialog(null, "Informa��es sobre usu�rio " + (contador+1));
			
			//Valida��o idade
			do{
				idade = Double.parseDouble(JOptionPane.showInputDialog("Digite a idade do usu�rio: "));
				if (idade<0)
					JOptionPane.showMessageDialog(null, "Cadastro Inv�lido. Idade n�o pode ser negativa","Erro",JOptionPane.ERROR_MESSAGE);
			}while(idade<0);
			
			//Valida��o resposta
			do {
				fumante = JOptionPane.showInputDialog("Digite S se o usu�rio for fumante ou N se n�o for:  ");		
				if(!fumante.equals("S")&& !fumante.equals("N"))
					JOptionPane.showMessageDialog(null, "Cadastro Inv�lido, informar S ou N.","Erro",JOptionPane.ERROR_MESSAGE);
			} while(!fumante.equals("S") && !fumante.equals("N"));
			
			//valida��o salario
			do {
				salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o sal�rio do usu�rio: "));
				if (salario<0)
					JOptionPane.showMessageDialog(null, "Cadastro Inv�lido. Sal�rio menor que 0","Erro",JOptionPane.ERROR_MESSAGE);
			}while (salario<0);
			
			//validacao tempo de clube
			do {
				mesesDeClube = Integer.parseInt(JOptionPane.showInputDialog("Digite o n�mero de meses que o usu�rio frequenta o clube:"));
				if(mesesDeClube<0){
					JOptionPane.showMessageDialog(null, "Tempo n�o pode ser negativo","Erro",JOptionPane.ERROR_MESSAGE);
				}
			} while(mesesDeClube<0);
			
			somaIdade += idade;
			somaSalario += salario;
			if (fumante.equals("S")) {
				quantidadeFumante++;
			}
			somaSalario += salario;
			if (mesesDeClube > 3) {
				contadorAcima3Meses++;
			}
			contador++;

			encerrar = JOptionPane.showInputDialog("Digite encerrar para finalizar o cadastro, ou qualquer outra"
					+ "tecla para cadastrar um novo usu�rio do clube:");
		} while (!encerrar.equals("encerrar"));
		
		String mediaSalarios = String.format("%.2f", (somaSalario/contador));
		String mediaIdades = String.format("%.1f", (somaIdade/contador));
		String percentualAcima3Meses = String.format("%.2f", (100*contadorAcima3Meses/contador));
		
		JOptionPane.showMessageDialog(null, "Informa��es sobre o usu�rio:"
				+ "\n\nM�dia de idade: " + mediaIdades
				+ "\nN�mero de Fumantes: " + quantidadeFumante
				+ "\nN�mero de N�o Fumantes: " + (contador-quantidadeFumante)
				+ "\nM�dia de sal�rios: R$ " + mediaSalarios
				+ "\nUsu�rios acima de 03 meses de clube: " + percentualAcima3Meses + "%");
	}

}
