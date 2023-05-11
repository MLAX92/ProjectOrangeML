package vue;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class PanelPrincipal extends JPanel
{
	public PanelPrincipal(String titre)
	{
		//les caractéristiques communes à tous les panels.
		this.setBackground(new Color(246, 172, 34  ));
		this.setBounds(60, 90, 780, 300);
		this.setLayout(null);
		
		
		JLabel lbTitre = new JLabel(titre); 
		lbTitre.setBounds(280, 20, 200, 20);
		this.add(lbTitre);
		
		this.setVisible(false);
	}
}
