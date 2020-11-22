package br.com.ciandt.playlist.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "playlists")
public class Playlist implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @ManyToMany(fetch = LAZY)
    @JoinTable(
            name = "playlistmusicas",
            joinColumns = @JoinColumn(name = "playlistid", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "musicaid", referencedColumnName = "id")
    )
    private List<Music> playlistMusicas;

    @OneToOne(mappedBy = "playlist")
    private User usuario;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Music> getPlaylistMusicas() {
        return playlistMusicas;
    }

    public void setPlaylistMusicas(List<Music> playlistMusicas) {
        this.playlistMusicas = playlistMusicas;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Playlist addMusic(final Music music) {
        this.playlistMusicas.add(music);
        return this;
    }

    public Playlist removeMusic(final Music music) {
        this.playlistMusicas.remove(music);
        return this;
    }
}
