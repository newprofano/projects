
package projetodisco.config.models;


public class Disco {
   private Integer id;
   private String nome;
   private String autor_cantor;
   private String ano;
   
   public Disco(String nome, String autor_cantor, String ano){
       this.nome = nome;
       this.autor_cantor = autor_cantor;
       this.ano = ano;
   }
   
   public Disco(String nome, String autor_cantor, String ano, Integer id){
       this(nome,autor_cantor,ano);
       this.id = id;
   
   }
   
   public String getNome(){
      return nome;
   }
   
   public Integer getId(){
       return id;
   }
   
   public String getAutor_cantor(){
       return autor_cantor;
   }
   
   public String getAno(){
       return ano;
   }
    
    
}
