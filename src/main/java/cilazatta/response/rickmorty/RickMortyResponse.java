package cilazatta.response.rickmorty;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record RickMortyResponse(String id, 
	String name, String status, String species, 
	String image, List<String> episode){

	/*
	private String id;
	private String name;
	private String status;
	private String species;
	private String image;
	private List<String> episode;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<String> getEpisode() {
		return episode;
	}
	public void setEpisode(List<String> episode) {
		this.episode = episode;
	}
	
*/
}
