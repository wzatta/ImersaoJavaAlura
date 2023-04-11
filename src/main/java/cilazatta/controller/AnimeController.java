package cilazatta.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cilazatta.client.AnimeClient;
import cilazatta.response.anime.AnimeResponse;
import cilazatta.service.GeradoraDeFigurinha;

@RestController
@RequestMapping(value = "anime")
public class AnimeController {
	
	@Autowired
	private AnimeClient client;
	
	@Autowired
	private GeradoraDeFigurinha gerafig;

	@GetMapping(value = "/{id}")
	public ResponseEntity<AnimeResponse> getById(@PathVariable String id) {
		
		AnimeResponse anime = client.findById(id);
		
		this.gerafig.cria(anime.data().attributes().posterImage().medium().toString(),
				anime.data().attributes().slug().toString()+".png", "TOP-ANIME".trim());
		
		
		return ResponseEntity.ok().body(anime);
		
	}
	
	
}
