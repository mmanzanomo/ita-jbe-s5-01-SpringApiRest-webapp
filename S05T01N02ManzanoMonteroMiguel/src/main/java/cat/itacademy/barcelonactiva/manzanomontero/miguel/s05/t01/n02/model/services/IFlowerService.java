package cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n02.model.dto.FlowerDTO;

import java.util.List;
import java.util.Optional;

public interface IFlowerService {
    FlowerDTO save(FlowerDTO flowerDTO);
    FlowerDTO update(FlowerDTO flowerDTO);
    void delete(int id);
    Optional<FlowerDTO> findOneById(int id);
    List<FlowerDTO> findAll();
}
