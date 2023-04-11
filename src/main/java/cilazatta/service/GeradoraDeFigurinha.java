package cilazatta.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

@Service
public class GeradoraDeFigurinha {

	public void cria(String urlImg, String nomeArquivo, String msg) {

		try {
			// Cria inputStream a partir da String url
			InputStream inputStream = new URL(urlImg).openStream();
			// Leitura da Imagem
			BufferedImage imgOriginal = ImageIO.read(inputStream);

			// Criar uma nova Imagem
			int largura = imgOriginal.getWidth();
			int altura = imgOriginal.getHeight();
			int novaAltura = altura + 25;
			BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

			// copiar a imagem Orignal para novo imagem (em memoria)
			Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
			graphics.drawImage(imgOriginal, 0, 0, null);

			// configurar a fonte
			Font font = new Font(Font.SANS_SERIF, Font.BOLD, 32);
			graphics.setColor(Color.yellow);
			graphics.setFont(font);

			// escrever uma frase na nova imagem
			int msgt = msg.length();

			float centraliza = 0;
			if (largura >= 390) {
				if (msgt <= 19) {

					centraliza = (largura - (msgt * 19.11f)) / 2;
					centraliza = Math.round(centraliza);
				}

			}
			if (largura <= 300) {
				if (msgt <= 16) {
					centraliza = (largura - (msgt * 19.11f)) / 2;
					centraliza = Math.round(centraliza);
				}
				System.out.println(centraliza);
			}

			graphics.drawString(msg, centraliza, novaAltura - 2);

			// escrever a nova imagem em um arquivo
			
			File dirFile = new File("C:\\Users\\wzjss\\OneDrive\\Documents\\ArquivoFigurinha");
			ImageIO.write(novaImagem, "png", new File("C:\\Users\\wzjss\\OneDrive\\Documents\\ArquivoFigurinha",nomeArquivo));

		} catch (Exception e) {
			throw new RuntimeException("Erro ao Gerar a Figurinha");
		}
	}

}
