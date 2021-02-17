import React, { Component } from 'react';
import { MapTo } from '@adobe/aem-react-editable-components';
import { Link } from 'react-router-dom';

const LinkContentEditConfig = {
    emptyLabel: 'Link Content',

    isEmpty: function(props) {
        return !props || !props.interestingPages;
    }
};

class LinkContent extends Component {
    render() {
        return (
            <div>my links
                <ul>
                    {this.props.linkPages &&
                    this.props.linkPages.map((page, index) => {
                        return (
                            <li key={index}>
                                <Link to={page.path} title={page.title}>{page.title}</Link>
                            </li>
                        );
                    })}
                </ul>
            </div>
        );
    }
}

export default MapTo('spa-react-aem/components/link-content')(
    LinkContent,
    LinkContentEditConfig
);