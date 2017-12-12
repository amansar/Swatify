import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';

class SpotifyCallback extends Component {
    componentDidMount() {
        var queryString = this.props.location.search;
        var url = '/api/v1/spotify-auth/callback' + queryString;
        return fetch(url);
    }

    render() {
        return <Redirect to='/feed'/>;
    }
}

export default SpotifyCallback;
