import React, { Component } from 'react';
import Loader from './Loader';

export default class UserProfile extends Component {
  state = {loading: true, users: null}

  componentDidMount() {
    fetch('/api/v1/users')
      .then(res => res.json())
      .then(users => this.setState({ users: users, loading: false }));
  }

  render() {
    if (this.state.loading) {
      return <Loader loading={this.state.loading} />;
    } else {
      return (
        <div>
          {this.state.users.map((user, index) => (
            <Link to={'/users/' + user.id} key={index}>
              {user.username}
            </Link>
          ))}
        </div>
      )
    }
  }
}