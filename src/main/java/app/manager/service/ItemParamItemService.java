package app.manager.service;

import app.mapper.ItemParamItemMapper;
import app.pojo.ItemParam;
import app.pojo.ItemParamItem;
import com.alibaba.druid.support.json.JSONUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xdcao on 2017/6/8.
 */
@Service
public class ItemParamItemService {

    @Autowired
    private ItemParamItemMapper itemParamItemMapper;

    private ObjectMapper mapper = new ObjectMapper();


    public JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }


    public ItemParamItem getItemParamItemByItemId(long itemId) throws IOException {
        ItemParamItem itemParamItem=itemParamItemMapper.getItemParamsByItemId(itemId);
        String paramData=itemParamItem.getParam_data();

        JavaType javaType = getCollectionType(ArrayList.class, Map.class);
        List<Map> mapList =  mapper.readValue(paramData, javaType);
        StringBuffer sb=new StringBuffer();
        sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\" class=\"Ptable\">\n");
        sb.append(" <tobdy>\n");
        for(Map map:mapList){
            sb.append("    <tr>\n");
            sb.append("        <th class=\"tdTitle\" colspan=\"2\">"+map.get("group")+"</th>\n");
            sb.append("    </tr>\n");
            List<Map> mapList2=(List<Map>)map.get("params");
            for (Map map2:mapList2){
                sb.append("    <tr>\n");
                sb.append("      <td class=\"tdTitle\">"+map2.get("k")+"</td>\n");
                sb.append("      <td>"+map2.get("v")+"</td>\n");
                sb.append("    </tr>\n");
            }
        }
        sb.append(" </tbody>\n");
        sb.append("</table>");
        itemParamItem.setParam_data(sb.toString());
        return itemParamItem;
    }


}
