import React, { Component } from 'react';
import AuthenticatedNavbar from './AuthenticatedNavbar';
import UnauthenticatedNavbar from './UnauthenticatedNavbar';
import swatifyFetch from '../swatifyFetch';
import './Navbar.css';

export default class Navbar extends Component {
  state = {me: null}

  componentDidMount() {
    swatifyFetch('/api/v1/users/me')
      .then(response => response.json())
      .then(user => {
        if (user) {
          this.setState({me: user});
        }
      });
  }

  render() {
    if (this.state.me) {
      return <AuthenticatedNavbar me={this.state.me} />;
    }
    else {
      return <UnauthenticatedNavbar />;
    }
  }
}
