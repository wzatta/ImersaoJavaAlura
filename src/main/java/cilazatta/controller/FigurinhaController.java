package cilazatta.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cilazatta.DTO.StickerDTO;
import cilazatta.client.AnimeClient;
import cilazatta.client.RickAndMortyClient;
import cilazatta.response.anime.AnimeResponse;
import cilazatta.response.rickmorty.RickMortyResponse;
import cilazatta.service.FigurinhaService;

@RestController
@RequestMapping(value = "api/v1/fig")
public class FigurinhaController {

	@Autowired
	private AnimeClient client;
	
	@Autowired
	private RickAndMortyClient rickAndMortyClient;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<List<StickerDTO>> findFigById(@PathVariable String id){
		
		AnimeResponse anime = client.findById(id);
		StickerDTO stickerDto = new StickerDTO(anime);
		
		if(stickerDto.getIdoriginaldto()==null) {
			stickerDto.setIdoriginaldto(id);
		}
		
		RickMortyResponse person = rickAndMortyClient.findCharacterById(id);
		
		StickerDTO stickerDto1 = new StickerDTO(person);
		
		if(stickerDto1.getNotadto()==null) {
			double nota = (Math.random()*10)+1;
			DecimalFormat df = new DecimalFormat("0.00");
			stickerDto1.setNotadto(df.format(nota));
			
		}
		
		List<StickerDTO> listSticker = new ArrayList<>();
		listSticker.add(stickerDto);
		listSticker.add(stickerDto1);
		
		return ResponseEntity.ok().body(listSticker);
		
	}
	
	
	
}
