package com.labyspring.GalleryApplication.model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

import com.google.gson.Gson;


public class ListOfImages implements Serializable{

    private HashMap<Integer, Image> collectionOfImages = new HashMap<>();
    private List<Image> imageList = new ArrayList<>();
    private Image im;
    private BasicFileAttributes myFileAttribiutes = null;
    private int indexCounter = 0;
    private Path p = null;
    private File tmpFile = null;
    private BufferedImage tmpImage = null;
    private String tmpName;
    private String tmpResolution;
    private long tmpSize;
    private FileTime tmpCreated;
    Gson gson = new Gson();
    String s, ss;

    public void setPath(String galPath){
        this.s = galPath;
    }

    public void putImagesToMap() {

            if(collectionOfImages == null)
                return;

            for(int i = 1; i <= 14; i++) {
                try {
                    ss = s;
                    ss += i + ".jpg";
                    tmpFile = new File(ss);
                    tmpImage = ImageIO.read(tmpFile);
                    p = tmpFile.toPath();
                    myFileAttribiutes = Files.readAttributes(p, BasicFileAttributes.class);
                    tmpSize = myFileAttribiutes.size();
                    tmpResolution = tmpImage.getWidth() + "x" + tmpImage.getHeight();
                    tmpName = tmpFile.getName();
                    tmpCreated = myFileAttribiutes.creationTime();
                    im = new Image(indexCounter, tmpName, tmpResolution, tmpSize, tmpCreated);
                    collectionOfImages.put(indexCounter,im);
                    imageList.add(im);
                    indexCounter++;
                    ss="";
                } catch (IOException e) {
                    System.out.println("Error with reading image file");
                    e.printStackTrace();
                }
            }
    }

    public Image getImage(int index){
        for(Image tmp : imageList){
            if(tmp.getIndex() == index){
                return tmp;
            }
        }
        return null;
    }

    public List deleteImage(int index){
        for(Image tmp : imageList){
            if(tmp.getIndex() == index){
                imageList.remove(tmp);
                return imageList;
            }
        }
        return imageList;
    }


    public List getImages(){
        return imageList;
    }

}

