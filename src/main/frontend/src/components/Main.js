import React, { Component } from 'react';
import { Route, HashRouter } from 'react-router-dom';

import Home from './Home';
import Feed from './Feed';

class Main extends Component {
  render() {
    return (
        <HashRouter>
            <div class="content">
                <Route exact path = "/" component = {Home}/>
                <Route exact path = "/feed" component = {Feed}/>
                <p>Welcome to Swatify</p>
            </div>
        </HashRouter>
    );
  }
}

export default Main;
