import React, { Component } from 'react';
import AlbumArtist from "./AlbumArtist";

class Album extends Component {
    state = {loading: true}
    componentDidMount(){
        fetch('/api/v1/albums/7gsWAHLeT0w7es6FofOXk1')
              .then(res => res.json())
              .then(album => this.setState({ albumName: album.name,
                                artistName: album.artists[0].name,
                                image: album.images[0].url,
                                artistId: album.artists[0].id,
                                tracks: album.tracks.items} ));
        /*
        fetch('/api/v1/albums/artists/5K4W6rqBFWDnAN6FQUkS6x')
              .then(res => res.json())
              .then(artist => this.setState({artistImage: artist.images[0].url} ));
        */
    }

    renderAlbumArtist(){
        return <AlbumArtist artistId={this.state.artistId} />;
    }
    /*
    convTracksToString() {
        const tracksToChange = this.state.tracks.slice();
        var listOfTrackNames = [];
        var i;
        for (i = 0; i < tracksToChange.length; i++) {
            listOfTrackNames.push(tracksToChange[i].name)
        }
        this.setState({trackNames: listOfTrackNames});
    }
*/
    render() {
        //this.convTracksToString();

        return (

        <div id="AlbumPage" className="Overlay">

            <div id="AlbumInfo" className="AlbumInfoAndLinkedAccounts" >
                <img src={this.state.image} alt="" height="200" width="200"></img>
                <h2> {this.state.albumName} </h2>
                {this.renderAlbumArtist()}
                <h1> {this.state.artistName} </h1>
            </div>



        </div>

        );
    }
}

export default Album;