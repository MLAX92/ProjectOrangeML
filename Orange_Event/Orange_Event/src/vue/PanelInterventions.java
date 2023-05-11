package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.C_Client;
import controleur.C_Intervention;
import controleur.C_Technicien;
import controleur.Client;
import controleur.Intervention;
import controleur.Technicien;

public class PanelInterventions extends PanelPrincipal implements ActionListener
{
	private JPanel panelForm = new JPanel(); 
	
	private JTextField txtMateriel = new JTextField(); 
	private JTextField txtPanne = new JTextField();
	private JTextField txtDateinter = new JTextField();
	private JTextField txtPrix = new JTextField();
	//des selects pour choisir un id client et un id technicien parmi ceux de la BDD 
	private JComboBox<String> cbxIdclient = new JComboBox<String>(); 
	private JComboBox<String> cbxIdtechnicien = new JComboBox<String>(); 
	
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	public PanelInterventions()
	{
		super ("Gestion des Interventions"); 
		this.panelForm.setBounds(20, 50, 300, 250);
		this.panelForm.setBackground(new Color(246, 172, 34  ));
		this.panelForm.setLayout(new GridLayout(7,2));
		this.panelForm.add(new JLabel("Le Matériel:")); 
		this.panelForm.add(this.txtMateriel); 
		this.panelForm.add(new JLabel("La panne constatée :")); 
		this.panelForm.add(this.txtPanne); 
		this.panelForm.add(new JLabel("Date Intervention :")); 
		this.panelForm.add(this.txtDateinter); 
		this.panelForm.add(new JLabel("Le prix :")); 
		this.panelForm.add(this.txtPrix);
		this.panelForm.add(new JLabel("Le Client:")); 
		this.panelForm.add(this.cbxIdclient);
		this.panelForm.add(new JLabel("Le Technicien:")); 
		this.panelForm.add(this.cbxIdtechnicien);
		this.panelForm.add(this.btAnnuler); 
		this.panelForm.add(this.btEnregistrer); 
		this.add(this.panelForm); 
		
		//remplir les CBX ID client et ID technicien 
		this.remplirCBX (); 
		
		//rendre les boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
	}
	
	public void remplirCBX ()
	{
		//vider le CBX ID Client
		this.cbxIdclient.removeAllItems();
		//récupérer les clients de la BDD 
		ArrayList<Client> lesClients = C_Client.selectAllClients();
		//on parcourt les clients et on remplit le CBX par les ID 
		for (Client unClient : lesClients)
		{
			this.cbxIdclient.addItem(unClient.getIdclient()+"-"+unClient.getNom());
		}
		
		//vider le CBX ID Technicien
		this.cbxIdtechnicien.removeAllItems();
		//récupérer les techniciens de la BDD 
		ArrayList<Technicien> lesTechniciens = C_Technicien.selectAllTechniciens();
		//on parcourt les clients et on remplit le CBX par les ID 
		for (Technicien unTechnicien : lesTechniciens)
		{
			this.cbxIdtechnicien.addItem(unTechnicien.getIdtechnicien()+"-"+unTechnicien.getNom());
		}
	}

	public void viderChamps ()
	{
		this.txtMateriel.setText("");
		this.txtPanne.setText("");
		this.txtDateinter.setText("");
		this.txtPrix.setText("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler)
		{
			this.viderChamps(); 
		}
		else if (e.getSource() == this.btEnregistrer)
		{
			String materiel = this.txtMateriel.getText(); 
			String panne = this.txtPanne.getText();
			String dateinter = this.txtDateinter.getText();
			float prix = Float.parseFloat(this.txtPrix.getText()); //conversion de type 
			
			String chaine = this.cbxIdclient.getSelectedItem().toString(); 
			String tab[] = chaine.split("-"); 
			int idclient = Integer.parseInt(tab[0]);
			
			chaine = this.cbxIdtechnicien.getSelectedItem().toString(); 
			tab = chaine.split("-"); 
			int idtechnicien = Integer.parseInt(tab[0]);
			
			//instancier une intervention 
			Intervention uneIntervention = new Intervention(materiel, panne, dateinter, prix, idclient, idtechnicien);
			
			//insertion de l'intervention dans la base de données 
			C_Intervention.insertIntervention(uneIntervention);
			
			JOptionPane.showMessageDialog(this, "Insertion réussie de l'intervention dans la base de données");
			this.viderChamps();
		}
		
	}

}













