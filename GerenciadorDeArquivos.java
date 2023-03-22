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
      GerenciadorDeArquivos.escreverArquivo(lerArquivo(nomeDoArquivo));
   }
   
   public static List<Tarefa> lerArquivo(String nomeDoArquivo){
      List<Tarefa> listaDeTarefas = new ArrayList<>();
      try (FileReader fr = new FileReader(nomeDoArquivo);
         BufferedReader br = new BufferedReader(fr)){
         String linha;
        while ((linha = br.readLine()) != null) {
            Tarefa tarefa = Tarefa.parseLinhaDoArquivo(linha);
            listaDeTarefas.add(tarefa);
        }
      }
      return listaDeTarefas;
   }
    
    public static void escreverArquivo(List<Tarefa> listaDeTarefas, String nomeDoArquivo) throws IOException {
      try (FileWriter fw = new FileWriter(nomeDoArquivo, false);
         BufferedWriter bw = new BufferedWriter(fw)) {
            for (Tarefa tarefa : listaDeTarefas) {
               bw.write(tarefa.formatarAtributosParaArquivo());
               bw.newLine();
            }
      }
   }

   
      /*public static void atualizarArquivo(Tarefa tarefa, String nomeDoArquivo){
      try{
         FileReader arquivo = new FileReader(nomeDoArquivo);
         BufferedReader dadosDoArquivo = new BufferedReader(arquivo);
         
         String linha = dadosDoArquivo.readLine();
         int numeroLinha = 1;
         
         while(linha != null){
            if(linha.contains(tarefa.getTitulo())){
               atualizarLinhaEscolhida(tarefa, nomeDoArquivo, numeroLinha);
            }
            numeroLinha++;
         }
         dadosDoArquivo.close();
      }catch(IOException e){
         System.out.println("deu erro mano");
      }
      
   }*/
   
      /*try {
         // Abrir o arquivo em modo leitura e escrita
         RandomAccessFile arquivo = new RandomAccessFile(nomeDoArquivo, "rw");
    
         // Localizar a posição da linha que deseja sobrescrever
         //String linha = arquivo.readLine();
         String linha;
         arquivo.seek(0);
         while((linha = arquivo.readLine()) != null){
            if(linha.contains(tarefa.getTitulo())){
               String novaLinha =  tarefa.getTitulo() + ";" + tarefa.getDescricao() + ";" + tarefa.getDataCriacao() + ";" + tarefa.getDataConclusao() + ";" + tarefa.getStatus() + ";" + tarefa.getIdTarefa();
               arquivo.seek(arquivo.getFilePointer() - linha.length() - 1);
               arquivo.writeBytes(novaLinha);
               arquivo.writeBytes(System.lineSeparator());
               arquivo.close();
            }
         }
          arquivo.close();
         } catch (IOException e) {
            e.printStackTrace();
      }
   }*/
         
         /*for (int i = 1; i < numeroLinha; i++) {
            arquivo.readLine();
         }
         long posicaoInicial = arquivo.getFilePointer();
    
         // Sobrescrever a linha
         String novaLinha = "Nova linha que irá sobrescrever a linha antiga";
         arquivo.writeBytes(novaLinha);*/
    
         // Fechar o arquivo
         /*arquivo.close();
         } catch (IOException e) {
            e.printStackTrace();
      }
   }*/
   
   /*public static void verificarSeArquivoExiste(File ){
        
   }*/
   
   /*public static void criarArquivo(){
      
   }*/
 

/*Sim, é possível sobrescrever uma linha em um arquivo sem reescrever o arquivo inteiro. Para isso, você precisa seguir os seguintes passos:

Abrir o arquivo em modo leitura e escrita (RandomAccessFile).
Localizar a posição da linha que deseja sobrescrever usando o método seek().
Sobrescrever a linha usando o método writeBytes() ou writeUTF() do objeto RandomAccessFile.

Neste exemplo, a linha que está na posição 3 do arquivo será sobrescrita pela nova linha. Note que é importante abrir o arquivo em modo leitura e escrita ("rw"), caso contrário não será possível realizar a sobrescrita.*/

}