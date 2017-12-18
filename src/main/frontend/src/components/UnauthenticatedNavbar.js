import React, { Component } from "react";
import { Link } from "react-router-dom";
import {
  Navbar as BSNavbar,
  Nav as BSNav,
  NavItem as BSNavItem
} from "react-bootstrap";
import { LinkContainer } from "react-router-bootstrap";
import "./Navbar.css";

export default class UnauthenticatedNavbar extends Component {
  render() {
    return (
      <BSNavbar inverse>
        <BSNavbar.Header>
          <BSNavbar.Brand>
            <Link to="/" className="Navbar-link">
              Swatify
            </Link>
          </BSNavbar.Brand>
          <BSNavbar.Toggle />
        </BSNavbar.Header>
        <BSNavbar.Collapse>
          {/* <BSNav>
            <LinkContainer to='/discover'>
              <BSNavItem className='Navbar-link'>Discover</BSNavItem>
            </LinkContainer>
          </BSNav> */}
          <BSNav pullRight>
            <LinkContainer to="/login">
              <BSNavItem className="Navbar-link">Log in</BSNavItem>
            </LinkContainer>
          </BSNav>
        </BSNavbar.Collapse>
      </BSNavbar>
    );
  }
}
