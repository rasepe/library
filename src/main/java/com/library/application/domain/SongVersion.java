package com.library.application.domain;

import java.time.YearMonth;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class SongVersion  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
String titleProper;
	
	@ManyToMany(fetch = FetchType.LAZY)  
	private Set<Expression> expressions;
	
	@ManyToOne
	Song song;
	
	int minutes;
	int seconds;
	private int year;
    private String month;
    private YearMonth ym; 
    
    
    
	public SongVersion(Integer id, String titleProper, Set<Expression> expressions, Song song, int minutes, int seconds,
			int year, String month, YearMonth ym) {
		super();
		this.id = id;
		this.titleProper = titleProper;
		this.expressions = expressions;
		this.song = song;
		this.minutes = minutes;
		this.seconds = seconds;
		this.year = year;
		this.month = month;
		this.ym = YearMonth.of(year, Integer.parseInt(month));
	}

	public SongVersion(String titleProper, Set<Expression> expressions, Song song, int minutes, int seconds) {
		super();
		this.titleProper = titleProper;
		this.expressions = expressions;
		this.song = song;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public SongVersion() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitleProper() {
		return titleProper;
	}

	public void setTitleProper(String titleProper) {
		this.titleProper = titleProper;
	}

	public Set<Expression> getExpressions() {
		return expressions;
	}

	public void setExpressions(Set<Expression> expressions) {
		this.expressions = expressions;
	}

	public Song getSong() {
		return song;
	}

	public void setSong(Song song) {
		this.song = song;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	
	
}
