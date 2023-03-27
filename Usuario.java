import java.util.*;

public class Usuario{

    private String nome;
    private UUID idUsuario;

    public Usuario(String nome){
        this.nome = nome;
        this.idUsuario = UUID.randomUUID();
  }
  
   public Usuario(String nome, UUID idUsuario){
      this.nome = nome;
      this.idUsuario = idUsuario;
  }

    public String getNome(){
        return nome;
 
  }
  
  public static Usuario formatarParaList(String linha){
      String[] atributos = linha.split(";");
      String nome = atributos[0];
      UUID idUsuario = UUID.fromString(atributos[1]);
      return new Usuario(nome, idUsuario);
  }
  
   public String formatarAtributosParaArquivo(){
      String atributosFormatados = this.nome + ";"
            + this.idUsuario;
      return atributosFormatados;
   }
}