package cilazatta.entity;

import java.io.Serializable;

import cilazatta.DTO.StickerDTO;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {
		@UniqueConstraint(name = "uniqueIdOrigAndTipo", columnNames = {"idoriginal","tipo"} )
})
public class Sticker implements Serializable{

		private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Column(name = "idoriginal")
	private String idoriginal;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="imagemurl")
	private String imagemurl;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name="imgbase64", columnDefinition = "LONGBLOB")
	private String imgbase64;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="nota")
	private String nota;
	
	@Column(name="texto", columnDefinition = "TEXT")
	private String texto;
	
	public Sticker(StickerDTO stickerdto) {
		
		this.id = stickerdto.getId();
		this.idoriginal = stickerdto.getIdoriginaldto();
		this.tipo = stickerdto.getTipodto();
		this.imagemurl = stickerdto.getImagemurldto();
		this.imgbase64 = stickerdto.getImagembase64();
		this.titulo = stickerdto.getTitulodto();
		this.nota = stickerdto.getNotadto();
		this.texto = stickerdto.getTextodto();
		
	}
	
}
