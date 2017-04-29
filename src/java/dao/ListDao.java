package dao;

import entity.Category;
import entity.Comments;
import entity.Posts;
import entity.Users;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class ListDao {
    public List catList(){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();        
        List<Category> cList= session.createQuery("SELECT al.catName FROM Category al").list();
        cList.toString();
        session.close();
        System.out.println(cList.size());
        return cList;
    }
    
    
    public List<Category> catListByName(String name){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();        
        List<Category> cList= session.createQuery("SELECT al FROM Category al"
                + " WHERE lower(catName) = '"+ name.toLowerCase() +"'").list();
        cList.toString();
        session.close();
        return cList;
    }

    public List allPostList(int page) {
       
        int postPerPage = 5;
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();   
        Query query = session.createQuery("SELECT p FROM Posts p ORDER BY p.postDate DESC");
        query.setFirstResult(page*postPerPage);
        query.setMaxResults(postPerPage);
        
        List<Posts> cList= query.list();
        
        cList.toString();
        
        for (int i = 0; i < cList.size(); i++) {
            String old = cList.get(i).getPostContent();
            
            cList.get(i).setPostContent(summary(old) + "...");
        }
        
        session.close();
        return cList;
    }
    
    public List allSearchPostList(int page, String keyword) {
        int postPerPage = 5;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();   
        Query query = session.createQuery("SELECT p FROM Posts p WHERE p.postTitle LIKE :key ORDER BY p.postDate DESC");
        
        query.setString("key", "%"+keyword+"%");
        query.setFirstResult(page*postPerPage);
        query.setMaxResults(postPerPage);
        List<Posts> cList= query.list();
        
        cList.toString();
        
        for (int i = 0; i < cList.size(); i++) {
            String old = cList.get(i).getPostContent();
            
            cList.get(i).setPostContent(summary(old) + "...");
        }
        
        session.close();
        return cList;
    }

    
    public List allPostList1(int page) {
       
        int postPerPage = 5;
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();   
        Query query = session.createQuery("SELECT p FROM Posts p ORDER BY p.postDate DESC");
        query.setFirstResult(page*postPerPage);
        query.setMaxResults(postPerPage);
        
        List<Posts> cList= query.list();
        
        cList.toString();
        
        
        session.close();
        return cList;
    }
    
    public String summary(String s){
        String summary = "";
        boolean adding = true;
        
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '<'){
                adding = false;
            }
            
            if(s.charAt(i) == '>'){
                adding = true;
            }
            
            if(adding && s.charAt(i) != '>' && s.charAt(i) != '<'){
                summary += s.charAt(i);
            }
            
            if(summary.length()>222){
                break;
            }
        }
        
        return summary;
    
    }
    
    
    public List allCatPostList(int postId, int page) {
        int postPerPage = 5;
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession(); 
        
        Query query = session.createQuery("SELECT p FROM Posts p WHERE p.category.catId =:cid ORDER BY p.postDate DESC");        
        query.setInteger("cid", postId);
        query.setFirstResult(page*postPerPage);
        query.setMaxResults(postPerPage);
        
        List<Posts> cList= query.list();
        
        cList.toString();
        
        for (int i = 0; i < cList.size(); i++) {
            String old = cList.get(i).getPostContent();            
            cList.get(i).setPostContent(summary(old) + "...");
        }
        
        session.close();
        return cList;
    }
    
    public List allUserPostList(int userId, int page) {
        int postPerPage = 5;
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession(); 
        
        Query query = session.createQuery("SELECT p FROM Posts p WHERE p.users.UId =:uid ORDER BY p.postDate DESC");        
        query.setInteger("uid", userId);
        query.setFirstResult(page*postPerPage);
        query.setMaxResults(postPerPage);
        
        List<Posts> cList= query.list();
        
        cList.toString();
        
        for (int i = 0; i < cList.size(); i++) {
            String old = cList.get(i).getPostContent();            
            cList.get(i).setPostContent(summary(old) + "...");
        }
        
        session.close();
        return cList;
    }
    
    public List allCategoryList() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession(); 
        
        List<Category> cList= session.createQuery("SELECT c FROM Category c").list();        
        cList.toString();
        
        session.close();
        return cList;
    }
    
    public List allCommentsList(int postId) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();    
        Query query = session.createQuery("SELECT c FROM Comments c "
                + "WHERE c.posts.postId = :pid ORDER BY c.commentDate");
        query.setInteger("pid", postId);
        
        List<Comments> cList= query.list();        
        cList.toString();
        
        session.close();
        return cList;
    }
    
    
    
    
    public List singlePostList(int postId){
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();        
        Query query = session.createQuery("SELECT p FROM Posts p WHERE p.postId =:pid");
        query.setInteger("pid", postId);
        
        List<Posts> cList= query.list();
        cList.toString();
        session.close();
        return cList;
    }

    public List<Category> allCattList() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();        
        Query query = session.createQuery("SELECT c FROM Category c");
        
        List<Category> cList= query.list();
        cList.toString();
        session.close();
        return cList;
    }
    
    public List<Users> allUsersList(int page) {
        int postPerPage = 5;
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();        
        Query query = session.createQuery("SELECT u FROM Users u ORDER BY URegistered DESC");
        
        query.setFirstResult(page*postPerPage);
        query.setMaxResults(postPerPage);
        
        List<Users> cList= query.list();
        cList.toString();
        session.close();
        return cList;
    }
    
    public long getTotalUser() {
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();        
        Query query = session.createQuery("SELECT COUNT(*) FROM Users");
        
        long total =(long) query.uniqueResult();
      
        return total;
    }
    
    public long getTotalPosts() {
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();        
        Query query = session.createQuery("SELECT COUNT(*) FROM Posts");
        
        long total =(long) query.uniqueResult();
      
        return total;
    }
    
}
