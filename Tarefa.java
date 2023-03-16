import java.util.*;
import java.lang.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Tarefa{
   private String titulo;
   private String descricao;
   private LocalDate dataCriacao;
   private String dataConclusao;
   private boolean status;
   
   public Tarefa(){
      Scanner leia = new Scanner(System.in);
      System.out.println("Digite o titulo de sua nova tarefa: ");
      this.titulo = leia.nextLine();
      System.out.println("Digite a descricao de sua nova tarefa: ");
      this.descricao = leia.nextLine();
      //System.out.println("Digite a data de criação de sua nova tarefa: ");
      //this.dataCriacao = leia.next();
      this.dataCriacao = LocalDate.now();
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
   
   public String getDataConclusao(){
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
   
   public void setTDataConclusao(String dataConclusao){
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