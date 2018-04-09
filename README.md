# React Native Android WebView With No Suggestions

This custom WebView hides text suggetions when the input method is latin (English) on Android.

## Getting started

```shell
$ npm install react-native-android-webview-no-suggestions --save
```

### Mostly automatic installation

```shell
$ react-native link react-native-android-webview-no-suggestions
```

### Manual installation

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import dog.craftz.webview.CDWebViewPackage;` to the imports at the top of the file
  - Add `new CDWebViewPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
    ```
    include ':react-native-android-webview-no-suggestions'
    project(':react-native-android-webview-no-suggestions').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-sqlite-2/android')
    ```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
    ```
    compile project(':react-native-android-webview-no-suggestions')
    ```

## Usage

See [test/app.js](test/app.js).
