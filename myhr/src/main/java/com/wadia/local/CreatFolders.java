package com.wadia.local;

import java.io.File;

import com.wadia.metier.PathProvider;

public class CreatFolders {
	
	private PathProvider pathProvider = new PathProvider();
	
    public String createFolderByUser(String username, int number){
    	
   	String linkToFile = pathProvider.path()+"paySlipsJpg"+"/"+username+"/"+number+"/";
   	
   	File dir = new File(linkToFile);
   	File fold = new File(pathProvider.path()+"paySlipsJpg");
   	
   	if(!fold.exists()){
   		
   		fold.mkdir();
   	}
   	
   	if(!dir.exists()){
   	
   		dir.mkdir();
   	}else{ // vider le fichier si il existe pour avoir toujour just 3 dernière payslips
   		dir.delete();
   		dir.mkdir();
   	}
   	
   	return linkToFile;
   	
   }

	public PathProvider getPathProvider() {
		return pathProvider;
	}

	public void setPathProvider(PathProvider pathProvider) {
		this.pathProvider = pathProvider;
	}

}
