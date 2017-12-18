import React, { Component } from 'react';
//import { Link } from 'react-router-dom';
import {
  Modal,
  Button,
  Form,
  FormGroup,
  FormControl
} from 'react-bootstrap';
import StarHoverable from "./StarHoverable";
//import "./ReviewModal.css";
//TODO finding musicWorkId
export default class ReviewModal extends Component {
    constructor(props) {
        super(props);

        this.state =  { showModal: false, content: '', stars:5 };
        this.open = this.open.bind(this);
        this.close = this.close.bind(this);
        this.handleStarClick = this.handleStarClick.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(e) {
        this.setState({content: e.target.value});
    }

    handleSubmit(e) {
        //TODO find user id
        fetch('/api/v1/reviews', {
           method: 'post',
           headers: {'Content-Type':'Review'},
           body: {
            "content": e.target.value,
            "user_id": this.state.stars
           }
          });
          this.close();
    }

    close() {
      this.setState({ showModal: false });
      this.setState({ content: "" })
    }

    open() {
      this.setState({ showModal: true });
    }

    save() {

    }

    handleStarClick(newStars) {
      this.setState({ stars: newStars});
    }

    render() {
        return (
            <div>
                <Button bsStyle="primary" bsSize="large" onClick={this.open}>
                    Create Review
                </Button>

                 <Modal show={this.state.showModal} onHide={this.close}>
                     <Form>
                         <Modal.Header>
                           <Modal.Title>Create New Review</Modal.Title>
                         </Modal.Header>

                         <Modal.Body>
                           <FormGroup>
                             <StarHoverable onClickStars={this.handleStarClick}curr_stars={5}/>
                             <FormControl key="review" componentClass="textarea" rows={6} placeholder="Your review..." className="form-control" bsSize="large" onChange={this.handleChange.bind(this)}></FormControl>
                           </FormGroup>
                         </Modal.Body>

                         <Modal.Footer>
                           <Button onClick={this.close}>Close</Button>
                           <Button onClick={this.handleSubmit.bind(this)} bsStyle="primary" disabled={!this.state.content}>
                             Create
                           </Button>
                         </Modal.Footer>
                     </Form>
                 </Modal>
            </div>
        );
    }
}
