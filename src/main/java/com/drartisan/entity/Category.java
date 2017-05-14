package com.drartisan.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by summer on 2017/5/13.
 */
@Entity
public class Category {
    @Id
    private int categoryId;
    private String categoryName;
    private int parentId;
    private String classList;
    private int classLayer;
    private int sortId;


    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getClassList() {
        return classList;
    }

    public void setClassList(String classList) {
        this.classList = classList;
    }

    public int getClassLayer() {
        return classLayer;
    }

    public void setClassLayer(int classLayer) {
        this.classLayer = classLayer;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }
}
