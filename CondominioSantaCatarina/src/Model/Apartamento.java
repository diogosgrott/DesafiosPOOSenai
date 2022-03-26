package Model;

public class Apartamento {

	private String numeroApto;
	private String sobrenomeFamilia;
	private int qtdeMoradores;
	private double rendaTotal;

	public Apartamento(String numeroApto, String sobrenomeFamilia, int qtdeMoradores, double rendaTotal) {
		this.numeroApto = numeroApto;
		this.sobrenomeFamilia = sobrenomeFamilia;
		this.qtdeMoradores = qtdeMoradores;
		this.rendaTotal = rendaTotal;
	}

	public String getNumeroApto() {
		return numeroApto;
	}

	public void setNumeroApto(String numeroApto) {
		this.numeroApto = numeroApto;
	}

	public String getSobrenomeFamilia() {
		return sobrenomeFamilia;
	}

	public void setSobrenomeFamilia(String sobrenomeFamilia) {
		this.sobrenomeFamilia = sobrenomeFamilia;
	}

	public int getQtdeMoradores() {
		return qtdeMoradores;
	}

	public void setQtdeMoradores(int qtdeMoradores) {
		this.qtdeMoradores = qtdeMoradores;
	}

	public double getRendaTotal() {
		return rendaTotal;
	}

	public void setRendaTotal(double rendaTotal) {
		this.rendaTotal = rendaTotal;
	}

}
