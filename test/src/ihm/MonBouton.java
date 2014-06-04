package ihm;

import javax.swing.JButton;

import outils.Param;

public class MonBouton extends JButton {
	public MonBouton(){}
	public MonBouton(String nom){
		super(nom);
		build();
	}
	private void build(){
		this.setMinimumSize(Param.DIM_BOUTON);
		this.setMaximumSize(Param.DIM_BOUTON);

	}
}
