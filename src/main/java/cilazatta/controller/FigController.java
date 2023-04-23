package cilazatta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cilazatta.DTO.ImagemDTO;
import cilazatta.DTO.StickerDTO;
import cilazatta.service.FigurinhaService;
import cilazatta.service.GeraFigServ;

@RestController
@RequestMapping(value = "api/v1/newfig" )
public class FigController {
	
	@Autowired
	private FigurinhaService figServ;
	
	@Autowired
	private GeraFigServ geradorfig;
	
	@PostMapping
	public ResponseEntity<StickerDTO> saveFig(@RequestBody StickerDTO stickerDto){
		
		System.out.println(stickerDto.getTipodto());
		System.out.println(stickerDto.getTextodto().length());
		
		
		stickerDto = figServ.saveFig(stickerDto);
		return ResponseEntity.created(null).body(stickerDto);
	}
	
	@GetMapping
	public ResponseEntity<List<StickerDTO>> findAll(){
		List<StickerDTO> list = figServ.findAll();
		return ResponseEntity.ok().body(list);
	}
	
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
