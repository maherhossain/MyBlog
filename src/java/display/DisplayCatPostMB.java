package display;

import dao.ListDao;
import entity.Posts;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean

public class DisplayCatPostMB implements Serializable{
    String catId, catName;
    String next;

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
    
    
    public List<Posts> getAllCatPosts(){
        int cid = 0;
        try {
            cid = Integer.parseInt(catId);
        } catch (Exception e) {
        }
        List<Posts> plist = new ListDao().allCatPostList(cid, nextPageNumber()-1);        
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
