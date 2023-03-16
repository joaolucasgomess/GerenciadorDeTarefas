import java.util.*;
import java.lang.*;

public class Main{
   public static void main (String[] args){
      GerenciadorDeTarefas gerenciadorDeTarefas = new GerenciadorDeTarefas();
      while(true){
         System.out.println("\nOpcoes: ");
         System.out.println("1 - Criar nova tarefa");
         System.out.println("2 - Concluir tarefa");
         System.out.println("3 - Exibir tarefas pendentes");
         System.out.println("4 - Exibir tarefas concluídas");
         Scanner leia = new Scanner(System.in);
         int opcao = leia.nextInt();
         
         switch (opcao){
            case 1:
               Tarefa novaTarefa = new Tarefa();
               gerenciadorDeTarefas.adicionarTarefa(novaTarefa);
               break;
            /*case 2: */
            
            case 3:
               gerenciadorDeTarefas.exibirTarefaPendentes();

               
               break;



            /* case 4:

            default:
               System.out.println("Opção invalida, escolha outra.");*/
         }

      }
   }
}