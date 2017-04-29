/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package display;

import dao.ListDao;
import entity.Posts;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.servlet.http.HttpSession;
import util.SessionUtil;

@ManagedBean
@SessionScoped

public class SearchResultMB implements Serializable{
    String keyword="software";
    List<Posts> plist= new ArrayList<>();
    String next="0";

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }    
    
    public List<Posts> getPlist() {
        this.plist = new ListDao().allSearchPostList(nextPageNumber()-1, keyword);
        return plist;
    }

    public void setPlist(List<Posts> plist) {
        this.plist = plist;
    }
    
    

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    
    public String search(){
       System.out.println("Keyword is : "+ keyword);
       this.plist = new ListDao().allSearchPostList(nextPageNumber()-1, keyword);
        
        ExternalContext ec = SessionUtil.getExternalContext();
        HttpSession session = SessionUtil.getSession();


        String redirect = ec.getRequestContextPath() + "/search/0"; 


        try {
            ec.redirect(redirect);
        } catch (IOException ex) {
            
        }
        
        return null;
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
