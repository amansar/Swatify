import React, { Component } from 'react';
import AlbumArtist from "./AlbumArtist";
import Loader from './Loader';
import ReactDOM from 'react-dom';

class Album extends Component {
    state = {loading: true}
    componentWillMount(){
        fetch('/api/v1/albums/7gsWAHLeT0w7es6FofOXk1')
              .then(res => res.json())
              .then(album => this.setState({ albumName: album.name,
                                artistName: album.artists[0].name,
                                image: album.images[0].url,
                                artistId: album.artists[0].id,
                                tracks: album.tracks.items,
                                loading: false} ));
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

    renderTracksList() {

                var tracks = this.state.tracks;
                return(
                   <u1>
                     {tracks.map(function(track, index){
                     return <li key={index}>{track.name}</li>;
                                    })}
                            </u1>
                        );

    }
    render() {
        //this.convTracksToString();

        if(this.state.loading == false){

        return (

        <div id="AlbumPage" className="Overlay">

            <div id="AlbumInfo" className="AlbumInfoAndLinkedAccounts" >
                <img src={this.state.image} alt="" height="200" width="200"></img>
                <h2> {this.state.albumName} </h2>
                {this.renderAlbumArtist()}
                <h1> {this.state.artistName} </h1>
                <div id="tracksList" className="TrackInfo">
                    {this.renderTracksList()}
                </div>
            </div>
        </div>

            );

            }


            else{
                return (<Loader loading={this.state.loading} />);
            }

    }
}

export default Album;