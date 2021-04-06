package com.chatboat.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatboat.model.AssociateResponseViewModel;
import com.chatboat.model.BusinessUnitWiseHighFlightRisk;
import com.chatboat.model.CriticalEmployeeHighRisk;
import com.chatboat.model.DashbordModel;
import com.chatboat.model.EnterpriseEmployeeRisk;
import com.chatboat.model.FlightRiskAnalysis;
import com.chatboat.model.GenderWiseView;
import com.chatboat.model.GradeWiseHighFlightRisk;
import com.chatboat.model.OverallCompanyMood;
import com.chatboat.model.RiskAnalysisEmployeeCover;
import com.chatboat.model.UnitPulseView;
import com.chatboat.model.UnitPulseViewRequest;
import com.chatboat.service.DashbordService;

@RestController
@RequestMapping(value = "/dashbord")
public class DashbordController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DashbordController.class);

	@Autowired
	private DashbordService dashbordService;
	
	@RequestMapping(value = "/getCompanyPulseScoreView", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins = "*")
	public DashbordModel getCompanyPulseScoreView(@RequestParam String Department, String Location, String Technology) throws JSONException {
		JSONObject jsonRequest = new JSONObject();
		LOGGER.info("Request of get the company pulse score view for dashbord of survey of chat bot application -->> {} : ", jsonRequest.toString());
		DashbordModel dashbordModel = new DashbordModel();
		try {
			dashbordModel = dashbordService.getCompanyPulseScoreView(Department, Location, Technology);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.info("[{}] Response of get the company pulse score view for dashbord of survey of chat bot application -->> {}", e);
		}
		LOGGER.info("[{}] Response of  get the company pulse score view for dashbord of survey of chat bot application -->> {}", dashbordModel);
		return  dashbordModel;
	}
	
	@RequestMapping(value = "/getAssociateResponseView", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins = "*")
	public AssociateResponseViewModel getAssociateResponseView(@RequestParam String Department, String Location, String Technology) throws JSONException {
		JSONObject jsonRequest = new JSONObject();
		LOGGER.info("Request of get the associate response view for dashbord of survey of chat bot application -->> {} : ", jsonRequest.toString());
		AssociateResponseViewModel associateResponseViewModel = new AssociateResponseViewModel();
		try {
			associateResponseViewModel = dashbordService.getAssociateResponseView(Department, Location, Technology);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("[{}] Response of  get the associate response view for dashbord of survey of chat bot application -->> {}", associateResponseViewModel);
		return  associateResponseViewModel;
	}
	
	
	@RequestMapping(value = "/getOverallCompanyMood", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins = "*")
	public OverallCompanyMood getOverallCompanyMood(@RequestParam String Department, String Location, String Technology) throws JSONException {
		JSONObject jsonRequest = new JSONObject();
		LOGGER.info("Request of get the Overall Company Mood for dashbord of survey of chat bot application -->> {} : ", jsonRequest.toString());
		OverallCompanyMood overallCompanyMood = new OverallCompanyMood();
		try {
			overallCompanyMood = dashbordService.getOverallCompanyMood(Department, Location, Technology);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("[{}] Response of  get the Overall Company Mood for dashbord of survey of chat bot application -->> {}", overallCompanyMood);
		return  overallCompanyMood;
	}
	
	@RequestMapping(value = "/getFlightRiskAnalysis", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins = "*")
	public FlightRiskAnalysis getFlightRiskAnalysis(@RequestParam String Department, String Location, String Technology) throws JSONException {
		JSONObject jsonRequest = new JSONObject();
		LOGGER.info("Request of get the Flight Risk Analysis for dashbord of survey of chat bot application -->> {} : ", jsonRequest.toString());
		FlightRiskAnalysis flightRiskAnalysis = new FlightRiskAnalysis();
		try {
			flightRiskAnalysis = dashbordService.getFlightRiskAnalysis(Department, Location, Technology);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("[{}] Response of  get the Flight Risk Analysis for dashbord of survey of chat bot application -->> {}");
		return  flightRiskAnalysis;
	}
	
	
	@RequestMapping(value = "/getUnitPulseView", method = RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins = "*")
	public UnitPulseView getUnitPulseView(@RequestBody UnitPulseViewRequest unitPulseViewRequest, @RequestParam String Department, String Location, String Technology) throws JSONException {
		JSONObject jsonRequest = new JSONObject(unitPulseViewRequest);
		LOGGER.info("Request of get the Unit Pulse View for dashbord of survey of chat bot application -->> {} : ", jsonRequest.toString());
		UnitPulseView unitPulseView = new UnitPulseView();
		try {
			
			if(unitPulseViewRequest.getType().equalsIgnoreCase("unitPulseView"))
			{
				unitPulseView = dashbordService.getUnitPulseView(Department, Location, Technology);
			}	
			else if(unitPulseViewRequest.getType().equalsIgnoreCase("EmployeeExperienceView"))
			{
				unitPulseView = dashbordService.getEmployeeExperienceView(Department, Location, Technology);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("[{}] Response of  get the Unit Pulse View  for dashbord of survey of chat bot application -->> {}", unitPulseView);
		return  unitPulseView;
	}
	
	@RequestMapping(value = "/getGenderWiseView", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins = "*")
	public GenderWiseView getGenderWiseView(@RequestParam String Department, String Location, String Technology) throws JSONException {
		JSONObject jsonRequest = new JSONObject();
		LOGGER.info("Request of get the gender wise View for dashbord of survey of chat bot application -->> {} : ", jsonRequest.toString());
		GenderWiseView genderWiseView = new GenderWiseView();
		try {
			genderWiseView = dashbordService.getGenderWiseView(Department, Location, Technology);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("[{}] Response of  get the gender wise View  for dashbord of survey of chat bot application -->> {}", genderWiseView);
		return  genderWiseView;
	}
	
	@RequestMapping(value = "/getGradeWiseHighFlightRisk", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins = "*")
	public GradeWiseHighFlightRisk getGradeWiseHighFlightRisk() throws JSONException {
		JSONObject jsonRequest = new JSONObject();
		LOGGER.info("Request of get the grade wise high flight risk for dashbord of survey of chat bot application -->> {} : ", jsonRequest.toString());
		GradeWiseHighFlightRisk gradeWiseHighFlightRisk = new GradeWiseHighFlightRisk();
		try {
			gradeWiseHighFlightRisk = dashbordService.getGradeWiseHighFlightRisk();
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("[{}] Response of  get the grade wise high flight risk  for dashbord of survey of chat bot application -->> {}", gradeWiseHighFlightRisk);
		return  gradeWiseHighFlightRisk;
	}
	
	
	
	
	@RequestMapping(value = "/getBusinessUnitWiseHighFlightRisk", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins = "*")
	public BusinessUnitWiseHighFlightRisk getBusinessUnitWiseHighFlightRisk() throws JSONException {
		JSONObject jsonRequest = new JSONObject();
		LOGGER.info("Request of get the Business Unit Wise High Flight Risk for dashbord of survey of chat bot application -->> {} : ", jsonRequest.toString());
		BusinessUnitWiseHighFlightRisk businessUnitWiseHighFlightRisk = new BusinessUnitWiseHighFlightRisk();
		try {
			businessUnitWiseHighFlightRisk = dashbordService.getBusinessUnitWiseHighFlightRisk();
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("[{}] Response of  get the Business Unit Wise High Flight Risk  for dashbord of survey of chat bot application -->> {}", businessUnitWiseHighFlightRisk);
		return  businessUnitWiseHighFlightRisk;
	}
	
	@RequestMapping(value = "/getEnterpriseEmployeeRisk", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins = "*")
	public EnterpriseEmployeeRisk getEnterpriseEmployeeRisk() throws JSONException {
		JSONObject jsonRequest = new JSONObject();
		LOGGER.info("Request of get the Enterprise Employee Risk for dashbord of survey of chat bot application -->> {} : ", jsonRequest.toString());
		EnterpriseEmployeeRisk enterpriseEmployeeRisk = new EnterpriseEmployeeRisk();
		try {
			enterpriseEmployeeRisk = dashbordService.getEnterpriseEmployeeRisk();
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("[{}] Response of  get the Enterprise Employee Risk  for dashbord of survey of chat bot application -->> {}", enterpriseEmployeeRisk);
		return  enterpriseEmployeeRisk;
	}
	
	@RequestMapping(value = "/getCriticalEmployeeHighRisk", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins = "*")
	public CriticalEmployeeHighRisk getCriticalEmployeeHighRisk() throws JSONException {
		JSONObject jsonRequest = new JSONObject();
		LOGGER.info("Request of get the Critical Employee High Risk for dashbord of survey of chat bot application -->> {} : ", jsonRequest.toString());
		CriticalEmployeeHighRisk criticalEmployeeHighRisk = new CriticalEmployeeHighRisk();
		try {
			criticalEmployeeHighRisk = dashbordService.getCriticalEmployeeHighRisk();
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("[{}] Response of  get the Critical Employee High Risk for dashbord of survey of chat bot application -->> {}", criticalEmployeeHighRisk);
		return  criticalEmployeeHighRisk;
	}
	
	@RequestMapping(value = "/getRiskAnalysisEmployeeCover", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@CrossOrigin(origins = "*")
	public RiskAnalysisEmployeeCover getRiskAnalysisEmployeeCover() throws JSONException {
		JSONObject jsonRequest = new JSONObject();
		LOGGER.info("Request of get the Risk Analysis Employee Covered for dashbord of survey of chat bot application -->> {} : ", jsonRequest.toString());
		RiskAnalysisEmployeeCover riskAnalysisEmployeeCover = new RiskAnalysisEmployeeCover();
		try {
			riskAnalysisEmployeeCover = dashbordService.getRiskAnalysisEmployeeCover();
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("[{}] Response of  get the Risk Analysis Employee Covered for dashbord of survey of chat bot application -->> {}", riskAnalysisEmployeeCover);
		return  riskAnalysisEmployeeCover;
	}
}
