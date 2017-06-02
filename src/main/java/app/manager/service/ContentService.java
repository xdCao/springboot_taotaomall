package app.manager.service;

import app.mapper.ContentMapper;
import app.model.DataGridResult;
import app.pojo.Content;
import app.pojo.Item;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xdcao on 2017/6/2.
 */
@Service
public class ContentService {

    @Autowired
    private ContentMapper contentMapper;

    public DataGridResult getContentsByCatId(int page,int rows,Long categoryId){
        PageHelper.startPage(page,rows);
        List<Content> contents=contentMapper.getByCatId(categoryId);
        PageInfo<Content> pageInfo=new PageInfo<Content>(contents);
        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setTotal(pageInfo.getTotal());
        dataGridResult.setRows(contents);
        return dataGridResult;
    }

}
