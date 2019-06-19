import React from 'react'

export default function Dropdown(props) {

    return(
        <div >
            <select onClick={onClickSelect}>
                <option value='A' onClick={onClickOption}>A</option>
            </select>
            <div class='ui simple dropdown'>
                <div class="text">File</div>
                <i class="dropdown icon"></i>
                <div class="menu">
                    <div class="item">New</div>
                </div>
            </div>
      </div>
    )
}

function onClickSelect(e){
    debugger
}
function onClickOption(e) {
    debugger
    const f = e.target.value
}