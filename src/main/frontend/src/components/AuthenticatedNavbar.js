import React, { Component } from "react";
import { Link } from "react-router-dom";
import {
  Navbar as BSNavbar,
  Nav as BSNav,
  NavItem as BSNavItem,
  Form,
  FormControl,
  FormGroup
} from "react-bootstrap";
import { LinkContainer } from "react-router-bootstrap";
import "./Navbar.css";
import swatifyFetch from "../swatifyFetch";

export default class AuthenticatedNavbar extends Component {
  state = {
    searchInput: ""
  };

  handleChange(e) {
    this.setState({ searchInput: e.target.value });
  }

  handleSubmit(e) {
    e.preventDefault();
    e.stopPropagation();
    console.log("submit");
    window.location = "/search/" + this.state.searchInput;
  }

  render() {
    return (
      <BSNavbar inverse>
        <BSNavbar.Header>
          <BSNavbar.Brand>
            <Link to="/feed" className="Navbar-link">
              <img alt="Swatify" src="/logo.png" width="70"/>
            </Link>
          </BSNavbar.Brand>
          <BSNavbar.Toggle />
        </BSNavbar.Header>
        <BSNavbar.Collapse>
          <BSNav>
            <LinkContainer to="/feed">
              <BSNavItem className="Navbar-link">Feed</BSNavItem>
            </LinkContainer>
            <LinkContainer to="/discover">
              <BSNavItem className="Navbar-link">Discover</BSNavItem>
            </LinkContainer>
            <LinkContainer to="/discuss">
              <BSNavItem className="Navbar-link">Discuss</BSNavItem>
            </LinkContainer>
            <LinkContainer to="/connect">
              <BSNavItem className="Navbar-link">Connect</BSNavItem>
            </LinkContainer>
          </BSNav>
          <BSNav pullRight>
            <div id="search">
              <Form onSubmit={this.handleSubmit.bind(this)}>
                <FormGroup>
                  <FormControl
                    type="text"
                    placeholder="Search"
                    onChange={this.handleChange.bind(this)}
                  />
                </FormGroup>
              </Form>
            </div>
            <LinkContainer to={"/users/" + this.props.me.id}>
              <BSNavItem className="Navbar-link">Me</BSNavItem>
            </LinkContainer>
            <BSNavItem onClick={() => swatifyFetch("/api/v1/logout")}>
              Log out
            </BSNavItem>
          </BSNav>
        </BSNavbar.Collapse>
      </BSNavbar>
    );
  }
}
