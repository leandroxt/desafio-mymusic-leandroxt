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
    private String nome;

    @JsonIgnore
    @ManyToMany(fetch = LAZY, mappedBy = "playlistMusicas")
    private List<Playlist> playlists;

    @ManyToOne
    @JoinColumn(name = "artistaid")
    private Artist artista;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public Artist getArtista() {
        return artista;
    }

    public void setArtista(Artist artista) {
        this.artista = artista;
    }
}
