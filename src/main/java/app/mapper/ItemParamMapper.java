package app.mapper;

import app.pojo.ItemParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by xdcao on 2017/5/28.
 */
public interface ItemParamMapper {

    @Select("select * from tb_item_param")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "item_cat_id",column = "item_cat_id"),
            @Result(property = "param_data",column = "param_data"),
            @Result(property = "created",column = "created"),
            @Result(property = "updated",column = "updated")
    })
    List<ItemParam> getAll();

    @Select("select * from tb_item_param where id=#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "item_cat_id",column = "item_cat_id"),
            @Result(property = "param_data",column = "param_data"),
            @Result(property = "created",column = "created"),
            @Result(property = "updated",column = "updated")
    })
    ItemParam getOne(long id);

    @Insert("insert into tb_item_param (item_cat_id,param_data,created,updated) values (#{item_cat_id},#{param_data},#{created},#{updated})")
    void insert(ItemParam itemParam);

    @Update("update tb_item_param set item_cat_id=#{item_cat_id},param_data=#{param_data},created=#{created},updated=#{updated} where id=#{id}")
    void update(ItemParam itemParam);

    @Delete("delete from tb_item_param where id=#{id}")
    void delete(long id);

}
