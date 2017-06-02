package app.portal.service;

import app.mapper.ItemCatMapper;
import app.model.CatItemResult;
import app.model.CatNode;
import app.pojo.ItemCat;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xdcao on 2017/5/29.
 */
@Service
public class PortalItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Cacheable(value = "portalitemCat",keyGenerator = "wiselyKeyGenerator")
    public CatItemResult getAllCats(){
        List result=getCatsByParentId(0);
        CatItemResult catItemResult=new CatItemResult();
        catItemResult.setData(result);
        return catItemResult;
    }


    private List getCatsByParentId(long parentId){

        List<ItemCat> list=itemCatMapper.getByParentId(parentId);
        List resultList=new ArrayList();

        int index=0;
        for (ItemCat itemCat:list){

            if (index>=14){
                break;
            }
            if (itemCat.isIs_parent()){
                CatNode catNode=new CatNode();
                catNode.setUrl("/products/"+itemCat.getId()+".html");
                if (itemCat.getParent_id()==0){
                    catNode.setName("<a href='/products/"+itemCat.getId()+".html'>"+itemCat.getName()+"</a>");
                    index++;
                }else {
                    catNode.setName(itemCat.getName());
                }
                catNode.setItems(getCatsByParentId(itemCat.getId()));
                resultList.add(catNode);
            }else {
                String item="/products/"+itemCat.getId()+".html|"+itemCat.getName();
                resultList.add(item);
            }
        }

        return resultList;

    }




}
