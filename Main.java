import java.util.*;

public class Main{
   public static void main (String[] args){
      Scanner leia = new Scanner(System.in);
      System.out.println("Usuario: ");
      String nomeUsuario = leia.next();
      System.out.println("Senha: ");
      String senhaUsuario = leia.next();
      Usuario usuarioLogando = new Usuario(nomeUsuario, senhaUsuario);
      
      GerenciadorDeTarefas gerenciadorDeTarefas = new GerenciadorDeTarefas(usuarioLogando);
      gerenciadorDeTarefas.verificarUsuario();
      while(true){
         System.out.println("\nOpcoes: ");
         System.out.println("1 - Criar nova tarefa");
         System.out.println("2 - Concluir tarefa");
         System.out.println("3 - Exibir tarefas pendentes");
         System.out.println("4 - Exibir tarefas concluidas");
         System.out.println("5 - Pesquisar");
         System.out.println("6 - Sair do sistema");
         int opcao = leia.nextInt();
         
         switch (opcao){
            case 1:
               gerenciadorDeTarefas.adicionarTarefa();
               break;
               
            case 2:
               gerenciadorDeTarefas.concluirTarefa();
               break;
            
            case 3:
               gerenciadorDeTarefas.exibirTarefas(false);
               break;
               
            case 4:
               gerenciadorDeTarefas.exibirTarefas(true);
               break;
               
            case 5:
               gerenciadorDeTarefas.buscar();
               break;
               
            case 6: 
               System.exit(0);
               break;
               
            default:
               System.out.println("Opcao invalida, escolha outra.");
         }
      }
   }
}