package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controleur.C_Technicien;
import controleur.Technicien;

public class PanelProfil extends PanelPrincipal implements ActionListener
{
	private Technicien unTechnicien ;
	private JTextArea txtInfos = new JTextArea(); 
	private JButton btModifier = new JButton("Modifier");
	
	private JPanel panelForm = new JPanel(); 
	
	private JTextField txtNom = new JTextField(); 
	private JTextField txtPrenom = new JTextField();
	private JTextField txtQualification = new JTextField();
	private JTextField txtEmail = new JTextField();
	private JPasswordField txtMdp = new JPasswordField(); 
	
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	public PanelProfil()
	{
		super ("Mon Profil"); 
		
		//récupérer le technicien connecté à partir de la vueConnexion 
		this.unTechnicien = VueConnexion.getTechnicien();
		//afficher les infos du technicien : le profil 
		this.txtInfos.setText(
				"\n ________________ Infos Profil ____________\n\n"
				+"Nom du Technicien    : " + this.unTechnicien.getNom()+"\n\n"
				+"Prénom du Technicien : " + this.unTechnicien.getPrenom()+"\n\n"
				+"Qualification        : " + this.unTechnicien.getQualification()+"\n\n"
				+"Email du Technicien  : " + this.unTechnicien.getEmail()+"\n\n"
				);
		this.txtInfos.setBounds(20, 50, 300, 200);
	
		this.txtInfos.setBackground(new Color(246, 172, 34  ));
		this.add(this.txtInfos);
		
		this.btModifier.setBounds(80, 270, 100, 20);
		this.add(this.btModifier); 
		
		this.panelForm.setBounds(350, 50, 300, 250);
		this.panelForm.setBackground(new Color(246, 172, 34  ));
		this.panelForm.setLayout(new GridLayout(6,2));
		this.panelForm.add(new JLabel("Nom Technicien :")); 
		this.panelForm.add(this.txtNom); 
		this.panelForm.add(new JLabel("Prénom Technicien :")); 
		this.panelForm.add(this.txtPrenom); 
		this.panelForm.add(new JLabel("Qualification :")); 
		this.panelForm.add(this.txtQualification); 
		this.panelForm.add(new JLabel("Email Technicien :")); 
		this.panelForm.add(this.txtEmail);
		this.panelForm.add(new JLabel("MDP Technicien :")); 
		this.panelForm.add(this.txtMdp);
		this.panelForm.add(this.btAnnuler); 
		this.panelForm.add(this.btEnregistrer); 
		this.add(this.panelForm); 
		this.panelForm.setVisible(false);
		
		//remplir les champs texte à modifier 
		this.txtNom.setText(this.unTechnicien.getNom());
		this.txtPrenom.setText(this.unTechnicien.getPrenom());
		this.txtQualification.setText(this.unTechnicien.getQualification());
		this.txtEmail.setText(this.unTechnicien.getEmail());
		
		//rendre les boutons ecoutables 
		this.btModifier.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
	}
	public void viderChamps ()
	{
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtQualification.setText("");
		this.txtEmail.setText("");
		this.txtMdp.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == this.btModifier)
		 {
			 if (this.panelForm.isVisible())
			 {
				 this.panelForm.setVisible(false);
			 }else {
				 this.panelForm.setVisible(true);
			 }
		 }
		 else if(e.getSource() == this.btAnnuler)
		 {
			 this.viderChamps (); 
		 }
		 else if (e.getSource() == this.btEnregistrer)
		 {
			 String nom = this.txtNom.getText(); 
			 String prenom = this.txtPrenom.getText(); 
			 String qualification = this.txtQualification.getText(); 
			 String email = this.txtEmail.getText(); 
			 String mdp = new String (this.txtMdp.getPassword()); 
			 
			 //instancier la classe technicien avec son ID technicien
			 this.unTechnicien = new Technicien (this.unTechnicien.getIdtechnicien(), nom, prenom, qualification,email, mdp); 
			 
			 //update du technicien dans la base de données 
			 C_Technicien.updateTechnicien(unTechnicien);
			 
			 JOptionPane.showMessageDialog(this, "Mise à jour réussie du technicien dans la base de données");
			 //mise à jour de TextArea avec les nouvelles données 
			 this.txtInfos.setText(
						"\n ________________ Infos Profil ____________\n\n"
						+"Nom du Technicien    : " + this.unTechnicien.getNom()+"\n\n"
						+"Prénom du Technicien : " + this.unTechnicien.getPrenom()+"\n\n"
						+"Qualification        : " + this.unTechnicien.getQualification()+"\n\n"
						+"Email du Technicien  : " + this.unTechnicien.getEmail()+"\n\n"
						);
		 }
		
	}
}






