import React, { Component } from 'react';
import Loader from './Loader';

export default class Feed extends Component {
  state = {user: null}

  componentDidMount() {
    fetch('/api/v1/users/' + this.props.userId)
      .then(res => res.json())
      .then(user => this.setState({ user }));
  }

  render() {
    return (
      <Loader loading={!this.state.user} />
    );
  }
}