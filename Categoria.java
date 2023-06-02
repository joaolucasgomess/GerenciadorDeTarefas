import java.util.*;

public class Categoria implements IFormatador{
   private String nome;
   private UUID idCategoria;
   
   public Categoria(String nome){
      this.nome = nome;
      this.idCategoria = UUID.randomUUID();
   }
   
   public Categoria(String nome, UUID idCategoria){
      this.nome = nome;
      this.idCategoria = idCategoria;
   }
   
   public String getNome(){
      return nome;
   }
   
   public void setNome(String nome){
      this.nome = nome;
   }
   
   public UUID getIdCategoria(){
      return idCategoria;
   }
   
   public void setIdCategoria(UUID idCategoria){
      this.idCategoria = idCategoria;
   } 
   
   @Override
   public String formatarAtributosParaArquivo(){
      String atributosFormatados = this.nome + ";"
            + this.idCategoria;
      return atributosFormatados;
   }
   
   @Override
   public String toString(){
      return nome;   
   }
   
     public static Categoria formatarParaList(String linha){
      String[] atributos = linha.split(";");
      String nome = atributos[0];
      UUID idCategoria = UUID.fromString(atributos[1]);
      return new Categoria(nome, idCategoria);
  }
}