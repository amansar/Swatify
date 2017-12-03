import React, { Component } from 'react';
import Loader from './Loader';
import {
  Button
} from 'react-bootstrap';

export default class AlbumArtist extends Component {

        state = {artistImage: null, loading: true}

        componentWillMount(){
            fetch('/api/v1/albums/artists/' + this.props.artistId)
                       .then(response => response.json())
                       .then(artist => this.setState({artistImage: artist.images[0].url,
                                                        loading: false} ));
        }



        render(){

                return(
                <div id="albumArtistInfo" className="albumArtistInfo">
                    <img src={this.state.artistImage} alt="" height="150" width="150"></img>
                </div>
                    );
            }


}