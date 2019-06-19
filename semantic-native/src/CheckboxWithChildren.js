import React from 'react'

export default class CheckboxWithChildren extends React.Component {

    constructor(props){
        super(props)
        this.state = {
            active : false
        }
        this.onClick = this.onClick.bind(this)
    }

    render() {
        const { active } = this.state
        
        return (
            <div>
                {this.renderParent()}
                 {active &&  this.renderChildren() }
            </div>
        )
       
    }

    renderParent() {
        return (
            <div class="ui checkbox" onClick={this.onClick}>
                <input type="checkbox" name="parent"/>
                <label>Test</label>
            </div>
        )
    }

    renderChildren() {
        return (
            <div>
                <div class="ui checkbox">
                    <input type="checkbox" name="c1"/>
                    <label>Children 1</label>
                </div>
                <div class="ui checkbox">
                    <input type="checkbox" name="c2"/>
                    <label>Children 2</label>
                </div>
                <div class="ui checkbox">
                    <input type="checkbox" name="c3"/>
                    <label>Children 3</label>
                </div>
            </div>
            
        )
    }

    onClick() {
        const {active} = this.state
        this.setState( {
            active :!active
        })
    }
}