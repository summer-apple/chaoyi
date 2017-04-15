package com.drartisan.entity;

import java.util.Collections;
import java.util.List;

/**
 * Created by summer on 16-8-24.
 */
public class Page<T> {

    private int pageNo;
    private int pageSize;
    private List<T> list;
    private int totalCount;

    public static Page EMPTY_PAGE = new Page(0,0, Collections.emptyList(),0);

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public Page(int pageNo, int pageSize, List<T> list, int totalCount) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.list = list;
        this.totalCount = totalCount;
    }

    public Page getEmptyPage(){
        return EMPTY_PAGE;
    }

}
