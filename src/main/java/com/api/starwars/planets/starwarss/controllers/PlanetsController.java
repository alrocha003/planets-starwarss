package com.api.starwars.planets.starwarss.controllers;

import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.starwars.planets.starwarss.domain.models.Planet;
import com.api.starwars.planets.starwarss.StarwarssApplication;
import com.api.starwars.planets.starwarss.domain.dtos.PlanetRequestDTO;

@RestController
@RequestMapping("/api/planets")
public class PlanetsController {

    private Logger logger = LogManager.getLogger(org.slf4j.Logger.class);
    private List<Planet> planets = new ArrayList<Planet>();

    @GetMapping("/{name}")
    public ResponseEntity<List<Planet>> getByName(@PathVariable String name) {
        logger.info("Buscando planeta: {}", name);

        if (name == null)
            return new ResponseEntity<List<Planet>>(planets, HttpStatus.OK);

        Stream<Planet> findPlanet = planets.stream().filter(p -> p.getName().equals(name));

        if (findPlanet.count() == 0)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<List<Planet>>(findPlanet.toList(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Planet> getById(@RequestParam("id") UUID id) {
        logger.info("Buscando planeta pelo id: ", id.toString());

        // TOOD: Implementar consulta na base de dados
        Planet planet = new Planet(new PlanetRequestDTO("Teste",
                "Teste", "Teste"));

        return new ResponseEntity<Planet>(planet, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Planet> insertPlanet(@RequestBody PlanetRequestDTO requestDTO) {
        logger.info("Acessando rota POST - insertPlanet");

        // TOOD: Implementar persistencia na base de dados
        Planet planetToInsert = requestDTO.toModel();
        System.out.println(planetToInsert);
        planets.add(planetToInsert);

        logger.trace("Retornando o planet criado pela rota POST - insertPlanet");

        return new ResponseEntity<Planet>(planetToInsert, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlanet(@PathVariable UUID id) {
        logger.info("Acessando rota DELETE - deletePlanet");

        return new ResponseEntity<String>(String.format("Planeta ID %s exclu[ido", id.toString()), HttpStatus.OK);
    }

}
