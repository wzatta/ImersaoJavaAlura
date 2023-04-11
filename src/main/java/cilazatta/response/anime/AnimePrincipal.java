package cilazatta.response.anime;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record AnimePrincipal(String id, 
		String synopsis, String slug, String canonicalTitle,
		String averageRating, AnimePosterImage posterImage) {

	
}
