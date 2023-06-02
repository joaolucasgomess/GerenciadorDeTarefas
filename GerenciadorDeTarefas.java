import java.util.*;
import java.io.IOException;
import java.time.LocalDateTime;

public class GerenciadorDeTarefas{
   private List<Tarefa> listaDeTarefas = new ArrayList<>();
   private List<Usuario> listaDeUsuarios = new ArrayList<>();
   private List<Categoria> listaCategorias = new ArrayList<>();
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
   
   public List<Categoria> getListaCategorias(){
      return listaCategorias;
   }
   
   public void setListaCategorias(List<Categoria> listaCategorias){
      this.listaCategorias = listaCategorias;
   }


   GerenciadorDeTarefas(Usuario usuario){
      this.usuarioLogado = usuario;
      listaDeUsuarios = GerenciadorDeArquivos.carregarDoArquivoUsuario(listaDeUsuarios, "Usuarios\\usuariosCadastrados.jdm");
      listaCategorias = GerenciadorDeArquivos.carregarDoArquivoCategorias(listaCategorias, "Usuarios\\Categorias.jdm");
      
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
      
      Tarefa novaTarefa = new Tarefa(tituloTarefa, descricaoTarefa, dataCriacaoTarefa);
      gerarIndiceTarefa(novaTarefa);
      this.listaDeTarefas.add(novaTarefa);
      GerenciadorDeArquivos.atualizarArquivo(listaDeTarefas, "Usuarios\\Tarefas\\" + usuarioLogado.getNome() + ".jdm");
      adicionarCategoria(novaTarefa);
   }
   
   public void exibirCategorias(){
      System.out.println("Categorias: ");
      int count = 1;
      for(Categoria categoria : this.listaCategorias){
         System.out.println(count + " - " + categoria);
         count++;
      }
   }
   
   public void adicionarCategoria(Tarefa novaTarefa){
      System.out.println("Deseja adicionar a tarefa a uma categoria?");
      System.out.println("1 - Sim // 2 - Nao");
      Scanner leia = new Scanner(System.in);
      int resposta = leia.nextInt();
      
      switch(resposta){
      
         case 1:
            exibirCategorias();
            System.out.println("Escolha uma categoria: ");
            int categoriaSelecionada = (leia.nextInt() - 1);
            novaTarefa.setCategoria(listaCategorias.get(categoriaSelecionada));
            break;
         
         case 2:
            break;
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
   
   public void cadastrarCategoria(){
      System.out.print("Digite o nome da nova categoria: ");
      Scanner leia = new Scanner(System.in);
      String nomeCategoria = leia.nextLine();
      Categoria novaCategoria = new Categoria(nomeCategoria);
      listaCategorias.add(novaCategoria);
      GerenciadorDeArquivos.atualizarArquivo(listaCategorias, "Usuarios\\Categorias.jdm");
   }
}
