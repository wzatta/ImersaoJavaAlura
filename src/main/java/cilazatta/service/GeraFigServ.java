package cilazatta.service;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

@Service
public class GeraFigServ {
	
		private String stringImage ="";
		private String type = "png";

		public String cria(String urlImg, String nomeArquivo, String msg) {

				// Cria inputStream a partir da String url
				InputStream inputStream = null;
				try {
					inputStream = new URL(urlImg).openStream();
				} catch (MalformedURLException e) {
					throw new RuntimeException("erro URL errada ");
					//e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
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
				Font font = new Font(Font.SANS_SERIF, Font.BOLD, 24);
				graphics.setColor(Color.red);
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
					
				}

				graphics.drawString(msg, centraliza, novaAltura - 2);

				// escrever a nova imagem em um arquivo
				
				
				stringImage = ConvertImagemToString.encodeToString(novaImagem, type);
				
				return stringImage;
				
			} catch (Exception e) {
				throw new RuntimeException("erro ao inicializar a imagem");
			}
		
		}
		
}
	
	
			


