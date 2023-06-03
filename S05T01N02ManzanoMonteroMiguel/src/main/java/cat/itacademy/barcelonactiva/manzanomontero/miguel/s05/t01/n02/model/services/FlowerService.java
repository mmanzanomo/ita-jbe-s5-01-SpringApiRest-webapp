package cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n02.model.domain.Flower;
import cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n02.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n02.model.repository.IFlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlowerService implements IFlowerService {
    @Autowired
    private IFlowerRepository repository;

    @Override
    @Transactional
    public FlowerDTO save(FlowerDTO flowerDTO) {
        Flower flower = convertToFlower(flowerDTO);
        return convertToDTO(this.repository.save(flower));
    }

    @Override
    @Transactional
    public FlowerDTO update(FlowerDTO flowerDTO) {
        Flower flower = convertToFlower(flowerDTO);
        Optional<Flower> updatedFlower = repository.findById(flower.getPk_FlowerID());
        if(updatedFlower.isPresent()) {
            return convertToDTO(this.repository.save(flower));
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<FlowerDTO> findOneById(int id) {
        Optional<Flower> flower = repository.findById(id);
        return flower.map(this::convertToDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FlowerDTO> findAll() {
        List<Flower> flowers = repository.findAll();

        List<FlowerDTO> flowerDTOs = flowers.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return flowerDTOs;
    }


    private FlowerDTO convertToDTO(Flower flower) {
        FlowerDTO flowerDTO = new FlowerDTO();
        flowerDTO.setPk_FlowerID(flower.getPk_FlowerID());
        flowerDTO.setName(flower.getName());
        flowerDTO.setCountry(flower.getCountry());

        return flowerDTO;
    }

    private Flower convertToFlower(FlowerDTO flowerDTO) {
        Flower flower = new Flower();
        flower.setPk_FlowerID(flowerDTO.getPk_FlowerID());
        flower.setName(flowerDTO.getName());
        flower.setCountry(flowerDTO.getCountry());

        return flower;
    }

}
