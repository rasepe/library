package com.library.application.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity // This tells Hibernate to make a table out of this class
public class Poem extends ComponentPart {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	String title;
	
	@ManyToMany(fetch = FetchType.LAZY)  
	private Set<Expression> expressions;

			public Poem(String title, Set<Expression> expressions) {
				super();
				this.title = title;
				this.expressions = expressions;
			}

			public Poem() {
				
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

			public Set<Expression> getExpressions() {
				return expressions;
			}

			public void setExpressions(Set<Expression> expressions) {
				this.expressions = expressions;
			}
			
			
			

}
