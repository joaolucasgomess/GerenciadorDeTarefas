import java.util.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

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

   public void adicionarTarefa(){
      Scanner leia = new Scanner(System.in);
      System.out.println("Digite o titulo de sua nova tarefa: ");
      String tituloTarefa = leia.nextLine();
      System.out.println("Digite a descricao de sua nova tarefa: ");
      String descricaoTarefa = leia.nextLine();
      LocalDate dataCriacaoTarefa = LocalDate.now();
      
      Tarefa novaTarefa = new Tarefa(tituloTarefa, descricaoTarefa, dataCriacaoTarefa);
      tarefasPendentes.add(novaTarefa);
   }
   
   public void concluirTarefa(){
      exibirTarefasPendentes();
      Scanner leia = new Scanner(System.in);
      System.out.println("Qual tarefa deseja concluir?");
      int tarefaEscolhida = (leia.nextInt() - 1);
      
      Tarefa novaTarefaConcluida = this.tarefasPendentes.get(tarefaEscolhida);
      novaTarefaConcluida.setStatus(true);
      novaTarefaConcluida.setDataConclusao(LocalDate.now());
      this.tarefasConcluidas.add(novaTarefaConcluida);
      tarefasPendentes.remove(tarefaEscolhida);
   }
   
   public void exibirTarefasPendentes(){
      System.out.println("Lista de tarefas pendentes: ");
      for (int dadosDaTarefa = 0; dadosDaTarefa < tarefasPendentes.size(); dadosDaTarefa++){
         System.out.println(tarefasPendentes.get(dadosDaTarefa));
      }
   }

  
   public void exibirTarefasConcluidas(){
      System.out.println("Lista de tarefas concluidas: ");
      for (int dadosDaTarefa = 0; dadosDaTarefa < tarefasConcluidas.size(); dadosDaTarefa++){
         System.out.println(tarefasConcluidas.get(dadosDaTarefa));
      }
   }
}
