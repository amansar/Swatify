import React, { Component } from 'react';


class Artist extends Component {
    state = {loading: true, artist: null}

    componentDidMount() {
        fetch('/api/v1/artists' + this.props.artistId)
            .then(res => res.join())
            .then(user => this.setState({user}));
    }

    render() {
        if()
        return (<h1>This is an artist page</h1>);
    }
}

export default Artist;