

const Dropdown = ({title,options,changeElement}) => {
  return (
    <div className="select">
      <select
        defaultValue="0"
        name="format"
        id="format"
        onChange={changeElement}
      >
        <option value="0" disabled>
          {title}
        </option>
        {options.map((o, i) => (
          <option value={o} key={i}>
            {o.toUpperCase()}
          </option>
        ))}
      </select>
    </div>
  );
}

export default Dropdown
