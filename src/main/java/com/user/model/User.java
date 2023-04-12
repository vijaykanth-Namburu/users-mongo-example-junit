package com.user.model;

import java.util.Optional;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "Users")

public class User {
	
	
	private int userId;
	
	@Id
	private int it;
	
	private String title;
	
	private String body;

	
	public User() {
		super();
	}
	
	
	

	public User(int userId, int it, String title, String body) {
		super();
		this.userId = userId;
		this.it = it;
		this.title = title;
		this.body = body;
	}




	public int getUserId() {
		return userId;
	}


	public void setUserid(int userid) {
		this.userId = userid;
	}

	public int getIt() {
		return it;
	}

	public void setIt(int it) {
		this.it = it;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}





}
