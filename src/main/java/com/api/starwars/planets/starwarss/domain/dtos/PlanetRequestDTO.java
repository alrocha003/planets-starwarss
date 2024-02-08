package com.api.starwars.planets.starwarss.domain.dtos;

import com.api.starwars.planets.starwarss.domain.models.Planet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PlanetRequestDTO {

    private String name;
    private String climate;
    private String terrain;

    public Planet toModel() {
        return new Planet(this);
    }

    @Override
    public String toString() {
        return String.format("Nome: %s - Clima: %s - Terreno: %s",
                this.name, this.climate, this.terrain);
    }
}
