import React from 'react'
import { Component } from "react";
import './App.css';
import 'semantic-ui-css/semantic.min.css';
import { Header } from 'semantic-ui-react'
import {Button} from 'semantic-ui-react';
import { Input } from 'semantic-ui-react'
import { getRequest } from "./utils/urlFunctions";

const URL = "http://localhost:8080/getprimes/";

class App extends Component {
  constructor(props) {
    super();
    this.state = {
      isLoading: false,
      upperLimit: null,
      listOfPrimes: undefined
    }
  }

  sendRequest = () => {
    const {upperLimit} = this.state;
    const requestUrl = URL + upperLimit;
    fetch(requestUrl).then(response => response.json)
    .then(data => {
      console.log(data);
    })
  };

  handleInput = (e) => {
    this.setState({ upperLimit: e.target.value });
  }

  render() {
    return (
      <div className="App">
        <Header as='h1'>Get list of prime numbers</Header>
        <Input onChange={this.handleInput} focus placeholder='Upper limit ...' />
        <Button onClick={this.sendRequest} >Get it!</Button>
      </div>
    );

  }
}

export default App;
