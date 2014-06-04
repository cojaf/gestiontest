package ihm;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelFormulaireMembre extends JPanel {
	
		//Initilisation des textfield
		private JTextField jtNom = null;
		private JTextField jtPrenom = null;
		private JTextField jtSexe = null;
		private JTextField jtDateNaissance = null;
		private JTextField jtRue = null;
		private JTextField jtNumero = null;
		private JTextField jtBoite = null;
		private JTextField jtVille = null;		
		private JTextField jtCodePostal = null;
		private JTextField jtConjoint = null;
		private JTextField jtCourriel = null;
		private JTextField jtTelephone = null;
		private JTextField jtPays = null;
		//Declaration des labels associe au fields
		private JLabel labelNom = new JLabel("Nom");
		private JLabel labelPrenom = new JLabel("Prenom") ;
		private JLabel labelSexe = new JLabel("Sexe");
		private JLabel labelDateNaissance = new JLabel("Date de naissance");
		private JLabel labelRue = new JLabel("Rue");
		private JLabel labelNumero = new JLabel("Numero");
		private JLabel labelBoite = new JLabel("Boite");
		private JLabel labelVille = new JLabel("Ville");
		private JLabel labelCodePostal = new JLabel("Code postal");
		private JLabel labelConjoint = new JLabel("Conjoint");
		private JLabel labelCourriel = new JLabel("Courriel");
		private JLabel labelTelephone = new JLabel("Telephone");
		private JLabel labelPays = new JLabel("Pays");
		public PanelFormulaireMembre(){
			

			super();
			build();
		}
		private void build(){
			//defintion des differentes taille
			
			int ecartH = 10;
			int ecartV = 15;
			Dimension dimField = new Dimension(200,20);
			Dimension dimBox = new Dimension(500,20);
			Dimension dimBoxV = new Dimension(500,600);
			//Instanciation des fields et definition d une taille
			jtNom = new JTextField();
			jtNom.setSize(dimField);
			jtPrenom = new JTextField();
			jtPrenom.setSize(dimField);			
			jtSexe = new JTextField();
			jtSexe.setSize(dimField);
			jtDateNaissance = new JTextField();
			jtDateNaissance.setSize(dimField);
			jtRue = new JTextField();
			jtRue.setSize(dimField);
			jtNumero = new JTextField();
			jtNumero.setSize(dimField);
		    jtBoite = new JTextField();
		    jtBoite.setSize(dimField);
			jtVille = new JTextField();
			jtVille.setSize(dimField);	
			jtCodePostal = new JTextField();
			jtCodePostal.setSize(dimField);
			jtConjoint = new JTextField();
			jtConjoint.setSize(dimField);
			jtCourriel = new JTextField();
			jtCourriel.setSize(dimField);
			jtTelephone = new JTextField();
			jtTelephone.setSize(dimField);
			jtPays = new JTextField();
			jtPays.setSize(dimField);
			
			//arrangement horizontal label - field
			Box bNom = Box.createHorizontalBox();
			bNom.setPreferredSize(dimBox);
			bNom.add(labelNom);
			bNom.add(Box.createHorizontalStrut(ecartH));
			bNom.add(jtNom);
			
			Box bPrenom = Box.createHorizontalBox();
			bPrenom.setPreferredSize(dimBox);			
			bPrenom.add(labelPrenom);
			bPrenom.add(Box.createHorizontalStrut(ecartH));
			bPrenom.add(jtPrenom);
			
			Box bSexe = Box.createHorizontalBox();
			bSexe.setPreferredSize(dimBox);
			bSexe.add(labelSexe);
			bSexe.add(Box.createHorizontalStrut(ecartH));
			bSexe.add(jtSexe);
			
			Box bDateNaissance = Box.createHorizontalBox();
			bDateNaissance.setPreferredSize(dimBox);
			bDateNaissance.add(labelDateNaissance);
			bDateNaissance.add(Box.createHorizontalStrut(ecartH));
			bDateNaissance.add(jtDateNaissance);
			
			Box bRue = Box.createHorizontalBox();
			bRue.setPreferredSize(dimBox);
			bRue.add(labelRue);
			bRue.add(Box.createHorizontalStrut(ecartH));
			bRue.add(jtRue);
			
			Box bNumero = Box.createHorizontalBox();
			bNumero.setPreferredSize(dimBox);
			bNumero.add(labelNumero);
			bNumero.add(Box.createHorizontalStrut(ecartH));
			bNumero.add(jtNumero);
			
			Box bBoite = Box.createHorizontalBox();
			bBoite.setPreferredSize(dimBox);
			bBoite.add(labelBoite);
			bBoite.add(Box.createHorizontalStrut(ecartH));
			bBoite.add(jtBoite);
			
			Box bVille = Box.createHorizontalBox();
			bVille.setPreferredSize(dimBox);
			bVille.add(labelVille);
			bVille.add(Box.createHorizontalStrut(ecartH));
			bVille.add(jtVille);
			
			Box bCodePostal = Box.createHorizontalBox();
			bCodePostal.setPreferredSize(dimBox);
			bCodePostal.add(labelCodePostal);
			bCodePostal.add(Box.createHorizontalStrut(ecartH));
			bCodePostal.add(jtCodePostal);
			
			Box bConjoint = Box.createHorizontalBox();
			bConjoint.setPreferredSize(dimBox);
			bConjoint.add(labelConjoint);
			bConjoint.add(Box.createHorizontalStrut(ecartH));
			bConjoint.add(jtConjoint);
			
			Box bCourriel = Box.createHorizontalBox();
			bCourriel.setPreferredSize(dimBox);
			bCourriel.add(labelCourriel);
			bCourriel.add(Box.createHorizontalStrut(ecartH));
			bCourriel.add(jtCourriel);
			
			Box bTelephone = Box.createHorizontalBox();
			bTelephone.setPreferredSize(dimBox);
			bTelephone.add(labelTelephone);
			bTelephone.add(Box.createHorizontalStrut(ecartH));
			bTelephone.add(jtTelephone);
			
			Box bPays = Box.createHorizontalBox();
			bPays.setPreferredSize(dimBox);
			bPays.add(labelPays);
			bPays.add(Box.createHorizontalStrut(ecartH));
			bPays.add(jtPays);
			//arrangement vertical des association label-field
			Box b = Box.createVerticalBox();
			b.setSize(dimBoxV);
			b.add(Box.createVerticalStrut(ecartV));
			b.add(bNom);
			b.add(Box.createVerticalStrut(ecartV));			
			b.add(bPrenom);
			b.add(Box.createVerticalStrut(ecartV));			
			b.add(bSexe);
			b.add(Box.createVerticalStrut(ecartV));
			b.add(bDateNaissance);
			b.add(Box.createVerticalStrut(ecartV));
			b.add(bRue);
			b.add(Box.createVerticalStrut(ecartV));
			b.add(bNumero);
			b.add(Box.createVerticalStrut(ecartV));
			b.add(bBoite);
			b.add(Box.createVerticalStrut(ecartV));
			b.add(bVille);
			b.add(Box.createVerticalStrut(ecartV));
			b.add(bCodePostal);
			b.add(Box.createVerticalStrut(ecartV));
			b.add(bPays);
			b.add(Box.createVerticalStrut(ecartV));
			b.add(bConjoint);
			b.add(Box.createVerticalStrut(ecartV));
			b.add(bTelephone);
			b.add(Box.createVerticalStrut(ecartV));
			b.add(bCourriel);
			b.add(Box.createVerticalStrut(ecartV));
			
			this.add(b);
			
		}
}
