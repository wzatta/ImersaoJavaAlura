package cilazatta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cilazatta.DTO.StickerDTO;
import cilazatta.client.AnimeClient;
import cilazatta.response.anime.AnimeResponse;
//import cilazatta.service.GeradoraDeFigurinha;

@RestController
@RequestMapping(value = "api/v1/anime")
public class AnimeController {
	
	@Autowired
	private AnimeClient client;
	
	//@Autowired
	//private GeradoraDeFigurinha gerafig;

	@GetMapping(value = "/{id}")
	public ResponseEntity<StickerDTO> getById(@PathVariable String id) {
		
		AnimeResponse anime = client.findById(id);
		StickerDTO stickerDto = new StickerDTO(anime);
		
		if(stickerDto.getIdoriginaldto()==null) {
			stickerDto.setIdoriginaldto(id);
		}
		
		//this.gerafig.cria(anime.data().attributes().posterImage().medium().toString(),
		//		anime.data().attributes().slug().toString()+".png", "TOP-ANIME".trim());
		
		
		return ResponseEntity.ok().body(stickerDto);
		
	}
	
	
}
