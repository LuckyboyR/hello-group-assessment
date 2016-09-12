/**
 * 
 */
package com.hello.group.assessment.fragments;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.hello.group.assessment.hello_group_assessment.R;
import com.hello.group.assessment.models.DatabaseHandler;
import com.hello.group.assessment.models.Item;

/**
 * @author Lucky Rapudi
 * 
 */
@SuppressLint("NewApi")
public class PMManagementFragment extends Fragment implements OnClickListener, OnKeyListener {
	private ArrayAdapter<String> itemList;
	private ArrayList<String> appointment;
	private EditText editText1;
	private Button addButton;
	private Button resetButton;
	private ListView listView1;
	private DatabaseHandler db;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.portrait_management_activity, container, false);

		db = new DatabaseHandler(getActivity().getApplicationContext());

		editText1 = (EditText) view.findViewById(R.id.editText1);
		addButton = (Button) view.findViewById(R.id.addButton);
		resetButton = (Button) view.findViewById(R.id.resetButton);
		listView1 = (ListView) view.findViewById(R.id.listView1);

		addButton.setOnClickListener(this);
		resetButton.setOnClickListener(this);
		editText1.setOnKeyListener(this);

		appointment = new ArrayList<String>();
		itemList = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, appointment);
		listView1.setAdapter(itemList);
		return view;
	}

	private void addItems(String item) {

		if (item.length() > 0) {
			this.appointment.add(item);
			this.itemList.notifyDataSetChanged();
			this.editText1.setText("");
		}

	}

	public void onClick(View v) {

		if (v == this.addButton) {
			this.addItems(this.editText1.getText().toString());

			Log.d("Insert: ", "Inserting ..");
			db.addItem(new Item(this.editText1.getText().toString()));

			Log.d("Reading: ", "Reading all Items..");
			List<Item> items = db.getAllItems();

			for (Item itm : items) {
				String log = "Id: " + itm.getId() + " ,Item: " + itm.getItem();
				Log.d("Name: ", log);

			}
		}
		if (v == this.resetButton) {
			itemList.clear();
			itemList.notifyDataSetChanged();
		}

	}

	public boolean onKey(View v, int keyCode, KeyEvent event) {

		if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DPAD_CENTER)
			this.addItems(this.editText1.getText().toString());

		return false;
	}

}
