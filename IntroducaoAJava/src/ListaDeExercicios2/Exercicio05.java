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

		//Cadastro dos usuários
		do {
			JOptionPane.showMessageDialog(null, "Informações sobre usuário " + (contador+1));
			
			//Validação idade
			do{
				idade = Double.parseDouble(JOptionPane.showInputDialog("Digite a idade do usuário: "));
				if (idade<0)
					JOptionPane.showMessageDialog(null, "Cadastro Inválido. Idade não pode ser negativa","Erro",JOptionPane.ERROR_MESSAGE);
			}while(idade<0);
			
			//Validação resposta
			do {
				fumante = JOptionPane.showInputDialog("Digite S se o usuário for fumante ou N se não for:  ");		
				if(!fumante.equals("S")&& !fumante.equals("N"))
					JOptionPane.showMessageDialog(null, "Cadastro Inválido, informar S ou N.","Erro",JOptionPane.ERROR_MESSAGE);
			} while(!fumante.equals("S") && !fumante.equals("N"));
			
			//validação salario
			do {
				salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário do usuário: "));
				if (salario<0)
					JOptionPane.showMessageDialog(null, "Cadastro Inválido. Salário menor que 0","Erro",JOptionPane.ERROR_MESSAGE);
			}while (salario<0);
			
			//validacao tempo de clube
			do {
				mesesDeClube = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de meses que o usuário frequenta o clube:"));
				if(mesesDeClube<0){
					JOptionPane.showMessageDialog(null, "Tempo não pode ser negativo","Erro",JOptionPane.ERROR_MESSAGE);
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
					+ "tecla para cadastrar um novo usuário do clube:");
		} while (!encerrar.equals("encerrar"));
		
		String mediaSalarios = String.format("%.2f", (somaSalario/contador));
		String mediaIdades = String.format("%.1f", (somaIdade/contador));
		String percentualAcima3Meses = String.format("%.2f", (100*contadorAcima3Meses/contador));
		
		JOptionPane.showMessageDialog(null, "Informações sobre o usuário:"
				+ "\n\nMédia de idade: " + mediaIdades
				+ "\nNúmero de Fumantes: " + quantidadeFumante
				+ "\nNúmero de Não Fumantes: " + (contador-quantidadeFumante)
				+ "\nMédia de salários: R$ " + mediaSalarios
				+ "\nUsuários acima de 03 meses de clube: " + percentualAcima3Meses + "%");
	}

}
