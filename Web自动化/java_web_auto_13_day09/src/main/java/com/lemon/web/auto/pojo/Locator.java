package com.lemon.web.auto.pojo;

/**
 * 描述xml中间的locator标签的pojo类
 * 
 * @author happy
 *
 */
public class Locator {

	private String name;
	private String type;
	private String value;

	public Locator(String name, String type, String value) {
		super();
		this.name = name;
		this.type = type;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Locator [name=" + name + ", type=" + type + ", value=" + value + "]";
	}

}
