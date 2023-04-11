package cilazatta.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cilazatta.client.RickAndMortyClient;
import cilazatta.response.rickmorty.RickMortyResponse;
import cilazatta.service.GeradoraDeFigurinha;

@RestController
@RequestMapping(value = "rickmorty")
public class RickAndMortyController {

	@Autowired
	private RickAndMortyClient rickAndMortyClient;
	
	@Autowired
	private GeradoraDeFigurinha geraFig;
	
	@GetMapping(value = "character/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<RickMortyResponse> getCharacterById(@PathVariable String id){
		
		RickMortyResponse person = rickAndMortyClient.findCharacterById(id);
		
		this.geraFig.cria(person.image(), person.name()+".png", "Doideira!!!".trim());
		
		
		return ResponseEntity.ok().body(person);
	}

}
