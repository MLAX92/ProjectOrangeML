package controleur;

import java.util.ArrayList;

import modele.ModeleIntervention;

public class C_Intervention {
	
	public static void insertIntervention(Intervention uneIntervention)
	{
		ModeleIntervention.insertIntervention(uneIntervention);
	}
	
	public static void deleteIntervention(int idIntervention)
	{
		ModeleIntervention.deleteIntervention(idIntervention);
	}
	
	public static void updateIntervention(Intervention uneIntervention)
	{
		ModeleIntervention.updateIntervention(uneIntervention);
	}
	
	public static  ArrayList<Intervention> selectAllInterventions ()
	{
		return ModeleIntervention.selectAllInterventions(); 
	}
	
	public static Intervention selectWhereIntervention (int idIntervention)
	{
		return ModeleIntervention.selectWhereIntervention(idIntervention); 
	}
}
