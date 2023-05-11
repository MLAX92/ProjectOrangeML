package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.C_Client;
import controleur.Client;

public class PanelClients extends PanelPrincipal implements ActionListener 
{
	private JPanel panelForm = new JPanel(); 
	
	private JTextField txtNom = new JTextField(); 
	private JTextField txtPrenom = new JTextField();
	private JTextField txtAdresse = new JTextField();
	private JTextField txtEmail = new JTextField();
	
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	public PanelClients()
	{
		super ("Gestion des Clients"); 
		this.panelForm.setBounds(20, 50, 300, 250);
		this.panelForm.setBackground(new Color(246, 172, 34  ));
		this.panelForm.setLayout(new GridLayout(5,2));
		this.panelForm.add(new JLabel("Nom Client :")); 
		this.panelForm.add(this.txtNom); 
		this.panelForm.add(new JLabel("Prénom Client :")); 
		this.panelForm.add(this.txtPrenom); 
		this.panelForm.add(new JLabel("Adresse postale :")); 
		this.panelForm.add(this.txtAdresse); 
		this.panelForm.add(new JLabel("Email Client :")); 
		this.panelForm.add(this.txtEmail);
		this.panelForm.add(this.btAnnuler); 
		this.panelForm.add(this.btEnregistrer); 
		this.add(this.panelForm); 
		
		//rendre les boutone ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
	}

	public void viderChamps ()
	{
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtAdresse.setText("");
		this.txtEmail.setText("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == this.btAnnuler)
		 {
			 this.viderChamps (); 
		 }
		 else if (e.getSource() == this.btEnregistrer)
		 {
			 //on récupere les données d'un client et on insère dans la BDD
			 String nom = this.txtNom.getText(); 
			 String prenom = this.txtPrenom.getText(); 
			 String adresse = this.txtAdresse.getText(); 
			 String email = this.txtEmail.getText(); 
			 
			 //instancier un client 
			 Client unClient = new Client(nom, prenom, adresse, email); 
			 //on l'insère dans la BDD via le controleur 
			 C_Client.insertClient(unClient);
			 JOptionPane.showMessageDialog(this, "Insertion réussie du client");
			 this.viderChamps();
		 }
		
	}
}
