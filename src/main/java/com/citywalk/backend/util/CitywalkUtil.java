package com.citywalk.backend.util;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.citywalk.backend.modal.ResponseStatus;

@Configuration
public class CitywalkUtil {
	
	@Autowired
	private Map<String,Object> headersMapObject;
	
	public static enum ResponseCodes {
		RESPONSE_OK(200), RESPONSE_NO_CONTENT(204), RESPONSE_NOT_FOUND(404),RESPONSE_CONFLICT(409), RESPONSE_SERVER_ERROR(500), RESPONSE_BAD_REQUEST(400),RESPONSE_CREATED(201);
		
		private int code;

		ResponseCodes(int code) {
			this.setCode(code);
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}
	}
	
	@PostConstruct
	public Map<String,Object> constructHeaders(){
		headersMapObject  = new LinkedHashMap<String,Object>();
		headersMapObject.put("Access-Control-Allow-Origin", "*");
		headersMapObject.put("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
		headersMapObject.put("Cache-Control", "no-cache");
		headersMapObject.put("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		headersMapObject.put("Access-Control-Max-Age", "1");
		headersMapObject.put("Access-Control-Allow-Credentials", "false");
		//logger.info("headersMapObject ==== "+headersMapObject);
		return headersMapObject;
	}
	
	/**
	 * Convert JSON object to java bean object
	 * @param filePath
	 * @throws PaymentException 
	 */
	/*public static Payment convertJSON2Java(final String filePath) throws PaymentException{
		Payment payment = null; 
		try {
			ObjectMapper mapper = new ObjectMapper();
			payment = mapper.readValue(new File(filePath), Payment.class);
		} catch (Exception e) {
		    throw new PaymentException(e.getMessage());

		} 
		return payment;
	}*/
	
	/**
	 * Convert Java bean object to JSON object
	 * @param filePath
	 * @param payment
	 * @throws PaymentException 
	 */
	/*public static void convertJava2JSON(final String filePath,final Payment payment) throws PaymentException{
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(new File(filePath), payment);
			System.out.println(mapper.writeValueAsString(payment));
		} catch (Exception e) {
		    throw new PaymentException(e.getMessage());

		} 
	}
	
	public static String readJSONFromFile(final String mockJSONPath) throws PaymentException{
		String output = "";
		try{
			StringBuilder stringBuilder = new StringBuilder();
			File file = new ClassPathResource(mockJSONPath).getFile();
			FileInputStream inputStream = new FileInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String line;
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
			}
			reader.close();
			output = stringBuilder.toString();
		}
		catch (Exception e) {
			throw new PaymentException(e.getMessage());
		}
		return output;
	}*/
	
	public static ResponseEntity<?> getResponseEntity(final String status,final Integer responseCode,final String message,final HttpStatus httpStatusCode){
		ResponseStatus responseStatus = new ResponseStatus();
		responseStatus.setStatus(status);
		responseStatus.setResponseCode(responseCode);
		responseStatus.setMessage(message);	
		ResponseEntity<?> responseEntity = new ResponseEntity<ResponseStatus>(responseStatus,httpStatusCode);
		return responseEntity;
	}
	
}
