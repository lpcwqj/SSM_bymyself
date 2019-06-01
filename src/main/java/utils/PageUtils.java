package utils;

import java.util.List;

/**
 * @author Lin
 * @Date 2019/5/28
 *
 * 分页数据封装工具
 */

public class PageUtils<T>{
    private Integer currentPage;    //当前页数
    private Integer pageSize;       //每页显示的记录数
    private Integer totalPage;      //总页数
    private Integer totalRecord;    //总记录数
    private List<T> list;   //每页显示的结果集，封装在集合中

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
