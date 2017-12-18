import React, { Component } from "react";
import { Modal, Button, Form, Glyphicon } from "react-bootstrap";
import swatifyFetch from "../swatifyFetch";

export default class DiscussionModal extends Component {
  constructor(props) {
    super(props);

    this.state = { showModal: false, title: "" };
    this.open = this.open.bind(this);
    this.close = this.close.bind(this);
  }

  handleChange(e) {
    this.setState({ title: e.target.value });
  }

  handleSubmit(e) {
    //TODO find user id
    swatifyFetch("/api/v1/discussions", {
      method: "post",
      headers: { "Content-Type": "Discussion" },
      body: JSON.stringify({
        userId: 7,
        title: this.state.title,
        userName: "tempUserName"
      })
    });
    this.close();
  }

  close() {
    this.setState({ showModal: false });
    this.setState({ title: "" });
  }

  open() {
    this.setState({ showModal: true });
  }

  render() {
    return (
      <div>
        <Button bsStyle="primary" bsSize="large" onClick={this.open}>
          <div>
            <Glyphicon className="pull-left" glyph="plus" />
            Add a Discussion
          </div>
        </Button>

        <Modal show={this.state.showModal} onHide={this.close}>
          <Form>
            <Modal.Header>
              <Modal.Title>Create New Discussion</Modal.Title>
            </Modal.Header>

            <Modal.Body>
              <input
                type="text"
                placeholder="Title"
                className="form-control"
                onChange={this.handleChange.bind(this)}
              />
            </Modal.Body>

            <Modal.Footer>
              <Button onClick={this.close}>Close</Button>
              <Button
                onClick={this.handleSubmit.bind(this)}
                bsStyle="primary"
                disabled={!this.state.title}
              >
                Save changes
              </Button>
            </Modal.Footer>
          </Form>
        </Modal>
      </div>
    );
  }
}
