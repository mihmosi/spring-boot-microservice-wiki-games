import React, { useEffect } from "react";
import Context from "./context";
import GIGList from "./components/GeneralItemGame/GIGList";
import AddItem from "./components/GeneralItemGame/AddItem";

function App() {
  let [items, setItems] = React.useState([]);

  let status = function (response) {
    if (response.status !== 200) {
      return Promise.reject(new Error(response.statusText));
    }
    return Promise.resolve(response);
  };
  let json = function (response) {
    return response.json();
  };

  useEffect(() => {
    fetch("http://localhost:8080/api/items", {
      method: "get",
    })
      .then(status)
      .then(json)
      .then(function (data) {
        console.log("data", data);
        setItems(data);
      })
      .catch(function (error) {
        console.log("error", error);
      });
  }, []);

  const listItems = () => {
    if (items.length) {
      return <GIGList items={items} />;
    } else {
      return <p>No items</p>;
    }
  };

  function addItem(name) {
    //fetch addItem
    fetch("http://localhost:8080/api/items", {
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      method: "post",
      body: JSON.stringify({ name: name }),
    })
      .then(status)
      .then(json)
      .then(function (data) {
        console.log("data", data);
        setItems(items.concat(data));
      })
      .catch(function (error) {
        console.log("error", error);
      });
  }

  function rmItem(id) {
    //fetch delItem
    fetch("http://localhost:8080/api/items/" + id, {
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      method: "delete",
    })
      .then(status)
      .then(function () {
        console.log("delete ok");
        setItems(items.filter((item) => item.id !== id));
      })
      .catch(function (error) {
        console.log("error", error);
      });
    // setItems(items.filter((item) => item.id !== id));
  }

  return (
    <Context.Provider value={{ rmItem: rmItem }}>
      <div className="baseWrapper">
        <h1>General Item Games</h1>
        {listItems()}
        <AddItem onCreate={addItem} />
      </div>
    </Context.Provider>
  );
}

export default App;
