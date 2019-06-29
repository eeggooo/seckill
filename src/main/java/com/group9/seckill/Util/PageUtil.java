package com.group9.seckill.Util;

public class PageUtil {
    private int pageNum;

    private int pageSize;

    private int pageIndex;

    private int totalCount;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    private int totalPage;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPagesize() {
        return pageSize;
    }

    public void setPagesize(int pagesize) {
        this.pageSize = pagesize;
    }


    public int getPageIndex() {
        return (pageNum-1)*pageSize;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getTotalPage() {
        if(totalCount%pageSize==0){
            return totalCount/pageSize;
        }
        else{
            return totalCount/pageSize+1;
        }
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
