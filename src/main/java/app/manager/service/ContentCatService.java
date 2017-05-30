package app.manager.service;

import app.mapper.ContentCatMapper;
import app.model.TreeNodeResult;
import app.pojo.ContentCat;
import app.pojo.ItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xdcao on 2017/5/30.
 */
@Service
public class ContentCatService {

    @Autowired
    private ContentCatMapper contentCatMapper;

    public List<TreeNodeResult> getContentCatTree(long parent_id){
        List<ContentCat> contentCats=contentCatMapper.getContentCatByParentId(parent_id);
        List<TreeNodeResult> treeNodeResults=new ArrayList<TreeNodeResult>();
        for (ContentCat contentCat:contentCats){
            TreeNodeResult treeNodeResult=new TreeNodeResult();
            treeNodeResult.setId(contentCat.getId());
            treeNodeResult.setText(contentCat.getName());
            treeNodeResult.setState(contentCat.isIs_parent()?"closed":"open");
            treeNodeResults.add(treeNodeResult);
        }
        return treeNodeResults;
    }


}
