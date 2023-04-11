package cilazatta.client;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import cilazatta.response.anime.AnimeResponse;
import reactor.core.publisher.Mono;

@Service
public class AnimeClient {

	private final WebClient webClient;
	
	public AnimeClient(WebClient.Builder builder) {
		webClient = builder
				.baseUrl("https://kitsu.io/api/edge")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, "application/vnd.api+json")
		        .defaultHeader(HttpHeaders.ACCEPT, "application/vnd.api+json")
				.build();
	}
	
	public AnimeResponse findById(String id) {
		
		Mono<AnimeResponse> monoAnime = this.webClient
				.get()
				.uri("/anime/"+id)
				.retrieve()
				 .onStatus(HttpStatusCode ::is4xxClientError  ,
						 error-> Mono.error(new RuntimeException("verifique os Parametros")))
				.bodyToMono(AnimeResponse.class);
		
		return monoAnime.block();
	}
	
	
}
