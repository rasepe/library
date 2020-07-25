package com.library.application.domain;


import java.time.YearMonth;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity // This tells Hibernate to make a table out of this class
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Work {
	
// This means to get the bean called userRepository
//private UserRepository userRepository;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;



	
	private String uniformTitle;

	
	private Language language;
	
	//****OBRA DERIVADA
	//****@OneToMany //(mappedBy="parentComment")
    //****private Set<User> sons;
    @ManyToOne
    private Work parent;
    
    //OBRA RELACIONADA
  //  @ManyToOne (fetch = FetchType.EAGER)
//	private Relationship related;
  //**** @ManyToMany  // @OneToMany //(mappedBy = "user")
  //****Set<Relationship> relationships;  
	

  //una obra pot tenir multiples autors i un autor multiples obres
    @ManyToMany(fetch = FetchType.LAZY)  
    private Set<Author> authors;

    

    @OneToMany(fetch = FetchType.LAZY)  
    private Set<Subject> subjects;

   
    private int year;
    private String month;
    private YearMonth ym; 

    //only music in phisical formats (ALBUM, SINGLE, EP)
    private Length length;

    
    
    
    public Work(Integer id, String uniformTitle, Language language, Work parent, Set<Author> authors,
			Set<Subject> subjects, int year, String month, YearMonth ym, Length length) {
		super();
		this.id = id;
		this.uniformTitle = uniformTitle;
		this.language = language;
		this.parent = parent;
		this.authors = authors;
		this.subjects = subjects;
		this.year = year;
		this.month = month;
		this.ym = ym;
		this.length = length;
	}

	//without length
	public Work(String uniformTitle, Language language, Work parent, Set<Author> authors, Set<Subject> subjects, int year, String month) {
		super();
		this.uniformTitle = uniformTitle;
		this.language = language;
		this.parent = parent;
		this.authors = authors;
		this.subjects = subjects;
		this.year = year;
		this.month = month;
		this.ym = YearMonth.of(year, Integer.parseInt(month));
	}

	public Work(String uniformTitle, Language language, Work parent, Set<Author> authors, Set<Subject> subjects) {
		super();
		this.uniformTitle = uniformTitle;
		this.language = language;
		this.parent = parent;
		this.authors = authors;
		this.subjects = subjects;
	}

	public Work() {
		// TODO Auto-generated constructor stub
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}







	public String getUniformTitle() {
		return uniformTitle;
	}



	public void setUniformTitle(String uniformTitle) {
		this.uniformTitle = uniformTitle;
	}



	public Work getParent() {
		return parent;
	}



	public void setParent(Work parent) {
		this.parent = parent;
	}



	public Language getLanguage() {
		return language;
	}



	public void setLanguage(Language language) {
		this.language = language;
	}



	public Set<Author> getAuthors() {
		return authors;
	}



	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}



	public Set<Subject> getSubjects() {
		return subjects;
	}



	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}



	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public YearMonth getYm() {
		return ym;
	}

	public void setYm(YearMonth ym) {
		this.ym = ym;
	}

	@Override
	public String toString() {
		
		String listAuthors = "";
		
	//	Iterable<Author> authorsPrinted = authors;
		
		 for (Author x : authors) {
			 listAuthors += 
			"{"+'\n'+
			"\"id\": " + x.getId() +','+ '\n'+
			"\"name\": " + x.getName() +','+ '\n'+
			"\"surname\": " + x.getSurname() +','+ '\n'+ 
			"\"yearBirth\": "  + x.getYearBirth() +','+ '\n'+ 
			"\"yearDeath\": "  + x.getYearDeath() +','+ '\n'+ 
		     "}";
			 
		 }
			 
		 String listSubjects = "";
		 
		 for (Subject x : subjects) {
			 listSubjects += 
			'{'+'\n'+
			"\"id\": " + x.getId() +','+ '\n'+
			"\"name\": " + x.getName() +','+ '\n'+
		     "}";
			 
		 }
			 

		 
		return "[\n" + 
				"    {\n" + 
				"        \"id\": "+ id +",\n" + 
				"        \"uniformTitle\": "+ uniformTitle +",\n" + 
				"        \"language\": "+ language +",\n" + 
				"		 \"parent\": " + parent +",\n" + 
				"		 \"authors\": " + "[\n" + listAuthors  +"]\n" +
				"		 \"subjects\": " + "[\n" + listSubjects  +"]\n" +
				"    }\n" + 
				"]";
	}

	public Length getLength() {
		return length;
	}

	public void setLength(Length length) {
		this.length = length;
	}

	
	
	
	
}
