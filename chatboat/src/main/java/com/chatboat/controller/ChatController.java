package com.chatboat.controller;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chatboat.model.ChatFeedRequest;
import com.chatboat.model.ChatFeedResponse;
import com.chatboat.model.ChatRequest;
import com.chatboat.model.ChatResponse;
import com.chatboat.model.SearchFeeds;
import com.chatboat.model.SearchFeedsResponse;
import com.chatboat.model.ValidateRequest;
import com.chatboat.model.ValidateResponse;
import com.chatboat.service.ChatService;
import com.chatboat.model.UserModel;

@RestController
@RequestMapping(value = "/chat")
public class ChatController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ChatController.class);

	@Autowired
	private ChatService chatService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins = "*")
	public JSONObject hello() throws JSONException {
		JSONObject jsonRequest = new JSONObject();
		LOGGER.info("GET Request of user validation for chat bot application -->> {} : ", jsonRequest.toString());
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("message", "Hello world !!!");
		return  jsonResponse;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String userRegistrationAndUpdate(@RequestBody UserModel userModel) throws JSONException {
		JSONObject jsonRequest = new JSONObject(userModel);
		LOGGER.info("Request of user registration for chat bot -->> {} : ", jsonRequest.toString());
		JSONObject jsonResponse = new JSONObject();
		String status = "101";
		String message = "Internal server error !!!";
		try {
			status = chatService.userRegistration(userModel);
			
			if(status.equalsIgnoreCase("200"))
			{
				jsonResponse.put("status", status);
				jsonResponse.put("message", "Registartion successfully in chat bot");
			}	
			else if (status.equalsIgnoreCase("201"))
			{
				jsonResponse.put("status", status);
				jsonResponse.put("message", "Email id already registered !!!");
			}
			else
			{
				jsonResponse.put("status", status);
				jsonResponse.put("message", message);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			jsonResponse.put("status", status);
			LOGGER.info("[{}] Response of user registration for chat bot -->> {}", e);
		}
		LOGGER.info("[{}] Response of user registration for chat bot -->> {}", jsonResponse.toString());
		return jsonResponse.toString();
	}
	
	
	
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins = "*")
	public ValidateResponse isValidate(@RequestBody ValidateRequest validateRequest) throws JSONException {
		JSONObject jsonRequest = new JSONObject(validateRequest);
		LOGGER.info("Request of user validation for chat bot application -->> {} : ", jsonRequest.toString());
		ValidateResponse validateResponse = new ValidateResponse();
		
		@SuppressWarnings("unused")
		JSONObject jsonResponse = new JSONObject();
		try {
			validateResponse = chatService.isValidate(validateRequest);
		} catch (Exception e) {
			e.printStackTrace();
			validateResponse.setStatus("101");
			validateResponse.setMessage("Internal server error !!!");
			LOGGER.info("[{}] Response of user validation for chat bot application -->> {}", e);
		}
		LOGGER.info("[{}] Response of  user validation for chat bot application -->> {}", validateResponse);
		return  validateResponse;
	}
	
	@RequestMapping(value = "/track", method = RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins = "*")
	public ChatResponse track(@RequestBody ChatRequest chatRequest) throws JSONException {
		JSONObject jsonRequest = new JSONObject(chatRequest);
		LOGGER.info("Request of user chat for chat bot application -->> {} : ", jsonRequest.toString());
		ChatResponse chatResponse = new ChatResponse();
		
		@SuppressWarnings("unused")
		JSONObject jsonResponse = new JSONObject();
		try {
			chatResponse = chatService.track(chatRequest);
		} catch (Exception e) {
			e.printStackTrace();
			chatResponse.setStatus("101");
			chatResponse.setMessage("Internal server error !!!");
			LOGGER.info("[{}] Response of user chat for chat bot application -->> {}", e);
		}
		LOGGER.info("[{}] Response of  user chat for chat bot application -->> {}", chatResponse);
		return  chatResponse;
	}
	
	
	@RequestMapping(value = "/getChatFeeds", method = RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins = "*")
	public ChatFeedResponse getChatFeeds(@RequestBody ChatFeedRequest chatFeedRequest) throws JSONException {
		JSONObject jsonRequest = new JSONObject(chatFeedRequest);
		LOGGER.info("Request of chat feeds list for chat bot application -->> {} : ", jsonRequest.toString());
		ChatFeedResponse chatFeedResponse = new ChatFeedResponse();
		try {
			chatFeedResponse.setChatFeedList(chatService.getChatFeeds(chatFeedRequest));
			if ((chatFeedResponse.getChatFeedList() != null) && !chatFeedResponse.getChatFeedList().isEmpty()) {
				chatFeedResponse.setStatus("200");
				chatFeedResponse.setMessage("Records found...");
			} else {
				chatFeedResponse.setStatus("201");
				chatFeedResponse.setMessage("Records not found...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			chatFeedResponse.setStatus("101");
			chatFeedResponse.setMessage("Internal server error !!!");
			LOGGER.info("[{}] Response of chat feeds list for chat bot application -->> {}", e);
		}
		LOGGER.info("[{}] Response of  chat feeds list for chat bot application -->> {}", chatFeedResponse);
		return  chatFeedResponse;
	}
	
	@RequestMapping(value = "/searchQuestions", method = RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins = "*")
	public SearchFeedsResponse searchQuestions(@RequestBody SearchFeeds searchFeeds) throws JSONException {
		JSONObject jsonRequest = new JSONObject(searchFeeds);
		LOGGER.info("Request of get question list for chat bot application -->> {} : ", jsonRequest.toString());
		SearchFeedsResponse SearchFeedsResponse = new SearchFeedsResponse();
		try {
			SearchFeedsResponse.setQuestions(chatService.searchQuestions(searchFeeds));
			LOGGER.info("[{}] Response of  question list for chat bot application -->> {}", SearchFeedsResponse);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("[{}] Response of question list for chat bot application -->> {}", e);
		}
		return  SearchFeedsResponse;
	}
}
