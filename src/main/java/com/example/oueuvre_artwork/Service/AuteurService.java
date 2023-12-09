package com.example.oueuvre_artwork.Service;

import com.example.oueuvre_artwork.Entity.Art;
import com.example.oueuvre_artwork.Entity.Auteur;
import com.example.oueuvre_artwork.Repository.ArtRepository;
import com.example.oueuvre_artwork.Repository.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuteurService {
    private final AuteurRepository auteurRepository;

    @Autowired
    public AuteurService(AuteurRepository auteurRepository) {
        this.auteurRepository = auteurRepository;

    }

    public void saveAuteur(Auteur author) {
        // Creating a new Art entity
        Auteur auteur = new Auteur();
        auteur.setNome(author.getNome());
        auteur.setPrenom(author.getPrenom());
        auteur.setDateDeNaissance(author.getDateDeNaissance());
        auteur.setLieuDeNaissance(author.getLieuDeNaissance());
        auteur.setArts(author.getArts());

        // Saving the entity using the repository's save method
        auteurRepository.save(auteur);

        // Now 'art' has been saved in the database
    }

    public void deleteAuteurById(Long artId) {
        auteurRepository.deleteById(artId);
    }
    public Auteur getAuteurById(Long id) {
        return auteurRepository.findById(id).orElse(null);
    }
    public Auteur updateAuteur(Long autId, Auteur updatedAuteur) {
        Auteur existingAut = auteurRepository.findById(autId).orElse(null);

        if (existingAut != null) {
            existingAut.setNome(updatedAuteur.getNome());
            existingAut.setPrenom(updatedAuteur.getPrenom());
            existingAut.setDateDeNaissance(updatedAuteur.getDateDeNaissance());
            existingAut.setLieuDeNaissance(updatedAuteur.getLieuDeNaissance());

            return auteurRepository.save(existingAut);
        } else {
            return null;
        }
    }

}

