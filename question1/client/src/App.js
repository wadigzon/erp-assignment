import React from 'react'
import { Component } from "react";
import './App.css';
import 'semantic-ui-css/semantic.min.css';
import { Header } from 'semantic-ui-react'
import {Button} from 'semantic-ui-react';
import { Input } from 'semantic-ui-react'
import LoadingComponent from './LoadingComponent'

const URL = "http://localhost:8080/getprimes/";

class App extends Component {
  constructor(props) {
    super();
    this.state = {
      isLoading: false,
      upperLimit: undefined,
      listOfPrimes: undefined
    }
  }

  sendRequest = () => {
    const {upperLimit} = this.state;
    const requestUrl = URL + upperLimit;
    let myInit = {
      method: 'get',
      mode: 'cors',
      cache: 'default',
    };
    this.setState({isLoading: true});
    fetch(requestUrl, myInit).then(response => response.json())
    .then(primeMessage => {
      // finished loading!
      this.setState({isLoading: false});
      if (primeMessage && primeMessage.primeNumbers && primeMessage.primeNumbers.length !== undefined) {
        const listString = primeMessage.primeNumbers.join(", ");
        const count = primeMessage.count;
        const upperBound = primeMessage.upperBound;
        this.setState({listOfPrimes: `We've found ${count} prime numbers less than or equal than ${upperBound} => [ ${listString} ]`})
      }
    })
  };

  resetContent  = () => {
    this.setState({
      isLoading: false,
      listOfPrimes: undefined
    });
  }
  handleInput = (e) => {
    this.setState({ upperLimit: e.target.value });
  }

  render() {
    const {isLoading, listOfPrimes, upperLimit} = this.state;
    return (
      <div className="App">
        <div className="input">
          <Header as='h1'>Get list of prime numbers</Header>
          <Input onChange={this.handleInput} focus placeholder='Upper limit ...' style={{marginRight: '5px'}} />
          <Button primary onClick={this.sendRequest} disabled={upperLimit === undefined || upperLimit.length === 0 || isNaN(Number(upperLimit)) ? true : false} >Get them!</Button>
          <Button secondary onClick={this.resetContent} >Clear!</Button>
        </div>
        <div className="output">
          { isLoading && listOfPrimes
            ? <LoadingComponent isLoading />
            : <div>{listOfPrimes} </div> }
        </div>
      </div>
    );

  }
}

export default App;
