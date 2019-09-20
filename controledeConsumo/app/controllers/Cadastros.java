package controllers;

import java.util.List;

import models.Cadastro;
import play.mvc.Controller;
import play.mvc.With;
@With(Secure.class)
public class Cadastros extends Controller {
	public static void form() {
		render();
		System.out.println("Junior e lindo e gostoso");
	}

	public static void cadastrar(Cadastro cad) {
		cad.save();
		flash.success("Cliente salvo com sucesso.");
		listar();
	}

	public static void listar() {
		String pesquisa = params.get("busca");
		List<Cadastro> cad = null;
		if (pesquisa == null || pesquisa.isEmpty()) {
			cad = Cadastro.findAll();
		} else {
			cad = Cadastro.find("lower(nome) like ?1 or lower(id_pulseira) like ?1 or lower(documento) like ?1",
					"%" + pesquisa.toLowerCase() + "%").fetch();
		}

		render(cad, pesquisa);
	}
    
	 
	public static void editar(Long id) {
		Cadastro cad = Cadastro.findById(id);
		renderTemplate("Cadastros/form.html", cad);
	}

	public static void remover(Long id) {
		Cadastro cad = Cadastro.findById(id);
		flash.error("Cliente removido com sucesso.");
		cad.delete();
		listar();
	}

}
