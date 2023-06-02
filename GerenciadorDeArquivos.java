import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class GerenciadorDeArquivos{
  
  public static <T extends IFormatador> void atualizarArquivo(List<T> lista, String nomeDoArquivo){
      try(
         FileWriter fw = new FileWriter(nomeDoArquivo, false);
         BufferedWriter bw = new BufferedWriter(fw)
      ){
         for(T item : lista){
            bw.write(item.formatarAtributosParaArquivo());
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
   
   public static List<Categoria> carregarDoArquivoCategorias(List<Categoria> listaDeCategorias, String nomeDoArquivo){
      try(
         FileReader fr = new FileReader(nomeDoArquivo);
         BufferedReader br = new BufferedReader(fr)
      ){
         String linha;
         while((linha = br.readLine()) != null){
            Categoria categoria = Categoria.formatarParaList(linha);
            listaDeCategorias.add(categoria);
         }
      }catch(IOException e){
         System.out.println("Ocorreu um erro ao tentar ler o conteudo do arquivo.");
         e.printStackTrace();
      }
      return listaDeCategorias;
   } 
}