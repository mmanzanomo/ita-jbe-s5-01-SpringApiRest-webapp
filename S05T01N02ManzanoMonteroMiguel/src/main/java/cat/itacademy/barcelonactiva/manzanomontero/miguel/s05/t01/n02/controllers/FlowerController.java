package cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n02.controllers;

import cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n02.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n02.model.services.IFlowerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flower")
public class FlowerController {
    @Autowired
    private IFlowerService service;


    @Operation(summary = "Add a new flower")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Added flower",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FlowerDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            })
    @PostMapping("/add")
    public ResponseEntity<FlowerDTO> add(@RequestBody FlowerDTO flowerDTO) {
        FlowerDTO savedFlower = service.save(flowerDTO);
        if (savedFlower == null) return ResponseEntity.status(500).body(null);
        return ResponseEntity.status(201).body(savedFlower);
    }

    @Operation(summary = "Update a flower by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated flower",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FlowerDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Flower not found",
                    content = @Content) })
    @PutMapping("/update")
    public ResponseEntity<FlowerDTO> update(@RequestBody FlowerDTO flowerDTO) {
        FlowerDTO updatedFlowerDTO = service.update(flowerDTO);
        if (updatedFlowerDTO != null) {
            return new ResponseEntity<>(updatedFlowerDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Delete a flower by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "removed flower",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FlowerDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Flower not found",
                    content = @Content) })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<FlowerDTO> delete(@PathVariable int id) {
        try {
            this.service.delete(id);
            return ResponseEntity.status(204).body(null);
        } catch (Exception e) {
            return  ResponseEntity.status(500).body(null);
        }
    }

    @Operation(summary = "Get all flowers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the list of flowers",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FlowerDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "Did not find any Flower",
                    content = @Content) })
    @GetMapping("/getAll")
    public ResponseEntity<List<FlowerDTO>> findAll() {
        List<FlowerDTO> list = this.service.findAll();
        if (list.isEmpty()) return ResponseEntity.status(204).body(null);
        return ResponseEntity.status(200).body(list);
    }

    @Operation(summary = "Get a flower by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the flower",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FlowerDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Flower not found",
                    content = @Content) })
    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlowerDTO> findOneById(@PathVariable int id) {
        Optional<FlowerDTO> flowerDTO = this.service.findOneById(id);
        if (flowerDTO.isPresent()) {
            return ResponseEntity.status(200).body(flowerDTO.get());
        }
        return ResponseEntity.status(404).body(null);
    }

}
