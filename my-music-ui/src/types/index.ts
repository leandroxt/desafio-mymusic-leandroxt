export interface Artist {
  id: string;
  nome: string;
}

export interface Music {
  id: string;
  nome: string;
  artista: Artist;
}

export interface User {
  id: string;
  playlistMusicas: Music[];
  usuario: {
    id: string;
    nome: string;
  }
}