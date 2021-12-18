package com.cineFlix.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class ShowTable implements Comparable<ShowTable>{

	@Id
	private String showId;
	@ManyToOne(targetEntity = Screen.class,fetch = FetchType.EAGER)
	private Screen screen;
	private Date showDate;
	private Time showTime;
	private String movieName;



	public String getShowId() {
		return showId;
	}

	public void setShowId( ) {
		this.showId =String.valueOf(this.screen.getId()) +"_"+this.getShowDate().toString()+"_"+this.getShowTime().toString().replace("-", "");
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public Time getShowTime() {
		return showTime;
	}

	public void setShowTime(Time showTime) {
		this.showTime = showTime;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	@Override
	public String toString() {
		return "Show [showId=" + showId  + ", showDate=" + showDate + ", showTime=" + showTime
				+ ", movieName=" + movieName + "]";
	}

	@Override
	public int compareTo(ShowTable o) {
		// TODO Auto-generated method stub
		if(this.showId==o.showId)
		{
			if(!this.equals(o))
				return 1;
		}
			
		return this.getShowId().compareTo(o.getShowId());
	}

}
