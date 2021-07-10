package app;

import models.AppUser;
import models.UserOrder;
import org.hibernate.Session;
import utils.HibernateSessionFactoryUtil;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        //System.out.println("Hello");
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        AppUser user = AddUser(session);
        AddUserOrder(session, user.getId());
        session.close();
    }
    public static AppUser AddUser(Session session)
    {
        session.beginTransaction();
        AppUser user = new AppUser("Іван");
        session.save(user);
        session.getTransaction().commit();
        return user;
    }

    public static UserOrder AddUserOrder(Session session, int user_id)
    {
        session.beginTransaction();

        UserOrder user = new UserOrder(new Date(System.currentTimeMillis()),
                "54f-54-hjhhtv",user_id);
        session.save(user);
        session.getTransaction().commit();
        return user;
    }
}
