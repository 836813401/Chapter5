import cn.accp.entity.Emp;
import cn.accp.util.Queryutil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * HQL使用  使用名称赋值   不要判断数据类型   按对象传,建议使用
 */
public class selectText3 {
    public static void main(String[] args) {
      //  List<Emp> lise = aaa(new Emp("%E%",7499));
      //  for (Emp emp:lise){
          //  System.out.println(emp);
       // }
    }
    public static List<Emp> aaa(Emp emp){
        Session session = Queryutil.openSession();
        Transaction transaction = session.beginTransaction();
        String sql="from Emp ename like:ename and empno=:empno";
        Query query = session.createQuery(sql);
        query.setProperties(emp);
        List<Emp> list =query.list();

        transaction.commit();
        session.close();
        return list;
    }
}
