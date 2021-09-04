import React from 'react';
import Navbar from 'react-bootstrap/Navbar'
import logo from '../image/wikiGameLogo.jpg'
import cat from '../image/cat.jpg'
import nature from '../image/nature.jpg'
import island from '../image/island.jpg'
import './Components.css';
import Button from 'react-bootstrap/Button'
import { NavLink } from 'react-router-dom';

export default function Header() {
    return (
        <Navbar bg="dark" variant="dark">
            <Navbar.Brand>
                <img
                    alt=""
                    src={logo}
                    width="230"
                    height="130"
                    className="d-inline-block align-top"
                />{' '}
                <span>Wiki Game world</span>
                <img
                    alt=""
                    src={cat}
                    width="230"
                    height="130"
                    className="d-inline-block align-top"
                />{' '}
                <img
                    alt=""
                    src={nature}
                    width="230"
                    height="130"
                    className="d-inline-block align-top"
                />{' '}
                <img id="lastImage"
                    alt=""
                    src={island}
                    width="230"
                    height="130"
                    className="d-inline-block align-top"
                />{' '}

                <Button variant="primary" href="#">Войти</Button>{' '}
                <Button variant="primary" href="#">Зарегистрироваться</Button><br></br>
            </Navbar.Brand>
        </Navbar>
    )
}