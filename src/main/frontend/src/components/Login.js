import React, { Component } from 'react';
import { Button } from 'react-bootstrap';
import { parse, stringify } from 'query-string';

export default class Login extends Component {
  state = {authorizeUrl: ''}

  componentDidMount() {
    fetch('/api/v1/spotify-auth/authorize-url')
      .then(response => response.json())
      .then(responseData => {
        let originalAuthorizeUrl = responseData.authorizeUrl;
        let queryParams = parse(originalAuthorizeUrl.split('?')[1]);
        queryParams.redirect_uri = window.location.origin + '/callback';
        let authorizeUrl = originalAuthorizeUrl.split('?')[0] + '?' + stringify(queryParams);
        this.setState({authorizeUrl: authorizeUrl});
      });
  }

  render() {
    return (
      <div>
        <h1>Log in to Swatify!</h1>
        <Button href={this.state.authorizeUrl}>Connect with Spotify</Button>
      </div>
    );
  }
}