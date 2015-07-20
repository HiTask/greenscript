package com.greenscriptool.utils;

import java.io.*;

import com.greenscriptool.IFileLocator;
import com.greenscriptool.IResource;

public class FileResource implements IResource {
    
    public static class FileLocator implements IFileLocator {
        @Override
        public File locate(String path) {
            return new File(path);
        }
    }
    
    public static FileLocator defFileLocator = new FileLocator();
    
    private File file_;
    public FileResource(File file) {
        if (null == file) throw new NullPointerException();
        file_ = file;
    }
    public FileResource(String path) {
        this(path, defFileLocator);
    }
    public FileResource(String path, IFileLocator fileLocator) {
        if (null == path || null == fileLocator) throw new NullPointerException();
        file_ = fileLocator.locate(path);
    }

    @Override
    public Reader getReader() {
        try {
            return null == file_ ? null : new InputStreamReader(new FileInputStream(file_),"UTF-8");
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public Writer getWriter() {
        try {
            return null == file_ ? null : new OutputStreamWriter(new FileOutputStream(file_),"UTF-8");
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getKey() {
        return null == file_ ? null : file_.getName();
    }

}
