package com.cineFlix.model;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.Sort;

@Entity
public class Screen implements Comparable<Screen>{
	
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne()
	private Theatre theatre;
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	private String screenName;
	private int totalRows;
	private int totalColumns;
	private int budgetRows;
	@OneToMany(mappedBy="screen",cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	@OrderBy
	private SortedSet<ShowTable> shows;
	public Screen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getTotalColumns() {
		return totalColumns;
	}
	public void setTotalColumns(int totalColumns) {
		this.totalColumns = totalColumns;
	}
	public int getBudgetRows() {
		return budgetRows;
	}
	public void setBudgetRows(int budgetRows) {
		this.budgetRows = budgetRows;
	}
	public SortedSet<ShowTable> getShows() {
		return shows;
	}
	public void setShows(SortedSet<ShowTable> shows) {
		this.shows = shows;
	}
	
	@Override
	public String toString() {
		return "Screen [id=" + id +  ", screenName=" + screenName + ", totalRows=" + totalRows
				+ ", totalColumns=" + totalColumns + ", budgetRows=" + budgetRows +  "]";
	}
	@Override
	public int compareTo(Screen o) {
		return this.id-o.id;
	}

}
