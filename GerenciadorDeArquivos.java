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
         FileReader arquivo = new FileReader(nomeDoArquivo);
         BufferedReader dadosDoArquivo = new BufferedReader(arquivo);
         
         String linha = dadosDoArquivo.readLine();
         
         while(linha != null){
            if(linha.contains(tarefa.getTitulo())){
               String[] dadosDaLinha = linha.split(";");
               dadosDaLinha[3] = tarefa.getDataConclusa().toString();
               dadosDaLinha[4] = tarefa.getStatus().toString();
               adicionarAoArquivo(tarefa, nomeDoArquivo);
               //TODO
            }
         }
         dadosDoArquivo.close();
      }catch(IOException e){
         System.out.println("deu erro mano");
      }
      
   }
   
   /*public static void verificarSeArquivoExiste(File ){
        
   }*/
   
   /*public static void criarArquivo(){
      
   }*/
   
   /*try {
    // Abrir o arquivo em modo leitura e escrita
    RandomAccessFile arquivo = new RandomAccessFile("caminho/do/arquivo.txt", "rw");
    
    // Localizar a posição da linha que deseja sobrescrever
    int numeroDaLinha = 3; // exemplo
    arquivo.seek(0);
    for (int i = 1; i < numeroDaLinha; i++) {
        arquivo.readLine();
    }
    long posicaoInicial = arquivo.getFilePointer();
    
    // Sobrescrever a linha
    String novaLinha = "Nova linha que irá sobrescrever a linha antiga";
    arquivo.writeBytes(novaLinha);
    
    // Fechar o arquivo
    arquivo.close();
} catch (IOException e) {
    e.printStackTrace();
}
Sim, é possível sobrescrever uma linha em um arquivo sem reescrever o arquivo inteiro. Para isso, você precisa seguir os seguintes passos:

Abrir o arquivo em modo leitura e escrita (RandomAccessFile).
Localizar a posição da linha que deseja sobrescrever usando o método seek().
Sobrescrever a linha usando o método writeBytes() ou writeUTF() do objeto RandomAccessFile.

Neste exemplo, a linha que está na posição 3 do arquivo será sobrescrita pela nova linha. Note que é importante abrir o arquivo em modo leitura e escrita ("rw"), caso contrário não será possível realizar a sobrescrita.





*/
}