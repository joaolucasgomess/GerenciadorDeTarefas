import java.util.*;
import java.io.IOException;
import java.time.LocalDateTime;

public class GerenciadorDeTarefas{
   private List<Tarefa> listaDeTarefas = new ArrayList<>();
   private List<Usuario> listaDeUsuarios = new ArrayList<>();
   private Usuario usuarioLogado;
   
   public List<Tarefa> getListaDeTarefas(){
      return listaDeTarefas;
   }
   public void setListaDeTarefas(List<Tarefa> listaDeTarefas){
      this.listaDeTarefas = listaDeTarefas;
   }
   
   public List<Usuario> getListaDeUsuarios(){
      return listaDeUsuarios;
   }
   
   public void setListaDeUsuarios(List<Usuario> listaDeUsuarios){
      this.listaDeUsuarios = listaDeUsuarios;
   }

   GerenciadorDeTarefas(Usuario usuario){
      this.usuarioLogado = usuario;
      listaDeUsuarios = GerenciadorDeArquivos.carregarDoArquivoUsuario(listaDeUsuarios, "Usuarios\\usuariosCadastrados.jdm");
   }
   
   public void verificarUsuario(){
      boolean usuarioExiste = false;
      for(Usuario usuario : this.listaDeUsuarios){
         if(usuario.getNome().equals(usuarioLogado.getNome())){
            usuarioExiste = true;
            listaDeTarefas = GerenciadorDeArquivos.carregarDoArquivoTarefa(listaDeTarefas, "Usuarios\\Tarefas\\" + usuarioLogado.getNome() + ".jdm");
            break;
         }
      }if(!usuarioExiste){
         listaDeUsuarios.add(usuarioLogado);
         GerenciadorDeArquivos.atualizarArquivoUsuario(listaDeUsuarios, "Usuarios\\usuariosCadastrados.jdm");
      }
   }
    
   public void gerarIndiceTarefa(Tarefa tarefa){
      if(this.listaDeTarefas.size() == 0){
         tarefa.setIndice(1);
      }else{
         Tarefa ultimaTarefaAdicionada = this.listaDeTarefas.get(listaDeTarefas.size() - 1);
         tarefa.setIndice(ultimaTarefaAdicionada.getIndice() + 1);
      }
   }

   public void adicionarTarefa(){
      Scanner leia = new Scanner(System.in);
      System.out.println("Digite o titulo de sua nova tarefa: ");
      String tituloTarefa = leia.nextLine();
      System.out.println("Digite a descricao de sua nova tarefa: ");
      String descricaoTarefa = leia.nextLine();
      LocalDateTime dataCriacaoTarefa = LocalDateTime.now();
      
      Tarefa novaTarefa = new Tarefa(tituloTarefa, descricaoTarefa, dataCriacaoTarefa);
      gerarIndiceTarefa(novaTarefa);
      this.listaDeTarefas.add(novaTarefa);
      GerenciadorDeArquivos.atualizarArquivoTarefa(listaDeTarefas, "Usuarios\\Tarefas\\" + usuarioLogado.getNome() + ".jdm");
   }
   
   public void concluirTarefa(){
      exibirTarefas(false);
      Scanner leia = new Scanner(System.in);
      System.out.println("Qual tarefa deseja concluir?");
      int indiceTarefaEscolhida = (leia.nextInt() - 1);
      
      Tarefa novaTarefaConcluida = this.listaDeTarefas.get(indiceTarefaEscolhida);
      novaTarefaConcluida.setStatus(true);
      //novaTarefaConcluida.setDataConclusao(LocalDateTime.now());
      this.listaDeTarefas.set(indiceTarefaEscolhida, novaTarefaConcluida);
      GerenciadorDeArquivos.atualizarArquivoTarefa(listaDeTarefas, "Usuarios\\Tarefas\\" + usuarioLogado.getNome() + ".jdm");
   }
   
   public void exibirTarefas(boolean teste){
      for(Tarefa tarefa : this.listaDeTarefas){
         if(tarefa.getStatus() == teste){
            System.out.println("Lista de tarefas: ");
            System.out.println(tarefa);
         }
      }
   }
}
