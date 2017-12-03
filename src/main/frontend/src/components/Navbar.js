import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import {
  Navbar as BSNavbar,
  Nav as BSNav,
  NavItem as BSNavItem
} from 'react-bootstrap';
import { LinkContainer } from 'react-router-bootstrap';
import './Navbar.css';

export default class Navbar extends Component {
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
                <form id="newSearch" method="get">
                    <input type="text" id="textInput" style={{color: 'black'}}></input>
                    <button style={{background: 'black'}}>Search</button>
                </form>
            </BSNavItem>
            <script>

            </script>
            <LinkContainer to='/users/1'>
              <BSNavItem className='Navbar-link'>Me</BSNavItem>
            </LinkContainer>
          </BSNav>
        </BSNavbar.Collapse>
      </BSNavbar>
    );
  }
}
