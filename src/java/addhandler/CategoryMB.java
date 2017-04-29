package addhandler;

import dao.ListDao;
import dao.RegisterDao;
import entity.Category;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class CategoryMB implements Serializable{
    Category category=new Category();
    private Category selectedCat;

    public Category getSelectedCat() {
        return selectedCat;
    }

    public void setSelectedCat(Category selectedCat) {
        this.selectedCat = selectedCat;
    }
    
    

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public String addCategory(){
        System.out.println("Adding Category...");
        category.setCatName(category.getCatName());
        category.setCatId(category.getCatId());
        category.setCatParent(0);
        
        
        if(new RegisterDao().addCategory(category)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Category added successfully", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
        return null;
    }
    
    public String updateCategory(){
        System.out.println("updating Category...");
        selectedCat.setCatName(selectedCat.getCatName());
       
        
        System.out.println("Id:"  + selectedCat.getCatId() );
        System.out.println("Name:"  + selectedCat.getCatName());
        System.out.println("Parent:"  + selectedCat.getCatParent());
                
        if(new RegisterDao().updateCategory(selectedCat)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Category updated successfully", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
        return null;
    }
    
    public String deleteCategory(){
        System.out.println("deleting Category...");
        
               
        if(new RegisterDao().deleteCategory(selectedCat)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Category deleted successfully", ""));
        } else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Something went wrong!", ""));
        }
        return null;
    }
    
   
    
    
    
    public List<Category> getAllCategory(){
        List<Category> clist = new ListDao().allCattList();        
        return clist;
    }
    
    
}
