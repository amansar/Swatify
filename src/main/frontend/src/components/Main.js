import React, { Component } from 'react';
import { Switch, Route } from 'react-router-dom';
import Feed from './Feed';
import Discover from './Discover';
import Discuss from './Discuss';
import Connect from './Connect';
import Users from './Users';
import Artist from './Artist';

export default class Main extends Component {
  render() {
    return (
      <Switch>
        <Route exact from='/' to='/feed' />
        <Route path='/feed' component={Feed} />
        <Route path='/discover' component={Discover} />
        <Route path='/discuss' component={Discuss} />
        <Route path='/connect' component={Connect} />
        <Route path='/users' component={Users} />
        <Route path='/artist' component={Artist} />
      </Switch>
    );
  }
}