package display;

import dao.ListDao;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean

public class DisplayWelcome implements Serializable{
    
    
    public long getTotalUser(){
        long total = new ListDao().getTotalUser();        
        return total;
    }
    
    public long getTotalPosts(){
        long total = new ListDao().getTotalPosts();        
        return total;
    }
}
