import React, { MouseEvent, ReactElement } from 'react';
import style from './table.module.css';

import { Music } from '../../types';

interface Props {
  musics: Music[];
  onCheck: (id: string, value: boolean) => void;
}

export default function Table({ musics, onCheck }: Props): ReactElement<Props> {
  function onCheckbox({ currentTarget }: MouseEvent<HTMLInputElement>): void {
    onCheck(currentTarget.id, currentTarget.checked);
  }

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
                <input
                  id={music.id}
                  className="form-check-input"
                  type="checkbox"
                  onClick={onCheckbox}
                />
              </div>
            </td>
          </tr>
        ))}
        {musics.length === 0 && (
          <tr>
            <td colSpan={3}>
              <span className="badge badge-pill badge-info d-flex justify-content-center">Não há músicas</span>
            </td>
          </tr>
        )}
      </tbody>
    </table>
  )
}