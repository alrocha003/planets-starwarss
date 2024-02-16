package com.api.starwars.planets.starwarss.infra.Entities;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import com.api.starwars.planets.starwarss.domain.dtos.PlanetRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "planets_tb")
@Getter
@Setter
@NoArgsConstructor
public class PlanetEntity {
    
    public PlanetEntity(PlanetRequestDTO planetRequestDTO) {
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
