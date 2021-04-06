package com.chatboat.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatboat.dao.SurveyDao;
import com.chatboat.model.SubmitSurveyModel;
import com.chatboat.model.SubmitSurveyParams;
import com.chatboat.model.SurveyModel;


@Service
public class SurveyService {
	
	@Autowired
	private SurveyDao surveyDao;
	
	public SurveyModel getServeyQuestionsList() {
		SurveyModel surveyModel = new SurveyModel();
		
		/*Random random=new Random();
		int num = random.nextInt(90) + 10;
		if(num%2 == 0)
		{
			surveyModel = surveyDao.getEngamentServeyQuestionsList();
		}
		else
		{
			surveyModel = surveyDao.getPersonalityServeyQuestionsList();
		}*/	
		surveyModel = surveyDao.getEngamentServeyQuestionsList();
		return surveyModel;
	}

	public String submitSurvey(SubmitSurveyModel submitSurveyModel) throws IOException {
		String status = "101";
		int ratingCount = 0;
		String surveyName = null;
		String ratingName = null;
		for (SubmitSurveyParams submitSurveyParams : submitSurveyModel.getServeyAnswerList())
		{
			if(submitSurveyParams.getType().equals("Negative"))
			{
				if(submitSurveyParams.getRating() == 1)
				{
					submitSurveyParams.setRating(12);
				}
				else if (submitSurveyParams.getRating() == 4) 
				{
					submitSurveyParams.setRating(9);
				} 
				else if (submitSurveyParams.getRating() == 6) 
				{
					submitSurveyParams.setRating(7);
				}
				else if (submitSurveyParams.getRating() == 7) 
				{
					submitSurveyParams.setRating(6);
				}
				else if (submitSurveyParams.getRating() == 9) 
				{
					submitSurveyParams.setRating(4);
				}
				else if (submitSurveyParams.getRating() == 12) 
				{
					submitSurveyParams.setRating(1);
				}
			}
			status = surveyDao.submitSurvey(submitSurveyModel, submitSurveyParams);
			ratingCount = ratingCount + submitSurveyParams.getRating();
			// Paste values from survey_scale_master table
			if(status.equalsIgnoreCase("200"))
			{
				if(ratingCount >= 5 && ratingCount <= 9)
				{
					surveyName = "Strongly disagree";
				}
				else if (ratingCount >= 10 && ratingCount <= 19) 
				{
					surveyName = "Disagree";
				}
				else if (ratingCount >= 20 && ratingCount <= 34) 
				{
					surveyName = "Somewhat disagree";
				}
				else if (ratingCount >= 35 && ratingCount <= 44) 
				{
					surveyName = "Somewhat agree";
				}
				else if (ratingCount >= 45 && ratingCount <= 54) 
				{
					surveyName = "Agree";
				}
				else if (ratingCount >= 55 && ratingCount <= 60) 
				{
					surveyName = "Strongly agree";
				}
			}
		}
		surveyDao.submitSurvey(submitSurveyModel, ratingCount, surveyName);
		
		float value = ratingCount;
		float avgOfSum = value/5;
		// Paste values from rating_value_master table
		if(avgOfSum >= 0.1 && avgOfSum <= 1.0)
		{
			ratingName = "Strongly disagree";
		}
		else if (avgOfSum >= 1.1 && avgOfSum <= 4.0) 
		{
			ratingName = "Disagree";
		}
		else if (avgOfSum >= 4.1 && avgOfSum <= 6.0) 
		{
			ratingName = "Somewhat disagree";
		}
		else if (avgOfSum >= 6.1 && avgOfSum <= 7.0) 
		{
			ratingName = "Somewhat agree";
		}
		else if (avgOfSum >= 7.1 && avgOfSum <= 9.0) 
		{
			ratingName = "Agree";
		}
		else if (avgOfSum >= 9.1 && avgOfSum <= 12.0) 
		{
			ratingName = "Strongly agree";
		}
		surveyDao.saveRatingAverage(submitSurveyModel ,avgOfSum, ratingName);
		return status;
	}
}
