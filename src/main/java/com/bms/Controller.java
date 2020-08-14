package com.bms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bms.Entity.AssetEntity;
import com.bms.model.EMEI_Batch;
import com.bms.model.t_batch;
import com.bms.model.t_batch_details;
import com.bms.service.AssetsServiceAPI;
import com.bms.service.BatchDetailsServiceApi;
import com.bms.service.BatchServiceApi;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@RestController
@CrossOrigin(origins = "*")
public class Controller {

	
	
	
	  @Autowired AssetsServiceAPI assetsServiceAPI;
//	  
//	  @Autowired BatchServiceApi batchServiceApi;
//	  
//	  @Autowired BatchDetailsServiceApi batchDetailsServiceApi;
//	 
	
	  @GetMapping(value = "/getAllAsset")
		public String findAllAsset()
		{
		
		  System.out.println("#####################################################################################################333");
		  
		  System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		  List<AssetEntity> assetList = assetsServiceAPI.findAllAssets();
		//  Timestamp	  currentTimestamp = new  java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
		 
		  System.out.println("assetList :: "+assetList); 
		  /* t_batch batch=new t_batch();
			
			 * batch.setBatch_id(1); batch.setUser("USER1");
			 * batch.setBatch_org_name("ORG_1"); batch.setCount(assetList.size());
			 * batch.setDescription("description_1"); batch.setStart_date(new
			 * Timestamp(Calendar.getInstance().getTime().getTime())); batch.setEnd_date(new
			 * Timestamp(Calendar.getInstance().getTime().getTime()));
			 * batch.setExecute("new"); batch.setStatus("0");
			 * batchServiceApi.saveBatchRecords(batch);
			 * 
			 * for (Iterator iterator = assetList.iterator(); iterator.hasNext();) {
			 * AssetEntity assetEntity = (AssetEntity) iterator.next(); t_batch_details
			 * batch_details = new t_batch_details(); batch_details.setStart_date(new
			 * Timestamp(Calendar.getInstance().getTime().getTime()));
			 * batch_details.setBMS("BSM_1"); batch_details.setCFG("CFG_1");
			 * batch_details.setIMEI(assetEntity.getImeiNo()); batch_details.setMax_time(6);
			 * batch_details.setSend_command("send_command_1");
			 * batch_details.setStatus("0"); batch_details.setTCL_version("tCL_version_1");
			 * batch_details.setBatch_id(batch.getBatch_id()); batch_details.setEnd_date(new
			 * Timestamp(Calendar.getInstance().getTime().getTime()));
			 * batchDetailsServiceApi.saveBatchDetailsRecords(batch_details); }
			 * 
			 * System.out.println(
			 * "???????????????????????????????????????????????????????????????????????????????????????????"
			 * );
			 * 
			 * // System.exit(0);
			 */
		//return assetList.toString();
		  return "Helloooo";
		  }
	  
	  @PostMapping("/upload-csv-file")
	    public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {

	        // validate file
	        if (file.isEmpty()) {
	            model.addAttribute("message", "Please select a CSV file to upload.");
	            model.addAttribute("status", false);
	        } else {

	            // parse CSV file to create a list of `User` objects
	            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

	                // create csv bean reader
	                CsvToBean<EMEI_Batch> csvToBean = new CsvToBeanBuilder(reader)
	                        .withType(EMEI_Batch.class)
	                        .withIgnoreLeadingWhiteSpace(true)
	                        .build();

	                // convert `CsvToBean` object to list of users
	                List<EMEI_Batch> users = csvToBean.parse();

	                // TODO: save users in DB?

	                // save users list on model
	                model.addAttribute("users", users);
	                model.addAttribute("status", true);

	            } catch (Exception ex) {
	                model.addAttribute("message", "An error occurred while processing the CSV file.");
	                model.addAttribute("status", false);
	            }
	        }

	        return "file-upload-status";
	    }
		 
	
}
