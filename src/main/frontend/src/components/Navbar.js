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
import { LinkContainer } from 'react-router-bootstrap';
import './Navbar.css';

export default class Navbar extends Component {



  search(query) {
    alert(query);
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
                <Form inline>
                    <FormGroup >
                        <FormControl
                            type="text"
                            id="searchButton"
                            ref="input"
                            className="searchButton"
                            placeholder="Search"
                            inputref={(input) => {this.setState({state: input})}}
                            keypress={this.search(this.state)} />
                    </FormGroup>
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
