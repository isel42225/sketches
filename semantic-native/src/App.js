import React from 'react'
import CheckboxWithChildren from './CheckboxWithChildren';

function App() {
  return (
    <div class='ui container'>
  
      <p>Hello Semantic</p>
      <CheckboxWithChildren />
      <div class="ui grid">
        <div class="four wide column"></div>
        <div class="four wide column"></div>
        <div class="four wide column">Hello</div>
        <div class="four wide column"></div>
      </div>
    </div>
  );
}

export default App;
