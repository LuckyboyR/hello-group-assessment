/**
 * 
 */
package com.hello.group.assessment.hello_group_assessment;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * @author Lucky Rapudi
 *
 */
public class SignUpActivity extends Activity{
	private WebView webview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup_activity);
		webview = (WebView) findViewById(R.id.webview);
		//WebView myWebView = (WebView) findViewById(R.id.webview);
		webview.loadUrl("https://www.android.com/");
	}

}
