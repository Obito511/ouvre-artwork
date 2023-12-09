package com.example.oueuvre_artwork.Repository;

import com.example.oueuvre_artwork.Entity.Art;
import com.example.oueuvre_artwork.Entity.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurRepository extends JpaRepository<Auteur, Long> {

}
