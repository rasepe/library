package com.library.application.domain;

import org.hibernate.validator.constraints.ISBN;
//import java.time.Year;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Manifestation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	 @ManyToMany(fetch = FetchType.LAZY)  
	    private Set<Expression> expressions;
	
	String isbn;
	String DL;
	
	String titleProper;
	
	String placePublication;
	String publisher;
	Integer yearPublication;
	//int yearPublication;
	
	Support support;
	
	@ManyToOne(fetch = FetchType.LAZY)  
	Collection collection;
	Integer collectionNumber;
	public Manifestation(Set<Expression> expressions, String isbn, String dL, String titleProper, String placePublication,
			String publisher, Integer yearPublication, Support support, Collection collection, Integer collectionNumber) {
		super();
		this.expressions = expressions;
		this.isbn = isbn;
		DL = dL;
		this.titleProper = titleProper;
		this.placePublication = placePublication;
		this.publisher = publisher;
		this.yearPublication = yearPublication;
		this.support = support;
		this.collection = collection;
		this.collectionNumber = collectionNumber;
	}
	public Manifestation() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Set<Expression> getExpressions() {
		return expressions;
	}
	public void setExpressions(Set<Expression> expressions) {
		this.expressions = expressions;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDL() {
		return DL;
	}
	public void setDL(String dL) {
		DL = dL;
	}
	public String getTitleProper() {
		return titleProper;
	}
	public void setTitleProper(String titleProper) {
		this.titleProper = titleProper;
	}
	public String getPlacePublication() {
		return placePublication;
	}
	public void setPlacePublication(String placePublication) {
		this.placePublication = placePublication;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Integer getYearPublication() {
		return yearPublication;
	}
	public void setYearPublication(Integer yearPublication) {
		this.yearPublication = yearPublication;
	}
	public Support getSupport() {
		return support;
	}
	public void setSupport(Support support) {
		this.support = support;
	}
	public Collection getCollection() {
		return collection;
	}
	public void setCollection(Collection collection) {
		this.collection = collection;
	}
	public Integer getCollectionNumber() {
		return collectionNumber;
	}
	public void setCollectionNumber(Integer collectionNumber) {
		this.collectionNumber = collectionNumber;
	}
//	@Override
//	public String toString() {
//		
//		String listExpressions = "";
//		
//		//	Iterable<Author> authorsPrinted = authors;
//		
//		
//		
//			 for (Expression x : expressions) {
//				 listExpressions += 
//				"{"+'\n'+
//				"\"id\": " + x.getId() +','+ '\n'+
//				"\"work\": " + x.getWork() +','+ '\n'+
//				"\"title\": " + x.getTitle() +','+ '\n'+ 
//				"\"language\": "  + x.getLanguage() +','+ '\n'+ 
//				"\"parent\": "  + x.getParent() +','+ '\n'+ 
//				"\"collaborators\": "  + x.getCollaborators() +','+ '\n'+ 
//			     "}";
//				 
//			 }
//				 
//		
//		
//				 
//
//			 
//			return "[\n" + 
//					"    {\n" + 
//					"        \"id\": "+ id +",\n" + 
//					"        \"expressions\": "+ listExpressions +",\n" + 
//					"        \"isbn\": "+ isbn +",\n" + 
//					"		 \"DL\": " + DL +",\n" + 
//					"		 \"titleProper\": " + "[\n" + titleProper +"]\n" +
//					"		 \"placePublication\": " + "[\n" + placePublication  +"]\n" +
//					"		 \"publisher\": " + "[\n" + publisher  +"]\n" +
//					"		 \"yearPublication\": " + "[\n" + yearPublication  +"]\n" +
//					"		 \"support\": " + "[\n" + support  +"]\n" +
//					"		 \"collection\": " + "[\n" + collection  +"]\n" +
//					"		 \"collectionNumber\": " + "[\n" + collectionNumber  +"]\n" +
//					"    }\n" + 
//					"]";
//		
//		
//	}
	@Override
	public String toString() {

		if (isbn == null) {
			isbn = "";
		}
		if (DL == null) {
			DL = "";
		}
		if (titleProper == null) {
			titleProper = "";
		}
		if (placePublication == null) {
			placePublication = "";
		}
		if (publisher == null) {
			publisher = "";
		}

		
		if (collectionNumber == null) {
			collectionNumber = 0;
		}
		if (collection == null && yearPublication == null) {
			return "{"+'\n'+
					"\"id\": " + id +','+ '\n'+
					"\"isbn\": " + "\"" + isbn + "\"" +','+ '\n'+
					"\"DL\": " + "\"" + DL + "\"" + ','+ '\n'+ 
					"\"titleProper\": "  + "\"" + titleProper  + "\"" + ','+ '\n'+ 
					"\"placePublication\": " + "\"" + placePublication + "\"" +','+ '\n'+ 
					"\"publisher\": "  + "\"" + publisher + "\"" +','+ '\n'+ 
					"\"support\": "  + "\"" + support + "\"" + '\n'+ 
				     "}";
		} else if (collection == null) {
			return "{"+'\n'+
					"\"id\": " + id +','+ '\n'+
					"\"isbn\": " + "\"" + isbn + "\"" +','+ '\n'+
					"\"DL\": " + "\"" + DL + "\"" + ','+ '\n'+ 
					"\"titleProper\": "  + "\"" + titleProper  + "\"" + ','+ '\n'+ 
					"\"placePublication\": " + "\"" + placePublication + "\"" +','+ '\n'+ 
					"\"publisher\": "  + "\"" + publisher + "\"" +','+ '\n'+
					"\"yearPublication\": "  + yearPublication +','+ '\n'+ 
					"\"support\": "  + "\"" + support + "\"" + '\n'+ 
				     "}";
		} else if (yearPublication == null) {
			return "{"+'\n'+
					"\"id\": " + id +','+ '\n'+
					"\"isbn\": " + "\"" + isbn + "\"" +','+ '\n'+
					"\"DL\": " + "\"" + DL + "\"" + ','+ '\n'+ 
					"\"titleProper\": "  + "\"" + titleProper  + "\"" + ','+ '\n'+ 
					"\"placePublication\": " + "\"" + placePublication + "\"" +','+ '\n'+ 
					"\"publisher\": "  + "\"" + publisher + "\"" +','+ '\n'+ 
					"\"support\": "  + "\"" + support + "\"" +','+ '\n'+ 
					"\"collection\": " + "\"" + collection.getName() + "\"" +','+ '\n'+ 
					"\"collectionNumber\": "  + collectionNumber + '\n'+ 
				     "}";
					
					
		
	} else { return "{"+'\n'+
				"\"id\": " + id +','+ '\n'+
				"\"isbn\": " + "\"" + isbn + "\"" +','+ '\n'+
				"\"DL\": " + "\"" + DL + "\"" + ','+ '\n'+ 
				"\"titleProper\": "  + "\"" + titleProper  + "\"" + ','+ '\n'+ 
				"\"placePublication\": " + "\"" + placePublication + "\"" +','+ '\n'+ 
				"\"publisher\": "  + "\"" + publisher + "\"" +','+ '\n'+ 
				"\"yearPublication\": "  + yearPublication +','+ '\n'+ 
				"\"support\": "  + "\"" + support + "\"" +','+ '\n'+ 
				"\"collection\": " + "\"" + collection.getName() + "\"" +','+ '\n'+ 
				"\"collectionNumber\": "  + collectionNumber + '\n'+ 
			     "}";
	}	
				
	
}
}
	

