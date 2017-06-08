package app.mapper;

import app.pojo.ItemParam;
import app.pojo.ItemParamItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by xdcao on 2017/5/29.
 */
public interface ItemParamItemMapper {

    @Select("select * from tb_item_param_item")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "item_id",column = "item_id"),
            @Result(property = "param_data",column = "param_data"),
            @Result(property = "created",column = "created"),
            @Result(property = "updated",column = "updated")
    })
    List<ItemParamItem> getAll();

    @Select("select * from tb_item_param_item where id=#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "item_id",column = "item_id"),
            @Result(property = "param_data",column = "param_data"),
            @Result(property = "created",column = "created"),
            @Result(property = "updated",column = "updated")
    })
    ItemParamItem getOne(long id);


    @Select("select * from tb_item_param_item where item_id=#{itemId}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "item_id",column = "item_id"),
            @Result(property = "param_data",column = "param_data"),
            @Result(property = "created",column = "created"),
            @Result(property = "updated",column = "updated")
    })
    ItemParamItem getItemParamsByItemId(long itemId);


    @Insert("insert into tb_item_param_item (item_id,param_data,created,updated) values (#{item_id},#{param_data},#{created},#{updated})")
    void insert(ItemParamItem itemParamItem);

    @Update("update tb_item_param_item set item_id=#{item_id},param_data=#{param_data},created=#{created},updated=#{updated} where id=#{id}")
    void update(ItemParamItem itemParamItem);

    @Delete("delete from tb_item_param_item where id=#{id}")
    void delete(long id);


}
