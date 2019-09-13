package controllers;

import java.util.List;

import models.Item;
import models.Marca;
//import models.Status;
import play.mvc.Controller;

public class Itens extends Controller {
	
	public static void form () {
		List<Marca> marcas = Marca.findAll();
		render(marcas);
	}
	
	public static void salvar (Item item) {
		item.save();
		form();
	}
	
	public static void listar () {
		List<Marca> marca = Marca.findAll();
		List<Item> item = Item.findAll();
		render(marca, item);
	}
	
	public static void remover(Long id) {
		Marca marca = Marca.findById(id);
		marca.delete();
		listar();
	}
	
}
