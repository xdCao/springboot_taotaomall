package app.mapper;

import app.pojo.ContentCat;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * Created by xdcao on 2017/5/30.
 */
public interface ContentCatMapper {

    @Select("select * from tb_content_category")
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
    List<ContentCat> getAll();

    @Select("select * from tb_content_category where id=#{id}")
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
    ContentCat getOne(long id);

    @Select("select * from tb_content_category where parent_id=#{parentId}")
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
    List<ContentCat> getContentCatByParentId(long parentId);

}
