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
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "artista")
    private List<Music> musicas;

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

    public List<Music> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Music> musicas) {
        this.musicas = musicas;
    }
}
