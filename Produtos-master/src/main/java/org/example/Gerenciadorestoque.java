package org.example;


import static org.hibernate.cfg.AvailableSettings.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Gerenciadorestoque {
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
}
