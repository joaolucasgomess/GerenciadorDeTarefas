import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class GerenciadorDeUsuarios{

    public void cadastrarUsuario(){
        System.out.println("Digite seu usuario: ");
        Scanner leia = new Scanner(System.in);
        String nomeUsuario = leia.nextLine();
        Usuario novoUsuario = new Usuario(nomeUsuario);
        try {
            //Validar dados do usuario
            if (nomeUsuario == "") {
              System.out.println("Dados faltantes, nao deixe o nome de usuario em branco,");
              System.exit(0);
            }/*
            //Verificar se usuario existe
            boolean usuarioExistente = verificarUsuarioExistente(novo.getNome());
            if(usuarioExistente){
               throw new Error("Usuario Existente");
            }
            
            //Adicionar linha ao arquivo Usuarios.usu
            String novaLinha = String.format("%s;%d;%s;%s", novo.getNome(), novo.getIdade(), novo.getEndereco(), novo.getId());
            FileManager.adicionarLinhaAoArquivo("Usuarios.usu", novaLinha);
      
            //Exibir mensagem de usuario cadastrado com sucesso */
          } catch (Exception e) {
            System.out.println(e.getMessage());
          }
    }
}