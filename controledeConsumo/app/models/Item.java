package models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import play.db.jpa.Model;

@Entity
public class Item extends Model {
	
	public String nome;
	public Double preco;
	public String quantidade;
	
	@ManyToOne
	public Marca marca;
	

	
}
