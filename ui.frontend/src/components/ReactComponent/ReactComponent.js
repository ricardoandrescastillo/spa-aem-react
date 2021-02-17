import React, { Component } from 'react';
import { MapTo } from '@adobe/aem-react-editable-components';

/**
 * @type EditConfig
 */

const ReactComponentEditConfig = {
    emptyLabel: 'React Component',

    isEmpty: function(props) {
        return !props || !props.text;
    }
}

class ReactComponent extends Component {
    render() {
        return(
            <div>Text Value: {this.props.text},  checkbox: {this.props.checkbox ? 'checked' : 'unchecked'}</div>
    )
    }
}

export default MapTo('spa-react-aem/components/react-component')(
    ReactComponent,
    ReactComponentEditConfig
);