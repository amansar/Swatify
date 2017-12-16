import React, { Component } from 'react';
import Loader from './Loader';
import NotFound from './NotFound';
import './ArtistPage.css';

class ArtistPage extends Component {
    state = {loading: true, artist: null, albums: [], results: null}

    componentDidMount() {
        fetch('/api/v1/artists/' + this.props.match.params.id)
            .then(res => res.json())
            .then(artist => this.setState({artist: artist, loading: false}));


        fetch('/api/v1/artists/' + this.props.match.params.id + '/albums')
                .then(response => response.json())
                .then(albums => this.setState({albums: albums, loading: false}));

        fetch('api/v1/artists/' + this.props.match.params.id + 'followers')
            .then(res => res.json())
            .then(followers => this.setState({followers: followers}))

        console.log("Here");

    }

    render() {
        if(this.state.loading){
            return <Loader loading={this.state.loading} />;
        } else if(this.state.artist){
            return (
                <div className="ArtistPage">
                    <div className="Sidebar">
                        <img src={this.state.artist.images[1].url} height={this.state.artist.images[1].height}
                            width={this.state.artist.images[1].width} alt={this.state.artist.name}></img>
                        <div className="Related">
                            <hr></hr>
                            <p><strong>Followers: </strong>{this.state.followers}</p>
                            <p><strong>Popularity: </strong>{this.state.artist.popularity}</p>
                            <p className="Genre"><strong>Genre: </strong>{this.state.artist.genres[0]}</p>
                            <div className="SpotifyLink">
                                <a href={this.state.artist.uri}>View this artist on Spotify</a>
                            </div>
                            <hr></hr>
                        </div>
                    </div>
                    <h1 id="artistName">{this.state.artist.name}</h1>
                    <div className="ArtistContent">
                        <div className="ArtistBio">
                            <h3>Bio</h3>
                            <hr></hr>
                            <p>This is the artist bio</p>
                        </div>
                        <h3>Albums</h3>
                        <hr></hr>
                        <ul>
                            {this.state.albums.map(function(album) {
                                return (<li>
                                            <div className="AlbumListing">
                                                <p>{this.state.results}</p>
                                            </div>
                                        </li>);
                                })
                            }
                        </ul>
                    </div>
                </div>
            );
        } else {
            return <NotFound />;
        }
    }
}

export default ArtistPage;
