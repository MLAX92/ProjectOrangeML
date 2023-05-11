package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Technicien;

public class ModeleTechnicien {
private static Bdd uneBdd = new Bdd ("localhost:8889","orange_event_2B_23","root","root");
	
	public static void insertTechnicien(Technicien unTechnicien)
	{
		String requete ="insert into Technicien values (null,'"
				+ unTechnicien.getNom()+"','"+unTechnicien.getPrenom()+"','"
				+unTechnicien.getQualification()+"','"+unTechnicien.getEmail()
				+"','" + unTechnicien.getMdp()+"');";
		try {
			uneBdd.seConnecter();
			//on instancie un curseur qui permet d'executer la requete
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur de requete : "+requete);
		}
	}
	public static ArrayList<Technicien> selectAllTechniciens ()
	{
		ArrayList <Technicien> lesTechniciens = new ArrayList<Technicien>(); 
		String requete ="select * from Technicien ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			//parcourir ces résultats et construire des instances Techniciens
			while (desResultats.next())
			{
				//instanciation de la classe Technicien
				Technicien unTechnicien = new Technicien (
						desResultats.getInt("idtechnicien"), 
						desResultats.getString("nom"), 
						desResultats.getString("prenom"), 
						desResultats.getString("qualification"), 
						desResultats.getString("email"), 
						desResultats.getString("mdp")
						);
				//on insere le Technicien dans lesTechniciens 
				lesTechniciens.add(unTechnicien);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : "+requete);
		}
		return lesTechniciens;
	}
	public static void deleteTechnicien(int idTechnicien)
	{
		String requete ="delete from Technicien where idTechnicien = " + idTechnicien +";";
		try {
			uneBdd.seConnecter();
			//on instancie un curseur qui permet d'executer la requete
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur de requete : "+requete);
		}
	}
	
	public static void updateTechnicien(Technicien unTechnicien)
	{
		String requete ="update Technicien set nom = '"
				+ unTechnicien.getNom() + "', prenom='"
				+ unTechnicien.getPrenom() + "', qualification = '"
				+ unTechnicien.getQualification() + "',email = '"
				+ unTechnicien.getEmail() + "', mdp = '"
				+ unTechnicien.getMdp()
				+ "' where idtechnicien ="
				+ unTechnicien.getIdtechnicien() + ";";
		try {
			uneBdd.seConnecter();
			//on instancie un curseur qui permet d'executer la requete
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete); 
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur de requete : "+requete);
		}
	}
	
	public static  Technicien selectWhereTechnicien (int idTechnicien)
	{
		Technicien unTechnicien = null; 
		String requete ="select * from Technicien where idTechnicien = "+idTechnicien+ ";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			//tester le resultat construire des instances Techniciens
			if (unResultat.next())
			{
				//instanciation de la classe Technicien
				 unTechnicien = new Technicien (
						unResultat.getInt("idtechnicien"), 
						unResultat.getString("nom"), 
						unResultat.getString("prenom"), 
						unResultat.getString("qualification"), 
						unResultat.getString("email") ,
						unResultat.getString("mdp")
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : "+requete);
		}
		return unTechnicien;
	}
	public static  Technicien selectWhereTechnicien (String email, String mdp)
	{
		Technicien unTechnicien = null; 
		String requete ="select * from Technicien where email ='"+email+"' and mdp='"+mdp+"';";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			//tester le resultat construire des instances Techniciens
			if (unResultat.next())
			{
				//instanciation de la classe Technicien
				 unTechnicien = new Technicien (
						unResultat.getInt("idTechnicien"), 
						unResultat.getString("nom"), 
						unResultat.getString("prenom"), 
						unResultat.getString("qualification"), 
						unResultat.getString("email") ,
						unResultat.getString("mdp")
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : "+requete);
		}
		return unTechnicien;
	}
}
