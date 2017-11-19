import React, { Component } from 'react';
import { NavLink, HashRouter } from "react-router-dom";

class Header extends Component {
  render() {
    return (
        <div>
            <h1>Swatify</h1>
            <HashRouter>
                <ul>
                    <li><NavLink to="/feed">Feed</NavLink></li>
                    <li><NavLink to="/">Discover</NavLink></li>
                    <li><NavLink to="/">Discuss</NavLink></li>
                    <li><NavLink to="/">Connect</NavLink></li>
                </ul>
            </HashRouter>
        </div>
    );
  }
}

export default Header;
