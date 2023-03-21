import java.util.*;
import java.io.IOException;
import java.time.LocalDateTime;

public class GerenciadorDeTarefas{
   private List<Tarefa> tarefasPendentes = new ArrayList<>();
   private List<Tarefa> tarefasConcluidas = new ArrayList<>();
   
   public List<Tarefa> getTarefasPendentes(){
      return tarefasPendentes;
   }
   
   
   public void setTarefasPendentes(List<Tarefa> tarefasPendentes){
      this.tarefasPendentes = tarefasPendentes;
   }
   
   public List<Tarefa> getTarefasConcluidas(){
      return tarefasConcluidas;
   }
   
   public void setTarefasConluidas(List<Tarefa> tarefasConcluidas){
      this.tarefasConcluidas = tarefasConcluidas;
   }
    /*GerenciadorDeTarefas(){
    }*/

   public void adicionarTarefa(){
      Scanner leia = new Scanner(System.in);
      System.out.println("Digite o titulo de sua nova tarefa: ");
      String tituloTarefa = leia.nextLine();
      System.out.println("Digite a descricao de sua nova tarefa: ");
      String descricaoTarefa = leia.nextLine();
      LocalDateTime dataCriacaoTarefa = LocalDateTime.now();
      
      Tarefa novaTarefa = new Tarefa(tituloTarefa, descricaoTarefa, dataCriacaoTarefa, Tarefa.getNumeroTarefa());
      this.tarefasPendentes.add(novaTarefa);
      GerenciadorDeArquivos.adicionarAoArquivo(novaTarefa, "tarefas.jdm");
   }
   
   public void concluirTarefa(){
   if(tarefasPendentes.size() == 0){
         System.out.println("\nNao existem tarefas pendentes.");
      }else{
      exibirTarefasPendentes();
      Scanner leia = new Scanner(System.in);
      System.out.println("\nQual tarefa deseja concluir?");
      int tarefaEscolhida = (leia.nextInt() - 1);
      
      if(tarefaEscolhida > Tarefa.getNumeroTarefa() - 1){
         System.out.println("\nTarefa invalida.");
      }else{
         Tarefa novaTarefaConcluida = this.tarefasPendentes.get(tarefaEscolhida);
         novaTarefaConcluida.setStatus(true);
         novaTarefaConcluida.setDataConclusao(LocalDateTime.now());
         this.tarefasConcluidas.add(novaTarefaConcluida);
         this.tarefasPendentes.remove(tarefaEscolhida);
         System.out.println("Tarefa " + (tarefaEscolhida + 1) + " removida com sucesso.");
      }
    }
   }
   
   public void exibirTarefas(List<Tarefa> listaDeTarefas){
      Tarefa.resetNumeroTarefa();
      for(Tarefa dadosDaTarefa : listaDeTarefas){
         System.out.println(dadosDaTarefa);
         Tarefa.addNumeroTarefa(2);
         Tarefa.removeNumeroTarefa(1);
      }
   }
   
   public void exibirTarefasPendentes(){
      if(tarefasPendentes.size() == 0){
         System.out.println("\nNao existem tarefas pendentes.");
      }else{
         System.out.println("Lista de tarefas pendentes: ");
         exibirTarefas(this.tarefasPendentes);
      }
   }

   public void exibirTarefasConcluidas(){
      if(tarefasConcluidas.size() == 0){
         System.out.println("\nNao existem tarefas concluidas.");
      }else{
         System.out.println("Lista de tarefas concluidas: ");
         exibirTarefas(this.tarefasConcluidas);
     }
   }
}