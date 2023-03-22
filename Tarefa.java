import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarefa{
   private String titulo;
   private String descricao;
   private LocalDateTime dataCriacao;
   private LocalDateTime dataConclusao;
   private boolean status;
   private UUID idTarefa;
   
   public Tarefa(String titulo, String descricao, LocalDateTime dataCriacao){
      this.titulo = titulo;
      this.descricao = descricao;
      this.dataCriacao = dataCriacao;
      this.status = false;
      this.idTarefa = UUID.randomUUID();
   }

   public String getTitulo(){
      return titulo;
   }
   
   public String getDescricao(){
      return descricao;
   }
   
   public LocalDateTime getDataCriacao(){
      return dataCriacao;
   }
   
   public LocalDateTime getDataConclusao(){
      return dataConclusao;
   }
   
    public boolean getStatus(){
      return status;
   }
   
    public void setTitulo(String titulo){
      this.titulo = titulo;
   }
    public void setDescricao(String descricao){
      this.descricao = descricao;
   }
   
   public void setDataCriacao(LocalDateTime dataCriacao){
      this.dataCriacao = dataCriacao;
   }
   
   public void setDataConclusao(LocalDateTime dataConclusao){
      this.dataConclusao = dataConclusao;
   }
   
   public void setStatus(boolean status){
      this.status = status;
   }
   
   public UUID getIdTarefa(){
      return idTarefa;
   }
   
   public void setIdTarefa(UUID idTarefa){
      this.idTarefa = idTarefa;
   } 

@Override
   public String toString(){
      if(this.dataConclusao == null){
         return("\nTarefa: " + this.titulo
            + "\nDescricao: "+ this.descricao
            + "\nData de Criacao: " + formatarDataEHora(this.dataCriacao)
         );
      }else{
         return("\nTarefa: " + this.titulo
            + "\nDescricao: " + this.descricao
            + "\nData de Criacao: " + formatarDataEHora(this.dataCriacao)
            + "\nData de Conclusao: " + formatarDataEHora(this.dataConclusao)
         );
      }
   }
   
   public String formatarDataEHora(LocalDateTime data){
      DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
      String dataFormatada = formatacao.format(data);
      return dataFormatada;
   }
   
   public String formatarAtributosParaArquivo(){
      String atributosFomatados = this.titulo + ";"
            + this.descricao + ";"
            + this.dataCriacao + ";"
            + this.dataConclusao + ";"
            + this.status + ";"
            + this.idTarefa;
      return atributosFomatados;
   }
   
   public static Tarefa parseLinhaDoArquivo(String linha) {
      String[] atributos = linha.split(";");
      String titulo = String.parse(atributos[0]);
      String descricao = String.parse(atributos[1]);
      LocalDateTime dataCriacao = String.parse(atributos[2]);
      LocalDateTime dataConclusao = String.parse(atributos[3]);
      boolean status = String.parse(atributos[4]);
      UUID idTarefa = String.parse(atributos[5]);
}
   
   /*public String arrayAtributos(){
      String dataCriacaoString = dataCriacao.toString();
      String dataConclusaoString = dataConclusao.toString();
      String statusString = String.valueOf(this.status);
      String idTarefaString = idTarefa.toString();
      
      String arrayAtributos = {this.titulo, this.descricao, dataCriacaoString, dataConclusaoString, statusString, idTarefaString};
      
      return arrayAtributos;
   }*/
}