/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import dao.ListDao;
import entity.Comments;
import entity.Posts;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;



@ManagedBean

public class DisplayPostMB implements Serializable{
    Posts posts = new Posts();   
    String next="0";
      
    
    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
      
    
    
    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }
    
    
    
    public List<Posts> getAllPosts(){
        List<Posts> plist = new ListDao().allPostList(nextPageNumber()-1);        
        return plist;
    }
    
    
    
    
    
    public List<Posts> getAllPosts1(){
        List<Posts> plist = new ListDao().allPostList1(nextPageNumber()-1);        
        return plist;
    }
    
    
    public List<Comments> getAllComments(int postId){
        List<Comments> plist = new ListDao().allCommentsList(postId);        
        return plist;
    }
    
    public String urlEncode(String s){
        return s.replace(" ", "-");
    }
    
    public int nextPageNumber(){
        int nextPageNumber = 1;
        try {
            nextPageNumber = Integer.parseInt(next)+1;
        } catch (Exception e) {
        }
        
        return nextPageNumber;
    }
    
}
