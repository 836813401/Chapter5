package cn.accp.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Queryutil {
    private  static SessionFactory sf=null;
    static {
        Configuration configure = new Configuration().configure("hibernate.cfg.xml");
            sf= configure.buildSessionFactory();
    }
//打开会话
    public static Session openSession(){
        return sf.openSession();
    }
}
