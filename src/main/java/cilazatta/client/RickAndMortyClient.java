package cilazatta.client;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import cilazatta.response.rickmorty.RickMortyResponse;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class RickAndMortyClient {

	private final WebClient webClient;
	
	public RickAndMortyClient(WebClient.Builder builder ) {
		webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
	}
	
	public RickMortyResponse findCharacterById(String id){
		log.info("Buscando o personagem com o id [{}]", id);
		Mono<RickMortyResponse> monoPerson = this.webClient
				.get()
				.uri("/character/" + id)
				.accept(APPLICATION_JSON)
				.retrieve()
				 .onStatus(HttpStatusCode ::is4xxClientError  ,
						 error-> Mono.error(new RuntimeException("verifique os Parametros")))
				.bodyToMono(RickMortyResponse.class);
			return monoPerson.block();
		
	}
	
}
