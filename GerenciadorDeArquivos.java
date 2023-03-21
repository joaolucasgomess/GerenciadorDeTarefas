import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GerenciadorDeArquivos{
   
   public static void adicionarAoArquivo(Tarefa tarefa, String nomeDoArquivo){
      try(
         FileWriter fw = new FileWriter(nomeDoArquivo, true);
         BufferedWriter bw = new BufferedWriter(fw)
      ){
         bw.write(
            tarefa.getTitulo() + ";"
            + tarefa.getDescricao() + ";"
            + tarefa.getDataCriacao() + ";"
            + tarefa.getDataConclusao() + ";"
            + tarefa.getStatus() + ";"
            + tarefa.getIdTarefa()
         );
         bw.newLine();
         System.out.println("Conteudo adicionado com sucesso ao arquivo.");
      }catch (IOException e) {
         System.out.println("Ocorreu um erro ao tentar adicionar o conteudo ao arquivo.");
         e.printStackTrace();
      }
   }
   
   public static void atualizarArquivo(Tarefa tarefa, String nomeDoArquivo){
      try{
         //TODO
      
      
      }catch
      
   }
   
   /*public static void verificarSeArquivoExiste(File ){
        
   }*/
   
   /*public static void criarArquivo(){
      
   }*/
}