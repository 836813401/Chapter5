import cn.accp.entity.Emp;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/**
 * HQL使用  使用占位符赋值   要根据不同的数据类型调用 不同的赋值方法
 */
import java.util.List;

public class getText {
    public static void main(String[] args) {
        List<Emp> query = query("%E%");
        for (Emp emp:query){
            System.out.println(emp);
        }
    }
    public  static List<Emp> query(String aa){
        Configuration configure = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configure.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql="from Emp where ename like ?";
        Query query1 = session.createQuery(sql);
        query1.setString(0,aa);
        List list = query1.list();

        transaction.commit();
        session.close();
        return list;
    }


}
