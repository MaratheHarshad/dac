import React, { Component } from "react";

export default class Discussion extends Component {
  constructor(props) {
    super(props);
    console.log("in constructor");
    this.state = {
      x: 10,
      currentTime: String(new Date()),
    };
  }

  componentDidMount() {
    console.log("in componentDidMount discussion");

    // set interval should be created only 1's at component rendering time i.e componentDidMount is used
    this.livetime = setInterval(() => {
      console.log("in set interval");

      this.setState({
        ...this.state,
        currentTime: String(new Date()),
        x: this.state.x + 1,
      });
    }, 1000);
  }

  componentWillUnmount() {
    console.log("componentWillUnmount discussion");
    // stop the setInterval
    clearTimeout(this.livetime);
  }

  render() {
    console.log("in render function discussion");

    return (
      <div>
        X : {this.state.x}
        <br></br>
        CurrentTime : {this.state.currentTime}
      </div>
    );
  }
}
