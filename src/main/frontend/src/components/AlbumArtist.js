import React, { Component } from 'react';
import Loader from './Loader';
import {
  Button
} from 'react-bootstrap';

export default class AlbumArtist extends Component {

    state = {artistImage: null}
        componentWillMount(){

            fetch('/api/v1/albums/artists/' + this.props.artistId)
                          .then(res => res.json())
                          .then(artist => this.setState({artistImage: artist.images[0].url} ));
        }


        render(){
            return(
            <div id="albumArtistInfo" className="albumArtistInfo">
                <img src={this.state.artistImage} alt="" height="150" width="150"></img>
                <h1> {this.props.artistId} </h1>
                <h1> {this.state.artistImage} </h1>
            </div>
                );
            }


}