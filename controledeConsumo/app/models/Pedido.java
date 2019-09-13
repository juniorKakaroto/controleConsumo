package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Pedido extends Model {
		
	@ManyToOne
	public Cliente cliente;	
	
	@OneToMany (mappedBy = "pedido", cascade = CascadeType.ALL)
	public List<PedidoItem> pedidoItens;
	

}
