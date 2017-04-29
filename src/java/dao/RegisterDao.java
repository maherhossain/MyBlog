/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Category;
import entity.Comments;
import entity.Posts;
import entity.Users;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;
import util.SessionUtil;

/**
 *
 * @author B6
 */
public class RegisterDao {

    public boolean register(Users u) {
        try {

            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            session.save(u);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
    
    public boolean login(Users user) {
        try {

            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
            
            Query query = session.createQuery("SELECT u FROM Users u WHERE u.UUsername=:uname AND u.UPass =:pass");
            query.setString("uname", user.getUUsername());
            query.setString("pass", user.getUPass());          
            
            List<Users> cList= query.list();
            cList.toString();
            session.getTransaction().commit();
            session.close();
            
            if(cList.size()>0){
                HttpSession session1 = SessionUtil.getSession();
                session1.setAttribute("uname", cList.get(0).getUUsername());
                session1.setAttribute("uid", cList.get(0).getUId());                
                return true;
            } else{
                return false;                
            }
            

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
    
    
    
    public boolean addCategory(Category c) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            session.save(c);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateCategory(Category c) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            session.update(c);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
    
    public boolean updatePost(Posts p) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            session.update(p);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateUsers(Users u) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            session.update(u);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean deleteCategory(Category c) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(c);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
    
    public boolean deletePost(Posts p) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(p);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteUsers(Users u) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            session.delete(u);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
    
    public boolean addPost(Posts p) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            session.save(p);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
    
    public boolean addComments(Comments c) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            session.save(c);

            session.getTransaction().commit();
            session.close();
            return true;

        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
    }
}
