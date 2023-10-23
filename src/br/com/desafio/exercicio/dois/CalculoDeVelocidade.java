package br.com.desafio.exercicio.dois;

public class CalculoDeVelocidade {

	private double velocidade;
	private double distancia = 4.0;
	private double sensor1;
	private double sensor2;

	public CalculoDeVelocidade() {

	}

	public CalculoDeVelocidade(double velocidade, double distancia, double sensor1, double sensor2) {

		this.velocidade = velocidade;
		this.distancia = distancia;
		this.sensor1 = sensor1;
		this.sensor2 = sensor2;
}

	public double getVelocidade() {
		return velocidade;
		}

	public double getDistancia() {
		return distancia;
		}

	public double getSensor1() {
		return sensor1;
	}
	
	public double getSensor2() {
		return sensor2;
	}

	public double calculaVelocidade(double sensor1, double sensor2) {
		velocidade = (distancia / (sensor2 - sensor1)) * 3.6;
		return velocidade;
	}

	@Override

	public String toString() {

		return "Velocidade Calculada: "
				+ String.format("%.2f", velocidade)
				+ "Km/h";
	}

}
