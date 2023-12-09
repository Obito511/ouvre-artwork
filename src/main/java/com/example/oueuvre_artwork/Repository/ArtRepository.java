package com.example.oueuvre_artwork.Repository;



import com.example.oueuvre_artwork.Entity.Art;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtRepository extends JpaRepository<Art, Long> {


}
