package cilazatta.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cilazatta.entity.Sticker;

public interface StickerRepository extends JpaRepository<Sticker, Long> {

  Optional<Sticker> findByIdoriginalAndTipo(String idoriginal, String tipo);
	
}
