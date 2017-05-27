package app.service;

import app.mapper.ItemDescMapper;
import app.mapper.ItemMapper;
import app.model.DataGridResult;
import app.model.TaoTaoResult;
import app.pojo.Item;
import app.pojo.ItemDesc;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by xdcao on 2017/5/23.
 */
@Service
public class ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemDescMapper itemDescMapper;

    public Item getItemById(long id){
        return itemMapper.getOne(id);
    }


    public List<Item> getAllItems(){
        return itemMapper.getAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public TaoTaoResult insertItem(Item item, String desc){
        long id=System.currentTimeMillis();
        item.setId(id);
        item.setStatus(1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        itemMapper.insert(item);
        ItemDesc itemDesc=new ItemDesc();
        itemDesc.setItem_id(id);
        itemDesc.setItem_desc(desc);
        itemDesc.setCreated(item.getCreated());
        itemDesc.setUpdated(item.getUpdated());
        itemDescMapper.insert(itemDesc);
        return new TaoTaoResult(200,"ok",null);
    }

    public void updateItem(Item item){
        itemMapper.update(item);
    }
    @Transactional
    public void deleteItemById(long id){
        itemMapper.delete(id);
    }

    public DataGridResult getItemListByPage(int page,int rows){
        PageHelper.startPage(page,rows);
        List<Item> items=itemMapper.getAll();
        PageInfo<Item> pageInfo=new PageInfo<Item>(items);
        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setTotal(pageInfo.getTotal());
        dataGridResult.setRows(items);
        return dataGridResult;
    }

}
