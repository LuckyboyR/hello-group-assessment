/**
 * 
 */
package com.hello.group.assessment.models;

/**
 * @author Lucky Rapudi
 *
 */
public class Item {
	private long id;
	private String item;

	/**
	 * @param item
	 */
	public Item(String item) {
		super();
		this.item = item;
	}
	public Item() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}
	
	@Override
	public String toString(){
		return item;
	}

}
