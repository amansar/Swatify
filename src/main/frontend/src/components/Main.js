import React, { Component } from 'react';
import { Switch, Route } from 'react-router-dom';
import Navbar from './Navbar';
import Login from './Login';
import Feed from './Feed';

export default class Main extends Component {
  render() {
    return (
      <div>
        <Navbar />
        <Switch>
          <Route path='/feed' component={Feed} />
          {/* <Route path='/discover' component={Discover} />
          <Route path='/discuss' component={Discuss} />
          <Route path='/connect' component={Connect} /> */}
        </Switch>
      </div>
    );
  }
}
