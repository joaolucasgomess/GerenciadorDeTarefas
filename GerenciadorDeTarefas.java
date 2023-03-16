import java.util.*;
import java.io.*;
import java.lang.*; 

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
   /*concluirTarefa(Tarefa t){
        
   }*/
   public void exibirTarefaPendentes(){ 
      for (int i = 0; i < tarefasPendentes.size(); i++){
         System.out.println(tarefasPendentes.get(i));
      }
   }

  
   /*exibirTarefaConcluidas(){
        
   }*/
}
