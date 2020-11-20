package br.com.ciandt.playlist.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class User {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "nome", nullable = false)
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "playlistid")
    private Playlist playlist;

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

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }
}
