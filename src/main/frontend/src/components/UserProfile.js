import React, { Component } from "react";
import Loader from "./Loader";
import NotFound from "./NotFound";
import swatifyFetch from "../swatifyFetch";
import "./UserProfile.css";
export default class UserProfile extends Component {
  state = { loading: true, user: null };

//html Page source: https://bootsnipp.com/snippets/featured/people-card-with-tabs
  render() {
      return (
            <div id= "profilePage" class="Overlay">
                <div class="card hovercard">
                    <div class="card-background">
                        <img class="card-bkimg" alt="" src="https://i.pinimg.com/originals/c9/2f/62/c92f62c1e75e2ee08e7887059081e1a5.jpg"/>
                    </div>
                    <div class="useravatar">
                        <img alt="" src="https://i.pinimg.com/originals/c9/2f/62/c92f62c1e75e2ee08e7887059081e1a5.jpg"/>
                    </div>
                    <div class="card-info"> <span class="card-title">Nujabes</span>

                    </div>
                </div>
                <div class="btn-pref btn-group btn-group-justified btn-group-lg" role="group" aria-label="...">
                    <div class="btn-group" role="group">
                        <button type="button" id="stars" class="btn btn-primary" href="#tab1" data-toggle="tab"><span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                            <div class="hidden-xs">Followers</div>
                        </button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" id="favorites" class="btn btn-default" href="#tab2" data-toggle="tab"><span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
                            <div class="hidden-xs">Favorites</div>
                        </button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" id="following" class="btn btn-default" href="#tab3" data-toggle="tab"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                            <div class="hidden-xs">Following</div>
                        </button>
                    </div>
                </div>

                    <div class="well">
                  <div class="tab-content">
                    <div class="tab-pane fade in active" id="tab1">
                      <h3>This is tab 1</h3>
                    </div>
                    <div class="tab-pane fade in" id="tab2">
                      <h3>This is tab 2</h3>
                    </div>
                    <div class="tab-pane fade in" id="tab3">
                      <h3>This is tab 3</h3>
                    </div>
                  </div>
                </div>

                </div>


      );
    }
  }

