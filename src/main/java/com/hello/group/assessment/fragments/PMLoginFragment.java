package com.hello.group.assessment.fragments;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.hello.group.assessment.hello_group_assessment.ManagementActivity;
import com.hello.group.assessment.hello_group_assessment.R;
import com.hello.group.assessment.hello_group_assessment.SignUpActivity;
import com.hello.group.assessment.models.Validation;


/**
 * @author Lucky Rapudi
 *
 */
@SuppressLint("NewApi")
public class PMLoginFragment extends Fragment {
	private Button signin;
	private Button signup;
	private EditText username;
	private EditText password;
	private Validation validation = new Validation();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		final View view = inflater.inflate(R.layout.portrait_mode_fragement, container, false);
		username = (EditText) view.findViewById(R.id.edtEmail);
		password = (EditText) view.findViewById(R.id.edtPassword);
		signin = (Button) view.findViewById(R.id.btnSignIn);
		signup = (Button) view.findViewById(R.id.btnSignUp);

		// set onclick
		signin.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// validate username and password
				if (validation.isEmailValid(username.getText().toString()) == false) {
					username.setError("Please enter valid email");
				}
				if (!password.getText().toString().equalsIgnoreCase("Magic")) {
					password.setError("Please enter correct password");
				}
				if (validation.isEmailValid(username.getText().toString()) && password.getText().toString().equalsIgnoreCase("Magic")) {
					Intent intent = new Intent(getActivity().getApplicationContext(), ManagementActivity.class);
					startActivity(intent);
				}

			}
		});

		signup.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				//webview = (WebView) view.findViewById(R.id.webview);
//				WebView myWebView = (WebView) view.findViewById(R.id.webView);
//				myWebView.loadUrl("https://www.android.com/");
				Intent intent = new Intent(getActivity().getApplicationContext(), SignUpActivity.class);
				startActivity(intent);
			}
		});

		return view;
	}

}
