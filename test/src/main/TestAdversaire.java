package main;

import pojo.Adversaire;
import pojo.Personne;
import hibernate.AdversaireDAO;
import hibernate.PersonneDAO;

public class TestAdversaire {

	public TestAdversaire() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addAdversaire();

	}
	private static void listPersonne() {
		PersonneDAO dao = new PersonneDAO();
		Personne personne = dao.findById(1);
		System.out.println(personne.toString());
		dao.getSession().close();
	}
	private static void addPersonne(){

		Personne personne = new Personne();
		//personne.setIdPersonne(1);
		personne.setNom("Gad");
		personne.setPrenom("Bonne");
		personne.setSexe(true);
		
		PersonneDAO dao = new PersonneDAO();
		org.hibernate.Transaction tx = dao.getSession().beginTransaction();
		dao.save(personne);
		tx.commit();
		dao.getSession().close();
		
	}
	private static void addAdversaire(){

		PersonneDAO daop = new PersonneDAO();
		Personne personne = daop.findById(9);
		Adversaire adversaire = new Adversaire();
		adversaire.setIdAdversaire(personne.getIdPersonne());
		adversaire.setPersonne(personne);
		adversaire.setNumeroLigue("30011130");
		AdversaireDAO dao = new AdversaireDAO();
		org.hibernate.Transaction tx = dao.getSession().beginTransaction();
		dao.save(adversaire);
		tx.commit();
		dao.getSession().close();
	}

}
