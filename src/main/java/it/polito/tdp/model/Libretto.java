package it.polito.tdp.model;

import java.util.*;

public class Libretto {
	
	
	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<Voto>();
		
	}
	
	public void add(Voto v) {
		voti.add(v);
	}
	
	
	public String toString () {
		String s="";
		for(Voto v : this.voti) {
			s = s + v.toString() + "\n";
		}
		return s;
	}
	
	
	
	
	
	
	
	
	
	
	

}
