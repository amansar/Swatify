import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import {
  Navbar as BSNavbar,
  Nav as BSNav,
  NavItem as BSNavItem,
  Form,
  FormControl,
  FormGroup
} from 'react-bootstrap';
import ReactDOM from 'react-dom';
import { LinkContainer } from 'react-router-bootstrap';
import './Navbar.css';

export default class Navbar extends Component {
  state = {searchInput: "nothing"}


  search(e) {
    if(e != null)
        alert(e.target.value);
  }

  handleChange(e) {
      console.log(e.target.value);
      this.setState({searchInput: e.target.value});
  }

   handleSubmit(e) {
        e.preventDefault();
        e.stopPropagation();
        console.log('submit');
        alert(this.state.searchInput);
    }


  render() {
    return (
      <BSNavbar inverse>
        <BSNavbar.Header>
          <BSNavbar.Brand>
            <Link to='/feed' className='Navbar-link'>Swatify</Link>
          </BSNavbar.Brand>
          <BSNavbar.Toggle />
        </BSNavbar.Header>
        <BSNavbar.Collapse>
          <BSNav>
            <LinkContainer to='/feed'>
              <BSNavItem className='Navbar-link'>Feed</BSNavItem>
            </LinkContainer>
            <LinkContainer to='/discover'>
              <BSNavItem className='Navbar-link'>Discover</BSNavItem>
            </LinkContainer>
            <LinkContainer to='/discuss'>
              <BSNavItem className='Navbar-link'>Discuss</BSNavItem>
            </LinkContainer>
            <LinkContainer to='/connect'>
              <BSNavItem className='Navbar-link'>Connect</BSNavItem>
            </LinkContainer>
          </BSNav>
          <BSNav pullRight>
            <BSNavItem id="search">
                <Form onSubmit={this.handleSubmit.bind(this)} >
                    <FormGroup >
                        <FormControl
                            type="text"
                            id="searchButton"
                            ref="input"
                            className="searchButton"
                            placeholder="Search"
                            onChange={this.handleChange.bind(this)}
                             />
                    </FormGroup >
                </Form>
            </BSNavItem>

            <LinkContainer to='/users/1'>
              <BSNavItem className='Navbar-link'>Me</BSNavItem>
            </LinkContainer>
          </BSNav>
        </BSNavbar.Collapse>
      </BSNavbar>
    );
  }
}
