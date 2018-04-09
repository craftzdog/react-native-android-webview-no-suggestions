import React, { Component } from 'react';
import PropTypes from 'prop-types'
import {WebView, requireNativeComponent} from 'react-native';

export default class CDWebView extends Component {
  static propTypes = WebView.propTypes;

  render() {
    return (
      <WebView {...this.props} nativeConfig={{component: RCTCustomWebView}} />
    );
  }
}

const RCTCustomWebView = requireNativeComponent(
  'RCTCustomWebView',
  CDWebView,
  WebView.extraNativeComponentConfig
);
