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
      try(
         FileReader fr = new FileReader(nomeDoArquivo);
         BufferedReader br = new BufferedReader(fr);
         FileWriter fw = new FileWriter(nomeDoArquivo, true);
         BufferedWriter bw = new BufferedWriter(fw)
         //entender como sobrescrever da maneira certa, do jeito que, com true no fw cria uma linha nova e não atualiza
         //sem o true apaga tudo
      ){
         String linha;
         while((linha = br.readLine()) != null){
            if(linha.contains(tarefa.getTitulo())){
               bw.write(
                  tarefa.getTitulo() + ";"
                  + tarefa.getDescricao() + ";"
                  + tarefa.getDataCriacao() + ";"
                  + tarefa.getDataConclusao() + ";"
                  + tarefa.getStatus() + ";"
                  + tarefa.getIdTarefa()
               );
            }
         }
      }catch(IOException e){
         System.out.println("Erro ao ler o arquivo: " + e.getMessage());
      }
   }
   
   /*public static void verificarSeArquivoExiste(File ){
        
   }*/
   
   /*public static void criarArquivo(){
      
   }*/
}