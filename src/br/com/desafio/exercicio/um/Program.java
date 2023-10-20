package br.com.desafio.exercicio.um;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Pessoa> list = new ArrayList<Pessoa>();
		String caminho = "D:\\ws-java\\DesafioJava\\pessoa.txt";
		try {
			int opcao = -1;
			do {

				System.out.println("Digite a Opção Desejada: ");
				System.out.print("\n");
				System.out.println("1 - Listar Pessoas Cadastradas");
				System.out.println("2 - Cadastrar Nova Pessoa");
				System.out.println("0 - Sair ");
				opcao = sc.nextInt();
				Arquivo arquivo = new Arquivo(caminho);

				switch (opcao) {
				case 1: 

					try (BufferedReader br = new BufferedReader(new FileReader((arquivo.getCaminhoDoArquivo())))) {
						String line = br.readLine();

						while(line != null) {
							System.out.println(line);
							line = br.readLine();
						}
					}

					catch (IOException exce) {
						System.out.println("Erro: " + exce.getMessage());
					}
					break;

				case 2: 

					System.out.println("Novo Cadastro :");
					sc.nextLine();
					System.out.print("Nome: ");
					String nome = sc.nextLine();
					System.out.print("Idade: ");
					String idade = sc.nextLine();
					System.out.print("Cpf: ");
					String cpf = sc.nextLine();

					Pessoa pessoa = new Pessoa(nome, idade, cpf);

					list.add(pessoa);

					try(BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo.getCaminhoDoArquivo(), true))){
						for (Pessoa lista : list) {
							bw.write(lista.toString());
							bw.newLine();
						}
					} catch (IOException ex) {
						ex.printStackTrace();
					}

					break;

				case 0:
					System.out.println("Programa Finalizado");
					break;
				
				default:
					break;
				}

			} while (opcao != 0);
			sc.close();
		} 
		catch (IllegalArgumentException e) {
			System.out.println("Opção Invalida!");
		} 
		catch (InputMismatchException e) {
			System.out.println("Opção Inválida!");
			System.out.println("Programa Finalizado!");
		}
	}
}


