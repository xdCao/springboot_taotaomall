package app.service;

import app.model.PictureResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by xdcao on 2017/5/27.
 */
@Service
public class PictureService {

    private static String filepath="D:/upload";
    private static String baseUrl="http://localhost/";

    public PictureResult uploadPicture(MultipartFile pic) {

        PictureResult pictureResult=new PictureResult();

        if (pic==null){
            pictureResult.setError(1);
            pictureResult.setMessage("文件为空");
            return pictureResult;
        }

        String picName=pic.getOriginalFilename();
        File file=new File(filepath,picName);
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            fileOutputStream.write(pic.getBytes());
        }catch (Exception e){
            pictureResult.setError(1);
            pictureResult.setMessage("上传文件失败");
            return pictureResult;
        }

        pictureResult.setError(0);
        pictureResult.setUrl(baseUrl+picName);
        return pictureResult;


    }

}
