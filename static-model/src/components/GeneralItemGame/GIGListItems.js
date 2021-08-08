import React from "react";

export default class GIGListItems extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      items: [],
      newItemInput: "",
      newItemSubmit: "",
      modalOpen: false,
      modalTitle: "Adding New Item",
      editId: "",
      editName: "",
      editDateOfCreation: "",
      editGenre: "",
      editHeroes: "",
    };

    this.submitHandler = this.submitHandler.bind(this);
    this.editHandler = this.editHandler.bind(this);
    this.addHandler = this.addHandler.bind(this);
    this.delHandler = this.delHandler.bind(this);
    this.applyHandler = this.applyHandler.bind(this);
  }

  fetchStatus(response) {
    if (response.status !== 200) {
      return Promise.reject(new Error(response.statusText));
    }
    return Promise.resolve(response);
  }
  fetchJson(response) {
    return response.json();
  }

  componentDidMount() {
    this.getItems();
  }

  getItems() {
    fetch("http://localhost:8080/api/items", {
      method: "GET",
    })
      .then(this.fetchStatus)
      .then(this.fetchJson)
      .then((data) => {
        this.setState({
          items: data.map((item) => ({
            id: item.id,
            name: item.name,
            dateOfCreation: item.dateOfCreation,
            genre: item.genre,
            heroes: item.heroes,
          })),
        });
      })
      .catch(function (error) {
        console.log("error", error);
      });
  }

  addItemApply() {
    fetch("http://localhost:8080/api/items", {
      headers: {
        "Content-Type": "application/json",
      },
      method: "POST",
      body: JSON.stringify({
        name: this.state.editName,
        dateOfCreation: this.state.editDateOfCreation,
        genre: this.state.editGenre,
        heroes: this.state.editHeroes,
      }),
    })
      .then(this.fetchStatus)
      .then(this.fetchJson)
      .then((data) => {
        this.setState({
          items: this.state.items.concat({
            id: data.id,
            name: data.name,
            dateOfCreation: data.dateOfCreation,
            genre: data.genre,
            heroes: data.heroes,
          }),
        });
      })
      .catch(function (error) {
        console.log("error", error);
      });
  }

  editItemApply() {
    fetch("http://localhost:8080/api/items", {
      headers: {
        "Content-Type": "application/json",
      },
      method: "POST",
      body: JSON.stringify({
        id: this.state.editId,
        name: this.state.editName,
        dateOfCreation: this.state.editDateOfCreation,
        genre: this.state.editGenre,
        heroes: this.state.editHeroes,
      }),
    })
      .then(this.fetchStatus)
      .then(this.fetchJson)
      .then((data) => {
        this.setState({
          items: this.state.items.map((item) => {
            if (item.id === this.state.editId) {
              item.name = data.name;
              item.dateOfCreation = data.dateOfCreation;
              item.genre = data.genre;
              item.heroes = data.heroes;
            }
            return item;
          }),
        });
      })
      .catch(function (error) {
        console.log("error", error);
      });
  }

  editItem(id) {
    let item = this.state.items.find((item) => {
      return item.id === id;
    });
    this.setState({
      editId: item.id,
      editName: item.name,
      editDateOfCreation: item.dateOfCreation,
      editGenre: item.genre,
      editHeroes: item.heroes,
      modalTitle: "Edit GameItem",
    });

    this.setState({ modalOpen: true });
  }

  addItem() {
    this.setState({
      editId: 0,
      editName: "",
      editDateOfCreation: "",
      editGenre: "",
      editHeroes: "",
      modalTitle: "Add GameItem",
    });

    this.setState({ modalOpen: true });
  }

  delItem(id) {
    fetch("http://localhost:8080/api/items/" + id, {
      headers: {
        "Content-Type": "application/json",
      },
      method: "DELETE",
    })
      .then(this.fetchStatus)
      .then(() => {
        this.setState({
          items: this.state.items.filter((item) => item.id !== id),
        });
      })
      .catch(function (error) {
        console.log("error", error);
      });
  }

  submitHandler(event) {
    event.preventDefault();
    this.addItem(this.state.newItemInput);
    this.setState({
      newItemInput: this.state.newItemInput,
    });
  }

  editHandler(id) {
    this.editItem(id);
  }

  addHandler() {
    this.addItem();
  }

  delHandler(id) {
    this.delItem(id);
  }

  applyHandler(event) {
    event.preventDefault();
    this.setState({ modalOpen: false });
    if (this.state.editId !== 0) {
      this.editItemApply();
    } else {
      this.addItemApply();
    }
  }

  render() {
    return (
      <React.Fragment>
        <div>
          Items: {this.state.items.length}
          <table className="table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Редактирование</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {this.state.items.map((item, key) => (
                <tr key={key}>
                  <td>{item.id}</td>
                  <td>
                    {item.name}
                    <ul>
                      <li>Date of creation: {item.dateOfCreation}</li>
                      <li>Genre: {item.genre}</li>
                      <li>Heroes: {item.heroes}</li>
                    </ul>
                  </td>
                  <td>
                    <button onClick={() => this.editHandler(item.id)}>
                      Edit
                    </button>
                  </td>
                  <td>
                    <button onClick={() => this.delHandler(item.id)}>
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
          <button onClick={() => this.addHandler()}>Add new GameItem</button>
          {this.state.modalOpen && (
            <div className="modal">
              <div className="modal-body">
                <h1>{this.state.modalTitle}</h1>
                <form className="addItem_input" onSubmit={this.applyHandler}>
                  <input type="hidden" value={this.state.editId} />
                  <ul>
                    <li>
                      Name:
                      <input
                        value={this.state.editName}
                        type="text"
                        onChange={(event) =>
                          this.setState({ editName: event.target.value })
                        }
                      />
                    </li>
                    <li>
                      Date of Creation:
                      <input
                        value={this.state.editDateOfCreation}
                        type="text"
                        onChange={(event) =>
                          this.setState({
                            editDateOfCreation: event.target.value,
                          })
                        }
                      />
                    </li>
                    <li>
                      Genre:
                      <input
                        value={this.state.editGenre}
                        type="text"
                        onChange={(event) =>
                          this.setState({ editGenre: event.target.value })
                        }
                      />
                    </li>
                    <li>
                      Heroes:
                      <input
                        value={this.state.editHeroes}
                        type="text"
                        onChange={(event) =>
                          this.setState({ editHeroes: event.target.value })
                        }
                      />
                    </li>
                  </ul>
                  <span>
                    <button
                      onClick={() => this.setState({ modalOpen: false })}
                      type="reset">
                      Cancel
                    </button>
                    <button type="submit">Save</button>
                  </span>
                </form>
              </div>
            </div>
          )}
        </div>
      </React.Fragment>
    );
  }
}
