import React, { useContext } from "react";
import PropTypes from "prop-types";
import Context from "../../context";

function GIGItem({ item, index }) {
  const { rmItem } = useContext(Context);
  return (
    <li className="items">
      <span>
        <input type="checkbox" className="items" />
        <strong>{item.id}</strong>&nbsp;{item.name}
      </span>
      <button className="rm_button" onClick={rmItem.bind(null, item.id)}>
        &times;
      </button>
    </li>
  );
}

GIGItem.propTypes = {
  item: PropTypes.object.isRequired,
  index: PropTypes.number,
};

export default GIGItem;
