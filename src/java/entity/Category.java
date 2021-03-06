package entity;
// Generated Jan 28, 2016 5:30:30 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Category generated by hbm2java
 */
public class Category  implements java.io.Serializable {


     private Long catId;
     private long catParent;
     private String catName;
     private Set postses = new HashSet(0);

    public Category() {
    }

	
    public Category(long catParent, String catName) {
        this.catParent = catParent;
        this.catName = catName;
    }
    public Category(long catParent, String catName, Set postses) {
       this.catParent = catParent;
       this.catName = catName;
       this.postses = postses;
    }
   
    public Long getCatId() {
        return this.catId;
    }
    
    public void setCatId(Long catId) {
        this.catId = catId;
    }
    public long getCatParent() {
        return this.catParent;
    }
    
    public void setCatParent(long catParent) {
        this.catParent = catParent;
    }
    public String getCatName() {
        return this.catName;
    }
    
    public void setCatName(String catName) {
        this.catName = catName;
    }
    public Set getPostses() {
        return this.postses;
    }
    
    public void setPostses(Set postses) {
        this.postses = postses;
    }




}


