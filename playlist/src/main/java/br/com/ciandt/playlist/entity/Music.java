package br.com.ciandt.playlist.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "musicas")
public class Music implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "nome", nullable = false)
    private String name;

    @JsonIgnore
    @ManyToMany(fetch = LAZY, mappedBy = "playlistMusics")
    private List<Playlist> playlists;

    @ManyToOne
    @JoinColumn(name = "artistaid")
    private Artist artist;

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

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
