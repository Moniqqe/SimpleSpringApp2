package com.labyspring.GalleryApplication.model;

import java.nio.file.attribute.FileTime;

public class Image {

    private int index;
    private String name;
    private String resolution;
    private long size;
    private FileTime created;

    public Image(){
        this.index = 0;
        this.name = "name";
        this.resolution = "resolution";
        this.size = 0;
        this.created = null;
    }

    public Image(int index, String name, String resolution, long size, FileTime created) {
        this.index = index;
        this.name = name;
        this.resolution = resolution;
        this.size = size;
        this.created = created;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public FileTime getCreated() {
        return created;
    }

    public void setCreated(FileTime created) {
        this.created = created;
    }
}
