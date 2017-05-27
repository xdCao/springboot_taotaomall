package app.controller;

import app.model.PictureResult;
import app.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by xdcao on 2017/5/27.
 */
@RestController
public class PictureController {

    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "/pic/upload")
    public PictureResult uploadPic(@RequestParam MultipartFile uploadFile){

        return pictureService.uploadPicture(uploadFile);

    }


}
