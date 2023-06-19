import java.util.*;

public class Usuario implements IFormatador{

    private String nome;
    private String senha;
    private UUID idUsuario;

    public Usuario(String nome){
        this.nome = nome;
        this.idUsuario = UUID.randomUUID();
  }
  
   public Usuario(String nome, String senha, UUID idUsuario){
      this.nome = nome;
      this.senha = senha;
      this.idUsuario = idUsuario;
  }

    public String getNome(){
        return nome;
 
  }
  
  public String getSenha(){
      return senha;  
  }
  
  public void setSenha(String senha){
      this.senha = senha;
  }

  public static Usuario formatarParaList(String linha){
      String[] atributos = linha.split(";");
      String nome = atributos[0];
      String senha = atributos[1];
      UUID idUsuario = UUID.fromString(atributos[2]);
      return new Usuario(nome, senha, idUsuario);
  }
  
  @Override
   public String formatarAtributosParaArquivo(){
      String atributosFormatados = this.nome + ";"
            + this.senha + ";"
            + this.idUsuario;
      return atributosFormatados;
   }
}