package it.polito.tdp.model;

import java.time.LocalDate;


//POJO - Plain Old Java Objext
// Java Bean
// Semplice contenitore di dati -- non ha "logica"

/**
 * Memorizza il riultato di un esame singolo
 * 
 * @author Francesco
 *
 */

public class Voto {
	
	private String nome;
	private int voto; //30L come lo rappresento?
	private LocalDate data; //data superamento esame
	
	/**
	 * Costruttore della classe Voto
	 * @param nome Nome del corso superato
	 * @param voto Voto ottenuto
	 * @param data Data di superamento
	 */
	
	
	
	public Voto(String nome, int voto, LocalDate data) {
		this.nome = nome;
		this.voto = voto;
		this.data = data;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}



	@Override
	public String toString() {
		return "Esame " + nome + " superato con " + voto + " il " + data;
	}
	
	
	
	
	
	
	
	
	

}
