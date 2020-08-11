package com.bms.kafka.service;

import java.text.ParseException;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class kafkaConsumer {
	
	
	private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

	private static final String Slag_Master_Data = "Save_master_data";
	private static final String Slag_Client_Data = "Save_client_data";
	private static final String Slag_Publish_Data = "publish_client_data";
	private static final String Asset_event = "asset_day_activity";	
	private static final String mqtt_data_with_partitions = "mqtt_data_with_partitions";
	
	
	/*
	 * @KafkaListener(topics = Slag_Master_Data, groupId = "master_data",
	 * containerFactory = "kafkaListenerContainerFactory") public void
	 * KafkaMasterDataDB(@Payload String
	 * data, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
	 * 
	 * @Header(KafkaHeaders.RECEIVED_TOPIC) String
	 * topic, @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts) throws
	 * ParseException {
	 * 
	 * String[] skey = key.split("--");
	 * System.out.println("data *************** "+data);
	 * System.out.println("key KafkaMasterDataDB "+ key);
	 * //System.out.println("partition KafkaMasterDataDB "+ partition); if
	 * (skey[0].equals("/exicom/bounce/bin/batterydata")) {
	 * 
	 * } }
	 */
	
	
	/*
	 * @KafkaListener(topics = mqtt_data_with_partitions, groupId = "master_data",
	 * containerFactory = "kafkaListenerContainerFactory") public void
	 * KafkaMasterDataDB(@Payload String
	 * data, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
	 * 
	 * @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
	 * 
	 * @Header(KafkaHeaders.RECEIVED_TOPIC) String
	 * topic, @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts) throws
	 * ParseException {
	 * 
	 * String[] skey = key.split("--"); System.out.println("**data** : "+data);
	 * System.out.println("key KafkaMasterDataDB "+ key);
	 * System.out.println("partition KafkaMasterDataDB "+ partition);
	 * 
	 * // System.exit(0); if (skey[0].equals("/exicom/bounce/bin/batterydata")) {
	 * 
	 * } }
	 */
	public static final String CHECK						=	"FWA/exicom";	
//  public static final String imei							=	"357897106611195";	
	public static final String imei							=	"357897106624016";
	public static final String FWA_exicom_client_TCU_imei	= 	"FWA/exicom/client/TCU/"+imei;
	public static final String FWA_exicom_client_TCU_imei1	= 	"FWA_exicom_client_TCU_"+imei;
	public static final String FWA_exicom_client_BMS_imei	=	"FWA/exicom/client/BMS/"+imei;
	
	 @KafkaListener(topics = FWA_exicom_client_TCU_imei1, groupId = "master_data", containerFactory = "kafkaListenerContainerFactory")
	      public void KafkaMasterDataDB(
					@Payload String data, @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,	  
			  		@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
			  		@Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			  		@Header(KafkaHeaders.RECEIVED_TIMESTAMP) long ts) throws ParseException {
			  
			  String[] skey = key.split("--");			
			  System.out.println("partition KafkaMasterDataDB "+ partition); 	 
			
				 if(skey[0].startsWith(CHECK))
				 {
					 System.out.println("%%%%%%%%%%%%%%%% IF IF IF IF IF IF IF I IF IF IF");
					 System.out.println("**data** : "+data);
					 System.out.println("key KafkaMasterDataDB "+ key);
					 System.out.println("**kafka_topic** : "+topic);
					 System.out.println("**mqtt_data** : "+skey[0]);
					 
				 }
				 else
				 {
					 System.out.println("!!!!!!!!!!!!!! ELSE ELSE ELSE ELSE ELSE ELSE");
				 }
			//	  System.exit(0);
	 }
			 
}
