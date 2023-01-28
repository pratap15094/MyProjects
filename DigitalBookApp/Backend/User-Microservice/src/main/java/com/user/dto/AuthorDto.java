package com.user.dto;

public class AuthorDto {
	private int authorId;
	private String authorName;
	private String authorEmail;
	private String authorPassword;
	private String authorRole;
	public AuthorDto() {
		super();
	}
	public AuthorDto(int authorId, String authorName, String authorEmail, String authorPassword, String authorRole) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorEmail = authorEmail;
		this.authorPassword = authorPassword;
		this.authorRole = authorRole;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorEmail() {
		return authorEmail;
	}
	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}
	public String getAuthorPassword() {
		return authorPassword;
	}
	public void setAuthorPassword(String authorPassword) {
		this.authorPassword = authorPassword;
	}
	public String getAuthorRole() {
		return authorRole;
	}
	public void setAuthorRole(String authorRole) {
		this.authorRole = authorRole;
	}
	
	
}
