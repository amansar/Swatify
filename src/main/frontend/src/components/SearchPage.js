import React, {Component} from 'react';
import Loader from './Loader';
import NotFound from './NotFound';

export default class SearchPage extends Component {
    state = {loading: true, results:[], tracks: [], intTest: null}

    componentDidMount() {

        fetch('/api/v1/search/' + this.props.match.params.id)
            .then(res => res.json())
            .then(results => this.setState({intTest: results, loading: false}));

//        fetch('/api/v1/search/' + this.props.match.params.id + '/tracks')
//            .then(response => response.json())
//            .then(tracks => this.setState({tracks: tracks, loading: false}));

        console.log("here");

    }

    render() {
        if(this.state.loading){
            return <Loader loading={this.state.loading} />;
        } else if(this.state.results){
            return (
                <div>
                    <h1>Search</h1>
                    <hr></hr>
                    <p>Got {this.state.results.length} results</p>
                    <h2>Artists</h2>
                    <p>Got {this.state.intTest} results</p>
                </div>
            );
        } else {
            return (
                <NotFound />
            );
        }
    }

}