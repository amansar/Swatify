import React, { Component } from 'react';
import { Switch, Route } from 'react-router';
import { Redirect } from 'react-router-dom';
import { Grid } from 'react-bootstrap';
import Login from './Login'
import Main from './Main'
import Navbar from './Navbar'
import './App.css';

export default class App extends Component {
  state = {
    userId: 1
  }

  render() {
    return (
      <div className='App'>
        <Navbar />
        <Grid>
          <Switch>
            <Route exact path='/login' component={Login} />
            <Route path='/' render={() => (
              this.state.userId ? (
                <Main userId={this.state.userId} />
              ) : (
                <Redirect to='/login' />
              )
            )} />
          </Switch>
        </Grid>
      </div>
    );
  }
}