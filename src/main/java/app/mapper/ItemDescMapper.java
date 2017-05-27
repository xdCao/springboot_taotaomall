package app.mapper;

import app.pojo.ItemDesc;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by xdcao on 2017/5/27.
 */
public interface ItemDescMapper {

    @Select("select * from tb_item_desc")
    @Results({
            @Result(property = "item_id",column = "item_id"),
            @Result(property = "item_desc",column = "item_desc"),
            @Result(property = "created",column = "created"),
            @Result(property = "updated",column = "updated")
    })
    List<ItemDesc> getAll();

    @Select("select * from tb_item_desc where item_id=#{id}")
    @Results({
            @Result(property = "item_id",column = "item_id"),
            @Result(property = "item_desc",column = "item_desc"),
            @Result(property = "created",column = "created"),
            @Result(property = "updated",column = "updated")
    })
    ItemDesc getOne(long id);

    @Insert("insert into tb_item_desc (item_id,item_desc,created,updated) values (#{item_id},#{item_desc},#{created},#{updated})")
    void insert(ItemDesc itemDesc);

    @Update("update tb_item_desc set item_desc=#{item_desc},updated=#{updated} where item_id=#{item_id}")
    void update(ItemDesc itemDesc);

    @Delete("delete from tb_item_desc where item_id=#{id}")
    void delete(long id);

}
