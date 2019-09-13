package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Marca extends Model{

	public String nome;
	
}
