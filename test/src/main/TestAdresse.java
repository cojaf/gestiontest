package main;

import pojo.Adresse;
import pojo.Pays;
import hibernate.AdresseDAO;
import hibernate.PaysDAO;

public class TestAdresse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addAdresse();

	}
	public static void addAdresse(){
		PaysDAO daop = new PaysDAO();
		Pays pays = daop.findById(1);
		Adresse adresse = new Adresse();
		adresse.setRue("rue du ");
		adresse.setNumero("3");
		adresse.setVille("Frameries");
		adresse.setCodePostal("7080");
		adresse.setPays(pays);
	
		AdresseDAO dao = new AdresseDAO();
		org.hibernate.Transaction tx = dao.getSession().beginTransaction();
		dao.save(adresse);
		tx.commit();
		dao.getSession().close();
	}
	

}
