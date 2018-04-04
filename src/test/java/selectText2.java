import cn.accp.entity.Emp;
import cn.accp.util.Queryutil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 * HQL使用  使用名称赋值   要根据不同的数据类型调用 不同的赋值方法
 */
import java.util.List;

public class selectText2 {
    public static void main(String[] args) {
        List<Emp> list = qurty("%E%", 7698);
        for (Emp emp: list){
            System.out.println(emp);
        }
    }
    public static List<Emp> qurty (String aa,int id){
        Session session = Queryutil.openSession();
        Transaction transaction = session.beginTransaction();
        String hql="from Emp where ename like:name and empno=:id";
        Query query = session.createQuery(hql);
        query.setString("name",aa);
        query.setInteger("id",id);
        List list = query.list();

        transaction.commit();
        session.close();

        return list;
    }
}
