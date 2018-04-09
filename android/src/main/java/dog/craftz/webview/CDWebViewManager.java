package dog.craftz.webview;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.views.webview.*;
import com.facebook.react.uimanager.ThemedReactContext;

import android.provider.Settings;
import android.webkit.WebView;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.BaseInputConnection;
import android.text.InputType;
import android.view.inputmethod.EditorInfo;
import android.util.Log;

@ReactModule(name = CDWebViewManager.REACT_CLASS)
public class CDWebViewManager extends ReactWebViewManager {
  /* This name must match what we're referring to in JS */
  protected static final String REACT_CLASS = "RCTCustomWebView";

  protected static class CustomWebViewClient extends ReactWebViewClient { }

  protected static class CustomWebView extends ReactWebView {
    public CustomWebView(ThemedReactContext reactContext) {
      super(reactContext);
    }

    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
      String inputMethodId = Settings.Secure.getString(
        getContext().getContentResolver(),
        Settings.Secure.DEFAULT_INPUT_METHOD
      );
      InputConnection inputConnection = super.onCreateInputConnection(outAttrs);

      // disable text suggestions when the input method is latin
      if (inputMethodId.indexOf("com.google.android.inputmethod.latin") >= 0) {
        outAttrs.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD;
      }

      return inputConnection;
    }
  }

  @Override
  protected ReactWebView createReactWebViewInstance(ThemedReactContext reactContext) {
    return new CustomWebView(reactContext);
  }

  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @Override
  protected void addEventEmitters(ThemedReactContext reactContext, WebView view) {
    view.setWebViewClient(new CustomWebViewClient());
  }
}
