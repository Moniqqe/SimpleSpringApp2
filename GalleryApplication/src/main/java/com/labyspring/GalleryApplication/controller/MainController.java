package com.labyspring.GalleryApplication.controller;


import com.labyspring.GalleryApplication.model.Image;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.labyspring.GalleryApplication.properties.GlobalProperties;
import com.labyspring.GalleryApplication.model.ListOfImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.InitializingBean;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;


@Controller
public class MainController implements InitializingBean{

    ListOfImages li = new ListOfImages();
    List<Image> newOne = new ArrayList<>();

    @Autowired
    private GlobalProperties globalProperties;

    @Override
    public void afterPropertiesSet() {
        li.setPath(globalProperties.getGalleryPath());
        li.putImagesToMap();
        newOne = li.getImages();
    }

    @RequestMapping(value = "/gallery/pictures/{index}")
    public String showImage(ModelMap model, @PathVariable int index, HttpServletResponse response) throws IOException
    {
        Image modelImage = li.getImage(index - 1);
        if(modelImage == null)
            return "error";
        else {
            //mod.addAttribute("modelImages", modelImage);
            model.put("modelImage", modelImage);
            return "showImage";
        }
    }


    @RequestMapping(value = "/gallery")
    public String allImages(ModelMap model)
    {
        if (newOne == null) {
            return "error";
        }
        else {
            model.put("allImages", newOne);
            return "allImages";
        }
    }

    @RequestMapping(value = "gallery/picture/{index}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String deleteImage (ModelMap model, @PathVariable int index, HttpServletResponse response) throws IOException{

        if (newOne == null) {
            return "{\"result\":false}";
        }
        else {
            newOne = li.deleteImage(index-1);
            //model.put("allImages", newOne);
            return "{\"result\":true}";
        }
    }

    @RequestMapping(value = "gallery/panel/{index}")
    public String deleteI(ModelMap model, @PathVariable int index, HttpServletResponse response) throws IOException{

        if (newOne == null) {
            return "error";
        }
        else {
            newOne = li.deleteImage(index-1);
            model.put("allImages", newOne);
            return "deleteImage";
        }
    }

    @RequestMapping(value = "gallery/panel")
    public String deleteImag(ModelMap model){

        if (newOne == null) {
            return "error";
        }
        else {
            model.put("allImages", newOne);
            return "deleteImage";
        }
    }

}
