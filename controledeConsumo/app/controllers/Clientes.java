package controllers;

import java.util.List;

import models.Cliente;
import play.mvc.Controller;

public class Clientes extends Controller {
	public static void form() {
		render();
	}

	public static void cadastrar(Cliente cad) {
		cad.save();
		flash.success("Cliente salvo com sucesso.");
		listar();
	}

	public static void listar() {
		String pesquisa = params.get("busca");
		List<Cliente> cad = null;
		if (pesquisa == null || pesquisa.isEmpty()) {
			cad = Cliente.findAll();
		} else {
			cad = Cliente.find("lower(nome) like ?1 or lower(pulseira) like ?1 or lower(documento) like ?1",
					"%" + pesquisa.toLowerCase() + "%").fetch();
		}

		render(cad, pesquisa);
	}

	public static void editar(Long id) {
		Cliente cad = Cliente.findById(id);
		renderTemplate("Clientes/form.html", cad);
	}

	public static void remover(Long id) {
		Cliente cad = Cliente.findById(id);
		flash.error("Cliente removido com sucesso.");
		cad.delete();
		listar();
	}

}
