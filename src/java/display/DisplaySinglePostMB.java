/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import dao.ListDao;
import entity.Posts;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped

public class DisplaySinglePostMB implements Serializable{
    String singlePostId;
    String singlePostTitle;
    
    public String getSinglePostTitle() {
        return singlePostTitle;
    }

    public void setSinglePostTitle(String singlePostTitle) {
        this.singlePostTitle = singlePostTitle;
    }

    public String getSinglePostId() {
        return singlePostId;
    }

    public void setSinglePostId(String singlePostId) {
        this.singlePostId = singlePostId;
    }
    
    
    
    public List<Posts> getSinglePost(){    
        
        int spid = 0;
        
        try {
            spid = Integer.parseInt(singlePostId);
        } catch (Exception e) {
        }
        
        List<Posts> plist = new ListDao().singlePostList(spid);        
        return plist;
    }
}
