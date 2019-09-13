package jobs;

import javax.persistence.ManyToOne;

import models.Cliente;
import models.Item;
import models.Marca;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {

	@Override
	public void doJob() throws Exception {
		if (Marca.count() == 0) {
			
			Marca brahma = new Marca();
			brahma.nome = "Brahma";		
			brahma.save();
			
			Marca skol = new Marca();
			skol.nome = "Skol";
			skol.save();
			
			Marca itaipava = new Marca();
			itaipava.nome = "Itaipava";
			itaipava.save();
		}
		
		if (Item.count() == 0) {
			
			Item item1 = new Item();
			item1.nome = "Cerveja 1";
			item1.preco = 10.00;
			item1.quantidade = "1";
			item1.save();
			
			Item item2 = new Item();
			item2.nome = "Cerveja 2";
			item2.preco = 10.00;
			item2.quantidade = "1";
			item2.save();
			
			Item item3 = new Item();
			item3.nome = "Cerveja 3";
			item3.preco = 10.00;
			item3.quantidade = "1";
			item3.save();
	
		}
		
		if (Cliente.count() == 0) {
			
			Cliente c1 = new Cliente();
			c1.nome = "Rodrigo";	
			c1.documento = "99999999999";
			c1.pulseira = "123";
			c1.save();
			
			Cliente c2 = new Cliente();
			c2.nome = "Fco Junior";	
			c2.documento = "00000000000";
			c2.pulseira = "456";
			c2.save();
			
			Cliente c3 = new Cliente();
			c3.nome = "Petinho";	
			c3.documento = "33333333300";
			c3.pulseira = "222";
			c3.save();

			Cliente c4 = new Cliente();
			c4.nome = "Manacio";	
			c4.documento = "11111111100";
			c4.pulseira = "789";
			c4.save();
			
			Cliente c5 = new Cliente();
			c5.nome = "Magdiel";	
			c5.documento = "22222222200";
			c5.pulseira = "111";
			c5.save();

		}
	
	}
}

