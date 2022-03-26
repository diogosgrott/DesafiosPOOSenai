package ListaDeExercicios1;

//colocar a restrição do /0
//validacao antes do segundo valor
import javax.swing.JOptionPane;

public class Exercicio06 {

	public static void main(String[] args) {
		int resultado;
		int valor;
		String continuar = "S";
		String operacao;
		
		resultado = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro valor: "));
		do {
			do {
				operacao = JOptionPane.showInputDialog("Qual operacao deseja fazer?"
						+ "\n\nDigite  +  para soma"
						+ "\nDigite  -  para subtração"
						+ "\nDigite  *  para multiplicação"
						+ "\nDigite  /  para divisão");				
			}while(!operacao.equals("+") && !operacao.equals("-") && !operacao.equals("*") && !operacao.equals("/"));
			
			do {
				valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo valor"));
				if (operacao.equals("/") && valor == 0) {
					JOptionPane.showMessageDialog(null,"Divisão por 0 é indeterminado. Digite um novo valor", "Erro",JOptionPane.ERROR_MESSAGE);
				}
			}while(operacao.equals("/") && valor == 0);
			switch (operacao) {
			case "+":
				resultado += valor;
				break;
			case "-":
				resultado -= valor;
				break;
			case "*":
				resultado *= valor;
				break;
			case "/":
				resultado /= valor;
				break;
			default:
				JOptionPane.showMessageDialog(null, "Operação não válida!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			
			
			continuar = JOptionPane.showInputDialog("Você deseja continuar o cálculo?"
					+ "\n\nDigite S para sim ou qualquer outro caractere para ver o resultado final");
		}while(continuar.equals("s") || continuar.equals("S"));
		
		JOptionPane.showMessageDialog(null, "Resultado Final: " + resultado);
	}

}
