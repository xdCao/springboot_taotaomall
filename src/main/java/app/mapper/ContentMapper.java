package app.mapper;

import app.pojo.Content;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by xdcao on 2017/5/23.
 */
public interface ContentMapper {

    @Select("select * from tb_content")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "categoryId",column = "category_id"),
            @Result(property = "title",column = "title"),
            @Result(property = "sub_title",column = "sub_title"),
            @Result(property = "title_desc",column = "title_desc"),
            @Result(property = "url",column = "url"),
            @Result(property = "pic",column = "pic"),
            @Result(property = "pic2",column = "pic2"),
            @Result(property = "content",column = "content"),
            @Result(property = "created",column = "created"),
            @Result(property = "updated",column = "updated")
    })
    List<Content> getAll();

    @Select("select * from tb_content where category_id=#{categoryId}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "categoryId",column = "category_id"),
            @Result(property = "title",column = "title"),
            @Result(property = "sub_title",column = "sub_title"),
            @Result(property = "title_desc",column = "title_desc"),
            @Result(property = "url",column = "url"),
            @Result(property = "pic",column = "pic"),
            @Result(property = "pic2",column = "pic2"),
            @Result(property = "content",column = "content"),
            @Result(property = "created",column = "created"),
            @Result(property = "updated",column = "updated")
    })
    List<Content> getByCatId(Long categoryId);

    @Select("select * from tb_content where id=#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "categoryId",column = "category_id"),
            @Result(property = "title",column = "title"),
            @Result(property = "sub_title",column = "sub_title"),
            @Result(property = "title_desc",column = "title_desc"),
            @Result(property = "url",column = "url"),
            @Result(property = "pic",column = "pic"),
            @Result(property = "pic2",column = "pic2"),
            @Result(property = "content",column = "content"),
            @Result(property = "created",column = "created"),
            @Result(property = "updated",column = "updated")
    })
    Content getOne(long id);

    @Insert("insert into tb_content(category_id,title,sub_title,title_desc,url,pic,pic2,content,created,updated) " +
            "values(#{categoryId},#{title},#{sub_title},#{title_desc},#{url},#{pic},#{pic2},#{content},#{created},#{updated})")
    void insert(Content content);


    @Update("update tb_content set category_id=#{categoryId},title=#{title},sub_title=#{sub_title},title_desc=#{title_desc}" +
            ",url=#{url},pic=#{pic},pic2=#{pic2},content=#{content},created=#{created},updated=#{updated} where id=#{id}")
    void update(Content content);

    @Delete("delete from tb_content where id=#{id}")
    void delete(long id);

}
