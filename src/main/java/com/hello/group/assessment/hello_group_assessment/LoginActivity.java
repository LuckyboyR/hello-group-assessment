package com.hello.group.assessment.hello_group_assessment;

import com.hello.group.assessment.fragments.LMLoginFragment;
import com.hello.group.assessment.fragments.PMLoginFragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;

/**
 * @author Lucky Rapudi
 *
 */
public class LoginActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle("LOGIN");
		//getActionBar().hide();

		Configuration config = getResources().getConfiguration();

		FragmentManager fragmentManager = getFragmentManager();

		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

		/**
		 * Check the device orientation and act accordingly
		 */
		if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
			/**
			 * Landscape mode of the device
			 */
			LMLoginFragment ls_fragment = new LMLoginFragment();
			fragmentTransaction.replace(android.R.id.content, ls_fragment);
		} else {
			/**
			 * Portrait mode of the device
			 */
			PMLoginFragment pm_fragment = new PMLoginFragment();
			fragmentTransaction.replace(android.R.id.content, pm_fragment);
		}

		fragmentTransaction.commit();
	}

}
