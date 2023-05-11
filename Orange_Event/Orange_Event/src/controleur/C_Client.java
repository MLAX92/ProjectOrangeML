package controleur;

import java.util.ArrayList;

import modele.ModeleClient;

public class C_Client {
	
	public static void insertClient(Client unClient)
	{
		ModeleClient.insertClient(unClient);
	}
	public static void deleteClient(int idclient)
	{
		ModeleClient.deleteClient(idclient);
	}
	public static void updateClient(Client unClient)
	{
		ModeleClient.updateClient(unClient);
	}
	public static ArrayList<Client> selectAllClients ()
	{
		return ModeleClient.selectAllClients(); 
	}
	
	public static Client selectWhereClient(int idclient)
	{
		return ModeleClient.selectWhereClient(idclient);
	}
}








