import React, { Component } from 'react';
import { BounceLoader } from 'react-spinners';
import Center from 'react-center';

export default class Loader extends Component {
  render() {
    return (
      <Center>
        <BounceLoader className='Loader' color={'#B31E3B'} size={100} loading={this.props.loading} />
      </Center>
    );
  }
}