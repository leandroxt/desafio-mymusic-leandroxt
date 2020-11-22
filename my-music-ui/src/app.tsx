import React, { ChangeEvent, ReactElement, useState } from 'react';
import Header from './components/header';
import SearchField from './components/search-field';
import Table, { Music } from './components/table';

import service from './service';

function App(): ReactElement {
  const [foundMusics, setFoundMusics] = useState<Music[]>([]);
  async function onSearchMusic({ currentTarget }: ChangeEvent<HTMLInputElement>): Promise<void> {
    const results = await service.searchMusic(currentTarget.value);

    setFoundMusics(() => results);
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
              title="User"
              onChange={onSearchMusic}
            />
          </div>
        </div>

        <div className="row mt-5">
          <div className="col">
            <Table musics={foundMusics} />
          </div>
          <div className="col">
            <Table musics={foundMusics} />
          </div>
        </div>
      </div>
    </>
  );
}

export default App;
