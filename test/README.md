How to run test
================

1. Create new react-native project

```
react-native init WebViewDemo
cd WebViewDemo
```

2. Install `react-native-android-webview-no-suggestions` by following instructions on its README.
3. Change `index.ios.js` and `index.android.js` to:

```javascript
import React, { Component } from 'react'
import {
  AppRegistry,
} from 'react-native'
import App from 'react-native-android-webview-no-suggestions/test/app'

AppRegistry.registerComponent('WebViewTest', () => App)
```
