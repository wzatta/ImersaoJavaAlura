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
	
	private final String urlImg = "https://img.freepik.com/vetores-gratis/ups-erro-404-com-ilustracao-de-conceito-de-robo-quebrado_114360-5529.jpg?w=740&t=st=1682297877~exp=1682298477~hmac=5448f4f5971b0d562295d64b66cd8a5a008e4f842c1878d078207483771447e5";
	private StickerDTO stickerDto;
	private StickerDTO stickerDto1;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<List<StickerDTO>> findFigById(@PathVariable String id){
		
		stickerDto = new StickerDTO(null,"id","404",urlImg,"","Not Found","","");
		stickerDto1 = new StickerDTO(null,"id","404",urlImg,"","Not Found","","");
		
		try {
			
			AnimeResponse anime = client.findById(id);
			stickerDto = new StickerDTO(anime);
			
			if(stickerDto.getIdoriginaldto()==null) {
				stickerDto.setIdoriginaldto(id);
			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
		try {
			RickMortyResponse person = rickAndMortyClient.findCharacterById(id);
			
			stickerDto1 = new StickerDTO(person);
			
			if(stickerDto1.getNotadto()==null) {
				double nota = (Math.random()*10)+1;
				DecimalFormat df = new DecimalFormat("0.00");
				stickerDto1.setNotadto(df.format(nota));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
		List<StickerDTO> listSticker = new ArrayList<>();
		listSticker.add(stickerDto);
		listSticker.add(stickerDto1);
		
		return ResponseEntity.ok().body(listSticker);
		
	}
	
	
	
}
