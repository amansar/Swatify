import React, { Component } from 'react';


class Album extends Component {
    state = {loading: true, album: null}

    componentDidMount(){
        fetch('/api/v1/albums' + this.props.albumId)
              .then(res => res.join())
              //.then(album => this.setState({ album: album, loading: false }));
              .then(user => this.setState({user}));
    }

    render() {
        return (
        <h1>This is an album page</h1>
        // <h1>this.state.album.getName</h1>
        );
    }
}

export default Album;