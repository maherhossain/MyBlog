package addhandler;

import dao.ListDao;
import dao.RegisterDao;
import entity.Users;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped

public class RegisterMB implements Serializable{
    Users users = new Users();
    Users selectedUser;
    String next="0";

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
      
    public Users getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(Users selectedUser) {
        this.selectedUser = selectedUser;
    }
    
    
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
    
    public String register(){
        users.setUFullname(users.getUFullname());
        users.setUEmail(users.getUEmail());
        users.setUUsername(users.getUUsername());
        users.setUPass(users.getUPass());
        //users.setURegistered(users.getURegistered());
        users.setURegistered(new Date());
        
        if(new RegisterDao().register(users)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registration successfull", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
        return null;
    }
    
    public List<Users> getAllUsers(){
        List<Users> clist = new ListDao().allUsersList(nextPageNumber()-1);        
        return clist;
    }
    
       
    public String updateUser(){
        System.out.println("updating User...");
        selectedUser.setUFullname(selectedUser.getUFullname());
        selectedUser.setUEmail(selectedUser.getUEmail());
        
       
                
        if(new RegisterDao().updateUsers(selectedUser)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "User updated successfully", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
        return null;
    }
    
    public String deleteUsers(){
        System.out.println("deleting Users...");
        
               
        if(new RegisterDao().deleteUsers(selectedUser)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "User deleted successfully", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
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
