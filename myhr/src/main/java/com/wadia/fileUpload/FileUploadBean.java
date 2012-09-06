/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wadia.fileUpload;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.imageio.ImageIO;

import org.richfaces.event.FileUploadEvent;

import com.wadia.beans.EGeneralData;
import com.wadia.metier.PathProvider;
import com.wadia.repos.EGeneralDataRepos;
import com.wadia.view.userController;

/**
 * 
 * @author wadi3
 */

@ManagedBean
@RequestScoped
public class FileUploadBean {

    @ManagedProperty(value = "#{eGeneralDataRepos}")
    private EGeneralDataRepos eGeneralDataRepos;
    private ArrayList<Files> files = new ArrayList<Files>();
    private int uploadsAvailable = 5;
    private boolean autoUpload = false;
    private boolean useFlash = false;
    private PathProvider pathProvider = new PathProvider();
    private userController user = new userController();

    public int getSize() {
	if (getFiles().size() > 0) {
	    return getFiles().size();
	} else {
	    return 0;
	}
    }


    public void paint(OutputStream stream, Object object) throws IOException {
	stream.write(getFiles().get((Integer) object).getData());
    }

    public void listener(FileUploadEvent event) throws Exception {

	Files file = new Files();
	file.setLength(event.getUploadedFile().getSize());
	file.setName(event.getUploadedFile().getName());
	file.setData(event.getUploadedFile().getData());
	files.add(file);
	System.out.println("" + file.getData());
	try {
	    String lien, datalien;
	    datalien = "photos/" + user.getUsername() + ".jpg";
	    lien = pathProvider.path() + "photos/" + user.getUsername() + ".jpg";
	    EGeneralData data = new EGeneralData();
	    data = eGeneralDataRepos.findOne(user.getUsername());
	    data.setIdPhoto(datalien);
	    eGeneralDataRepos.save(data);
	    System.out.println("lien : " + lien);
	    InputStream in = new ByteArrayInputStream(file.getData());
	    BufferedImage bImageFromConvert = ImageIO.read(in);

	    ImageIO.write(bImageFromConvert, "jpg", new File(lien));
	} catch (IOException e) {
	}

	uploadsAvailable--;
	System.out.println("" + file.getName());
    }

    public String clearUploadData() {
	files.clear();
	setUploadsAvailable(5);
	return null;
    }

    public long getTimeStamp() {
	return System.currentTimeMillis();
    }

    public ArrayList<Files> getFiles() {
	return files;
    }

    public void setFiles(ArrayList<Files> files) {
	this.files = files;
    }

    public int getUploadsAvailable() {
	return uploadsAvailable;
    }

    public void setUploadsAvailable(int uploadsAvailable) {
	this.uploadsAvailable = uploadsAvailable;
    }

    public boolean isAutoUpload() {
	return autoUpload;
    }

    public void setAutoUpload(boolean autoUpload) {
	this.autoUpload = autoUpload;
    }

    public boolean isUseFlash() {
	return useFlash;
    }

    public void setUseFlash(boolean useFlash) {
	this.useFlash = useFlash;
    }

    public EGeneralDataRepos geteGeneralDataRepos() {
        return eGeneralDataRepos;
    }

    public void seteGeneralDataRepos(EGeneralDataRepos eGeneralDataRepos) {
        this.eGeneralDataRepos = eGeneralDataRepos;
    }

    public PathProvider getPathProvider() {
        return pathProvider;
    }

    public void setPathProvider(PathProvider pathProvider) {
        this.pathProvider = pathProvider;
    }


    public userController getUser() {
        return user;
    }


    public void setUser(userController user) {
        this.user = user;
    }
    
    
}
