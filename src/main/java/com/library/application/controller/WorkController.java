package com.library.application.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.library.application.domain.Author;
import com.library.application.domain.Language;
import com.library.application.domain.Subject;
import com.library.application.domain.WRelationship;
import com.library.application.domain.WRelationshipType;
import com.library.application.domain.Work;
import com.library.application.persistence.AuthorRepository;
import com.library.application.persistence.SubjectRepository;
import com.library.application.persistence.WRelationshipRepository;
import com.library.application.persistence.WorkRepository;


@Controller	// This means that this class is a Controller
@CrossOrigin
@RequestMapping(path="/work") // This means URL's start with /demo (after Application path)
public class WorkController {
	@Autowired // This means to get the bean called userRepository
			   // Which is auto-generated by Spring, we will use it to handle the data
	private WorkRepository workRepository;
	
	@Autowired // This means to get the bean called userRepository
	   // Which is auto-generated by Spring, we will use it to handle the data
private AuthorRepository authorRepository;
	@Autowired
	
	private SubjectRepository subjectRepository;
	@Autowired
	
	private WRelationshipRepository wRelationshipRepository;
	
	Work work;
	
	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewWork (@RequestParam String uniformTitle, @RequestParam Language language, @RequestParam Integer idParent, @RequestParam Set<Integer> idsAuthors, @RequestParam Set<Integer> idsSubjects ) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		/*
		 * public Work(String uniformTitle, Language language, Work parent, Set<Author> authors, Set<Subject> subjects) {
		super();
		this.uniformTitle = uniformTitle;
		this.language = language;
		this.parent = parent;
		this.authors = authors;
		this.subjects = subjects;
	}
		 * 
		 */
		
		Work n = new Work();
		n.setUniformTitle(uniformTitle);
		n.setLanguage(language);
		
		
		
		
Iterable<Work> allWorks = workRepository.findAll();
		
		Work parentWork = new Work();
		 for (Work x : allWorks) {

			 if (x.getId() == idParent) {
				 parentWork = x;
			 }
	
		 }
		
		 n.setParent(parentWork);
		
		Iterable<Author> allAuthors = authorRepository.findAll();
		
		Set<Author> workAuthors = new HashSet<Author>();
		 for (Author x : allAuthors) {
			 for (int i : idsAuthors) {
			 if (x.getId() == i) {
				 workAuthors.add(x);
			 }
			 }
		 }
		
		 n.setAuthors(workAuthors);
		 
		 Iterable<Subject> allSubjects = subjectRepository.findAll();
		 
		 Set<Subject> workSubjects = new HashSet<Subject>();
		 for (Subject x : allSubjects) {
			 for (int i : idsSubjects) {
			 if (x.getId() == i) {
				 workSubjects.add(x);
			 }
			 }
		 }
		 
		n.setSubjects(workSubjects);
		
