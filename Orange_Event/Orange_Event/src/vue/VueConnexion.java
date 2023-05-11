package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.C_Technicien;
import controleur.OrangeEvent;
import controleur.Technicien;

public class VueConnexion extends JFrame implements ActionListener, KeyListener
{
	private JTextField txtEmail = new JTextField(); 
	private JPasswordField txtMdp = new JPasswordField(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btSeConnecter = new JButton("Se Connecter");
	
	private JPanel panelConnexion = new JPanel(); 
	
	private static Technicien unTechnicien = null; 
	
	public static Technicien getTechnicien()
	{
		return unTechnicien; 
	}
	
	public VueConnexion()
	{
		this.setTitle("Logiciel de gestion des interventions");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(246, 172, 34  ));
		this.setLayout(null);
		this.setBounds(100, 100, 600, 300);
		
		//construction du panel Connexion 
		this.panelConnexion.setBackground(new Color(246, 172, 34  ));
		this.panelConnexion.setBounds(250, 60, 340, 160);
		this.panelConnexion.setLayout(new GridLayout(3,2));
		
		this.panelConnexion.add(new JLabel("Email : ")); 
		this.panelConnexion.add(this.txtEmail); 
		this.panelConnexion.add(new JLabel("MDP : ")); 
		this.panelConnexion.add(this.txtMdp);
		this.panelConnexion.add(this.btAnnuler); 
		this.panelConnexion.add(this.btSeConnecter);
		
		this.add(this.panelConnexion); 
		
		//ajout du logo dans la vue 
		ImageIcon uneImage = new ImageIcon("src/images/logo.png");
		JLabel lbImage = new JLabel(uneImage); 
		lbImage.setBounds(20, 20, 200, 220);
		this.add(lbImage); 
		
		//rendre les deux boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		
		//rendre les txt email et mdp ecoutables 
		this.txtEmail.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == this.btAnnuler)
		 {
			 this.txtEmail.setText(""); 
			 this.txtMdp.setText("");
		 }
		 else if (e.getSource() == this.btSeConnecter)
		 {
			 this.traitement (); 
		 }
	}
	
	public void traitement ()
	{
		String email = this.txtEmail.getText(); 
		 String mdp = new String (this.txtMdp.getPassword()); 
		 
		 //on vérifie dans la base de données la présence d'un technicien 
		 unTechnicien = C_Technicien.selectWhereTechnicien(email, mdp); 
		 if( unTechnicien == null) {
			 JOptionPane.showMessageDialog(this, 
					 "Veuillez vérifier vos identifiants !");
		 }else {
			 JOptionPane.showMessageDialog(this, 
					 "Bienvenue M./MM "+unTechnicien.getNom()+"  "
					 + unTechnicien.getPrenom());
			 
			 //on rend la vue connexion en false 
			 // et la vue generale en true 
			 OrangeEvent.rendreVisibleVueConnexion(false);
			 OrangeEvent.rendreVisibleVueGenerale(true);
		 }
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//sur frappe de la touche enter 
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			this.traitement (); 
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}













