package com.api.starwars.planets.starwarss.domain.models;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import com.api.starwars.planets.starwarss.domain.dtos.PlanetRequestDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Planet {

    public Planet(PlanetRequestDTO planetRequestDTO) {
        this.id = UUID.randomUUID();
        this.name = planetRequestDTO.getName();
        this.climate = planetRequestDTO.getClimate();
        this.terrain = planetRequestDTO.getTerrain();
        this.insertDate = Date.from(Instant.now());
        this.active = true;
    }

    private UUID id;
    private String name;
    private String climate;
    private String terrain;
    private Date insertDate;
    private Boolean active;
}
