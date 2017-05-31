package app.mapper;

import app.pojo.ContentCat;
import org.apache.ibatis.annotations.*;

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

    @Insert("insert into tb_content_category (parent_id,name,status,sort_order,is_parent,created,updated) " +
            "values (#{parent_id},#{name},#{status},#{sort_order},#{is_parent},#{created},#{updated})")
    @SelectKey(statement ="select last_insert_id()" , keyProperty = "id", keyColumn = "id", before = false, resultType = Long.class)
    void insert(ContentCat contentCat);

    @Update("update tb_content_category set parent_id=#{parent_id},name=#{name},status=#{status},sort_order=#{sort_order},is_parent=#{is_parent},updated=#{updated} where id=#{id}")
    void update(ContentCat contentCat);

    @Delete("delete from tb_content_category where id=#{id}")
    void delete(long id);

}
