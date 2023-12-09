package com.example.oueuvre_artwork.Service;

import com.example.oueuvre_artwork.Entity.Art;
import com.example.oueuvre_artwork.Repository.ArtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtService {
    private final ArtRepository artRepository;

    @Autowired
    public ArtService(ArtRepository artRepository) {
        this.artRepository = artRepository;
    }

    public void saveArt(Art art) {
        // Creating a new Art entity
        Art art2 = new Art();
        art.setNom(art.getNom());
        art.setDescription(art.getDescription());
        art.setImage(art.getImage());

        // Saving the entity using the repository's save method
        artRepository.save(art);

        // Now 'art' has been saved in the database
    }


    public void deleteArtById(Long artId) {
        artRepository.deleteById(artId);
    }

    public Art getArtById(Long id) {
        return artRepository.findById(id).orElse(null);
    }

    public Art updateArt(Long artId, Art updatedArt) {
        Art existingArt = artRepository.findById(artId).orElse(null);

        if (existingArt != null) {
            existingArt.setNom(updatedArt.getNom());
            existingArt.setDescription(updatedArt.getDescription());
            existingArt.setImage(updatedArt.getImage());
            // Update other attributes as needed

            return artRepository.save(existingArt);
        } else {
            return null; // Or handle as needed, indicating the entity doesn't exist
        }
    }
}
