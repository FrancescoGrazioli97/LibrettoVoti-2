package it.polito.tdp.model;

import java.util.*;

public class Libretto {
	
	
	private List<Voto> voti;
	private Map<String,Voto> votiMap; //identity map : nome esame -> oggetto Voto
	
	public Libretto() {
		this.voti = new ArrayList<Voto>();
		this.votiMap = new HashMap<>();
	}
	
	public void add(Voto v) {
		voti.add(v);
		this.votiMap.put(v.getNome(), v);
	}
	
	/*
	public void stampaVotiUguali (int punteggio) {
		// il Libretto stampa da solo i voti
		1 alternativa
		blahhhhhhhh
	}
	
	public String votiUguali(int punteggio) {
		//calcolo una stringa che contiene i voti
		//sara' poi il chiamante a stamparli
		 * 2 alternativca
	}
	*/
	
	public List<Voto> listaVotiUguali (int punteggio){
		//restituisce solo i voti uguali al criterio
		List<Voto> risultato = new ArrayList<Voto>();
		for(Voto v : this.voti) {
			if(v.getVoto()==punteggio) {
				risultato.add(v);
				
			}
		}
		return risultato;
	}
	
	
	public Libretto votiUguali(int punteggio) {
		Libretto risultato = new Libretto();
		for(Voto v : this.voti) {
			if(v.getVoto()==punteggio) {
				risultato.add(v);
				//risultato.voti.add(v);
			}
		}
		return risultato;
	}
	
	
	/**
	 * Ricerca un Voto del corso di cui è specificato il nome
	 * Se il corso non esiste , restituisce null
	 * @param nomeCorso
	 * @return
	 */
	public Voto ricercaCorso(String nomeCorso) {
		/*Voto risultato = null;
		for(Voto v : this.voti) {
			if(v.getNome().equals(nomeCorso)) {
				risultato = v ;
				break;
			}
		}
		return risultato;
		*/
		return this.votiMap.get(nomeCorso);
	}
	
	
	/**
	 * Verifica se nel libretto c'è gia' un voto con lo stesso esame e la
	 * stessa votazione
	 * @param v
	 * @return
	 */
	public boolean esisteDuplicato(Voto v) {
		/*boolean trovato = false;
		for(Voto voto : this.voti) {
			if(voto.getNome().equals(v.getNome()) && voto.getVoto()==v.getVoto()) {
				trovato = true;
				break;
			}
		}
		return trovato;
		*/
		Voto trovato = this.votiMap.get(v.getNome());
		if(trovato == null)
			return false;
		if(trovato.getVoto()==v.getVoto()) {
			return true;
		}
		else
			return false;
		
	}
	
	
	/**
	 * Verifica che nel libretto c'è gia' un voto con lo stesso esame ma
	 * votazione diversa
	 * @param v
	 * @return
	 */
	public boolean esisteConflitto(Voto v) {
		/*boolean trovato = false;
		for(Voto voto : this.voti) {
			if(voto.getNome().equals(v.getNome()) && voto.getVoto()!=v.getVoto()) {
				trovato = true;
				break;
			}
		}
		return trovato;
		*/
		Voto trovato = this.votiMap.get(v.getNome());
		if(trovato == null)
			return false;
		if(trovato.getVoto()!=v.getVoto()) {
			return true;
		}
		else
			return false;
	}
	
	
	public String toString () {
		String s="";
		for(Voto v : this.voti) {
			s = s + v.toString() + "\n";
		}
		return s;
	}
	

}
