import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GerenciadorDeArquivos{
   
   public static void adicionarAoArquivo(Tarefa tarefa, String nomeDoArquivo){
      try(
         FileWriter fw = new FileWriter(nomeDoArquivo, true);
         BufferedWriter bw = new BufferedWriter(fw)
      ){
         bw.write(tarefa.formatarAtributosParaArquivo());
         bw.newLine();
         System.out.println("Conteudo adicionado com sucesso ao arquivo.");
      }catch(IOException e){
         System.out.println("Ocorreu um erro ao tentar adicionar o conteudo ao arquivo.");
         e.printStackTrace();
      }
   }
   
   public static void atualizarArquivo(List<Tarefa> tarefasPendentes, List<Tarefa> tarefasConcluidas, String nomeDoArquivo){
      List<Tarefa> listaDeTarefas = new ArrayList<>();
      listaDeTarefas.addAll(tarefasPendentes);
      listaDeTarefas.addAll(tarefasConcluidas);
      
      Collections.sort(listaDeTarefas, new Comparator<Tarefa>(){
         @Override
         public int compare(Tarefa o1, Tarefa o2) {
            return o1.getDataCriacao().compareTo(o2.getDataCriacao());
         }
      });
      
      try(
         FileWriter fw = new FileWriter(nomeDoArquivo, false);
         BufferedWriter bw = new BufferedWriter(fw)
      ){
         for(Tarefa tarefa : listaDeTarefas){
            bw.write(tarefa.formatarAtributosParaArquivo());
            bw.newLine();
         }
      }catch(IOException e){
         System.out.println("Ocorreu um erro ao tentar adicionar o conteudo ao arquivo.");
         e.printStackTrace();
      }
   }

}