		workRepository.save(n);
		return "Saved";
	}
	

	@PostMapping(path="/addsimple") // Map ONLY POST Requests
	public @ResponseBody String addNewWorkSimple (@RequestParam String uniformTitle, @RequestParam Language language, @RequestParam Set<Integer> idsAuthors) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		/*
		 * public Work(String uniformTitle, Language language, Work parent, Set<Author> authors, Set<Subject> subjects) {
		super();
		this.uniformTitle = uniformTitle;
		this.language = language;
		this.parent = parent;
		this.authors = authors;
		this.subjects = subjects;
	}
		 * 
		 */
		
		Work n = new Work();
		n.setUniformTitle(uniformTitle);
		n.setLanguage(language);
		
		
		
		

		
		Iterable<Author> allAuthors = authorRepository.findAll();
		
		Set<Author> workAuthors = new HashSet<Author>();
		 for (Author x : allAuthors) {
			 for (int i : idsAuthors) {
			 if (x.getId() == i) {
				 workAuthors.add(x);
			 }
			 }
		 }
		
		 n.setAuthors(workAuthors);
		 

		
		workRepository.save(n);
		return "Saved";
	}
	
	@PostMapping(path="/addson") // Map ONLY POST Requests
	public @ResponseBody String addNewWorkWithParent (@RequestParam String title, @RequestParam Integer parentId) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Work n = new Work();
		n.setUniformTitle(title);
		//n.setEmail(email);
		Work parent = new Work();
		 Iterable<Work> allWorks = workRepository.findAll();
		 for (Work x : allWorks) 
			 {
			 if (x.getId() == parentId) {
				 parent = x;
			 }
			 }; 
		
		
		n.setParent(parent);
		workRepository.save(n);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Work> getAllWorks() {
		// This returns a JSON or XML with the users
		return workRepository.findAll();
	}
	
	//Find works by an author
	@GetMapping(path="/{id_author}")
	public @ResponseBody Iterable<Work> getAllWorksByAuthor(@PathVariable Integer id_author) {
	
		Iterable<Work> allWorks = workRepository.findAll();
		 Set<Author> authorsFromWork = new HashSet<Author>();
		 Iterable<Author> allAuthors = authorRepository.findAll();

		 Set<Work> worksFromAuthor = new HashSet<Work>();
		 
		 Author author = null;
		 for (Author a : allAuthors) {
			 if (a.getId() == id_author) {
				 author = a;
			 }
		 }
		 
		 for (Work x : allWorks) { 
			 authorsFromWork = x.getAuthors();
			 for (Author a : authorsFromWork) {
				 if (a.getId() == author.getId()) {
					 worksFromAuthor.add(x);
				 };
			 }
		 }
		 
		 
		 
		return worksFromAuthor;
	}
	
	//Find number of works by an author
	@GetMapping(path="/{id_author}/number")
	public @ResponseBody Integer getNumberWorksByAuthor(@PathVariable Integer id_author) {
	
		Iterable<Work> allWorks = workRepository.findAll();
		 Set<Author> authorsFromWork = new HashSet<Author>();
		 Iterable<Author> allAuthors = authorRepository.findAll();

		 Set<Work> worksFromAuthor = new HashSet<Work>();
		 
		 Author author = null;
		 for (Author a : allAuthors) {
			 if (a.getId() == id_author) {
				 author = a;
			 }
		 }
		 
		 for (Work x : allWorks) { 
			 authorsFromWork = x.getAuthors();
			 for (Author a : authorsFromWork) {
				 if (a.getId() == author.getId()) {
					 worksFromAuthor.add(x);
				 };
			 }
		 }
		 
		 
		 
		return worksFromAuthor.size();
	}
	
	@GetMapping(path="/allrelationships")
	public @ResponseBody Iterable<WRelationship> getAllRelationships() {
		// This returns a JSON or XML with the users
		return wRelationshipRepository.findAll();
	}
	
	@GetMapping(path="/{id_work}/relatedworks")
	public @ResponseBody Iterable<Work> getRelatedWorks(@PathVariable Integer id_work) {
		// This returns a JSON or XML with the users
		
		Set<WRelationship> relationShipsFromWork = new HashSet<WRelationship>();
		Set<Work> relatedWorks = new HashSet<Work>();
		for (WRelationship r : wRelationshipRepository.findAll()) {
			
			
			for (Work w : r.getWorks()) {
				if (w.getId() == id_work) {
					
					relationShipsFromWork.add(r);
					
				}
			}
			
		}
		
		for (WRelationship r :  relationShipsFromWork) {
			
			for (Work w : r.getWorks()) {
				if (w.getId() != id_work) {
					
					relatedWorks.add(w);
					
				}
				
				
			}
			
		}
		
		
		return relatedWorks;
	}
	
	
	@GetMapping(path="/{id_work}/numrelatedworks")
	public @ResponseBody Integer getNumRelatedWorks(@PathVariable Integer id_work) {
		// This returns a JSON or XML with the users
		
		Integer numRelatedWorks = 0;
		
		Set<WRelationship> relationShipsFromWork = new HashSet<WRelationship>();
		Set<Work> relatedWorks = new HashSet<Work>();
		for (WRelationship r : wRelationshipRepository.findAll()) {
			
			
			for (Work w : r.getWorks()) {
				if (w.getId() == id_work) {
					
					relationShipsFromWork.add(r);
					
				}
			}
			
		}
		
		for (WRelationship r :  relationShipsFromWork) {
			
			for (Work w : r.getWorks()) {
				if (w.getId() != id_work) {
					
					numRelatedWorks++;
					
				}
				
				
			}
			
		}
		
		
		return numRelatedWorks;
	}
	
	@PostMapping(path="/addrelationship") // Map ONLY POST Requests
	public @ResponseBody String addNewWRelationship (@RequestParam Set<Integer> ids, @RequestParam WRelationshipType wRelationshipType) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		List<Integer> listIds = new ArrayList<Integer>(ids);
		
		
		
		Set<Work> worksInRelationship = new HashSet<Work>(); 
		List<Work> listWorksInRelationship = new ArrayList<Work>(worksInRelationship);
		
		
		
	//	Set<User> users = (Set<User>) userRepository.findAll();

		Set<Work> worksSet = new HashSet<Work>();
		
		Iterable<Work> worksIterable = workRepository.findAll();
		
		 for (Work x : worksIterable) 
			 worksSet.add(x); 
		
		
		List<Work> listWorks = new ArrayList<Work>(worksSet);


		
for (int i=0; i<listWorks.size(); i++) {
	
	//System.out.println("hola");
	
	for (int j=0; j<ids.size(); j++) {
		if (listWorks.get(i).getId() == listIds.get(j)) {
			listWorksInRelationship.add(listWorks.get(i));
			
			
		}		
	}
	

	
}
		

		
		 //Set<String> hSet = new HashSet<String>(); 
	        for (Work x : listWorksInRelationship) 
	        	worksInRelationship.add(x); 
	        
		//r.setUsers((Set<User>) listUsersRelationship);
		
		
	        WRelationship r = new WRelationship();
	        r.setWorks(worksInRelationship);
			r.setwRelationshipType(wRelationshipType);
			wRelationshipRepository.save(r);
			return "Saved";
			

	
	}
	
	

	
	@GetMapping(path="/getsingle/{id_work}")
	public @ResponseBody Work getSingleWork(@PathVariable Integer id_work) {
		// This returns a JSON or XML with the users
		
		Work selectedWork = null;
		
		for (Work w : workRepository.findAll()) {
			if (w.getId() == id_work) {
				selectedWork = w;
			}
		}
		
			
		return selectedWork;
	}
	
	
}
