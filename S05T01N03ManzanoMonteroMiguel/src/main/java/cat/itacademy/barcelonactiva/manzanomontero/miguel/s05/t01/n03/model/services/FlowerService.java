package cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n03.model.dto.FlowerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class FlowerService implements IFlowerService {
    private final WebClient webClient;

    public FlowerService(WebClient.Builder builder) {
        webClient = builder.baseUrl("http://localhost:9001/flower").build();
    }

    @Override
    public Mono<FlowerDTO> save(FlowerDTO flowerDTO) {
        return webClient.post()
                .uri("/add")
                // Emits the body object
                .body(Mono.just(flowerDTO), FlowerDTO.class)
                .retrieve()
                .bodyToMono(FlowerDTO.class);
    }

    @Override
    public Mono<FlowerDTO> update(FlowerDTO flowerDTO) {
        return webClient.put()
                .uri("/update")
                .body(Mono.just(flowerDTO), FlowerDTO.class)
                .retrieve()
                .bodyToMono(FlowerDTO.class);
    }

    @Override
    public Mono<Void> delete(int id) {
        return webClient.delete()
                .uri("/delete/" + id)
                .retrieve()
                .bodyToMono(Void.class);
    }

    @Override
    public Mono<FlowerDTO> findOneById(int id) {
        return webClient.get()
                .uri("/getOne/" + id)
                .retrieve()
                .bodyToMono(FlowerDTO.class);
    }

    @Override
    public Flux<FlowerDTO> findAll() {
        return webClient.get()
                .uri("/getAll")
                .retrieve()
                .bodyToFlux(FlowerDTO.class);
    }
}
