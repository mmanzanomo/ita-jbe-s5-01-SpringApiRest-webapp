package cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n03.model.dto.FlowerDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface IFlowerService {
    Mono<FlowerDTO> save(FlowerDTO flowerDTO);
    Mono<FlowerDTO> update(FlowerDTO flowerDTO);
    Mono<Void> delete(int id);
    Mono<FlowerDTO> findOneById(int id);
    Flux<FlowerDTO> findAll();
}
