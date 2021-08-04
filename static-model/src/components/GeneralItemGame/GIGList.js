import React from "react";
import PropTypes from "prop-types";
import GIGItem from "./GIGItem";

function GIGList({ items }) {
  return (
    <ul className="items">
      {items.map((item, idx) => {
        return <GIGItem item={item} key={item.id} index={idx} />;
      })}
    </ul>
  );
}

GIGList.propTypes = {
    items: PropTypes.arrayOf(PropTypes.object).isRequired
}

export default GIGList