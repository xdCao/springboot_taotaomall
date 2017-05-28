package app.service;

import app.mapper.ItemParamMapper;
import app.model.DataGridResult;
import app.pojo.Item;
import app.pojo.ItemParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xdcao on 2017/5/28.
 */
@Service
public class ItemParamService {

    @Autowired
    private ItemParamMapper itemParamMapper;

    public DataGridResult getItemParamListByPage(int page, int rows){
        PageHelper.startPage(page,rows);
        List<ItemParam> items=itemParamMapper.getAll();
        PageInfo<ItemParam> pageInfo=new PageInfo<ItemParam>(items);
        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setTotal(pageInfo.getTotal());
        dataGridResult.setRows(items);
        return dataGridResult;
    }



}
