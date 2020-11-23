import React, { ChangeEvent, ReactElement, useState } from 'react';
import Header from './components/header';
import SearchField from './components/search-field';
import Table, { Music } from './components/table';

import service from './service';

interface User {
  id: string;
  playlistMusicas: Music[];
  usuario: {
    id: string;
    nome: string;
  }
}

function App(): ReactElement {
  const [foundMusics, setFoundMusics] = useState<Music[]>([]);
  const [userMusic, setUserMusic] = useState<User>();

  async function onSearchMusic(value: string): Promise<void> {
    const results = await service.searchMusic(value);
    setFoundMusics(() => results);
  }

  async function onSearchUserPlaylist(value: string): Promise<void> {
    const result = await service.searchUserPlaylist(value);
    setUserMusic(() => result);
  }

  function onCheck(id: string): void {

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
            <button type="button" className="btn btn-primary mb-3">{'>>'}</button>
            <button type="button" className="btn btn-primary mt-3">{'<<'}</button>
          </div>
          <div className="col-5">
            <Table
              musics={userMusic?.playlistMusicas || []}
              onCheck={onCheck}
            />
          </div>
        </div>
      </div>
    </>
  );
}

export default App;
