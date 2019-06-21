import React from 'react'

export default function TextInMiddleOfScreen (props) {

    return (
        <div class= 'ui sixteen column centered grid'>
            <div class='row'/>
            <div class='row'/>
            <div class='row'/>
            <div class='row'/>
            <div class='row'/>
            <div class='row'/>
            <div class='row'/>
            <div class='row'/>
            <div class='row'/>
            <div class='row'/>
            <div class='row'/>
            <div class='row'/>
            <div class='ui raised segment'>
                <form class='ui form' name='user-form'>
                    <div class='inline field'>
                        <label>Username</label>
                        <input type='text' 
                               name='username'
                        />
                    </div>
                    <div class='inline  field'>
                        <label>Password</label>
                        <input type='text'
                            name = 'password' 
                        />
                    </div>
                    <button class="ui button">
                        Follow
                    </button>
                    <button class="ui button">
                        Like
                    </button>
                </form>
            </div>
        </div>
    )

}