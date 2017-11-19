import React, { Component } from 'react';

class Artist extends Component {
    constructor (props) {
        super(props);
        this.state = {
            spotifyId: null,
        }
    }

    render() {
        return (<h1>This is an artist page</h1>);
    }
}

export default Artist;