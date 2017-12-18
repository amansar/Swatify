import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';
import swatifyFetch from '../swatifyFetch';

class SpotifyCallback extends Component {
    componentDidMount() {
        var queryString = this.props.location.search;
        var url = '/api/v1/spotify-auth/callback' + queryString;
        return swatifyFetch(url);
    }

    render() {
        return <Redirect to='/feed'/>;
    }
}

export default SpotifyCallback;
