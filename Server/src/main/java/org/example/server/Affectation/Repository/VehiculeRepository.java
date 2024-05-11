package org.example.server.Affectation.Repository;

import org.example.server.Affectation.Model.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehiculeRepository extends JpaRepository<Vehicule, Integer> {
    List<Vehicule> findAllByDisponibilite(boolean disponibilite);
}
