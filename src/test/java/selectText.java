
import cn.accp.entity.Emp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class selectText {
    public static void main(String[] args) {
        Configuration configure = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql="from Emp";
        Query query = session.createQuery(sql);
        List<Emp> list = query.list();
        for (Emp emp:list){
            System.out.print(emp);
        }
        transaction.commit();
        session.close();
    }
}
