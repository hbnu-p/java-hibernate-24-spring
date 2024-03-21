import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import pojo.Contact;
import pojo.Name;
import pojo.PhoneType;
import pojo.User;

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

        Contact contact = new Contact();
        contact.setId(7);
        contact.setAddress("huangshi");
        contact.setName(new Name("zhou","kangan"));
        contact.getPhones().add("1761111");
        contact.getPhones().add("1762222");
        contact.getMap().put(0,"17611111");
        contact.getMap().put(1,"17612222");
        contact.setPhoneType(PhoneType.MOBILE);

        session.save(contact);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
