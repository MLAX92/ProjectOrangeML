package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Intervention;

public class ModeleIntervention {
private static Bdd uneBdd = new Bdd ("localhost:8889","orange_Event_2B_23","root","root");
	
	public static void insertIntervention(Intervention unIntervention)
	{
		String requete ="insert into Intervention values (null,'"
				+ unIntervention.getMateriel()+"','"+unIntervention.getPanne()+"','"
				+unIntervention.getDateinter()+"','"+unIntervention.getPrix()+"','"
				+unIntervention.getIdclient()+"','"+unIntervention.getIdtechnicien()+"');";
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
			exp.printStackTrace();
		}
	}
	public static ArrayList<Intervention> selectAllInterventions ()
	{
		ArrayList <Intervention> lesInterventions = new ArrayList<Intervention>(); 
		String requete ="select * from Intervention ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			//parcourir ces résultats et construire des instances Interventions
			while (desResultats.next())
			{
				//instanciation de la classe Intervention
				Intervention unIntervention = new Intervention (
						desResultats.getInt("idintervention"), 
						desResultats.getString("materiel"), 
						desResultats.getString("panne"), 
						desResultats.getString("dateinter"), 
						desResultats.getFloat("prix"),
						desResultats.getInt("idclient"),
						desResultats.getInt("idtechnicien")
						);
				//on insere le Intervention dans lesInterventions 
				lesInterventions.add(unIntervention);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : "+requete);
		}
		return lesInterventions;
	}
	public static void deleteIntervention(int idIntervention)
	{
		String requete ="delete from Intervention where idinter = " + idIntervention +";";
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
	
	public static void updateIntervention(Intervention unIntervention)
	{
		String requete ="update Intervention set materiel = '"
				+ unIntervention.getMateriel() + "', panne='"
				+ unIntervention.getPanne() + "', dateinter = '"
				+ unIntervention.getDateinter() + "',prix = '"
				+ unIntervention.getPrix() + "' where idinter ="
				+ unIntervention.getIdinter() + ";";
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
	
	public static  Intervention selectWhereIntervention (int idIntervention)
	{
		Intervention unIntervention = null; 
		String requete ="select * from Intervention where idinter = "+idIntervention+ ";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			//tester le resultat construire des instances Interventions
			if (unResultat.next())
			{
				//instanciation de la classe Intervention
				 unIntervention = new Intervention (
						unResultat.getInt("idinter"), 
						unResultat.getString("materiel"), 
						unResultat.getString("panne"), 
						unResultat.getString("dateinter"), 
						unResultat.getFloat("prix"),
						unResultat.getInt("idclient"),
						unResultat.getInt("idtechnicien")
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : "+requete);
		}
		return unIntervention;
	}
	

}
