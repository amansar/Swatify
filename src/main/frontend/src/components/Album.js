import React, { Component } from 'react';


class Album extends Component {
    state = {loading: true}

    componentDidMount(){
        fetch('/api/v1/albums/7gsWAHLeT0w7es6FofOXk1')
              .then(res => res.json())
              .then(album => this.setState({ album: album.name,
                                artist: album.artists[0].name,
                                image: album.images[0].url} ));
    }

    render() {
        return (
            <div>
                <h1>{this.state.album}</h1>
                <h2>{this.state.artist}</h2>
                <img src={this.state.image} alt="" height="200" width="200"></img>
            </div>);
       // <h1>this.state.album.getName</h1>
    }
}

export default Album;