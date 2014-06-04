package ihm;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

import outils.Param;

public class FenetreP extends JFrame {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreP frame = new FenetreP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private PanelOuest panelOuest = null;
	private PanelFormulaireMembre panelFormulaire = null;
	public FenetreP(){
		super();
		build();
	}	
	private void build(){
		this.setTitle(Param.TITRE_PRINCIPAL);
		this.setPreferredSize(Param.DIM_FENETREPRINCIPALE);
		panelOuest = new PanelOuest();
		this.setLayout(new BorderLayout());
		this.getContentPane().add(panelOuest,BorderLayout.WEST);
		panelFormulaire = new PanelFormulaireMembre();
		this.getContentPane().add(panelFormulaire,BorderLayout.CENTER);
		this.setVisible(true);
		this.pack();
		
	}
}
