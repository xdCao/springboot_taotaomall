package app.pojo;

import java.util.Date;

/**
 * Created by xdcao on 2017/5/28.
 */
public class ItemParam {

    private long id;
    private long item_cat_id;
    private String param_data;
    private Date created;
    private Date updated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getItem_cat_id() {
        return item_cat_id;
    }

    public void setItem_cat_id(long item_cat_id) {
        this.item_cat_id = item_cat_id;
    }

    public String getParam_data() {
        return param_data;
    }

    public void setParam_data(String param_data) {
        this.param_data = param_data;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
