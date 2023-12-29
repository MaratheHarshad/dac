import React, { Component } from "react";

export default class Demos extends Component {
  // lifecycle methods :

  constructor(props) {
    super(props);
    console.log("in constructor demos");
    this.state = {
      x: 5,
      searchtxt: "",
      y: 34,
    };
  }

  // static method available
  static getDerivedStateFromProps(nextProps, prevState) {
    // do the things with nextProps.someprops != prevState.s
    console.log("in getDerivedState from props");

    return {
      x: 10,
    };
  }

  //
  shouldComponentUpdate() {
    console.log("in shouldComponentUpdate from demos");

    return true;
  }

  componentDidUpdate(prevprops, prevstate, snapshot) {
    // risky function in case we do
    // this.setState({})

    // always keep the code in some condition, otherwise it will go in infinite loop

    // only update state if searchtxt is not equal to prevstate text
    if (
      this.state.searchtxt !== "" &&
      prevstate.searchtxt !== this.state.searchtxt
    ) {
      console.log(
        "text is not matching",
        prevstate.searchtxt,
        this.state.searchtxt
      );
      this.setState({ ...this.state, y: 50 });
    }
  }

  getSnapshotBeforeUpdate(prevprops, prevstate) {
    console.log("in getsnapshotBeforeUpdate");
    return 100;
  }

  handlechange = (event) => {
    this.setState({ ...this.state, searchtxt: event.target.value });
  };

  componentWillUnmount() {
    console.log("in componentWillUnmount");
  }

  // The render() method returns JSX that is displayed in the UI. A render() can also return a null if there is nothing to render for that component.
  // A render() method has to be pure with no side-effects
  // React requires that your
  render() {
    return (
      <div>
        {console.log("x in discussion : ", this.state.y)}
        <input
          type="text"
          name="search"
          id="search"
          value={this.state.searchtxt}
          onChange={this.handlechange}
        />
        <p>Demos : {this.state.x}</p>
      </div>
    );
  }
}
