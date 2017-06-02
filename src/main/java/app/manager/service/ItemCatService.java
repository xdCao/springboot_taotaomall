package app.manager.service;

import app.mapper.ItemCatMapper;
import app.model.TreeNodeResult;
import app.pojo.ItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xdcao on 2017/5/24.
 */
@Service
public class ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Cacheable(value = "itemCatCache",keyGenerator = "wiselyKeyGenerator")
    public List<TreeNodeResult> getItemCatTree(long parent_id){
        List<ItemCat> itemCats=itemCatMapper.getByParentId(parent_id);
        List<TreeNodeResult> treeNodeResults=new ArrayList<TreeNodeResult>();
        for (ItemCat itemCat:itemCats){
            TreeNodeResult treeNodeResult=new TreeNodeResult();
            treeNodeResult.setId(itemCat.getId());
            treeNodeResult.setText(itemCat.getName());
            treeNodeResult.setState(itemCat.isIs_parent()?"closed":"open");
            treeNodeResults.add(treeNodeResult);
        }
        return treeNodeResults;
    }

}
