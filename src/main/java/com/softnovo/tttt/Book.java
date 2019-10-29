package com.softnovo.tttt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Book {
	private static final Logger LOGGER = LoggerFactory.getLogger(Book.class);
	
	public Book() {
		LOGGER.info("_+_+_+_+_+_+_+_+_+_+ --- " + this + " --- init");
	}

	private String name;
	private Integer size;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", size=" + size + "]";
	}
}


