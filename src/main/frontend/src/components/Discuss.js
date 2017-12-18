import React, { Component } from "react";
import DiscussionModal from "./DiscussionModal";
import ReviewModal from "./ReviewModal";
import DiscussionTable from "./DiscussionTable";

export default class Discuss extends Component {
  render() {
    return (
      <div>
        <ReviewModal />
        <br />
        <DiscussionModal />
        <br />
        <DiscussionTable />
      </div>
    );
  }
}
