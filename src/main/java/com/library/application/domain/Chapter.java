package com.library.application.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity // This tells Hibernate to make a table out of this class
public class Chapter extends ComponentPart {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	String title;
	
			@ManyToOne(fetch = FetchType.LAZY)  
			private Expression expression;

	
	

	
	


	public Chapter(String title, Expression expression) {
				super();
				this.title = title;
				this.expression = expression;
			}








	public Chapter() {
	}








	public Integer getId() {
		return id;
	}








	public void setId(Integer id) {
		this.id = id;
	}








	public String getTitle() {
		return title;
	}








	public void setTitle(String title) {
		this.title = title;
	}








	public Expression getExpression() {
		return expression;
	}








	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	

	
}
