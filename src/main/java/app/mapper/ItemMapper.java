package app.mapper;

import app.pojo.Item;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by xdcao on 2017/5/23.
 */
public interface ItemMapper {

    @Select("select * from tb_item")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "title",column = "title"),
            @Result(property = "sell_point",column = "sell_point"),
            @Result(property = "price",column = "price"),
            @Result(property = "num",column = "num"),
            @Result(property = "barcode",column = "barcode"),
            @Result(property = "image",column = "image"),
            @Result(property = "cid",column = "cid"),
            @Result(property = "status",column = "status"),
            @Result(property = "created",column = "created"),
            @Result(property = "updated",column = "updated")
    })
    List<Item> getAll();


    @Select("select * from tb_item where id=#{id}")
    @Results({
            @Result(property = "title",column = "title"),
            @Result(property = "sell_point",column = "sell_point"),
            @Result(property = "price",column = "price"),
            @Result(property = "num",column = "num"),
            @Result(property = "barcode",column = "barcode"),
            @Result(property = "image",column = "image"),
            @Result(property = "cid",column = "cid"),
            @Result(property = "status",column = "status"),
            @Result(property = "created",column = "created"),
            @Result(property = "updated",column = "updated")
    })
    Item getOne(long id);


    @Insert("insert into tb_item(title,sell_point,price,num,barcode,image,cid,status,created,updated) values " +
            "(#{title},#{sell_point},#{price},#{num},#{barcode},#{image},#{cid},#{status},#{created},#{updated})")
    void insert(Item item);

    @Update("update tb_item set title=#{title},sell_point=#{sell_point},price=#{price},num=#{num},barcode=#{barcode}," +
            "image=#{image},cid=#{cid},status=#{status},created=#{created},updated=#{updated} where id=#{id}")
    void update(Item item);

    @Delete("delete from tb_item where id=#{id}")
    void delete(long id);

}
