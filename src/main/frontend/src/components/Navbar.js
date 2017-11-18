import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import {
  Navbar as BSNavbar,
  Nav as BSNav,
  NavItem as BSNavItem
} from 'react-bootstrap';
import './Navbar.css';

export default class Navbar extends Component {
  render() {
    return (
      <BSNavbar>
        <BSNavbar.Header>
          <BSNavbar.Brand>
            Swatify
          </BSNavbar.Brand>
        </BSNavbar.Header>
        <BSNavbar.Collapse>
          <BSNav>
            <BSNavItem><Link to='/feed' className='Navbar-link'>Feed</Link></BSNavItem>
            <BSNavItem><Link to='/discover' className='Navbar-link'>Discover</Link></BSNavItem>
            <BSNavItem><Link to='/discuss' className='Navbar-link'>Discuss</Link></BSNavItem>
            <BSNavItem><Link to='/connect' className='Navbar-link'>Connect</Link></BSNavItem>
          </BSNav>
        </BSNavbar.Collapse>
      </BSNavbar>
    );
  }
}
