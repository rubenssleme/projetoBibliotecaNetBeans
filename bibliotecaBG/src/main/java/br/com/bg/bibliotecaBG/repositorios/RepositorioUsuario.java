package br.com.bg.bibliotecaBG.repositorios;

import br.com.bg.bibliotecaBG.dominio.Usuario;
import br.com.bg.bibliotecaBG.utilitarios.Mensagem;

/**
 *
 * @author rubens leme
 */
public class RepositorioUsuario extends RepositorioGenerico<Usuario>{
 
    public void inserirUsuario(Usuario usuario){
        
        Mensagem.exibirMensagem( "Agora foi - "  + usuario.toString());
        
    }
    
    
}
