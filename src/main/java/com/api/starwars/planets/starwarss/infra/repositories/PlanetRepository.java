package com.api.starwars.planets.starwarss.infra.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.starwars.planets.starwarss.infra.Entities.PlanetEntity;
import java.util.List;

@Repository
public interface PlanetRepository extends JpaRepository<PlanetEntity, String> {

    List<PlanetEntity> findByName(String name);
}
