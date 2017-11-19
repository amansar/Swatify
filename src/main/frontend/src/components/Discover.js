import React, { Component } from 'react';
import { Link, Route } from 'react-router-dom'

import Artist from './Artist'

export default class Discover extends Component {
  render() {
    return (
      <div>
        <h1>Discover</h1>
        <Link to='/artist'>Check out this artist</Link>
      </div>

    );
  }
}