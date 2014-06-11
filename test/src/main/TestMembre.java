package main;

import hibernate.AdresseDAO;
import hibernate.MembreDAO;
import hibernate.PersonneDAO;

import java.util.Date;

import org.hibernate.Transaction;

import pojo.Adresse;
import pojo.Membre;
import pojo.Personne;

public class TestMembre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addMembre();
	}
	public static void addMembre(){
		AdresseDAO daoa = new AdresseDAO();
		Adresse adresse = daoa.findById(1);
		PersonneDAO daop = new PersonneDAO();
		Personne personne = daop.findById(2);
		Membre membre = new Membre(personne.getIdPersonne(),personne,adresse);
		membre.setCourriel("coja@gmail.com");
		membre.setDateNaissance(new Date(1980,12,01));
		membre.setTelephone("0473546022");			
		MembreDAO dao = new MembreDAO();
		Transaction tx = dao.getSession().beginTransaction();
		dao.save(membre);
		tx.commit();
		dao.getSession().close();
	}
	
}
