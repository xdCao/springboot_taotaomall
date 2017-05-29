package app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by xdcao on 2017/5/29.
 */
public class CatNode {

    @JsonProperty("u")
    private String url;
    @JsonProperty("n")
    private String name;
    @JsonProperty("i")
    private List items;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }
}
