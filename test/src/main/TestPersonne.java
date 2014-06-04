package main;

import pojo.Personne;
import hibernate.PersonneDAO;

public class TestPersonne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addPersonne();
		listPersonne();
		

	}
	private static void listPersonne() {
		PersonneDAO dao = new PersonneDAO();
		Personne personne = dao.findById(1);
		System.out.println(personne.toString());
		dao.getSession().close();
	}
	private static void addPersonne(){

		Personne personne = new Personne();
		personne.setNom("Carlier");
		personne.setPrenom("Christine");
		personne.setSexe(true);		
		PersonneDAO dao = new PersonneDAO();
		org.hibernate.Transaction tx = dao.getSession().beginTransaction();
		dao.save(personne);
		tx.commit();
		dao.getSession().close();
		
	}


}
