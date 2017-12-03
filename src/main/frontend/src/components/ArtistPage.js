import React, { Component } from 'react';
import Loader from './Loader';
import NotFound from './NotFound';
import './ArtistPage.css';

class ArtistPage extends Component {
    state = {loading: true, artist: null, albums: []}

    componentDidMount() {
        fetch('/api/v1/artists/' + this.props.match.params.id)
            .then(res => res.json())
            .then(artist => this.setState({artist: artist, loading: false}));

//        fetch('/api/v1/artists/' + this.props.match.params.id + '/albums')
//                .then(response => response.json())
//                .then(albums => this.setState({albums: albums, loading: false}));
    }

    render() {
        if(this.state.loading){
            return <Loader loading={this.state.loading} />;
        } else if(this.state.artist){
            return (
                <div >
                    <div className="Title">
                        <img src={this.state.artist.images[1].url} height={this.state.artist.images[1].height}
                            width={this.state.artist.images[1].width} alt={this.state.artist.name}></img>
                        <h1>{this.state.artist.name}</h1>
                    </div>
                    <ul>
                        {this.state.albums.map(function(album) {
                            return <li>
                                        <div className="AlbumListing">
                                            <h3>I am an album!</h3>
                                            <img src={album.images[0].url} height={album.images[0].height}
                                                width={album.images[0].width} alt={album.name} cover></img>
                                            <h3>{album.name}</h3>
                                        </div>
                                    </li>

                            })
                        }
                    </ul>
                </div>
            );
        } else {
            return <NotFound />;
        }
    }
}

export default ArtistPage;
