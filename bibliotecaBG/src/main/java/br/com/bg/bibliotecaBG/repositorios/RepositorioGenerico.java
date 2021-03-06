package br.com.bg.bibliotecaBG.repositorios;

import br.com.bg.bibliotecaBG.utilitarios.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rubens Leme
 */
public class RepositorioGenerico<Entidade> {

    private final Class<Entidade> classe;

    public RepositorioGenerico() {
        this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public boolean salvar(Entidade entidade) {
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        boolean retorno = false;
        Transaction transacao = null;
        try {
            transacao = sessao.beginTransaction();
            sessao.save(entidade);
            transacao.commit();
            retorno = true;
        } catch (RuntimeException e) {
            if (transacao != null) {
                transacao.rollback();
            }
            retorno = false;
            throw e;
        } finally {
            sessao.close();
        }
        return retorno;
    }

}
