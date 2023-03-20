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
      
      Tarefa novaTarefa = new Tarefa(tituloTarefa, descricaoTarefa, dataCriacaoTarefa);
      this.tarefasPendentes.add(novaTarefa);
      GerenciadorDeArquivos.adicionarAoArquivo(novaTarefa, "tarefas.jdm");
   }
   
   public void concluirTarefa(){
      exibirTarefasPendentes();
      Scanner leia = new Scanner(System.in);
      System.out.println("Qual tarefa deseja concluir?");
      int tarefaEscolhida = (leia.nextInt() - 1);
      
      Tarefa novaTarefaConcluida = this.tarefasPendentes.get(tarefaEscolhida);
      novaTarefaConcluida.setStatus(true);
      novaTarefaConcluida.setDataConclusao(LocalDateTime.now());
      this.tarefasConcluidas.add(novaTarefaConcluida);
      this.tarefasPendentes.remove(tarefaEscolhida);
      GerenciadorDeArquivos.atualizarArquivo(novaTarefaConcluida, "tarefas.jdm");
   }
   
   public void exibirTarefas(List<Tarefa> listaDeTarefas){
      for(Tarefa dadosDaTarefa : listaDeTarefas){
         System.out.println(dadosDaTarefa);
      }
   }
   
   public void exibirTarefasPendentes(){
      System.out.println("Lista de tarefas pendentes: ");
      exibirTarefas(this.tarefasPendentes);
   }

   public void exibirTarefasConcluidas(){
      System.out.println("Lista de tarefas concluidas: ");
      exibirTarefas(this.tarefasConcluidas);
   }
}
