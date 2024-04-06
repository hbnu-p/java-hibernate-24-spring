import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pojo.Contact;
import pojo.Name;
import pojo.PhoneType;
import pojo.User;

import java.util.ArrayList;

public class HibetnateTest {
    public static void main(String[] args) {
        // 构建session
        // 加载配置
        Configuration configuration = new Configuration().configure();
        // 构建sessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // 获取session
        Session session = sessionFactory.openSession();

        // 打开事务
        Transaction transaction = session.beginTransaction();

        // 不会写……
        Contact contact = new Contact();
        contact.setId(7);
        contact.setAddress("huangshi");
        contact.setName(new Name("zhou","kangan"));
        contact.getPhones().add("1761111");
        contact.getPhones().add("1762222");
        contact.getMap().put(0,"17611111");
        contact.getMap().put(1,"17612222");
        contact.setPhoneType(PhoneType.MOBILE);

        // 能运行……
        ArrayList <User> Users = new ArrayList<User>();
        session.persist(new User("Luna Sakurakouji","Sakura mansion"));
        session.persist(new User("Ōkura Yūsei","Sakura mansion"));
        session.persist(new User("Kokura Asahi","Sakura mansion"));
        // 新版本把 save（保存） 改成了 persist（持久化）


        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
