package com.jcs.sbs.main;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jcs.sbs.service.CommonService;
import com.jcs.sbs.service.impl.VolumeServiceImpl;

public class Main {

	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		CommonService service = new VolumeServiceImpl();
		List result = service.getResult("1", "project_id", "asc", 0, 10,"project_id",null);
		for(Object obj : result){
			String volume = gson.toJson(obj);
			System.out.println(volume);
		}
		/*
		VolumeService service = new VolumeServiceImpl();
		List result = service.getAllVolumes("123", "id", "asc", 0, 10);
        for(Object obj : result){
            String volume = gson.toJson(obj);
            System.out.println(volume);
        }*/
		//String result = gson.toJson(ExcelReader.getExcelAccountType());
		//System.out.println(result);

	}

}
