import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
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
      }catch (IOException e) {
         System.out.println("Ocorreu um erro ao tentar adicionar o conteudo ao arquivo.");
         e.printStackTrace();
      }
   }
   
   public static void atualizarArquivo(Tarefa tarefa, String nomeDoArquivo){
      escreverArquivo(lerArquivo(nomeDoArquivo, tarefa), nomeDoArquivo);
   }
   
   public static List<Tarefa> lerArquivo(String nomeDoArquivo, Tarefa tarefa) {
      List<Tarefa> listaDeTarefas = new ArrayList<>();
      try (FileReader fr = new FileReader(nomeDoArquivo);
         BufferedReader br = new BufferedReader(fr)) {
         String linha;
         Tarefa arquivo;
         while ((linha = br.readLine()) != null) {
            arquivo = Tarefa.parseLinhaDoArquivo(linha);
            listaDeTarefas.add(arquivo);
         }
         for(Tarefa socorro : listaDeTarefas){
            if(socorro.getTitulo().equals(tarefa.getTitulo())){
               socorro.setStatus(tarefa.getStatus());
            }
         }
            System.out.println("Conteúdo do arquivo lido com sucesso.");
      }catch (IOException e) {
            System.out.println("Ocorreu um erro ao tentar ler o conteúdo do arquivo.");
            e.printStackTrace();
      }
      return listaDeTarefas;
   }
    
   public static void escreverArquivo(List<Tarefa> listaDeTarefas, String nomeDoArquivo) {
      try (FileWriter fw = new FileWriter(nomeDoArquivo, false);
         BufferedWriter bw = new BufferedWriter(fw)) {
            for (Tarefa tarefa : listaDeTarefas) {
               bw.write(tarefa.formatarAtributosParaArquivo());
               bw.newLine();
            }
            System.out.println("Conteúdo adicionado com sucesso ao arquivo.");
       }catch (IOException e) {
            System.out.println("Ocorreu um erro ao tentar adicionar o conteúdo ao arquivo.");
            e.printStackTrace();
      }
   }

}