import React, { Component } from 'react';
import Loader from './Loader';
import NotFound from './NotFound';

class Artist extends Component {
    state = {loading: true, artist: null}

    componentDidMount() {
        fetch('/api/v1/artists/' + this.props.artistId)
            .then(res => res.json())
            .then(artist => this.setState({artist}));
    }

    render() {
        if(this.state.loading){
            return <Loader loading={this.state.loading} />;
        } else if(this.state.artist){
            return <h3>{this.state.artist.name}</h3>;
        } else {
            return <NotFound />;
        }
    }
}

export default Artist;