package com.library.application.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // This tells Hibernate to make a table out of this class
public class Expression {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	//una obra té múltiples expressions, però una exp fa ref només a una obra
	@ManyToOne(fetch = FetchType.LAZY) 
	@JsonIgnore 
	private Work work;
	
	private String title;
	
	private Language language;
	
	//****EXPRESSIÓ DERIVADA D'UNA ALTRA EXPRESSIÓ (exemple traducció d'una edició concreta)
    @ManyToOne
    private Expression parent;

    //una exp pot tenir multiples cols i un col multiples expr
    @ManyToMany(fetch = FetchType.LAZY)  
    private Set<Collaborator> collaborators;




	public Expression(Work work, String title, Language language, Expression parent, Set<Collaborator> collaborators) {
		super();
		this.work = work;
		this.title = title;
		this.language = language;
		this.parent = parent;
		this.collaborators = collaborators;
	}

	public Expression() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Expression getParent() {
		return parent;
	}

	public void setParent(Expression parent) {
		this.parent = parent;
	}

	public Set<Collaborator> getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(Set<Collaborator> collaborators) {
		this.collaborators = collaborators;
	}
	
	
	
}
