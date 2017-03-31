package com.citywalk.backend.endpoint;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.citywalk.backend.modal.User;
import com.citywalk.backend.service.UserService;

@Controller
@RequestMapping("/user/api/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private Logger logger = Logger.getLogger(UserController.class);
	
	@RequestMapping(value = "/save",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	@ResponseBody
	public String create(@RequestBody User user) {
		JSONObject jsonObject = new JSONObject();
		try {
			userService.save(user);
			logger.info("SUCCESSFULLY SAVED...");
			jsonObject.put("STATUS", "SUCCESS");
			jsonObject.put("MESSAGE", "User created successfully...");
			jsonObject.put("STATUS_CODE", HttpStatus.OK);
		} catch (Exception ex) {
			logger.info("Exception raised while saving...");
			try {
				jsonObject.put("STATUS", "FAILURE");
				jsonObject.put("MESSAGE", "Exception raised while saving...");
				jsonObject.put("STATUS_CODE", HttpStatus.INTERNAL_SERVER_ERROR);
				jsonObject.put("CAUSE", ex.getStackTrace());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return jsonObject.toString();
	}
	
	@RequestMapping(value = "/getuser",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	@ResponseBody
	public String getUser(@RequestBody User user) {
		JSONObject jsonObject = new JSONObject();
		try {
			user = userService.getUser(user);
			logger.info("User retrieved successfully...");
			jsonObject.put("STATUS", "SUCCESS");
			jsonObject.put("MESSAGE", "User retrieved successfully...");
			jsonObject.put("STATUS_CODE", HttpStatus.OK);
			jsonObject.put("USER INFO", user.toString());
		} catch (Exception ex) {
			logger.info("Exception raised while retrieving user...");
			try {
				jsonObject.put("STATUS", "FAILURE");
				jsonObject.put("MESSAGE", "Exception raised while retrieving user...");
				jsonObject.put("STATUS_CODE", HttpStatus.INTERNAL_SERVER_ERROR);
				jsonObject.put("CAUSE", ex.getStackTrace());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return jsonObject.toString();
	}
	
	@RequestMapping(value="test", method = RequestMethod.GET,consumes="application/json",produces="application/json")
	public String test(){
		return "This is test";
	}
}
