package com.citywalk.backend.endpoint;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.citywalk.backend.modal.Order;
import com.citywalk.backend.service.OrderService;

@RestController
@RequestMapping(value="/order/api")
public class OrderController {
	
	private Logger logger = Logger.getLogger(OrderController.class);

	@Autowired
	private OrderService orderService;

	@RequestMapping(value="/save", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	@ResponseBody
	public  String saveOrder(@RequestBody Order order) {
		JSONObject jsonObject = new JSONObject();
		try {
			orderService.save(order);
			logger.info("ORDER SUCCESSFULLY SAVED...");
			jsonObject.put("STATUS", "SUCCESS");
			jsonObject.put("MESSAGE", "Order saved successfully...");
			jsonObject.put("STATUS_CODE", HttpStatus.OK);
		} catch (Exception ex) {
			logger.info("Exception raised while saving order...");
			try {
				jsonObject.put("STATUS", "FAILURE");
				jsonObject.put("MESSAGE", "Exception raised while saving order...");
				jsonObject.put("STATUS_CODE", HttpStatus.INTERNAL_SERVER_ERROR);
				jsonObject.put("CAUSE", ex.getStackTrace());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return jsonObject.toString();
	}

	@RequestMapping(value="/list", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public String listOrders(@RequestBody Order order) {
		JSONObject jsonObject = new JSONObject();
		try {
			List<Order> orders = orderService.findAll();
			logger.info("ORDER SUCCESSFULLY SAVED...");
			jsonObject.put("STATUS", "SUCCESS");
			jsonObject.put("MESSAGE", "Order saved successfully...");
			jsonObject.put("STATUS_CODE", HttpStatus.OK);
			jsonObject.put("ORDERS", orders);
		} catch (Exception ex) {
			logger.info("Exception raised while saving order...");
			try {
				jsonObject.put("STATUS", "FAILURE");
				jsonObject.put("MESSAGE", "Exception raised while saving order...");
				jsonObject.put("STATUS_CODE", HttpStatus.INTERNAL_SERVER_ERROR);
				jsonObject.put("CAUSE", ex.getStackTrace());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return jsonObject.toString();
	}

	@RequestMapping(value="/update", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public String update(@RequestBody Order order) {
		JSONObject jsonObject = new JSONObject();
		try {
			Order updatedOrder = orderService.update(order);
			logger.info("ORDER SUCCESSFULLY SAVED...");
			jsonObject.put("STATUS", "SUCCESS");
			jsonObject.put("MESSAGE", "Order saved successfully...");
			jsonObject.put("STATUS_CODE", HttpStatus.OK);
			jsonObject.put("UPDATED_ORDER", updatedOrder);
		} catch (Exception ex) {
			logger.info("Exception raised while saving order...");
			try {
				jsonObject.put("STATUS", "FAILURE");
				jsonObject.put("MESSAGE", "Exception raised while saving order...");
				jsonObject.put("STATUS_CODE", HttpStatus.INTERNAL_SERVER_ERROR);
				jsonObject.put("CAUSE", ex.getStackTrace());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return jsonObject.toString();
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public String delete(@RequestBody Order order){
		JSONObject jsonObject = new JSONObject();
		try {
			orderService.delete(order.getOrderId());
			logger.info("ORDER SUCCESSFULLY SAVED...");
			jsonObject.put("STATUS", "SUCCESS");
			jsonObject.put("MESSAGE", "Order deleted successfully...");
			jsonObject.put("STATUS_CODE", HttpStatus.OK);
		} catch (Exception ex) {
			logger.info("Exception raised while saving order...");
			try {
				jsonObject.put("STATUS", "FAILURE");
				jsonObject.put("MESSAGE", "Exception raised while deleting order...");
				jsonObject.put("STATUS_CODE", HttpStatus.INTERNAL_SERVER_ERROR);
				jsonObject.put("CAUSE", ex.getStackTrace());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return jsonObject.toString();
	}

}