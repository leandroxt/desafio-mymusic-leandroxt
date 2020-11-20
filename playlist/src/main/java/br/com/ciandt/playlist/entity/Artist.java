package br.com.ciandt.playlist.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "artistas")
public class Artist {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "nome", nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "artist")
    private List<Music> musics;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Music> getMusics() {
        return musics;
    }

    public void setMusics(List<Music> musics) {
        this.musics = musics;
    }
}
