package br.com.ciandt.playlist.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "playlists")
public class Playlist implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @ManyToMany(fetch = EAGER)
    @JoinTable(
            name = "playlistmusicas",
            joinColumns = @JoinColumn(name = "playlistid", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "musicaid", referencedColumnName = "id")
    )
    private List<Music> playlistMusics;

    @OneToOne(mappedBy = "playlist")
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Music> getPlaylistMusics() {
        return playlistMusics;
    }

    public void setPlaylistMusics(List<Music> playlistMusics) {
        this.playlistMusics = playlistMusics;
    }

    public User getUsers() {
        return user;
    }

    public void setUsers(User users) {
        this.user = users;
    }
}
