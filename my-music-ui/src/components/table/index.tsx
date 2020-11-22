import React, { ReactElement } from 'react';
import style from './table.module.css';

interface Artist {
  id: string;
  nome: string;
}

export interface Music {
  id: string;
  nome: string;
  artista: Artist;
}

interface Props {
  musics: Music[];
}

export default function Table({ musics }: Props): ReactElement<Props> {
  return (
    <table className="table table-striped">
      <thead>
        <tr>
          <th scope="col">Music name</th>
          <th scope="col">Artist name</th>
          <th scope="col"></th>
        </tr>
      </thead>
      <tbody>
        {musics.map((music) => (
          <tr key={music.id}>
            <td className={style.song}>{music.nome}</td>
            <td className={style.artist}>{music.artista.nome}</td>
            <td className={style.check}>
              <div className="form-check">
                <input className="form-check-input" type="checkbox" value="" id="defaultCheck1" />
              </div>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  )
}