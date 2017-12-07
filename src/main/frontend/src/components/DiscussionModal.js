import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import {
  Modal,
  Button,
  Form,
  FormGroup,
  FormControl,
  Glyphicon
} from 'react-bootstrap';
import { LinkContainer } from 'react-router-bootstrap';

export default class DiscussionModal extends Component {
    constructor(props) {
        super(props);

        this.state =  { showModal: false, title: '' };
        this.open = this.open.bind(this);
        this.close = this.close.bind(this);
    }

//    getFormInitialState() {
//        return {title: ''};
//    }

    handleChange(e) {
        this.setState({title: e.target.value});
    }

    handleSubmit(e) {
        //TODO find user id
        fetch('/api/v1/discussions', {
           method: 'post',
           headers: {'Content-Type':'Discussion'},
           body: {
            "title": e.target.value,
            "user_id": 7
           }
          });
          this.close();
    }

    close() {
      this.setState({ showModal: false });
      this.setState({ title: '' });
    }

    open() {
      this.setState({ showModal: true });
    }

    save() {

    }

    render() {
        return (
            <div>
                <Button bsStyle="primary" bsSize="large" onClick={this.open}>
                    <div>
                        <Glyphicon class="pull-left" glyph="plus"></Glyphicon>
                        Add a Discussion
                    </div>
                </Button>

                 <Modal show={this.state.showModal} onHide={this.close}>
                     <Form>
                         <Modal.Header>
                           <Modal.Title>Create New Discussion</Modal.Title>
                         </Modal.Header>

                         <Modal.Body>
                           <input type="text" placeholder="Title" className="form-control" onChange={this.handleChange.bind(this)}></input>
                         </Modal.Body>

                         <Modal.Footer>
                           <Button onClick={this.close}>Close</Button>
                           <Button onClick={this.handleSubmit.bind(this)} bsStyle="primary" disabled={!this.state.title}>
                           Save changes
                           </Button>
                         </Modal.Footer>
                     </Form>
                 </Modal>
            </div>
        );
    }
}
