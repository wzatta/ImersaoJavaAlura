package cilazatta.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cilazatta.DTO.ImagemDTO;
import cilazatta.service.GeraFigServ;

@RestController
@RequestMapping(value = "api/v1/gerafig")
public class GeraFigController {

	
	@Autowired
	private GeraFigServ geradorfig;
	
	/* public ResponseEntity<Void> geraFigurinha(String urlImg, String nomeArquivo, String msg){
		 
		this.gerafig.cria(urlImg, nomeArquivo, msg);
		 
		 return ResponseEntity.noContent().build();
	 }*/
	
	 @GetMapping(value = "/view")
	 public ResponseEntity<ImagemDTO> viewFig(
			  @RequestParam String url, 
			  @RequestParam String nomeArquivo, 
			  @RequestParam String msg
			 ){
		 
		 String stringImg = this.geradorfig.cria(url, nomeArquivo, msg);
		 
		 ImagemDTO imgdto = new ImagemDTO(stringImg);
		 
		 return ResponseEntity.ok().body(imgdto);
		 
	 }
	
}
