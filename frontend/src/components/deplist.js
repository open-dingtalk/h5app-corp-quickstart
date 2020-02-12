import React from 'react';
import { List, Spin, Avatar, Button } from 'antd';
import * as dd from 'dingtalk-jsapi';
import config from '../config.js'

const host = config.host
class H5AppQSDeplist extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            loading: false,
            users: [
            ],
        }

        this.openChat = this.openChat.bind(this);
    }

    componentDidMount() {
        this.setState({loading: true});
        // 单页应用使用首页地址做jsAPI鉴权
        dd.config({
            ...this.props.config,
            jsApiList: [
                'biz.chat.openSingleChat'
            ]
        })
        dd.error(err => {
            alert('dd.config error: ' + JSON.stringify(err));
        });

        fetch(host + '/user/simplelist?department_id='+ this.props.deptId)
            .then(res => res.json())
            .then(result => {
                this.setState({
                    users: result.result,
                    loading: false
                })
            })
    }

    openChat(e, userid) {
        //alert(JSON.stringify(this.props.config));
        dd.biz.chat.openSingleChat({
            corpId: this.props.config.corpId, // 企业id,必须是用户所属的企业的corpid
            userId: userid, // 用户的工号
            onSuccess : function() {},
            onFail : function(err) {alert("fail:" + JSON.stringify(err));}
        }).catch(err => alert("exp:" + JSON.stringify(err) + JSON.stringify(this.props.config)))
    }

    render() {
        return (
            <div style={{ width:320, margin: '0 auto' }}>
                <Spin tips="Loading..." spinning={this.state.loading}>
                    <h3 style={{ marginBottom: 16 }}>用户列表</h3>
                    <List
                        bordered
                        dataSource={this.state.users}
                        renderItem={item => (
                            <List.Item>
                                <Avatar icon="user" /> {item.name}
                                <Button
                                    onClick={(e) => this.openChat(e, item.userid)}
                                    shape="circle"
                                    icon="dingding"
                                    style={{marginLeft: 20}}/>
                            </List.Item>
                        )}
                    />
                </Spin>
            </div>
        )
    }
}

export default H5AppQSDeplist
