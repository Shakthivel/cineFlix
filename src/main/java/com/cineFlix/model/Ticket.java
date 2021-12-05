package com.cineFlix.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ticket implements Comparable<Ticket> {

	@Id
	private int userId;
	private int noOfSeats;
	private String movieName;
	private String theatreName;
	private String screenName;
	private Date showDate;
	private Time showTiming;
	private int seatNumber;

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public Time getShowTiming() {
		return showTiming;
	}

	public void setShowTiming(Time showTiming) {
		this.showTiming = showTiming;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	@Override
	public String toString() {
		return "TicketDTO [userId=" + userId + ", noOfSeats=" + noOfSeats + ", movieName=" + movieName
				+ ", theatreName=" + theatreName + ", screenName=" + screenName + ", showDate=" + showDate
				+ ", showTiming=" + showTiming + ", seatNumber=" + seatNumber + "]";
	}

	@Override
	public int compareTo(Ticket o) {
		return 0;
	}

}
