import React, { Component } from 'react';
import PropTypes from 'prop-types'
import {WebView, requireNativeComponent} from 'react-native';

export default class CDWebView extends Component {
  static propTypes = WebView.propTypes;

  componentDidMount () {
    this.injectJavaScript = this.webView.injectJavaScript.bind(this.webView)
  }

  render() {
    return (
      <WebView
        {...this.props}
        ref={el => this.webView = el}
        nativeConfig={{component: RCTCustomWebView}}
      />
    );
  }
}

const RCTCustomWebView = requireNativeComponent(
  'RCTCustomWebView',
  CDWebView,
  WebView.extraNativeComponentConfig
);
