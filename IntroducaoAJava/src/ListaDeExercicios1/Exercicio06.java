package ListaDeExercicios1;

//colocar a restri��o do /0
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
						+ "\nDigite  -  para subtra��o"
						+ "\nDigite  *  para multiplica��o"
						+ "\nDigite  /  para divis�o");				
			}while(!operacao.equals("+") && !operacao.equals("-") && !operacao.equals("*") && !operacao.equals("/"));
			
			do {
				valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo valor"));
				if (operacao.equals("/") && valor == 0) {
					JOptionPane.showMessageDialog(null,"Divis�o por 0 � indeterminado. Digite um novo valor", "Erro",JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(null, "Opera��o n�o v�lida!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			
			
			continuar = JOptionPane.showInputDialog("Voc� deseja continuar o c�lculo?"
					+ "\n\nDigite S para sim ou qualquer outro caractere para ver o resultado final");
		}while(continuar.equals("s") || continuar.equals("S"));
		
		JOptionPane.showMessageDialog(null, "Resultado Final: " + resultado);
	}

}
