package main;

import pojo.Pays;
import hibernate.PaysDAO;


public class TesterPays {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addPays();
	}
	private static void addPays(){

		Pays pays = new Pays();
		pays.setNomPays("Espagne");
		pays.setCodePays("E");
		PaysDAO dao = new PaysDAO();
		org.hibernate.Transaction tx = dao.getSession().beginTransaction();
		dao.save(pays);
		tx.commit();
		dao.getSession().close();
		
	}

}
