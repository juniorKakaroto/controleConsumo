package models;

import javax.persistence.Entity;

import play.db.jpa.Model;
@Entity
public class Cadastro extends Model{
   public String nome ; 
   public String documento ;
   public String id_pulseira;
}
