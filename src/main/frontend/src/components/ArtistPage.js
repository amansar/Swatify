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

        fetch('/api/v1/artists/' + this.props.match.params.id + '/albums')
                .then(response => response.json())
                .then(albums => this.setState({albums: albums, loading: false}));

        fetch('/api/v1/artists/' + this.props.match.params.id + '/followers')
            .then(res => res.json())
            .then(followers => this.setState({followers: followers}))

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
             
                                <iframe title="widget" src={"https://embed.spotify.com/follow/1/?uri=spotify:artist:"+this.state.artist.id+"&size=basic&theme=light&show-count=0"} width="200" height="56" scrolling="no" style={{overflow:"hidden"}} frameborder="0" allowtransparency="true"></iframe>
                                <p><strong>Followers: </strong>{this.state.artist.followers.total}</p>
                                <p><strong>Popularity: </strong>{this.state.artist.popularity}</p>
                                <p className="Genre"><strong>Genre: </strong>{this.state.artist.genres[0]}</p>
                                <div className="SpotifyLink">
                                    <a href={this.state.artist.uri}>View this artist on Spotify</a>

                                </div>
                                <hr></hr>
                            </div>
                    </div>
                    <div className="ArtistContent">
                        <h1 id="artistName">{this.state.artist.name}</h1>
                        <h3>Albums</h3>
                        <hr></hr>
                        <ul>
                            {this.state.albums.map(function(album) {
                                console.log("album");
                                var albumLink = "/albums/" + album.id
                                return (<li>
                                            <div className="AlbumListing">
                                                <img alt="album" src={album.images[1].url} height={album.images[1].height*0.5}
                                                width={album.images[1].width*0.5}></img>
                                                <br></br>
                                                <a href={albumLink}>{album.name}</a>
                                            </div>
                                        </li>);
                                })
                            }
                        </ul>
                        <br></br>
                        <h3>Discussions</h3>
                        <hr></hr>
                    </div>
                </div>
            );
        } else {
            return <NotFound />;
        }
    }
}

export default ArtistPage;
