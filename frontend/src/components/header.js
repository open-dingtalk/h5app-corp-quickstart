import React from 'react';
import { Row, Col } from 'antd';
import H5AppQSUser from './user.js'

class H5AppQSHeader extends React.Component {
    render() {
        return (
            <div>
                <Row>
                    <Col xs={{ span: 0 }}
                        sm={{ span: 0 }}
                        md={{ span: 7 }}
                        lg={{ span: 7 }}
                        xl={{ span: 7 }}
                        xxl={{ span: 6 }}>
                    <a href="/index.html">
                        <img src="/images/logo.png" alt="dingding" className="logo"/>
                        <span className="logo">钉钉微应用QuickStart</span>
                    </a>
                    </Col>
                    <Col xs={{ span: 24 }}
                        sm={{ span: 24 }}
                        md={{ span: 17 }}
                        lg={{ span: 17 }}
                        xl={{ span: 17 }}
                        xxl={{ span: 18 }}
                    ><H5AppQSUser style={{ float: 'right' }} user={this.props.user}/></Col>
                </Row>
            </div>
        );
    }
}

export default H5AppQSHeader
