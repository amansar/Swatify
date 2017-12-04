import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Table } from "react-bootstrap";
import { LinkContainer } from 'react-router-bootstrap';
import "./DiscussionTable.css"

export default class DiscussionTable extends Component {
    constructor(props) {
        super(props);


        fetch('/api/v1/albums/7gsWAHLeT0w7es6FofOXk1')
              .then(res => res.json())
              .then(album => this.setState({ album: album.name,
                                artist: album.artists[0].name,
                                image: album.images[0].url} ));
    }

    render() {
        return (
            <div>
                <Table striped={true} hover={true}>
                  <thead>
                    <tr>
                      <th>Discussion Title</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>Discussion 1</td>
                    </tr>
                    <tr>
                      <td>Discussion 2</td>
                    </tr>
                    <tr>
                      <td>Discussion 3</td>
                    </tr>
                  </tbody>
                </Table>
            </div>
        );
    }
}
