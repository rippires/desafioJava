package br.com.desafio.exercicio.tres;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formata {
	
	private String nomeArquivo;
	
	public Formata() {
	}

	public Formata(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}
	
	public String formatarNome(LocalDateTime data) {
		
		LocalDateTime dataHora = LocalDateTime.now();
		DateTimeFormatter ft = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String dataConvertida = dataHora.format(ft);
		return dataConvertida;
	}
	
	public String formataCaminho(LocalDate caminho) {
		
		LocalDate data = LocalDate.now();
		DateTimeFormatter ft = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String caminhoConvertido = data.format(ft);
		return caminhoConvertido;
	}
	
	
	
	

}
