import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tarefa{
   private String titulo;
   private String descricao;
   private LocalDate dataCriacao;
   private LocalDate dataConclusao;
   private boolean status;
   
   public Tarefa(String titulo, String descricao, LocalDate dataCriacao){
      this.titulo = titulo;
      this.descricao = descricao;
      this.dataCriacao = dataCriacao;
      this.status = false;
   }

   public String getTitulo(){
      return titulo;
   }
   
   public String getDescricao(){
      return descricao;
   }
   
   public LocalDate getDataCriacao(){
      return dataCriacao;
   }
   
   public LocalDate getDataConclusao(){
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
   
   public void setDataCriacao(LocalDate dataCriacao){
      this.dataCriacao = dataCriacao;
   }
   
   public void setDataConclusao(LocalDate dataConclusao){
      this.dataConclusao = dataConclusao;
   }
   
   public void setStatus(boolean status){
      this.status = status;
   } 

   public String toString(){
      return("\nTarefa: " + this.getTitulo() + "\nDescricao: "+ this.getDescricao() + "\nData de Criacao: " + formatarData(getDataCriacao()));

   }
   
   public String formatarData(LocalDate data){
      DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      String dataFormatada = formatacao.format(data);
      return dataFormatada;
   }

}