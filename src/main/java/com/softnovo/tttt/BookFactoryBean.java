package com.softnovo.tttt;

import org.springframework.beans.factory.FactoryBean;

public class BookFactoryBean implements FactoryBean<Book> {

	private String bookInfo;

	@Override
	public Book getObject() throws Exception {
		Book book = new Book();
		String[] infos = bookInfo.split(",");
		book.setName(infos[0]);
		book.setSize(Integer.parseInt(infos[1]));
		return book;
	}

	@Override
	public Class<?> getObjectType() {
		return Book.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	public String getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(String bookInfo) {
		this.bookInfo = bookInfo;
	}
}
