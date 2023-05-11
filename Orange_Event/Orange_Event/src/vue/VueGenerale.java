package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controleur.OrangeEvent;

public class VueGenerale extends JFrame implements ActionListener
{
	private JPanel panelMenu = new JPanel(); 
	private JButton btProfil = new JButton("Profil"); 
	private JButton btClients = new JButton("Clients"); 
	private JButton btTechniciens = new JButton("Techniciens"); 
	private JButton btInterventions = new JButton("Interventions"); 
	private JButton btStats = new JButton("Statistiques"); 
	private JButton btQuitter = new JButton("Quitter"); 
	
	//instanciation des Panels 
	private PanelProfil unPanelProfil = new PanelProfil(); 
	private PanelClients unPanelClients = new PanelClients(); 
	private PanelTechniciens unPanelTechniciens = new PanelTechniciens(); 
	private PanelInterventions unPanelInterventions = new PanelInterventions(); 
	private PanelStats unPanelStats = new PanelStats(); 
	
	public VueGenerale () {
		this.setTitle("Logiciel de gestion des interventions");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(246, 172, 34  ));
		this.setLayout(null);
		this.setBounds(10, 100, 900, 500);
		
		//construction du panel Menu 
		this.panelMenu.setBounds(40, 40, 800, 30);
		this.panelMenu.setBackground(new Color(246, 172, 34  ));
		this.panelMenu.setLayout(new GridLayout(1, 6));
		this.panelMenu.add(this.btProfil);
		this.panelMenu.add(this.btClients);
		this.panelMenu.add(this.btTechniciens);
		this.panelMenu.add(this.btInterventions);
		this.panelMenu.add(this.btStats);
		this.panelMenu.add(this.btQuitter);
		this.add(this.panelMenu); 
		
		//rendre les boutons ecoutables 
		this.btProfil.addActionListener(this);
		this.btClients.addActionListener(this);
		this.btTechniciens.addActionListener(this);
		this.btInterventions.addActionListener(this);
		this.btStats.addActionListener(this);
		this.btQuitter.addActionListener(this);
		
		//ajout des panels dans la fenetre 
		this.add(this.unPanelProfil); 
		this.add(this.unPanelClients); 
		this.add(this.unPanelTechniciens); 
		this.add(this.unPanelInterventions); 
		this.add(this.unPanelStats); 
		
		
		this.setVisible(false);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btQuitter)
		{
			int retour = JOptionPane.showConfirmDialog(this, 
					"Voulez vous quitter l'application !", 
					"Quitter l'application", 
					JOptionPane.YES_NO_OPTION);
			if (retour == 0) {
				this.dispose();
				OrangeEvent.rendreVisibleVueConnexion(true);
			}
		}
		else if (e.getSource() == this.btProfil)
		{
			this.rendreVisible (1); 
		}
		else if (e.getSource() == this.btClients)
		{
			this.rendreVisible (2); 
		}
		else if (e.getSource() == this.btTechniciens)
		{
			this.rendreVisible (3); 
		}
		else if (e.getSource() == this.btInterventions)
		{
			this.rendreVisible (4); 
		}
		else if (e.getSource() == this.btStats)
		{
			this.rendreVisible (5); 
		}
	}
	public void rendreVisible (int numero)
	{
		this.unPanelProfil.setVisible(false);
		this.unPanelClients.setVisible(false);
		this.unPanelTechniciens.setVisible(false);
		this.unPanelInterventions.setVisible(false);
		this.unPanelStats.setVisible(false);
		switch (numero)
		{
		case 1 : this.unPanelProfil.setVisible(true); break;
		case 2 : this.unPanelClients.setVisible(true); break;
		case 3 : this.unPanelTechniciens.setVisible(true); break;
		case 4 : this.unPanelInterventions.setVisible(true); break;
		case 5 : this.unPanelStats.setVisible(true); break;
		}
		
	}
}
