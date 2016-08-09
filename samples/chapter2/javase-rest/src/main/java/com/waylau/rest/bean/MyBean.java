package com.waylau.rest.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyBean {

	private String name;
	private int age;
 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
