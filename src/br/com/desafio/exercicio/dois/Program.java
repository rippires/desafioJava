package br.com.desafio.exercicio.dois;

import java.util.Locale;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		CalculoDeVelocidade calculoDeVelocidade = new CalculoDeVelocidade();
		calculoDeVelocidade.calculaVelocidade(10, 10.2);
		
		System.out.print(calculoDeVelocidade);

	}

}
