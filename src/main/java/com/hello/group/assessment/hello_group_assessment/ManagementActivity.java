/**
 * 
 */
package com.hello.group.assessment.hello_group_assessment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;

import com.hello.group.assessment.fragments.LMManagementFragment;
import com.hello.group.assessment.fragments.PMManagementFragment;

/**
 * @author Lucky Rapudi
 *
 */
public class ManagementActivity extends Activity{
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.management_activity);
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
			LMManagementFragment ls_fragment = new LMManagementFragment();
			fragmentTransaction.replace(android.R.id.content, ls_fragment);
		} else {
			/**
			 * Portrait mode of the device
			 */
			PMManagementFragment pm_fragment = new PMManagementFragment();
			fragmentTransaction.replace(android.R.id.content, pm_fragment);
		}

		fragmentTransaction.commit();
	}

}
