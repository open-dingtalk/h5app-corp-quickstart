import React from 'react';
import { Avatar } from 'antd';

function H5AppQSUser(props) {
    return (
        <div className="user" style={props.style}>
            <Avatar size="large" icon="user" src={props.user.avatar}/>
            <span className="user-detail">
                <span>{props.user.name}</span> (<span>{props.user.userid}</span>)
            </span>
        </div>
    )
}

export default H5AppQSUser
