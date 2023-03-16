import java.util.*;
import java.io.*;
import java.lang.*; 
import java.time.*;

public class GerenciadorDeTarefas{
   private Tarefa tarefa;
   private List<Tarefa> tarefasPendentes = new ArrayList<>();
   private List<Tarefa> tarefasConcluidas = new ArrayList<>();
   
   public Tarefa getTarefa(){
      return tarefa;
   }
   
   public void setTarefa(Tarefa tarefa){
      this.tarefa = tarefa;
   }
   
   public List<Tarefa> getTarefasPendentes(){
      return tarefasPendentes;
   }
   public void setTarefasPendentes(List<Tarefa> tarefasPendentes){
      this.tarefasPendentes = tarefasPendentes;
   }
   
    /*GerenciadorDeTarefas(){

    }*/

   public void adicionarTarefa(Tarefa novaTarefa){
      setTarefa(novaTarefa);
      tarefasPendentes.add(getTarefa());
   }
   
   public void concluirTarefa(){
      exibirTarefasPendentes();
      //TODO
      
   }
   
   public void exibirTarefasPendentes(){
      System.out.println("Lista de tarefas pendentes: ");
      for (int dadosDaTarefa = 0; dadosDaTarefa < tarefasPendentes.size(); dadosDaTarefa++){
         System.out.println(tarefasPendentes.get(dadosDaTarefa));
      }
   }

  
   /*exibirTarefaConcluidas(){
        
   }*/
}
