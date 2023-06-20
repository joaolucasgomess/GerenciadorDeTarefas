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
            if(usuario.getSenha().equals(usuarioLogado.getSenha())){
               listaDeTarefas = GerenciadorDeArquivos.carregarDoArquivoTarefa(listaDeTarefas, "Usuarios\\Tarefas\\" + usuarioLogado.getNome() + ".jdm");
               break;  
            }else{
               System.out.println("Senha incorreta!");
               break;
            }
         }
      }if(!usuarioExiste){
         listaDeUsuarios.add(usuarioLogado);
         GerenciadorDeArquivos.atualizarArquivo(listaDeUsuarios, "Usuarios\\usuariosCadastrados.jdm");
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
      String categoria = adicionarCategoria();
      
      Tarefa novaTarefa = new Tarefa(tituloTarefa, descricaoTarefa, dataCriacaoTarefa, categoria);
      gerarIndiceTarefa(novaTarefa);
      this.listaDeTarefas.add(novaTarefa);
      GerenciadorDeArquivos.atualizarArquivo(listaDeTarefas, "Usuarios\\Tarefas\\" + usuarioLogado.getNome() + ".jdm");
   }
   
   public String adicionarCategoria(){
      System.out.println("Deseja adicionar a tarefa a uma categoria?");
      System.out.println("1 - Sim // 2 - Nao");
      Scanner leia = new Scanner(System.in);
      int resposta = leia.nextInt();
      if(resposta == 1){
            System.out.println("Digite o nome da categoria: ");
            String novaCategoria = leia.next();
            if(novaCategoria != null){
               return novaCategoria;
            }else{
               return "sem categoria";
            }
      }else{
         return "sem categoria";
      }           
   }
   
   public void concluirTarefa(){
      exibirTarefas(false);
      Scanner leia = new Scanner(System.in);
      System.out.println("\nQual tarefa deseja concluir?");
      int indiceTarefaEscolhida = (leia.nextInt() - 1);
      if(verificaIndice(indiceTarefaEscolhida)){
         Tarefa novaTarefaConcluida = this.listaDeTarefas.get(indiceTarefaEscolhida);
         novaTarefaConcluida.setStatus(true);
         //novaTarefaConcluida.setDataConclusao(LocalDateTime.now());
         this.listaDeTarefas.set(indiceTarefaEscolhida, novaTarefaConcluida);
         GerenciadorDeArquivos.atualizarArquivo(listaDeTarefas, "Usuarios\\Tarefas\\" + usuarioLogado.getNome() + ".jdm");
      }else{
         System.out.println("Codigo da tarefa invalido. Tente novamente.");
         concluirTarefa();
      }
   }
   
   public boolean verificaIndice(int indice){
      try{
         this.listaDeTarefas.get(indice);
      }catch(Exception e){
         System.out.println("Codigo da tarefa invalido. Tente novamente.");
         concluirTarefa();
      }
      Tarefa tarefa = this.listaDeTarefas.get(indice);
      
      if(tarefa.getStatus()){
         return false;
      }else{
         return true;
      }
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
