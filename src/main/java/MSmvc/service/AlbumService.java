package MSmvc.service;

import MSmvc.model.Album;
import MSmvc.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository repository;

    public List<Album> getAllAlbuns(){
        return repository.findAll();
    }
    public Optional<Album> find(String title){
        return repository.findByTitle(title);
    }

    public Album save(Album album){
        return repository.save(album);
    }
    public List<Album> searchGender(String genre){
        return repository.findByGenre(genre);
    }
}
