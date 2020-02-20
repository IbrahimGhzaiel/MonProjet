package fr.eni_ecole.jee.bean;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="stagiaire")
public class Stagiaire extends Utilisateur {

	private static final long serialVersionUID = 1L;
	
	public Stagiaire(){
		super();
	}

	public Stagiaire(int id, String nom, String prenom, String motDePasse, String email) {
		super(id, nom, prenom, motDePasse, email);
	}	

	public Stagiaire(int id) {
		super(id);
	}
}
