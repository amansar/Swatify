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
        </BSNavbar.Collapse>
      </BSNavbar>
    );
  }
}
