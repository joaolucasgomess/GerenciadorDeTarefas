import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
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
  
  public static void atualizarArquivoTarefa(List<Tarefa> listaDeTarefas, String nomeDoArquivo){
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
   
  public static void atualizarArquivoUsuario(List<Usuario> listaDeUsuarios, String nomeDoArquivo){
      try(
         FileWriter fw = new FileWriter(nomeDoArquivo, false);
         BufferedWriter bw = new BufferedWriter(fw)
      ){
         for(Usuario usuario : listaDeUsuarios){
            bw.write(usuario.formatarAtributosParaArquivo());
            bw.newLine();
         }
      }catch(IOException e){
         System.out.println("Ocorreu um erro ao tentar adicionar o conteudo ao arquivo.");
         e.printStackTrace();
      }
   }
   
   public static List<Tarefa> carregarDoArquivoTarefa(List<Tarefa> listaDeTarefas, String nomeDoArquivo){
      try(
         FileReader fr = new FileReader(nomeDoArquivo);
         BufferedReader br = new BufferedReader(fr)
      ){
         String linha;
         while((linha = br.readLine()) != null){
            Tarefa tarefa = Tarefa.formatarParaList(linha);
            listaDeTarefas.add(tarefa);
         }
      }catch(IOException e){
         System.out.println("Ocorreu um erro ao tentar ler o conteudo do arquivo.");
         e.printStackTrace();
      }
      return listaDeTarefas;
   }
   
   public static List<Usuario> carregarDoArquivoUsuario(List<Usuario> listaDeUsuarios, String nomeDoArquivo){
      try(
         FileReader fr = new FileReader(nomeDoArquivo);
         BufferedReader br = new BufferedReader(fr)
      ){
         String linha;
         while((linha = br.readLine()) != null){
            Usuario usuario = Usuario.formatarParaList(linha);
            listaDeUsuarios.add(usuario);
         }
      }catch(IOException e){
         System.out.println("Ocorreu um erro ao tentar ler o conteudo do arquivo.");
         e.printStackTrace();
      }
      return listaDeUsuarios;
   } 
}