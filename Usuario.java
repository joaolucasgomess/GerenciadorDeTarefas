import java.util.*;

public class Usuario implements IFormatador{

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
  
  @Override
   public String formatarAtributosParaArquivo(){
      String atributosFormatados = this.nome + ";"
            + this.idUsuario;
      return atributosFormatados;
   }
}