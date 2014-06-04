package main;

import java.util.Date;

import hibernate.AdresseDAO;
import hibernate.MembreDAO;
import hibernate.PaysDAO;
import hibernate.PersonneDAO;
import pojo.Adresse;
import pojo.Membre;
import pojo.Pays;
import pojo.Personne;

public class TestMembre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addMembre();
	}
	public static void addMembre(){
		AdresseDAO daoa = new AdresseDAO();
		Adresse adresse = daoa.findById(2);
		PersonneDAO daop = new PersonneDAO();
		Personne personne = daop.findById(3);
		Membre membre = new Membre(personne.getIdPersonne(),personne,adresse);
		membre.setCourriel("fred@gmail.com");
		membre.setDateNaissance(new Date(1980,12,01));
		membre.setTelephone("09002010");			
		MembreDAO dao = new MembreDAO();
		org.hibernate.Transaction tx = dao.getSession().beginTransaction();
		dao.save(membre);
		tx.commit();
		dao.getSession().close();
	}
	
}
