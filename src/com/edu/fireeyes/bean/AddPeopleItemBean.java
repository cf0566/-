package com.edu.fireeyes.bean;

public class AddPeopleItemBean {
	private String name;
	private boolean isChecked;//选中状态
	public AddPeopleItemBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddPeopleItemBean(String name, boolean isChecked) {
		super();
		this.name = name;
		this.isChecked = isChecked;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	@Override
	public String toString() {
		return "AddPeopleItemBean [name=" + name + ", isChecked=" + isChecked
				+ "]";
	}
	
}
