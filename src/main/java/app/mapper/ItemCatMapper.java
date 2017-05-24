package app.mapper;

import app.pojo.ItemCat;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by xdcao on 2017/5/24.
 */
public interface ItemCatMapper {

    @Select("select * from tb_item_cat where parent_id=#{parent_id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "parent_id",column = "parent_id"),
            @Result(property = "name",column = "name"),
            @Result(property = "status",column = "status"),
            @Result(property = "sort_order",column = "sort_order"),
            @Result(property = "is_parent",column = "is_parent"),
            @Result(property = "created",column = "created"),
            @Result(property = "updated",column = "updated")
    })
    List<ItemCat> getByParentId(long parent_id);


}
