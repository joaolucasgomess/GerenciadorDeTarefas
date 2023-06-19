import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tarefa implements IFormatador{
   private int indice;
   private String titulo;
   private String descricao;
   private LocalDateTime dataCriacao;
   //private LocalDateTime dataConclusao;
   private boolean status;
   private UUID idTarefa;
   private String categoria;
   
   public Tarefa(String titulo, String descricao, LocalDateTime dataCriacao){
      this.titulo = titulo;
      this.descricao = descricao;
      this.dataCriacao = dataCriacao;
      this.status = false;
      this.idTarefa = UUID.randomUUID();
   }
   
   public Tarefa(int indice, String titulo, String descricao, LocalDateTime dataCriacao,  boolean status, UUID idTarefa, String categoria){
      this.indice = indice;
      this.titulo = titulo;
      this.descricao = descricao;
      this.dataCriacao = dataCriacao;
      //this.dataConclusao = dataConclusao;
      this.status = status;
      this.idTarefa = UUID.randomUUID();
      this.categoria = categoria;
   }
   
   public int getIndice(){
      return indice;
   }
   
   public void setIndice(int indice){
      this.indice = indice;
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
   
   /*public LocalDateTime getDataConclusao(){
      return dataConclusao;
   }*/
   
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
   
   /*public void setDataConclusao(LocalDateTime dataConclusao){
      this.dataConclusao = dataConclusao;
   }*/
   
   public void setStatus(boolean status){
      this.status = status;
   }
   
   public UUID getIdTarefa(){
      return idTarefa;
   }
   
   public String getCategoria(){
      return categoria;
   }
   
   public void setCategoria(String categoria){
      this.categoria = categoria;
   }

@Override
   public String toString(){
      if(this.dataCriacao != null){
         return("\nCodigo: " + this.indice
            + "\nTarefa: " + this.titulo
            + "\nDescricao: "+ this.descricao
            + "\nData de Criacao: " + formatarDataEHora(this.dataCriacao)
         );
      }else{
         return("\nCodigo: " + this.indice
            + "\nTarefa: " + this.titulo
            + "\nDescricao: " + this.descricao
            + "\nData de Criacao: " + formatarDataEHora(this.dataCriacao)
            /*+ "\nData de Conclusao: " + formatarDataEHora(this.dataConclusao)*/
            + "\nCategoria: " + this.getCategoria()
         );
      }
   }
   
   public String formatarDataEHora(LocalDateTime data){
      DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
      String dataFormatada = formatacao.format(data);
      return dataFormatada;
   }
   @Override
   public String formatarAtributosParaArquivo(){
      String atributosFormatados = this.indice + ";"
            + this.titulo + ";"
            + this.descricao + ";"
            + this.dataCriacao + ";"
            /*+ this.dataConclusao + ";"*/
            + this.status + ";"
            + this.idTarefa + ";"
            + this.categoria;
      return atributosFormatados;
   }
   
   public static Tarefa formatarParaList(String linha) {
      String[] atributos = linha.split(";");
      int indice = Integer.parseInt(atributos[0]);
      String titulo = atributos[1];
      String descricao = atributos[2];
      LocalDateTime dataCriacao = LocalDateTime.parse(atributos[3]);
      //LocalDateTime dataConclusao = LocalDateTime.parse(atributos[3]);
      boolean status = Boolean.parseBoolean(atributos[4]);
      UUID idTarefa = UUID.fromString(atributos[5]);
      String categoria = atributos[6];
      return new Tarefa(indice, titulo, descricao, dataCriacao, status, idTarefa, categoria);
   }
}