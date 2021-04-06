package com.chatboat.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatboat.dao.ChatDao;
import com.chatboat.model.ChatFeedParams;
import com.chatboat.model.ChatFeedRequest;
import com.chatboat.model.ChatRasaResponse;
import com.chatboat.model.ChatRequest;
import com.chatboat.model.ChatResponse;
import com.chatboat.model.Questions;
import com.chatboat.model.SearchFeeds;
import com.chatboat.model.UserModel;
import com.chatboat.model.ValidateRequest;
import com.chatboat.model.ValidateResponse;
import com.google.gson.Gson;

@Service
public class ChatService {
	
	@Autowired
	private ChatDao chatDao;
	
	public String userRegistration(UserModel userModel) {
		String status = chatDao.userRegistration(userModel);
		return status;
	}
	

	public ValidateResponse isValidate(ValidateRequest validateRequest) {
		ValidateResponse validateResponse = new ValidateResponse();
		boolean isValidate = chatDao.isValidate(validateRequest);
		if(isValidate)
		{
			validateResponse = chatDao.getUserDetails(validateRequest);
		}	
		else
		{
			validateResponse.setStatus("201");
			validateResponse.setMessage("Not valid user, try again...");
		}	
		return validateResponse;
	}

	public ChatResponse track(ChatRequest chatRequest) throws IOException, ParseException {
		ChatResponse chatResponse = new ChatResponse();
		boolean isEmailId = chatDao.isEmailIdExixt(chatRequest);
		if(isEmailId)
		{
			String url = "http://149.129.191.22:9093/Rasa/";
			String urlParameters = "{\"question\":\"" + chatRequest.getQuestion() + "\"}";

			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Content-Type", "application/json");

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println("Response - : " + response.toString());
			
			//String response = "{\"flag\":\"YES\",\"message\":\"A business leadership team responds to the goals and strategies of the company. Each member of the leadership team has a function within company activities and overseas how they are carried out. The leadership team of the company comprises of the below team members\"}";
			Gson gson = new Gson();
		    ChatRasaResponse chatRasaResponse = gson.fromJson(response.toString(), ChatRasaResponse.class);
			    
			if (responseCode == 200) {
				String status = chatDao.track(chatRequest, chatRasaResponse);
				if (status.equalsIgnoreCase("200")) {
					chatResponse.setQuestion(chatRequest.getQuestion());
					chatResponse.setFlag(chatRasaResponse.getFlag());
					chatResponse.setAnswer(chatRasaResponse.getMessage());
					chatResponse.setMsg_by("there");
					chatResponse.setStatus("200");
				} else {
					chatResponse.setStatus("101");
					chatResponse.setMessage("Internal server error !!!");
				}
			} else {
				chatResponse.setStatus("101");
				chatResponse.setMessage("Internal server error !!!");
			}
		}	
		else
		{
			chatResponse.setStatus("201");
			chatResponse.setMessage("User not verified ....");
		}
		return chatResponse;
	}

	public List<ChatFeedParams> getChatFeeds(ChatFeedRequest chatFeedRequest) {
		List<ChatFeedParams> chatFeedList = new ArrayList<ChatFeedParams>();
		chatFeedList = chatDao.getChatFeeds(chatFeedRequest);
		return chatFeedList;
	}


	public List<Questions> searchQuestions(SearchFeeds searchFeeds) {
		List<Questions> questions = new ArrayList<Questions>();
		questions = chatDao.searchQuestions(searchFeeds);
		return questions;
	}

	
}
