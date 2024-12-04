package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import static org.hibernate.cfg.JdbcSettings.FORMAT_SQL;
import static org.hibernate.cfg.JdbcSettings.HIGHLIGHT_SQL;
import static org.hibernate.cfg.JdbcSettings.PASS;
import static org.hibernate.cfg.JdbcSettings.SHOW_SQL;
import static org.hibernate.cfg.JdbcSettings.URL;
import static org.hibernate.cfg.JdbcSettings.USER;

public class Gerenciadorestoque {
    

    //FAZ CONEXAO COM O BANCO DE DADOS.... 
    private SessionFactory configuration = new Configuration()
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect")
                .addAnnotatedClass(Produto.class)
    // use H2 in-memory database
                .setProperty(URL, "jdbc:mysql://localhost:3306/banco_produtos")
                .setProperty(USER, "root")
                .setProperty(PASS, "")
    // use Agroal connection pool
                .setProperty("hibernate.agroal.maxSize", 20)
    // display SQL in console
                .setProperty(SHOW_SQL, true)
                .setProperty(FORMAT_SQL, true)
                .setProperty(HIGHLIGHT_SQL, true)
                .buildSessionFactory();

    public void addProduto (Produto produto){
        configuration.inTransaction(session -> {
            session.persist(produto);

        });
    }
    public void deleteProduto (Integer id){
        configuration.inTransaction(session -> {
            Produto produto = session.get(Produto.class, id);
            session.delete(produto);
        });

    }
    
    public Produto getProduto(Integer id) {
        Session session = null;
        try {
            session = configuration.openSession();
            session.beginTransaction();
            Produto produto = session.get(Produto.class, id);
            session.getTransaction().commit();
            return produto;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();

            }
        }
     return null;
    }

    public Produto updateProduto (Integer id,Produto produto){
        Produto produto1 = getProduto(id);
        produto1.setNome(produto.getNome());
        produto1.setPreco(produto.getPreco());
        produto1.setQuantidade(produto.getQuantidade());
        configuration.inTransaction(session -> {
            session.update(produto1);
            session.flush();

        });
        return null;
    }

}
