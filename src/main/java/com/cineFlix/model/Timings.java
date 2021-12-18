package com.cineFlix.model;

import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Timings implements Comparable<Timings> {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(targetEntity = Screen.class,cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	private Screen screen;
	
	private Time timing;

	public Timings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Time getTiming() {
		return timing;
	}

	public void setTiming(Time timing) {
		this.timing = timing;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Timings [id=" + id + ", screen=" + screen + ", timing=" + timing + "]";
	}

	@Override
	public int compareTo(Timings o) {
		// TODO Auto-generated method stub
		return this.id-o.id;
	}

	
	
	
}
