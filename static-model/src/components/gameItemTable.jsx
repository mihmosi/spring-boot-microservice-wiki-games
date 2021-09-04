import React from "react";
import Table from 'react-bootstrap/Table'
import ReactDOM from 'react-dom';
import './gameConsoleView.css'


let selectedRow;

export default function gameItemTable() {
    fetch('http://localhost:8080/api/items')
        .then(response => { return response.json() })
        .then(data => {
            let gameItems = Array.from(data);
            let gameItemRows = gameItems.map((game) => {
                return (
                    <tr className='gameItemRow' id={`gameItem-${game.id}`} onClick={setFocus}>
                        <td>{game.id}</td>
                        <td>{game.name}</td>
                        <td>{game.dateOfCreation}</td>
                        <td>{game.genre}</td>
                        <td>{game.heroes}</td>
                        <td>{game.villains}</td>
                        <td>{game.status}</td>
                    </tr>)
            })
            let table = <Table bordered hover variant="dark">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Game</th>
                            <th>Creation date</th>
                            <th>Genre</th>
                            <th>Heroes</th>
                            <th>Villains</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        {gameItemRows}
                    </tbody>
                </Table>
            ReactDOM.render(table, document.getElementById('display'))
            selectedRow = 0;
        })
}

function setFocus (event) {
    if (selectedRow) {
        document.getElementById(selectedRow).classList.toggle('selected')
    } else {document.addEventListener('keydown', keydownListener)}
    event.target.parentNode.classList.toggle('selected')
    selectedRow = event.target.parentNode.id;
}

export function clickNavigationButton (direction) {
    let table = document.querySelector('#display table')
    let rows = Array.from(table.rows)
    if (!selectedRow && rows.length > 1) {
        rows[1].classList.toggle('selected')
        selectedRow = rows[1].id
        document.addEventListener('keydown', keydownListener)
        return
    }
    let currentSelectedRow = document.getElementById(selectedRow)
    currentSelectedRow.classList.toggle('selected')
    let index = currentSelectedRow.rowIndex
    let newIndex;
    if (direction === 'ArrowUp' || direction === 'ArrowLeft') {
        newIndex = index === 1 ? rows.length - 1 : index - 1;
    } else {
        newIndex = index === rows.length - 1 ? 1 : index +1;
    }
    rows[newIndex].classList.toggle('selected')
    selectedRow = rows[newIndex].id;
}

function keydownListener (event) {
    if (!document.querySelector('#display table')) {
        document.removeEventListener('keydown', keydownListener)
        return
    }
    clickNavigationButton(event.key)
}

export function removeGameItem () {
    if (!selectedRow) return;

}