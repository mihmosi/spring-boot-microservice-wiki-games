import React from 'react';
import { Route } from 'react-router';
import './gameConsoleView.css'
import './leftGameConsoleView.css'
import './rightGameConsoleView.css'
import GameItemTable from './gameItemTable';
import {clickNavigationButton} from './gameItemTable'
import {removeGameItem} from './gameItemTable'
import { NavLink } from 'react-router-dom';
import ReactDOM from 'react-dom';

let displayGameItems = false;

export default function GameConsoleView() {
    return (
        <div id="gameConsoleViewMode">
            <div id="leftGameConsole">

                <NavLink to='/wiki-game/game-items'>
                    <button id="circle" onClick={() => {
                        if (!displayGameItems) {
                            GameItemTable();
                            displayGameItems = true;
                        } else {
                            ReactDOM.render(<></>, document.getElementById('display'))
                            displayGameItems = false;
                            // selectedRow = 0;
                        }
                    }}>
                    </button>
                </NavLink>

                <button id="up" className="navButtons" onClick={() => {
                    if (displayGameItems) clickNavigationButton('ArrowUp')
                    }}></button>
                <button id="down" className="navButtons" onClick={() => {
                    if (displayGameItems) clickNavigationButton('ArrowDown')
                    }}></button>
                <button id="left" className="navButtons" onClick={() => {
                    if (displayGameItems) clickNavigationButton('ArrowLeft')
                    }}></button>
                <button id="right" className="navButtons" onClick={() => {
                    if (displayGameItems) clickNavigationButton('ArrowRight')
                    }}></button>
            </div>

            <div id="centralGameConsole">
                <div id="display"></div>
            </div>

            <div id="rightGameConsole">
                <button id="toPlay"></button>
                <button id="x" className="navButtons" onClick={() => {
                    if (displayGameItems) removeGameItem()
                }}>X</button>
                <button id="b" className="navButtons">B</button>
                <button id="y" className="navButtons">Y</button>
                <button id="a" className="navButtons">A</button>
                <button id="homeButton" className="navButtons">L</button>
            </div>
        </div>
    )
}