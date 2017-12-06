import React, { Component } from 'react';
import AlbumArtist from "./AlbumArtist";
import Loader from './Loader';
import { Table } from "react-bootstrap";
import Rating from "./Rating";
import "./Album.css";

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

    renderTracksList() {

                var tracks = this.state.tracks;
                return(
                   <tbody>
                       {tracks.map(function(track, index){
                       var numberToUse = (index + 1).toString();
                       var trackDuration = (track.duration/1000/60).toFixed(2);
                       var givenTrackId = track.id;
                       return <tr key={index}>
                                   <td class="col-md-1"> {numberToUse} </td>
                                   <td class="col-md-8"> {track.name} </td>
                                   <td class="col-md-1"> {trackDuration} </td>
                                   <td class="col-md-4"> <Rating trackId={givenTrackId} /> </td>
                              </tr>;
                                        })}

                    </tbody>
                        );

    }
    render() {

        if(this.state.loading == false){

        return (

        <div id="AlbumPage" className="Overlay">

            <div id="AlbumInfo" className="AlbumInfoAndLinkedAccounts" >
                <img src={this.state.image} alt="" height="200" width="200"></img>
                <h3> {this.state.albumName} </h3>
                //{this.renderAlbumArtist()}
                <AlbumArtist artistId={this.state.artistId} />
                <h5> {this.state.artistName} </h5>
                <div id="tracksList" className="TrackInfo">
                     <Table striped={true} hover={true}>
                          <h1>TRACKLIST</h1>
                          <thead> </thead>
                            {this.renderTracksList()}
                    </Table>
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