/**
 * 
 */
package com.hello.group.assessment.models;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Lucky Rapudi
 * 
 */
public class DatabaseHandler extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "itemsManager";
	private static final String TABLE_ITEMS = "items";
	private static final String KEY_ID = "id";
	private static final String KEY_ITEM = "item";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_ITEMS_TABLE = "CREATE TABLE " + TABLE_ITEMS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ITEM + " TEXT" + ")";
		db.execSQL(CREATE_ITEMS_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
		onCreate(db);
	}

	public void addItem(Item item) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_ITEM, item.getItem());

		db.insert(TABLE_ITEMS, null, values);
		db.close();
	}

	public List<Item> getAllItems() {
		List<Item> itemList = new ArrayList<Item>();
		String selectQuery = "SELECT  * FROM " + TABLE_ITEMS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {
				Item item = new Item();
				item.setId(Integer.parseInt(cursor.getString(0)));
				item.setItem(cursor.getString(1));

				itemList.add(item);
			} while (cursor.moveToNext());
		}

		return itemList;
	}

}
