/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addhandler;

import dao.ListDao;
import java.util.List;
import dao.RegisterDao;
import entity.Category;
import entity.Posts;
import entity.Users;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped

public class PostsMB implements Serializable{
    Posts posts = new Posts();
    Users users = new Users();
    Category category = new Category();
    
    Posts sellectedPost;

    public Posts getSellectedPost() {
        return sellectedPost;
    }

    public void setSellectedPost(Posts sellectedPost) {
        this.sellectedPost = sellectedPost;
    }
    
    
    String catName;
    List<Category> listCtat; 

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
    
    
    public List<Category> getListCtat() {
        return listCtat;
    }

    public void setListCtat(List<Category> listCtat) {
        this.listCtat = listCtat;
    }
    

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    
    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }
    
    public String addPost(int uid){
        users.setUId(new Long(uid));
        
        
        listCtat = new ListDao().catListByName(catName);
        category.setCatId(listCtat.get(0).getCatId());
        
        posts.setUsers(users);
        posts.setCategory(category);
        posts.setPostDate(new Date());
        posts.setPostTitle(posts.getPostTitle());
        posts.setPostContent(posts.getPostContent());
        
        
        if(new RegisterDao().addPost(posts)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Post added successfully", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
        return null;
    }
    
    public List<SelectItem> getCategoryName(){
        List<SelectItem> catNames = new ListDao().catList();        
        return catNames;
    }
    
    public String updatePost(){
        System.out.println("updating Post...");
        sellectedPost.setPostTitle(sellectedPost.getPostTitle());
        sellectedPost.setPostContent(sellectedPost.getPostContent());
        
       
                
        if(new RegisterDao().updatePost(sellectedPost)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Post updated successfully", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
        return null;
    }
    
    public String deletePost(){
        System.out.println("deleting Category...");
        
               
        if(new RegisterDao().deletePost(sellectedPost)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Post deleted successfully", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
        return null;
    }
  
}
