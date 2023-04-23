package cilazatta.controller;


import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cilazatta.DTO.StickerDTO;
import cilazatta.client.RickAndMortyClient;
import cilazatta.response.rickmorty.RickMortyResponse;
//import cilazatta.service.GeradoraDeFigurinha;

@RestController
@RequestMapping(value = "api/v1/rickmorty")
public class RickAndMortyController {

	@Autowired
	private RickAndMortyClient rickAndMortyClient;
	
	//@Autowired
	//private GeradoraDeFigurinha geraFig;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<StickerDTO> getCharacterById(@PathVariable String id){
		
		RickMortyResponse person = rickAndMortyClient.findCharacterById(id);
		
		//this.geraFig.cria(person.image(), person.name()+".png", "Doideira!!!".trim());
		
		StickerDTO stickerDto = new StickerDTO(person);
		
		if(stickerDto.getNotadto()==null) {
			double nota = (Math.random()*10)+1;
			DecimalFormat df = new DecimalFormat("0.00");
			stickerDto.setNotadto(df.format(nota));
			
		}
		
		return ResponseEntity.ok().body(stickerDto);
	}

}
