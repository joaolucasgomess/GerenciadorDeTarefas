import java.util.*;
import java.lang.*;

public class Main{
   public static void main (String[] args){
      Scanner leia = new Scanner(System.in);
      System.out.print("Usuario: ");
      String nomeUsuario = leia.next();
      
      Usuario usuarioLogin = new Usuario(nomeUsuario);
      GerenciadorDeTarefas gerenciadorDeTarefas = new GerenciadorDeTarefas(usuarioLogin);
      while(true){
         System.out.println("\nOpcoes: ");
         System.out.println("1 - Criar nova tarefa");
         System.out.println("2 - Concluir tarefa");
         System.out.println("3 - Exibir tarefas pendentes");
         System.out.println("4 - Exibir tarefas concluidas");
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
               
            /*default:
               System.out.println("Opção invalida, escolha outra.");*/
         }
      }
   }
}