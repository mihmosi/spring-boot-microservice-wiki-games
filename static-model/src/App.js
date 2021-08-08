import React from "react";
import GIGListItems from "./components/GeneralItemGame/GIGListItems";

export default class Application extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      items: null,
    };
  }

  render() {
    return (
      <div className="baseWrapper">
        <h1>General Item Games</h1>
        <GIGListItems />
      </div>
    );
  }
}
