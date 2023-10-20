package br.com.desafio.exercicio.tres;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.imageio.ImageIO;

public class Program {

    public static void main(String[] args) {
        try {
           
        	String caminho = "D:\\ws-java\\DesafioJava";

            
            File arquivoEntrada = new File("D:\\ws-java\\DesafioJava\\carro.jpg");
            BufferedImage imagemEntrada = ImageIO.read(arquivoEntrada);

           
            int larguraDesejada = 600;
            int alturaDesejada = 480;

           
            BufferedImage imagemRedimensionada = new BufferedImage(larguraDesejada, alturaDesejada, BufferedImage.TYPE_INT_RGB);

            
            Graphics2D g2d = imagemRedimensionada.createGraphics();
            g2d.drawImage(imagemEntrada, 0, 0, larguraDesejada, alturaDesejada, null);
            g2d.dispose();

            
            int alturaTarja = alturaDesejada - imagemEntrada.getHeight();
            if (alturaTarja > 0) {
                Graphics2D g2dTarja = imagemRedimensionada.createGraphics();
                g2dTarja.setColor(Color.BLACK);
                g2dTarja.fillRect(0, imagemEntrada.getHeight(), larguraDesejada, alturaTarja);
                g2dTarja.dispose();
            }

           
            LocalDate dataAtual = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String caminhoFormatado = dataAtual.format(formatter);

            File diretorioNovo = new File(caminho + "\\" + caminhoFormatado);

            boolean success = diretorioNovo.mkdirs();
            
            if( success = true) {
            	 System.out.println("Imagem redimensionada com tarja preta adicionada com sucesso.");
            }
            
            String nomeArquivoSaida = "imagem_redimensionada.jpg";
            File arquivoSaida = new File(caminhoFormatado + "\\" + nomeArquivoSaida);
            ImageIO.write(imagemRedimensionada, "jpg", arquivoSaida);

           

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
