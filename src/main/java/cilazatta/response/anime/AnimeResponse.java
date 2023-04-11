package cilazatta.response.anime;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record AnimeResponse(AnimeAtributos data) {
	
}
