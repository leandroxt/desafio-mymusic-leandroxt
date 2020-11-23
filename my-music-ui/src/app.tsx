import React, { ChangeEvent, ReactElement, useState } from 'react';
import Header from './components/header';
import SearchField from './components/search-field';
import Table from './components/table';
import { Music, User } from './types';

import service from './service';


function App(): ReactElement {
  const [foundMusics, setFoundMusics] = useState<Music[]>([]);
  const [userMusic, setUserMusic] = useState<User>();
  const [musicsSelected, setMusicSelected] = useState<string[]>([]);
  const [musicsDelete, setMusicDelete] = useState<string[]>([]);

  async function onSearchMusic(value: string): Promise<void> {
    const results = await service.searchMusic(value);
    setFoundMusics(() => results);
  }

  async function onSearchUserPlaylist(value: string): Promise<void> {
    const result = await service.searchUserPlaylist(value);
    setUserMusic(() => result);
  }

  function onCheck(id: string, value: boolean): void {
    let selected: string[] = [];
    if (value) {
      selected = [...musicsSelected, id];
    } else {
      selected = musicsSelected.filter(musicId => musicId !== id);
    }
    setMusicSelected(() => selected);
  }

  function onCheckDelete(id: string, value: boolean) {
    let selected: string[] = [];
    if (value) {
      selected = [...musicsDelete, id];
    } else {
      selected = musicsDelete.filter(musicId => musicId !== id);
    }
    setMusicDelete(() => selected);
  }

  function add(): void {
    musicsSelected.forEach((musicId) => {
      const music = foundMusics.find(m => m.id === musicId);
      if (music) {
        service.addMusic(userMusic?.id || '', music);
      }
    });

    // remover da lista de pesquisa as músicas adicionadas
    const filtered = foundMusics.filter(m => !musicsSelected.includes(m.id));
    setFoundMusics(() => filtered);
  }

  function remove() {
    musicsDelete.forEach((musicId) => {
      service.deleteMusic(userMusic?.id || '', musicId);
    });

    if (userMusic) { // typescript ¯\_(ツ)_/¯
      const filtered = userMusic.playlistMusicas.filter(m => !musicsDelete.includes(m.id));
      const user = { ...userMusic, playlistMusicas: filtered };
      setUserMusic(() => user);
    }
  }

  return (
    <>
      <Header />
      <div className="container-xl">
        <div className="row mb-5">
          <div className="col">
            <SearchField
              title="Music or artist"
              onChange={onSearchMusic}

            />
          </div>
          <div className="col">
            <SearchField
              dispatchOnEnter
              title="User"
              onChange={onSearchUserPlaylist}
            />
          </div>
        </div>

        <div className="row mt-5">
          <div className="col-6">
            <Table
              musics={foundMusics}
              onCheck={onCheck}
            />
          </div>
          <div className="col-1">
            <button type="button" className="btn btn-primary mb-3" onClick={add}>{'>>'}</button>
            <button type="button" className="btn btn-primary mt-3" onClick={remove}>{'<<'}</button>
          </div>
          <div className="col-5">
            <Table
              musics={userMusic?.playlistMusicas || []}
              onCheck={onCheckDelete}
            />
          </div>
        </div>
      </div>
    </>
  );
}

export default App;
