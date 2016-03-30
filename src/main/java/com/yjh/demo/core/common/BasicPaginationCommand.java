package com.yjh.demo.core.common;

/**
 * Created by YJH on 2016/3/7.
 */
public class BasicPaginationCommand extends AbstractBasicCommand {

    static final private Integer DEFAULT_PAGE = 1;

    static final private Integer MAX_PAGE_SIZE = 200;

    private Integer page;

    private Integer pageSize;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public final void verifyPage() {
        Integer page = this.getPage();
        if (null == page) {
            this.setPage(DEFAULT_PAGE);
        } else {
            if (page < 1) {
                this.setPage(DEFAULT_PAGE);
            }
        }
    }

    public final void verifyPageSize(Integer defaultValue) {
        Integer pageSize = this.getPageSize();
        if (null == pageSize) {
            pageSize = null != defaultValue ? defaultValue : MAX_PAGE_SIZE;
        } else {
            if (pageSize < 1) {
                pageSize = null != defaultValue ? defaultValue : MAX_PAGE_SIZE;
            }
        }
        this.setPageSize(Math.min(pageSize, MAX_PAGE_SIZE));
    }

}
