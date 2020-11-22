import React, { ChangeEvent, ReactElement } from 'react';

interface Props {
  title: string;
  onChange: (e: ChangeEvent<HTMLInputElement>) => void;
}

export default function SearchField({ title, onChange }: Props): ReactElement<Props> {
  return (
    <form className="form-inline">
      <div className="form-group">
        <label>{title}</label>
        <input type="text" className="form-control mx-sm-3" onChange={onChange} />
      </div>
    </form>
  );
}