package com.chatboat.controller;

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

import com.chatboat.model.SubmitSurveyModel;
import com.chatboat.model.SurveyModel;
import com.chatboat.service.SurveyService;

@RestController
@RequestMapping(value = "/survey")
public class SurveyController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SurveyController.class);

	@Autowired
	private SurveyService surveyService;
	
	@RequestMapping(value = "/getSurveyQuestionList", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins = "*")
	public SurveyModel getSurveyQuesList() throws JSONException {
		JSONObject jsonRequest = new JSONObject();
		LOGGER.info("Request of question list for survey of chat bot application -->> {} : ", jsonRequest.toString());
		SurveyModel surveyModel = new SurveyModel();
		try {
			surveyModel = surveyService.getServeyQuestionsList();
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("[{}] Response of  question list for survey of chat bot application -->> {}", e);
		}
		LOGGER.info("[{}] Response of   question list for survey of chat bot application -->> {}");
		return  surveyModel;
	}
	
	@RequestMapping(value = "/submitSurvey", method = RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins = "*")
	public String submitSurvey(@RequestBody SubmitSurveyModel submitSurveyModel) throws JSONException {
		JSONObject jsonRequest = new JSONObject(submitSurveyModel);
		LOGGER.info("Request of submit survey of chat bot application -->> {} : ", jsonRequest.toString());
		JSONObject jsonResponse = new JSONObject();
		//jsonResponse.put("message", "Hello world !!!");
		String status = "101";
		try {
			status = surveyService.submitSurvey(submitSurveyModel);
			jsonResponse.put("status", status);
		} catch (Exception e) {
			jsonResponse.put("status", status);
			e.printStackTrace();
			LOGGER.info("[{}] Response of  submit survey of chat bot application -->> {}", e);
		}
		LOGGER.info("[{}] Response of   submit survey of chat bot application -->> {}");
		return  jsonResponse.toString();
	}
}
