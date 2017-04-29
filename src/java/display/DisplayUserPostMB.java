package display;

import dao.ListDao;
import entity.Posts;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean

public class DisplayUserPostMB implements Serializable{
    String userId, userName;
    String next;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
    
    public List<Posts> getAllUserPosts(){
        int uid = 0;
        try {
            uid = Integer.parseInt(userId);
        } catch (Exception e) {
        }
        List<Posts> plist = new ListDao().allUserPostList(uid, nextPageNumber()-1);        
        return plist;
    }
    
    public int nextPageNumber(){
        System.out.println(next);
        int nextPageNumber = 1;
        try {
            nextPageNumber = Integer.parseInt(next)+1;
        } catch (Exception e) {
           // e.printStackTrace();
        }
        
        return nextPageNumber;
    }
}
