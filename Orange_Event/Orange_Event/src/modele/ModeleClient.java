package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Client;

public class ModeleClient {
private static Bdd uneBdd = new Bdd ("localhost:8889","orange_event_2b_23","root","root");
	
	public static void insertClient(Client unClient)
	{
		String requete ="insert into client values (null,'"
				+ unClient.getNom()+"','"+unClient.getPrenom()+"','"
				+unClient.getAdresse()+"','"+unClient.getEmail()+"');";
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
	public static ArrayList<Client> selectAllClients ()
	{
		ArrayList <Client> lesClients = new ArrayList<Client>(); 
		String requete ="select * from client ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			//parcourir ces résultats et construire des instances clients
			while (desResultats.next())
			{
				//instanciation de la classe Client
				Client unClient = new Client (
						desResultats.getInt("idclient"), 
						desResultats.getString("nom"), 
						desResultats.getString("prenom"), 
						desResultats.getString("adresse"), 
						desResultats.getString("email") 
						);
				//on insere le client dans lesClients 
				lesClients.add(unClient);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : "+requete);
		}
		return lesClients;
	}
	public static void deleteClient(int idclient)
	{
		String requete ="delete from client where idclient = " + idclient +";";
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
	
	public static void updateClient(Client unClient)
	{
		String requete ="update client set nom = '"
				+ unClient.getNom() + "', prenom='"
				+ unClient.getPrenom() + "', adresse = '"
				+ unClient.getAdresse() + "',email = '"
				+ unClient.getEmail() + "' where idclient ="
				+ unClient.getIdclient() + ";";
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
	
	public static  Client selectWhereClient (int idclient)
	{
		Client unClient = null; 
		String requete ="select * from client where idclient = "+idclient+ ";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			//tester le resultat construire des instances clients
			if (unResultat.next())
			{
				//instanciation de la classe Client
				 unClient = new Client (
						unResultat.getInt("idclient"), 
						unResultat.getString("nom"), 
						unResultat.getString("prenom"), 
						unResultat.getString("adresse"), 
						unResultat.getString("email") 
						);
			}
			unStat.close();
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : "+requete);
		}
		return unClient;
	}
	
}






















