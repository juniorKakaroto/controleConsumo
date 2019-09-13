package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Cliente;
import models.Item;
import models.Pedido;
import models.PedidoItem;
import play.mvc.Controller;

public class Pedidos extends Controller {

	public static void novoPedido(Long id) {
		Cliente cliente = Cliente.findById(id);
		List<Item> itens = Item.findAll();
		Pedido pedido = new Pedido();
		pedido.cliente = cliente;
		pedido.save();
		renderTemplate("/Pedidos/pedido.html", pedido, itens, cliente);
	}

	public static void pedido(Long id) {
		Pedido pedido = Pedido.findById(id);
		Cliente cliente = Cliente.findById(id);
		List<Item> itens = Item.findAll();
		render(pedido, itens, cliente);
	}

	public static void additem(Long idItem, Long idPedido, int qntItem) {
		Item item = Item.findById(idItem);
		Pedido pedido = Pedido.findById(idPedido);

		PedidoItem pedidoItem = new PedidoItem();
		pedidoItem.item = item;
		pedidoItem.pedido = pedido;
		pedidoItem.quantidade = qntItem;

		if (pedido.pedidoItens == null) {
			pedido.pedidoItens = new ArrayList<PedidoItem>();
		}
		pedido.pedidoItens.add(pedidoItem);
		pedido.save();

		pedido(pedido.id);
	}

}
