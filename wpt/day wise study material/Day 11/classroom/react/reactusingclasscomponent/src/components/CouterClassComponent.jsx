import React, { Component } from "react";

// using this is class component beccause this component is going to have state
class CounterClassComponent extends Component {
  // in class component we can write constructor

  // life cycle method, only call once
  constructor(props) {
    // predefined object available in class -> state

    console.log("inside constructor");
    super(props);

    // we can assing any number of states that we want to retain

    this.state = {
      count: 0,
      name: "kishori",
    };

    // take the current fun increment and add the class object and then override the fun
    // with new property
    // this is required only if we write function like this -> increment() {}
    // because in array fun, there is no access to -> this

    this.increment = this.increment.bind(this);
  }

  //   increment() {}

  // always use sesstate function to change the state
  increment = () => {
    // setState is asynchronous function, i.e callback function is used to have access updated state
    this.setState({ ...this.state, count: this.state.count + 1 }, () => {
      console.log(this.state.count);
    });
  };

  render() {
    // render execute every time, whenever there is change in the state, i.e this is a lifecycle method

    console.log("inside render");

    return (
      <div>
        <h3>you clicked {this.state.count} times</h3>

        {/* events names should be write in camelcase format */}
        {/* without curly braces-> fun name means call only when button is clicked */}
        <h1>Counter Class Component</h1>
        <button type="button" onClick={this.increment}>
          increment
        </button>
        <button type="button">decrement</button>
        <button type="button">reset</button>
      </div>
    );
  }
}

export default CounterClassComponent;
