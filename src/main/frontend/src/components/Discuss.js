import React, { Component } from 'react';
import DiscussionModal from "./DiscussionModal";
import ReviewModal from "./ReviewModal";

export default class Discuss extends Component {
  render() {
    return (
      <div>
        <p>Test</p>
        <DiscussionModal />
        <br/>
        <ReviewModal />
      </div>
    );
  }
}