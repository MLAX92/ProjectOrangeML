package controleur;

public class Intervention {
	private int idinter ; 
	private String materiel, panne, dateinter ; 
	private float prix ; 
	private int idclient, idtechnicien ;
	public Intervention(int idinter, String materiel, String panne, String dateinter, float prix, int idclient,
			int idtechnicien) {
		
		this.idinter = idinter;
		this.materiel = materiel;
		this.panne = panne;
		this.dateinter = dateinter;
		this.prix = prix;
		this.idclient = idclient;
		this.idtechnicien = idtechnicien;
	} 
	public Intervention(String materiel, String panne, String dateinter, float prix, int idclient,
			int idtechnicien) {
		
		this.idinter = 0;
		this.materiel = materiel;
		this.panne = panne;
		this.dateinter = dateinter;
		this.prix = prix;
		this.idclient = idclient;
		this.idtechnicien = idtechnicien;
	} 
	public Intervention() {
		
		this.idinter = 0;
		this.materiel = "";
		this.panne = "";
		this.dateinter = "";
		this.prix = 0;
		this.idclient = 0;
		this.idtechnicien = 0;
	}
	
	public int getIdinter() {
		return idinter;
	}
	public void setIdinter(int idinter) {
		this.idinter = idinter;
	}
	public String getMateriel() {
		return materiel;
	}
	public void setMateriel(String materiel) {
		this.materiel = materiel;
	}
	public String getPanne() {
		return panne;
	}
	public void setPanne(String panne) {
		this.panne = panne;
	}
	public String getDateinter() {
		return dateinter;
	}
	public void setDateinter(String dateinter) {
		this.dateinter = dateinter;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getIdclient() {
		return idclient;
	}
	public void setIdclient(int idclient) {
		this.idclient = idclient;
	}
	public int getIdtechnicien() {
		return idtechnicien;
	}
	public void setIdtechnicien(int idtechnicien) {
		this.idtechnicien = idtechnicien;
	} 
	
	
}
