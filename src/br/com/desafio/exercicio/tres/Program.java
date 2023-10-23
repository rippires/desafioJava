package br.com.desafio.exercicio.tres;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.imageio.ImageIO;

public class Program {

    public static void main(String[] args) {
        try {
           
        	String caminho = "D:/ws-java/DesafioJava";
        	
        	Formata formata = new Formata();
        	
        	String codeqp = "EQUIPAMENTOTESTE";
        	
            File arquivoEntrada = new File("D:/ws-java/DesafioJava/carro.jpg");
            BufferedImage imagemEntrada = ImageIO.read(arquivoEntrada);
            
            int larguraDesejada = 600;
            int alturaDesejada = 480;

           
            BufferedImage imagemRedimensionada = new BufferedImage(larguraDesejada, alturaDesejada, BufferedImage.TYPE_INT_RGB);
            
            Graphics2D g2d = imagemRedimensionada.createGraphics();
            g2d.drawImage(imagemEntrada, 0, 0, larguraDesejada, alturaDesejada, null);
            g2d.dispose();
            
            int larguraComTarja = larguraDesejada + 60;
            
            BufferedImage imagemComTarja = new BufferedImage(larguraComTarja, alturaDesejada, BufferedImage.TYPE_INT_RGB);
            
            Graphics2D g2dtarja = imagemComTarja.createGraphics();
            g2dtarja.drawImage(imagemEntrada, 0, -60, larguraComTarja, alturaDesejada, null);
            g2dtarja.dispose();

            System.out.println(imagemComTarja.getWidth());
            
            LocalDate dataAtual = LocalDate.now();
            String caminhoFormatado = formata.formataCaminho(dataAtual);

            File diretorioNovo = new File(caminho + "/" + caminhoFormatado);

            boolean success = diretorioNovo.mkdirs();
            
            if(diretorioNovo.exists() && diretorioNovo.isDirectory()) {
            	File[] numArquivos = diretorioNovo.listFiles();
            	
            	if(numArquivos!=null) {
            		int quantidadeDeArquivos = numArquivos.length + 1;
            		System.out.println("Quantidade de Imagens: " + quantidadeDeArquivos);
            	}
            } else {
            	System.out.println("Diretório Vazio. ");
            }
            
            if( success = true) {
            	
            	 System.out.println("Imagem redimensionada com tarja preta adicionada com sucesso no Diretório " + diretorioNovo);
            	 
            }
            
            LocalDateTime data = LocalDateTime.now();
            String nome = formata.formatarNome(data);
            
            String nomeArquivo = caminhoFormatado + "/" + nome + codeqp + ".jpg";
            
            
            File arquivoSaida = new File(nomeArquivo);
            ImageIO.write(imagemComTarja, "jpg", arquivoSaida);
            
            System.out.println("Novo Arquivo: " + nome);
         

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
