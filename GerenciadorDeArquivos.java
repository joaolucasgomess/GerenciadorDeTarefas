import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;

public class GerenciadorDeArquivos{
   
   public static void organizaArrayList(List<Tarefa> listaDeTarefas){
      Collections.sort(listaDeTarefas, new Comparator<Tarefa>(){
         @Override
         public int compare(Tarefa o1, Tarefa o2) {
            return o1.getDataCriacao().compareTo(o2.getDataCriacao());
         }
      });
   }
  
  public static void atualizarArquivo(List<Tarefa> listaDeTarefas, String nomeDoArquivo){
      organizaArrayList(listaDeTarefas);
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