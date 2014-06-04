package ihm;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOuest extends JPanel{
	private JButton boutonMembre = null;
	private JButton boutonSalle = null;
	private JButton boutonInterclub = null;
	private JButton boutonOperation = null;
	public PanelOuest(){
		super();
		build();
	}
	private void build(){
		final int ecartV = 100;
		boutonMembre = new MonBouton("Membre");
		boutonSalle = new MonBouton("Salle");
		boutonInterclub = new MonBouton("Interclubs");
		boutonOperation = new MonBouton("Operation");
		Box b = Box.createVerticalBox();
		b.add(Box.createVerticalStrut(ecartV/2));
		b.add(boutonMembre);
		b.add(Box.createVerticalStrut(ecartV));
		b.add(boutonSalle);
		b.add(Box.createVerticalStrut(ecartV));
		b.add(boutonOperation);
		b.add(Box.createVerticalStrut(ecartV));
		b.add(boutonInterclub);
		this.add(b);
		
	}
}
