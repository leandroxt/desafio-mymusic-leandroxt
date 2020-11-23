import React, { ChangeEvent, KeyboardEvent, ReactElement } from 'react';

interface Props {
  title: string;
  onChange: (value: string) => void;
  dispatchOnEnter?: boolean;
}

export default function SearchField({ title, onChange, dispatchOnEnter = false }: Props): ReactElement<Props> {
  function _onChange({ currentTarget }: ChangeEvent<HTMLInputElement>): void {
    if (!dispatchOnEnter) {
      onChange(currentTarget.value);
    }
  }

  function onKeyPress({ key, currentTarget }: KeyboardEvent<HTMLInputElement>): void {
    if (dispatchOnEnter && key === 'Enter') {
      onChange(currentTarget.value);
    }
  }

  return (
    <div className="form-group">
      <label>{title}</label>
      <input type="text" className="form-control mx-sm-3" onChange={_onChange} onKeyPress={onKeyPress} />
    </div>
  );
}