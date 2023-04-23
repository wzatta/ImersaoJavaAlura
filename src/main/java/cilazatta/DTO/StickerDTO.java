package cilazatta.DTO;

import cilazatta.entity.Sticker;
import cilazatta.response.anime.AnimeResponse;
import cilazatta.response.rickmorty.RickMortyResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StickerDTO {

	private Long id;
	private String idoriginaldto;
	private String tipodto;
	private String imagemurldto;
	private String imagembase64;
	private String titulodto;
	private String notadto;
	private String textodto;
	
	
	public StickerDTO(Sticker sticker) {
		
		this.id = sticker.getId();
		this.idoriginaldto = sticker.getIdoriginal();
		this.imagemurldto= sticker.getImagemurl();
		this.imagembase64 = sticker.getImgbase64();
		this.notadto = sticker.getNota();
		this.tipodto = sticker.getTipo();
		this.textodto = sticker.getTexto();
		this.titulodto = sticker.getTitulo();
		
	}
	
	public StickerDTO(AnimeResponse anime) {
		this.idoriginaldto = anime.data().attributes().id();
		this.imagemurldto = anime.data().attributes().posterImage().small();
		this.notadto = anime.data().attributes().averageRating();
		if(anime.data().attributes().canonicalTitle().length()>15) {
		this.titulodto = anime.data().attributes().canonicalTitle().substring(0, 15);
		} else {
			this.titulodto = anime.data().attributes().canonicalTitle();
		}
		this.textodto = anime.data().attributes().synopsis();
		this.tipodto = "ANIME";
	}
	
	public StickerDTO(RickMortyResponse rick) {
		this.idoriginaldto = rick.id();
		this.imagemurldto = rick.image();
		this.textodto = rick.species();
		if(rick.name().length()>16) {
		this.titulodto = rick.name().substring(0, 15);
		} else {
			this.titulodto = rick.name();
		}
		this.tipodto = "RICKANDMORTY";
				
	}
	
	
	
}
