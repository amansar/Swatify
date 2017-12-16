import React, {Component} from 'react';
import Loader from './Loader';
import NotFound from './NotFound';

export default class SearchPage extends Component {
    state = {loading: true, results: "No results"}

    componentDidMount() {
        fetch('/api/search/' + this.props.match.params.query)
            .then(res => res.json())
            .then(items => this.setState({results: items.items, loading: false}));
    }

    render() {
        if(this.state.loading){
            return <Loader loading={this.state.loading} />;
        } else if(this.state.results){
            return (
                <div>
                    <h1>Search</h1>
                    <hr/>
                    <p>{this.state.results[0].name}</p>
                </div>
            );
        } else {
            return (
                <NotFound />
            );
        }
    }

}