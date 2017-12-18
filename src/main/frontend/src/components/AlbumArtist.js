import React, { Component } from "react";
import Loader from "./Loader";
import swatifyFetch from "../swatifyFetch";

export default class AlbumArtist extends Component {
  state = { loading: true };

  componentDidMount() {
    swatifyFetch("/api/v1/artists/" + this.props.artistId)
      .then(response => response.json())
      .then(artist =>
        this.setState({
          artistImage: artist.images[0].url,
          loading: false
        })
      );
  }

  render() {
    if (this.state.loading) {
      return <Loader loading={this.state.loading} />;
    } else {
      return (
        <div id="albumArtistInfo" className="albumArtistInfo">
          <img src={this.state.artistImage} alt="" height="100" width="100" />
        </div>
      );
    }
  }
}
