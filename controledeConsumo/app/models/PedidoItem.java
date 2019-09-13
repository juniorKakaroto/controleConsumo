package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;


@Entity
public class PedidoItem extends Model {

	public Integer quantidade;
	
	@ManyToOne
	public Item item;
	
	@ManyToOne
	public Pedido pedido;
		

}
