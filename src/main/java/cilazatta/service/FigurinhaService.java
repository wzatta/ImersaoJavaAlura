package cilazatta.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cilazatta.DTO.StickerDTO;
import cilazatta.entity.Sticker;
import cilazatta.repositories.StickerRepository;
import cilazatta.service.exceptions.FieldDataIntegrityViolationException;

@Service
public class FigurinhaService {
	
	@Autowired
	private StickerRepository figRepo;
	
	
	private Sticker fig;

	public StickerDTO saveFig(StickerDTO stickerDto) {
		
		Optional<Sticker> figOpt = 
				figRepo.findByIdoriginalAndTipo(stickerDto.getIdoriginaldto(), stickerDto.getTipodto());
		
		if(figOpt.isPresent()) {
			throw new FieldDataIntegrityViolationException("Sticker ja Cadastrado");
		} else {
		
		fig = new Sticker(stickerDto);
		
		fig = figRepo.save(fig);
		
		StickerDTO stickerDTO = new StickerDTO(fig);
		
		return stickerDTO;
		
		}
		
	}
	


	public List<StickerDTO> findAll(){
		
		List<Sticker> listSticker = figRepo.findAll();
		
		List<StickerDTO> listDto = listSticker.stream()
				.map(w-> new StickerDTO(w))
				.collect(Collectors.toList());
		return listDto;
	}

}
