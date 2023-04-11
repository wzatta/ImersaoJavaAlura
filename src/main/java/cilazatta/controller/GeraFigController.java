package cilazatta.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cilazatta.service.GeradoraDeFigurinha;

@RestController
@RequestMapping(value = "gerafig")
public class GeraFigController {

	@Autowired
	private GeradoraDeFigurinha gerafig;
	
	 public ResponseEntity<Void> geraFigurinha(String urlImg, String nomeArquivo, String msg){
		 
		this.gerafig.cria(urlImg, nomeArquivo, msg);
		 
		 return ResponseEntity.noContent().build();
	 }
	
	
}
