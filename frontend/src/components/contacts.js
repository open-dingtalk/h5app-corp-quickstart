import React from 'react';
import { Switch, Route, Link, useParams } from 'react-router-dom';
import { List, Icon, Spin } from 'antd';
import config from '../config.js'

const host = config.host
class H5AppQSContacts extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            loading: false,
            contacts: [],
        }
    }

    componentDidMount() {
        this.setState({loading: true})
        fetch(host + '/department/list')
            .then(res => res.json())
            .then(result => {
                this.setState({
                    contacts: result.result,
                    loading: false
                })
            })
    }

    render() {
        return (
            <Spin tips="Loading..." spinning={this.state.loading}>
            <div style={{ width:320, margin: '0 auto' }}>
                <h3 style={{ marginBottom: 16 }}>部门列表</h3>
                <List
                    bordered
                    dataSource={this.state.contacts}
                    renderItem={item => (
                        <List.Item>
                            <Link to={ "/deptlist/" + item.id }>
                                <Icon type="apartment" /> {item.name}
                            </Link>
                        </List.Item>
                    )}
                />
            </div>
            </Spin>
        )
    }
}

export default H5AppQSContacts
