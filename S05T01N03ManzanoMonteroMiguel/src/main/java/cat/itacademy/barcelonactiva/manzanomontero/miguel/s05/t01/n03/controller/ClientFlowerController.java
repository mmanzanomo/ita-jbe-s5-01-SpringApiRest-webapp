package cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n03.controller;

import cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n03.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.manzanomontero.miguel.s05.t01.n03.model.services.IFlowerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/flower")
public class ClientFlowerController {
    @Autowired
    private IFlowerService service;


    @Operation(summary = "Add a new flower")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Added flower",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FlowerDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "No connection to Flowers REST API",
                    content = @Content)
    })
    @PostMapping("/clientFlowersAdd")
    public Mono<FlowerDTO> add(@RequestBody FlowerDTO flowerDTO) {
        return service.save(flowerDTO)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                        "The flower could not be succefully saved.")));
    }

    @Operation(summary = "Update a flower by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated flower",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FlowerDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Flower not found",
                    content = @Content) ,
            @ApiResponse(responseCode = "500", description = "No connection to Flowers REST API",
                    content = @Content)
    })
    @PutMapping("/clientFlowersUpdate")
    public Mono<FlowerDTO> update(@RequestBody FlowerDTO flowerDTO) {
        return service.update(flowerDTO)
                .flatMap(updatedFlower -> {
                    if (updatedFlower == null) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The flower was not found.");
                    }
                    return Mono.just(updatedFlower);
                });
    }

    @Operation(summary = "Delete a flower by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "removed flower",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FlowerDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Flower not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "No connection to Flowers REST API",
                    content = @Content)
    })
    @DeleteMapping("/clientFlowersDelete/{id}")
    public Mono<Void> delete(@PathVariable int id) {
        return service.delete(id);
    }

    @Operation(summary = "Get all flowers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the list of flowers",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FlowerDTO.class)) }),
            @ApiResponse(responseCode = "204", description = "No content",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Did not find any Flower",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "No connection to Flowers REST API",
                    content = @Content) })
    @GetMapping("/getAll")
    public Flux<FlowerDTO> findAll() {
        return service.findAll();
    }

    @Operation(summary = "Get a flower by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the flower",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FlowerDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Flower not found",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "No connection to Flowers REST API",
                    content = @Content)
    })
    @GetMapping("/getOne/{id}")
    public Mono<FlowerDTO> findOneById(@PathVariable int id) {
        return service.findOneById(id)
                .flatMap(flower -> {
                    if (flower == null) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The flower was not found.");
                    }
                    return Mono.just(flower);
                });
    }

}

