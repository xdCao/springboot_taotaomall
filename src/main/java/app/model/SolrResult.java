package app.model;

import app.pojo.SolrItem;

import java.util.List;

/**
 * Created by xdcao on 2017/6/6.
 */
public class SolrResult {

    private List<SolrItem> itemlist;
    private Long recordCount;
    private int pageCount;
    private int curPage;

    public List<SolrItem> getItemlist() {
        return itemlist;
    }

    public void setItemlist(List<SolrItem> itemlist) {
        this.itemlist = itemlist;
    }

    public Long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Long recordCount) {
        this.recordCount = recordCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }
}
