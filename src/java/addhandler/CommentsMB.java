
package addhandler;

import dao.RegisterDao;
import entity.Comments;
import entity.Posts;
import entity.Users;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped

public class CommentsMB implements Serializable{
    Comments comments = new Comments();
    Users users = new Users();
    Posts posts = new Posts();

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }
    
    

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }
    
    public String addComments(int uid, int postid){
        users.setUId(new Long(uid));
        posts.setPostId(new Long(postid));
        
        comments.setCommentContent(comments.getCommentContent());
        comments.setUsers(users);
        comments.setPosts(posts);
        comments.setCommentDate(new Date());
        
        if(new RegisterDao().addComments(comments)){
            comments.setCommentContent("");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Comment added successfully", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
        return null;
        
    }
    
}
