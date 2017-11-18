import React, { Component } from 'react';
import { Switch, Route } from 'react-router';
import Login from './Login'
import Main from './Main'
import './App.css';

class App extends Component {
  render() {
    return (
      <Switch>
        <Route exact path='/login' component={Login} />
        <Route path='/' component={Main} />
      </Switch>
    );
  }
}

export default App;
