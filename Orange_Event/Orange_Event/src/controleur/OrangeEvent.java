package controleur;

import vue.VueConnexion;
import vue.VueGenerale;

public class OrangeEvent {
	
	private static VueConnexion uneVueConnexion ; 
	private static VueGenerale uneVueGenerale ; 
	
	public static void main(String[] args) {
		 uneVueConnexion = new VueConnexion(); 
	}
	
	public static void rendreVisibleVueConnexion (boolean action)
	{
		uneVueConnexion.setVisible(action);
	}
	public static void rendreVisibleVueGenerale (boolean action)
	{
		if (action == true) {
				uneVueGenerale = new VueGenerale();
		}
		uneVueGenerale.setVisible(action);
		
	}
}
