package com.chatboat.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatboat.dao.DashbordDao;
import com.chatboat.model.AgeGroup;
import com.chatboat.model.AssociateResponseView;
import com.chatboat.model.AssociateResponseViewModel;
import com.chatboat.model.BusinesUnitA;
import com.chatboat.model.BusinesUnitB;
import com.chatboat.model.BusinesUnitC;
import com.chatboat.model.BusinesUnitD;
import com.chatboat.model.BusinessUnitWiseHighFlightRisk;
import com.chatboat.model.BusinessUnitWiseHighFlightRiskParam;
import com.chatboat.model.Career;
import com.chatboat.model.CompanyPulseScoreView;
import com.chatboat.model.CriticalEmployeeHighRisk;
import com.chatboat.model.CriticalEmployeeHighRiskParam;
import com.chatboat.model.Culture;
import com.chatboat.model.Customer;
import com.chatboat.model.DashbordModel;
import com.chatboat.model.DecisionMaking;
import com.chatboat.model.Educations;
import com.chatboat.model.EmployeeExperienceView;
import com.chatboat.model.EmployeeRole;
import com.chatboat.model.EnterpriseEmployeeRisk;
import com.chatboat.model.EnterpriseEmployeeRiskParam;
import com.chatboat.model.Experience;
import com.chatboat.model.FemaleGender;
import com.chatboat.model.FemaleGenderCritical;
import com.chatboat.model.FlightHighRisk;
import com.chatboat.model.FlightMediumRisk;
import com.chatboat.model.FlightRiskAnalysis;
import com.chatboat.model.FlightRiskAnalysisParam;
import com.chatboat.model.Gender;
import com.chatboat.model.GenderWiseView;
import com.chatboat.model.GenderWiseViewParam;
import com.chatboat.model.Grade1;
import com.chatboat.model.Grade2;
import com.chatboat.model.Grade3;
import com.chatboat.model.Grade4;
import com.chatboat.model.Grade5;
import com.chatboat.model.Grade6;
import com.chatboat.model.Grade7;
import com.chatboat.model.GradeWiseHighFlightRisk;
import com.chatboat.model.GradeWiseHighFlightRiskParam;
import com.chatboat.model.HighRisk;
import com.chatboat.model.Leadership;
import com.chatboat.model.Location;
import com.chatboat.model.MaleGender;
import com.chatboat.model.MaleGenderCritical;
import com.chatboat.model.ManagerCommunication;
import com.chatboat.model.MediumRisk;
import com.chatboat.model.NoRisk;
import com.chatboat.model.OverallCompanyMood;
import com.chatboat.model.OverallCompanyMoodParam;
import com.chatboat.model.PerformanceManagement;
import com.chatboat.model.Performers;
import com.chatboat.model.PositiveNegative;
import com.chatboat.model.ProcessPolicy;
import com.chatboat.model.RiskAnalysisEmployeeCover;
import com.chatboat.model.RiskAnalysisEmployeeCoverParam;
import com.chatboat.model.TeamWork;
import com.chatboat.model.UnitPulseView;
import com.chatboat.model.UnitPulseViewParam;

@Service
public class DashbordService {
	
	@Autowired
	private DashbordDao dashbordDao;

	public DashbordModel getCompanyPulseScoreView(String Department, String Location, String Technology) {
		DashbordModel dashbordModel = new DashbordModel();
		
		// Function for company pulse score view 
		int totalEmployee = dashbordDao.getTotalEmployeeFilter(Department,Location, Technology);
		
		CompanyPulseScoreView companyPulseScoreView =  new CompanyPulseScoreView();
		companyPulseScoreView.setStronglyDisagreeCount(dashbordDao.getStronglyDisagreeCount(Department,Location, Technology));
		companyPulseScoreView.setDisagreeCount(dashbordDao.getDisagreeCount(Department,Location, Technology));
		companyPulseScoreView.setSomewhatDisagreeCount(dashbordDao.getSomewhatDisagreeCount(Department,Location, Technology));
		companyPulseScoreView.setSomewhatAgreeCount(dashbordDao.getSomewhatAgreeCount(Department,Location, Technology));
		companyPulseScoreView.setAgreeCount(dashbordDao.getAgreeCount(Department,Location, Technology));
		companyPulseScoreView.setStronglyAgreeCount(dashbordDao.getStronglyAgreeCount(Department,Location, Technology));
		
		dashbordModel.setTotalAssociates(totalEmployee);
		dashbordModel.setCompanyPulseScoreView(companyPulseScoreView);
		
		return dashbordModel;
	}

	public AssociateResponseViewModel getAssociateResponseView(String Department, String Location, String Technology) {
		AssociateResponseViewModel associateResponseViewModel = new AssociateResponseViewModel();
		AssociateResponseView associateResponseView = new AssociateResponseView();
		Location location = new Location();
		
		associateResponseView.setTotalEmployee(dashbordDao.getTotalEmployee());
		associateResponseView.setTotalResponse(dashbordDao.getTotalEmployeeFilter(Department, Location, Technology));
		
		PositiveNegative positiveNegativeDelhi= new PositiveNegative();
		PositiveNegative positiveNegativeMumbai= new PositiveNegative();
		PositiveNegative positiveNegativeChennai= new PositiveNegative();
		PositiveNegative positiveNegativeKolkata= new PositiveNegative();
		PositiveNegative positiveNegativeBanglore= new PositiveNegative();
		if(Location != null && Location != "")
		{
			if(Location.equalsIgnoreCase("Noida"))
			{
				positiveNegativeDelhi.setPositive(dashbordDao.getNoidaPositive(Department, Location, Technology));
				positiveNegativeDelhi.setNegative(dashbordDao.getNoidaNegative(Department, Location, Technology));
				location.setNoida(positiveNegativeDelhi);
			}
			
			if(Location.equalsIgnoreCase("Mumbai"))
			{
				positiveNegativeMumbai.setPositive(dashbordDao.getMumbaiPositiveFilter(Department, Location, Technology));
				positiveNegativeMumbai.setNegative(dashbordDao.getMumbaiNegativeFilter(Department, Location, Technology));
				location.setMumbai(positiveNegativeMumbai);
			}
			
			if(Location.equalsIgnoreCase("Chennai"))
			{
				positiveNegativeChennai.setPositive(dashbordDao.getChennaiPositiveFilter(Department, Location, Technology));
				positiveNegativeChennai.setNegative(dashbordDao.getChennaiNegativeFilter(Department, Location, Technology));
				location.setChennai(positiveNegativeChennai);
			}
			
			if(Location.equalsIgnoreCase("Kolkatta"))
			{
				positiveNegativeKolkata.setPositive(dashbordDao.getKolkattaPositiveFilter(Department, Location, Technology));
				positiveNegativeKolkata.setNegative(dashbordDao.getKolkattaNegativeFilter(Department, Location, Technology));
				location.setKolkatta(positiveNegativeKolkata);
			}
			
			if(Location.equalsIgnoreCase("Bengaluru"))
			{
				positiveNegativeBanglore.setPositive(dashbordDao.getBengaluruPositiveFilter(Department, Location, Technology));
				positiveNegativeBanglore.setNegative(dashbordDao.getBengaluruNegativeFilter(Department, Location, Technology));
				location.setBengaluru(positiveNegativeBanglore);
			}
		}
		else
		{
			positiveNegativeDelhi.setPositive(dashbordDao.getDelhiPositive(Department, Location, Technology));
			positiveNegativeDelhi.setNegative(dashbordDao.getDelhiNegative(Department, Location, Technology));
			location.setNoida(positiveNegativeDelhi);
			
			positiveNegativeMumbai.setPositive(dashbordDao.getMumbaiPositive(Department, Location, Technology));
			positiveNegativeMumbai.setNegative(dashbordDao.getMumbaiNegative(Department, Location, Technology));
			location.setMumbai(positiveNegativeMumbai);
			
			positiveNegativeChennai.setPositive(dashbordDao.getChennaiPositive(Department, Location, Technology));
			positiveNegativeChennai.setNegative(dashbordDao.getChennaiNegative(Department, Location, Technology));
			location.setChennai(positiveNegativeChennai);
			
			
			positiveNegativeKolkata.setPositive(dashbordDao.getKolkataPositive(Department, Location, Technology));
			positiveNegativeKolkata.setNegative(dashbordDao.getKolkataNegative(Department, Location, Technology));
			location.setKolkatta(positiveNegativeKolkata);
			
			positiveNegativeBanglore.setPositive(dashbordDao.getBanglorePositive(Department, Location, Technology));
			positiveNegativeBanglore.setNegative(dashbordDao.getBangloreNegative(Department, Location, Technology));
			location.setBengaluru(positiveNegativeBanglore);
		}	
		associateResponseView.setLocation(location);
		associateResponseViewModel.setAssociateResponseView(associateResponseView);
		return associateResponseViewModel;
	}

	public OverallCompanyMood getOverallCompanyMood(String Department, String Location, String Technology) {
		OverallCompanyMood overallCompanyMood = new OverallCompanyMood();
		OverallCompanyMoodParam overallCompanyMoodParam = new OverallCompanyMoodParam();
		//overallCompanyMoodParam = dashbordDao.getOverallCompanyMood();
		
		int totalEmployee = dashbordDao.getTotalEmployeeFilter(Department, Location, Technology);
		int sumOfRatings = dashbordDao.getSumOfRatings(Department, Location, Technology);
		BigDecimal overAllMood = new BigDecimal(((float) totalEmployee / (float) sumOfRatings) * 100).setScale(2, BigDecimal.ROUND_HALF_UP);
		float rounded = overAllMood.setScale(1, RoundingMode.DOWN).floatValue();
		//overallCompanyMoodParam.setOverAllMood(rounded);

		if(rounded >= 0.1 && rounded <= 1.0)
		{
			overallCompanyMoodParam.setOverAllMood(1);
			overallCompanyMoodParam.setRatingName("Strongly disagree");
		}
		else if (rounded >= 1.1 && rounded <= 4.0) 
		{
			overallCompanyMoodParam.setOverAllMood(4);
			overallCompanyMoodParam.setRatingName("Disagree");
		}
		else if (rounded >= 4.1 && rounded <= 6.0) 
		{
			overallCompanyMoodParam.setOverAllMood(6);
			overallCompanyMoodParam.setRatingName("Somewhat disagree");
		}
		else if (rounded >= 6.1 && rounded <= 7.0) 
		{
			overallCompanyMoodParam.setOverAllMood(7);
			overallCompanyMoodParam.setRatingName("Somewhat agree");
		}
		else if (rounded >= 7.1 && rounded <= 9.0) 
		{
			overallCompanyMoodParam.setOverAllMood(9);
			overallCompanyMoodParam.setRatingName("Agree");
		}
		else if (rounded >= 9.1 && rounded <= 12.0) 
		{
			overallCompanyMoodParam.setOverAllMood(12);
			overallCompanyMoodParam.setRatingName("Strongly agree");
		}
		overallCompanyMood.setOverallCompanyMood(overallCompanyMoodParam);
		return overallCompanyMood;
	}

	public FlightRiskAnalysis getFlightRiskAnalysis(String Department, String Location, String Technology) {
		FlightRiskAnalysis flightRiskAnalysis = new FlightRiskAnalysis();
		FlightRiskAnalysisParam flightRiskAnalysisParam = new FlightRiskAnalysisParam();
		flightRiskAnalysisParam.setAssociates(dashbordDao.getTotalEmployeeFilter(Department, Location, Technology));
		int totalSurveyCount = dashbordDao.getTotalSurveyCount(Department, Location, Technology);
		
		int highRiskEmployeeCount = dashbordDao.getHighRiskCount(Department, Location, Technology);
		float  highRisk =(((float)highRiskEmployeeCount/totalSurveyCount)*100);
		BigDecimal roundHighRisk = new BigDecimal(highRisk).setScale(0,BigDecimal.ROUND_HALF_UP);
		flightRiskAnalysisParam.setHighRisk(roundHighRisk);
		flightRiskAnalysisParam.setHighRiskEmployeeCount(highRiskEmployeeCount);
		
		int mediumRiskEmployeeCount = dashbordDao.getMediumRiskCount(Department, Location, Technology);
		float  mediumRisk = (((float)mediumRiskEmployeeCount/totalSurveyCount)*100);
		BigDecimal roundMediumRisk = new BigDecimal(mediumRisk).setScale(0,BigDecimal.ROUND_HALF_UP);
		flightRiskAnalysisParam.setMediumRisk(roundMediumRisk);
		flightRiskAnalysisParam.setMediumRiskEmployeeCount(mediumRiskEmployeeCount);
		
		int noRiskEmployeeCount = dashbordDao.getNoRiskCount(Department, Location, Technology);
		float  noRisk = (((float)noRiskEmployeeCount/totalSurveyCount)*100);
		BigDecimal roundNoRisk = new BigDecimal(noRisk).setScale(0,BigDecimal.ROUND_HALF_UP);
		flightRiskAnalysisParam.setNoRisk(roundNoRisk);
		flightRiskAnalysisParam.setNoRiskEmployeeCount(noRiskEmployeeCount);
		
		flightRiskAnalysis.setFlightRiskAnalysis(flightRiskAnalysisParam);
		
		return flightRiskAnalysis;
	}

	public UnitPulseView getUnitPulseView(String Department, String Location, String Technology) {
		UnitPulseView unitPulseView = new UnitPulseView();
		UnitPulseViewParam UnitPulseViewParam = new UnitPulseViewParam();
		UnitPulseViewParam.setTotalAssociates(dashbordDao.getTotalEmployeeFilterUnitWise(Department, Location, Technology));
		UnitPulseViewParam.setTotalBusinesUnit(dashbordDao.getTotalBusinesUnit());
		
		BusinesUnitA buA = new BusinesUnitA();
		BusinesUnitB buB = new BusinesUnitB();
		BusinesUnitC buC = new BusinesUnitC();
		BusinesUnitD buD = new BusinesUnitD();
		for(int i = 1 ; i<= 4 ; i++)
		{
			if (i == 1)
			{
				buA.setStronglyDisengage(dashbordDao.getStronglyDisengage(i, "Strongly disagree", Department, Location, Technology));
				buA.setDisengage(dashbordDao.getDisengage(i, "Disagree", Department, Location, Technology));
				buA.setSomewhatDisengage(dashbordDao.getSomewhatDisengage(i, "Somewhat disagree", Department, Location, Technology));
				buA.setSomewhatEngage(dashbordDao.getSomewhatEngage(i, "Somewhat agree", Department, Location, Technology));
				buA.setEngage(dashbordDao.getEngage(i, "Agree", Department, Location, Technology));
				buA.setStronglyEngage(dashbordDao.getStronglyEngage(i, "Strongly agree", Department, Location, Technology));
				UnitPulseViewParam.setBuA(buA);
			}
			else if (i == 2)
			{
				buB.setStronglyDisengage(dashbordDao.getStronglyDisengage(i, "Strongly disagree", Department, Location, Technology));
				buB.setDisengage(dashbordDao.getDisengage(i, "Disagree", Department, Location, Technology));
				buB.setSomewhatDisengage(dashbordDao.getSomewhatDisengage(i, "Somewhat disagree", Department, Location, Technology));
				buB.setSomewhatEngage(dashbordDao.getSomewhatEngage(i, "Somewhat agree", Department, Location, Technology));
				buB.setEngage(dashbordDao.getEngage(i, "Agree", Department, Location, Technology));
				buB.setStronglyEngage(dashbordDao.getStronglyEngage(i, "Strongly agree", Department, Location, Technology));
				UnitPulseViewParam.setBuB(buB);
			}
			else if (i == 3)
			{
				buC.setStronglyDisengage(dashbordDao.getStronglyDisengage(i, "Strongly disagree", Department, Location, Technology));
				buC.setDisengage(dashbordDao.getDisengage(i, "Disagree", Department, Location, Technology));
				buC.setSomewhatDisengage(dashbordDao.getSomewhatDisengage(i, "Somewhat disagree", Department, Location, Technology));
				buC.setSomewhatEngage(dashbordDao.getSomewhatEngage(i, "Somewhat agree", Department, Location, Technology));
				buC.setEngage(dashbordDao.getEngage(i, "Agree", Department, Location, Technology));
				buC.setStronglyEngage(dashbordDao.getStronglyEngage(i, "Strongly agree", Department, Location, Technology));
				UnitPulseViewParam.setBuC(buC);
			}
			else if (i == 4)
			{
				buD.setStronglyDisengage(dashbordDao.getStronglyDisengage(i, "Strongly disagree", Department, Location, Technology));
				buD.setDisengage(dashbordDao.getDisengage(i, "Disagree", Department, Location, Technology));
				buD.setSomewhatDisengage(dashbordDao.getSomewhatDisengage(i, "Somewhat disagree", Department, Location, Technology));
				buD.setSomewhatEngage(dashbordDao.getSomewhatEngage(i, "Somewhat agree", Department, Location, Technology));
				buD.setEngage(dashbordDao.getEngage(i, "Agree", Department, Location, Technology));
				buD.setStronglyEngage(dashbordDao.getStronglyEngage(i, "Strongly agree", Department, Location, Technology));
				UnitPulseViewParam.setBuD(buD);
			}
		}	
		unitPulseView.setUnitPulseView(UnitPulseViewParam);
		return unitPulseView;
	}

	public UnitPulseView getEmployeeExperienceView(String Department, String Location, String Technology) {
		UnitPulseView unitPulseView = new UnitPulseView();
		EmployeeExperienceView employeeExperienceView = new EmployeeExperienceView();
		
		EmployeeRole employeeRole = new EmployeeRole();
		TeamWork teamWork = new TeamWork();
		ProcessPolicy processPolicy = new ProcessPolicy();
		Leadership leadership = new Leadership ();
		PerformanceManagement performanceManagement = new PerformanceManagement();
		ManagerCommunication manager = new ManagerCommunication();
		Career career = new Career();
		Culture culture = new Culture();
		Customer customer = new Customer();
		DecisionMaking decisionMaking = new DecisionMaking();
		
		for (int i = 1 ; i<= 10 ; i++)
		{
			if (i == 1)
			{
				String driverName = "Role";
				employeeRole.setEmployeeCount(dashbordDao.getEmployeeCount(driverName, Department, Location, Technology));
				
				employeeRole.setStronglyDisengageEmployee(dashbordDao.getTotalEmp("Strongly disagree",driverName, Department, Location, Technology));
				employeeRole.setDisengageEmployee(dashbordDao.getTotalEmp("Disagree",driverName, Department, Location, Technology));
				employeeRole.setSomewhatDisengageEmployee(dashbordDao.getTotalEmp("Somewhat disagree",driverName, Department, Location, Technology));
				employeeRole.setSomewhatEngageEmployee(dashbordDao.getTotalEmp("Somewhat agree",driverName, Department, Location, Technology));
				employeeRole.setEngageEmployee(dashbordDao.getTotalEmp("Agree",driverName, Department, Location, Technology));
				employeeRole.setStronglyEngageEmployee(dashbordDao.getTotalEmp("Strongly agree",driverName, Department, Location, Technology));
				
				employeeRole.setStronglyDisengage(dashbordDao.getStronglyDisengageAvg("Strongly disagree", driverName, Department, Location, Technology));
				employeeRole.setDisengage(dashbordDao.getDisengageAvg("Disagree", driverName, Department, Location, Technology));
				employeeRole.setSomewhatDisengage(dashbordDao.somewhatDisengageAvg("Somewhat disagree", driverName, Department, Location, Technology));
				employeeRole.setSomewhatEngage(dashbordDao.somewhatEngageAvg("Somewhat agree", driverName, Department, Location, Technology));
				employeeRole.setEngage(dashbordDao.engageAvg("Agree", driverName, Department, Location, Technology));
				employeeRole.setStronglyEngage(dashbordDao.stronglyEngageAvg("Strongly agree", driverName, Department, Location, Technology));
				employeeExperienceView.setEmployeeRole(employeeRole);
			}
			else if (i == 2)
			{
				String driverName = "Teamwork";
				teamWork.setEmployeeCount(dashbordDao.getEmployeeCount(driverName, Department, Location, Technology));
				
				teamWork.setStronglyDisengageEmployee(dashbordDao.getTotalEmp("Strongly disagree",driverName, Department, Location, Technology));
				teamWork.setDisengageEmployee(dashbordDao.getTotalEmp("Disagree",driverName, Department, Location, Technology));
				teamWork.setSomewhatDisengageEmployee(dashbordDao.getTotalEmp("Somewhat disagree",driverName, Department, Location, Technology));
				teamWork.setSomewhatEngageEmployee(dashbordDao.getTotalEmp("Somewhat agree",driverName, Department, Location, Technology));
				teamWork.setEngageEmployee(dashbordDao.getTotalEmp("Agree",driverName, Department, Location, Technology));
				teamWork.setStronglyEngageEmployee(dashbordDao.getTotalEmp("Strongly agree",driverName, Department, Location, Technology));
				
				teamWork.setStronglyDisengage(dashbordDao.getStronglyDisengageAvg("Strongly disagree", driverName, Department, Location, Technology));
				teamWork.setDisengage(dashbordDao.getDisengageAvg("Disagree", driverName, Department, Location, Technology));
				teamWork.setSomewhatDisengage(dashbordDao.somewhatDisengageAvg("Somewhat disagree", driverName, Department, Location, Technology));
				teamWork.setSomewhatEngage(dashbordDao.somewhatEngageAvg("Somewhat agree", driverName, Department, Location, Technology));
				teamWork.setEngage(dashbordDao.engageAvg("Agree", driverName, Department, Location, Technology));
				teamWork.setStronglyEngage(dashbordDao.stronglyEngageAvg("Strongly agree", driverName, Department, Location, Technology));
				employeeExperienceView.setTeamWork(teamWork);
			}
			else if (i == 3)
			{
				String driverName = "Process Policy ";
				processPolicy.setEmployeeCount(dashbordDao.getEmployeeCount(driverName, Department, Location, Technology));
				
				processPolicy.setStronglyDisengageEmployee(dashbordDao.getTotalEmp("Strongly disagree",driverName, Department, Location, Technology));
				processPolicy.setDisengageEmployee(dashbordDao.getTotalEmp("Disagree",driverName, Department, Location, Technology));
				processPolicy.setSomewhatDisengageEmployee(dashbordDao.getTotalEmp("Somewhat disagree",driverName, Department, Location, Technology));
				processPolicy.setSomewhatEngageEmployee(dashbordDao.getTotalEmp("Somewhat agree",driverName, Department, Location, Technology));
				processPolicy.setEngageEmployee(dashbordDao.getTotalEmp("Agree",driverName, Department, Location, Technology));
				processPolicy.setStronglyEngageEmployee(dashbordDao.getTotalEmp("Strongly agree",driverName, Department, Location, Technology));
				
				processPolicy.setStronglyDisengage(dashbordDao.getStronglyDisengageAvg("Strongly disagree", driverName, Department, Location, Technology));
				processPolicy.setDisengage(dashbordDao.getDisengageAvg("Disagree", driverName, Department, Location, Technology));
				processPolicy.setSomewhatDisengage(dashbordDao.somewhatDisengageAvg("Somewhat disagree", driverName, Department, Location, Technology));
				processPolicy.setSomewhatEngage(dashbordDao.somewhatEngageAvg("Somewhat agree", driverName, Department, Location, Technology));
				processPolicy.setEngage(dashbordDao.engageAvg("Agree", driverName, Department, Location, Technology));
				processPolicy.setStronglyEngage(dashbordDao.stronglyEngageAvg("Strongly agree", driverName, Department, Location, Technology));
				employeeExperienceView.setProcessPolicy(processPolicy);
			}
			else if (i == 4)
			{
				String driverName = "Learning and Development";
				leadership.setEmployeeCount(dashbordDao.getEmployeeCount(driverName, Department, Location, Technology));
				
				leadership.setStronglyDisengageEmployee(dashbordDao.getTotalEmp("Strongly disagree",driverName, Department, Location, Technology));
				leadership.setDisengageEmployee(dashbordDao.getTotalEmp("Disagree",driverName, Department, Location, Technology));
				leadership.setSomewhatDisengageEmployee(dashbordDao.getTotalEmp("Somewhat disagree",driverName, Department, Location, Technology));
				leadership.setSomewhatEngageEmployee(dashbordDao.getTotalEmp("Somewhat agree",driverName, Department, Location, Technology));
				leadership.setEngageEmployee(dashbordDao.getTotalEmp("Agree",driverName, Department, Location, Technology));
				leadership.setStronglyEngageEmployee(dashbordDao.getTotalEmp("Strongly agree",driverName, Department, Location, Technology));
				
				leadership.setStronglyDisengage(dashbordDao.getStronglyDisengageAvg("Strongly disagree", driverName, Department, Location, Technology));
				leadership.setDisengage(dashbordDao.getDisengageAvg("Disagree", driverName, Department, Location, Technology));
				leadership.setSomewhatDisengage(dashbordDao.somewhatDisengageAvg("Somewhat disagree", driverName, Department, Location, Technology));
				leadership.setSomewhatEngage(dashbordDao.somewhatEngageAvg("Somewhat agree", driverName, Department, Location, Technology));
				leadership.setEngage(dashbordDao.engageAvg("Agree", driverName, Department, Location, Technology));
				leadership.setStronglyEngage(dashbordDao.stronglyEngageAvg("Strongly agree", driverName, Department, Location, Technology));
				employeeExperienceView.setLeadership(leadership);
			}
			else if (i == 5)
			{
				String driverName = "Performance Management";
				performanceManagement.setEmployeeCount(dashbordDao.getEmployeeCount(driverName, Department, Location, Technology));
				
				performanceManagement.setStronglyDisengageEmployee(dashbordDao.getTotalEmp("Strongly disagree",driverName, Department, Location, Technology));
				performanceManagement.setDisengageEmployee(dashbordDao.getTotalEmp("Disagree",driverName, Department, Location, Technology));
				performanceManagement.setSomewhatDisengageEmployee(dashbordDao.getTotalEmp("Somewhat disagree",driverName, Department, Location, Technology));
				performanceManagement.setSomewhatEngageEmployee(dashbordDao.getTotalEmp("Somewhat agree",driverName, Department, Location, Technology));
				performanceManagement.setEngageEmployee(dashbordDao.getTotalEmp("Agree",driverName, Department, Location, Technology));
				performanceManagement.setStronglyEngageEmployee(dashbordDao.getTotalEmp("Strongly agree",driverName, Department, Location, Technology));
				
				performanceManagement.setStronglyDisengage(dashbordDao.getStronglyDisengageAvg("Strongly disagree", driverName, Department, Location, Technology));
				performanceManagement.setDisengage(dashbordDao.getDisengageAvg("Disagree", driverName, Department, Location, Technology));
				performanceManagement.setSomewhatDisengage(dashbordDao.somewhatDisengageAvg("Somewhat disagree", driverName, Department, Location, Technology));
				performanceManagement.setSomewhatEngage(dashbordDao.somewhatEngageAvg("Somewhat agree", driverName, Department, Location, Technology));
				performanceManagement.setEngage(dashbordDao.engageAvg("Agree", driverName, Department, Location, Technology));
				performanceManagement.setStronglyEngage(dashbordDao.stronglyEngageAvg("Strongly agree", driverName, Department, Location, Technology));
				employeeExperienceView.setPerformanceManagement(performanceManagement);
			}
			else if (i == 6)
			{
				String driverName = "Manager";
				manager.setEmployeeCount(dashbordDao.getEmployeeCount(driverName, Department, Location, Technology));
				
				manager.setStronglyDisengageEmployee(dashbordDao.getTotalEmp("Strongly disagree",driverName, Department, Location, Technology));
				manager.setDisengageEmployee(dashbordDao.getTotalEmp("Disagree",driverName, Department, Location, Technology));
				manager.setSomewhatDisengageEmployee(dashbordDao.getTotalEmp("Somewhat disagree",driverName, Department, Location, Technology));
				manager.setSomewhatEngageEmployee(dashbordDao.getTotalEmp("Somewhat agree",driverName, Department, Location, Technology));
				manager.setEngageEmployee(dashbordDao.getTotalEmp("Agree",driverName, Department, Location, Technology));
				manager.setStronglyEngageEmployee(dashbordDao.getTotalEmp("Strongly agree",driverName, Department, Location, Technology));
				
				manager.setStronglyDisengage(dashbordDao.getStronglyDisengageAvg("Strongly disagree", driverName, Department, Location, Technology));
				manager.setDisengage(dashbordDao.getDisengageAvg("Disagree", driverName, Department, Location, Technology));
				manager.setSomewhatDisengage(dashbordDao.somewhatDisengageAvg("Somewhat disagree", driverName, Department, Location, Technology));
				manager.setSomewhatEngage(dashbordDao.somewhatEngageAvg("Somewhat agree", driverName, Department, Location, Technology));
				manager.setEngage(dashbordDao.engageAvg("Agree", driverName, Department, Location, Technology));
				manager.setStronglyEngage(dashbordDao.stronglyEngageAvg("Strongly agree", driverName, Department, Location, Technology));
				employeeExperienceView.setManager(manager);
			}
			else if (i == 7)
			{
				String driverName = "Career";
				career.setEmployeeCount(dashbordDao.getEmployeeCount(driverName, Department, Location, Technology));
				
				career.setStronglyDisengageEmployee(dashbordDao.getTotalEmp("Strongly disagree",driverName, Department, Location, Technology));
				career.setDisengageEmployee(dashbordDao.getTotalEmp("Disagree",driverName, Department, Location, Technology));
				career.setSomewhatDisengageEmployee(dashbordDao.getTotalEmp("Somewhat disagree",driverName, Department, Location, Technology));
				career.setSomewhatEngageEmployee(dashbordDao.getTotalEmp("Somewhat agree",driverName, Department, Location, Technology));
				career.setEngageEmployee(dashbordDao.getTotalEmp("Agree",driverName, Department, Location, Technology));
				career.setStronglyEngageEmployee(dashbordDao.getTotalEmp("Strongly agree",driverName, Department, Location, Technology));
				
				career.setStronglyDisengage(dashbordDao.getStronglyDisengageAvg("Strongly disagree", driverName, Department, Location, Technology));
				career.setDisengage(dashbordDao.getDisengageAvg("Disagree", driverName, Department, Location, Technology));
				career.setSomewhatDisengage(dashbordDao.somewhatDisengageAvg("Somewhat disagree", driverName, Department, Location, Technology));
				career.setSomewhatEngage(dashbordDao.somewhatEngageAvg("Somewhat agree", driverName, Department, Location, Technology));
				career.setEngage(dashbordDao.engageAvg("Agree", driverName, Department, Location, Technology));
				career.setStronglyEngage(dashbordDao.stronglyEngageAvg("Strongly agree", driverName, Department, Location, Technology));
				employeeExperienceView.setCareer(career);
			}
			else if (i == 8)
			{
				String driverName = "Culture";
				culture.setEmployeeCount(dashbordDao.getEmployeeCount(driverName, Department, Location, Technology));
				
				culture.setStronglyDisengageEmployee(dashbordDao.getTotalEmp("Strongly disagree",driverName, Department, Location, Technology));
				culture.setDisengageEmployee(dashbordDao.getTotalEmp("Disagree",driverName, Department, Location, Technology));
				culture.setSomewhatDisengageEmployee(dashbordDao.getTotalEmp("Somewhat disagree",driverName, Department, Location, Technology));
				culture.setSomewhatEngageEmployee(dashbordDao.getTotalEmp("Somewhat agree",driverName, Department, Location, Technology));
				culture.setEngageEmployee(dashbordDao.getTotalEmp("Agree",driverName, Department, Location, Technology));
				culture.setStronglyEngageEmployee(dashbordDao.getTotalEmp("Strongly agree",driverName, Department, Location, Technology));
				
				culture.setStronglyDisengage(dashbordDao.getStronglyDisengageAvg("Strongly disagree", driverName, Department, Location, Technology));
				culture.setDisengage(dashbordDao.getDisengageAvg("Disagree", driverName, Department, Location, Technology));
				culture.setSomewhatDisengage(dashbordDao.somewhatDisengageAvg("Somewhat disagree", driverName, Department, Location, Technology));
				culture.setSomewhatEngage(dashbordDao.somewhatEngageAvg("Somewhat agree", driverName, Department, Location, Technology));
				culture.setEngage(dashbordDao.engageAvg("Agree", driverName, Department, Location, Technology));
				culture.setStronglyEngage(dashbordDao.stronglyEngageAvg("Strongly agree", driverName, Department, Location, Technology));
				employeeExperienceView.setCulture(culture);
			}
			else if (i == 9)
			{
				String driverName = "Customer";
				customer.setEmployeeCount(dashbordDao.getEmployeeCount(driverName, Department, Location, Technology));
				
				customer.setStronglyDisengageEmployee(dashbordDao.getTotalEmp("Strongly disagree",driverName, Department, Location, Technology));
				customer.setDisengageEmployee(dashbordDao.getTotalEmp("Disagree",driverName, Department, Location, Technology));
				customer.setSomewhatDisengageEmployee(dashbordDao.getTotalEmp("Somewhat disagree",driverName, Department, Location, Technology));
				customer.setSomewhatEngageEmployee(dashbordDao.getTotalEmp("Somewhat agree",driverName, Department, Location, Technology));
				customer.setEngageEmployee(dashbordDao.getTotalEmp("Agree",driverName, Department, Location, Technology));
				customer.setStronglyEngageEmployee(dashbordDao.getTotalEmp("Strongly agree",driverName, Department, Location, Technology));
				
				customer.setStronglyDisengage(dashbordDao.getStronglyDisengageAvg("Strongly disagree", driverName, Department, Location, Technology));
				customer.setDisengage(dashbordDao.getDisengageAvg("Disagree", driverName, Department, Location, Technology));
				customer.setSomewhatDisengage(dashbordDao.somewhatDisengageAvg("Somewhat disagree", driverName, Department, Location, Technology));
				customer.setSomewhatEngage(dashbordDao.somewhatEngageAvg("Somewhat agree", driverName, Department, Location, Technology));
				customer.setEngage(dashbordDao.engageAvg("Agree", driverName, Department, Location, Technology));
				customer.setStronglyEngage(dashbordDao.stronglyEngageAvg("Strongly agree", driverName, Department, Location, Technology));
				employeeExperienceView.setCustomer(customer);
			}
			else if (i == 10)
			{
				String driverName = "Decision Making";
				decisionMaking.setEmployeeCount(dashbordDao.getEmployeeCount(driverName, Department, Location, Technology));
				
				decisionMaking.setStronglyDisengageEmployee(dashbordDao.getTotalEmp("Strongly disagree",driverName, Department, Location, Technology));
				decisionMaking.setDisengageEmployee(dashbordDao.getTotalEmp("Disagree",driverName, Department, Location, Technology));
				decisionMaking.setSomewhatDisengageEmployee(dashbordDao.getTotalEmp("Somewhat disagree",driverName, Department, Location, Technology));
				decisionMaking.setSomewhatEngageEmployee(dashbordDao.getTotalEmp("Somewhat agree",driverName, Department, Location, Technology));
				decisionMaking.setEngageEmployee(dashbordDao.getTotalEmp("Agree",driverName, Department, Location, Technology));
				decisionMaking.setStronglyEngageEmployee(dashbordDao.getTotalEmp("Strongly agree",driverName, Department, Location, Technology));
				
				decisionMaking.setStronglyDisengage(dashbordDao.getStronglyDisengageAvg("Strongly disagree", driverName, Department, Location, Technology));
				decisionMaking.setDisengage(dashbordDao.getDisengageAvg("Disagree", driverName, Department, Location, Technology));
				decisionMaking.setSomewhatDisengage(dashbordDao.somewhatDisengageAvg("Somewhat disagree", driverName, Department, Location, Technology));
				decisionMaking.setSomewhatEngage(dashbordDao.somewhatEngageAvg("Somewhat agree", driverName, Department, Location, Technology));
				decisionMaking.setEngage(dashbordDao.engageAvg("Agree", driverName, Department, Location, Technology));
				decisionMaking.setStronglyEngage(dashbordDao.stronglyEngageAvg("Strongly agree", driverName, Department, Location, Technology));
				employeeExperienceView.setDecisionMaking(decisionMaking);
			}
		}	
		unitPulseView.setEmployeeExperienceView(employeeExperienceView);
		return unitPulseView;
	}

	public GenderWiseView getGenderWiseView(String Department, String Location, String Technology) {
		GenderWiseView genderWiseView = new GenderWiseView();
		GenderWiseViewParam genderWiseViewParam = new GenderWiseViewParam();
		MaleGender maleGender = new MaleGender();
		FemaleGender femaleGender = new FemaleGender();
		for(int i = 1 ; i<= 2 ; i++ )
		{
			if(i == 1)
			{
				BigDecimal mood = new BigDecimal(((float) dashbordDao.getTotalGenderCount(i, Department, Location, Technology) / dashbordDao.getGenderWiseSurveySum(i, Department, Location, Technology)) * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
				maleGender.setMood(mood);
				
				BigDecimal progress = new BigDecimal(((float) dashbordDao.getResponseGenderCount(i, Department, Location, Technology) / (float) dashbordDao.getGenderCount(i, Department, Location, Technology)) * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
				maleGender.setProgress(progress);
				maleGender.setCriticalEmployee(dashbordDao.getCriticalEmployeeCount(i, Department, Location, Technology));
				
				genderWiseViewParam.setMaleGender(maleGender);
			}	
			else if(i == 2)
			{
				BigDecimal mood = new BigDecimal(((float) dashbordDao.getTotalGenderCount(i, Department, Location, Technology) / dashbordDao.getGenderWiseSurveySum(i, Department, Location, Technology)) * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
				femaleGender.setMood(mood);
				
				BigDecimal progress = new BigDecimal(((float) dashbordDao.getResponseGenderCount(i, Department, Location, Technology) / (float) dashbordDao.getGenderCount(i, Department, Location, Technology)) * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
				femaleGender.setProgress(progress);
				femaleGender.setCriticalEmployee(dashbordDao.getCriticalEmployeeCount(i, Department, Location, Technology));
				
				genderWiseViewParam.setFemaleGender(femaleGender);
			}	
		}	
		genderWiseView.setGenderWiseView(genderWiseViewParam);
		return genderWiseView;
	}

	public GradeWiseHighFlightRisk getGradeWiseHighFlightRisk() {
		GradeWiseHighFlightRisk gradeWiseHighFlightRisk = new GradeWiseHighFlightRisk();
		GradeWiseHighFlightRiskParam gradeWiseHighFlightRiskParam = new GradeWiseHighFlightRiskParam();
		int totalCountOfHighRisk = dashbordDao.TotalCountOfHighRisk();
		for(int i = 1 ; i<= 7 ; i++ )
		{
			if(i == 1)
			{
				Grade1 grade1 = new Grade1();
				int totalHighRiskEmployeeGrade1 = dashbordDao.getTotalGradeCountOfHighRisk("M1");
				BigDecimal percente = new BigDecimal(((float) totalHighRiskEmployeeGrade1 / totalCountOfHighRisk) * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
				grade1.setPercente(percente);
				grade1.setTotalHighRiskEmployee(totalHighRiskEmployeeGrade1);
				
				gradeWiseHighFlightRiskParam.setGrade1(grade1);
			}	
			else if(i == 2)
			{
				Grade2 grade2 = new Grade2();
				int totalHighRiskEmployeeGrade2 = dashbordDao.getTotalGradeCountOfHighRisk("M2");
				BigDecimal percente = new BigDecimal(((float) totalHighRiskEmployeeGrade2 / totalCountOfHighRisk) * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
				grade2.setPercente(percente);
				grade2.setTotalHighRiskEmployee(totalHighRiskEmployeeGrade2);
				
				gradeWiseHighFlightRiskParam.setGrade2(grade2);
			}
			
			else if(i == 3)
			{
				Grade3 grade3 = new Grade3();
				int totalHighRiskEmployeeGrade3 = dashbordDao.getTotalGradeCountOfHighRisk("M3");
				BigDecimal percente = new BigDecimal(((float) totalHighRiskEmployeeGrade3 / totalCountOfHighRisk) * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
				grade3.setPercente(percente);
				grade3.setTotalHighRiskEmployee(totalHighRiskEmployeeGrade3);
				
				gradeWiseHighFlightRiskParam.setGrade3(grade3);
			}
			else if(i == 4)
			{
				Grade4 grade4 = new Grade4();
				int totalHighRiskEmployeeGrade4 = dashbordDao.getTotalGradeCountOfHighRisk("M4");
				BigDecimal percente = new BigDecimal(((float) totalHighRiskEmployeeGrade4 / totalCountOfHighRisk) * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
				grade4.setPercente(percente);
				grade4.setTotalHighRiskEmployee(totalHighRiskEmployeeGrade4);
				
				gradeWiseHighFlightRiskParam.setGrade4(grade4);
			}
			else if(i == 5)
			{
				Grade5 grade5 = new Grade5();
				int totalHighRiskEmployeeGrade5 = dashbordDao.getTotalGradeCountOfHighRisk("M5");
				BigDecimal percente = new BigDecimal(((float) totalHighRiskEmployeeGrade5 / totalCountOfHighRisk) * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
				grade5.setPercente(percente);
				grade5.setTotalHighRiskEmployee(totalHighRiskEmployeeGrade5);
				
				gradeWiseHighFlightRiskParam.setGrade5(grade5);
			}
			else if(i == 6)
			{
				Grade6 grade6 = new Grade6();
				int totalHighRiskEmployeeGrade6 = dashbordDao.getTotalGradeCountOfHighRisk("M6");
				BigDecimal percente = new BigDecimal(((float) totalHighRiskEmployeeGrade6 / totalCountOfHighRisk) * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
				grade6.setPercente(percente);
				grade6.setTotalHighRiskEmployee(totalHighRiskEmployeeGrade6);
				
				gradeWiseHighFlightRiskParam.setGrade6(grade6);
			}
			else if(i == 7)
			{
				Grade7 grade7 = new Grade7();
				int totalHighRiskEmployeeGrade7 = dashbordDao.getTotalGradeCountOfHighRisk("M7");
				BigDecimal percente = new BigDecimal(((float) totalHighRiskEmployeeGrade7 / totalCountOfHighRisk) * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
				grade7.setPercente(percente);
				grade7.setTotalHighRiskEmployee(totalHighRiskEmployeeGrade7);
				
				gradeWiseHighFlightRiskParam.setGrade7(grade7);
			}
		}	
		gradeWiseHighFlightRisk.setGradeWiseHighFlightRisk(gradeWiseHighFlightRiskParam);;
		return gradeWiseHighFlightRisk;
	}

	public BusinessUnitWiseHighFlightRisk getBusinessUnitWiseHighFlightRisk() {
		BusinessUnitWiseHighFlightRisk businessUnitWiseHighFlightRisk = new BusinessUnitWiseHighFlightRisk();
		BusinessUnitWiseHighFlightRiskParam businessUnitWiseHighFlightRiskParam = new BusinessUnitWiseHighFlightRiskParam();
		int totalHighRiskAssociates = dashbordDao.getTotalHighRiskAssociates();
		for(int i = 1 ; i<= 4 ; i++ )
		{
			if(i == 1)
			{
				int totalHighRiskBusinessUnit = dashbordDao.gettotalHighRiskBusinessUnit(i);
				BigDecimal percente = new BigDecimal(((float) totalHighRiskBusinessUnit / totalHighRiskAssociates) * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
				businessUnitWiseHighFlightRiskParam.setPercenteOfBusinesUnit1(percente);
			}	
			else if(i == 2)
			{
				int totalHighRiskBusinessUnit = dashbordDao.gettotalHighRiskBusinessUnit(i);
				BigDecimal percente = new BigDecimal(((float) totalHighRiskBusinessUnit / totalHighRiskAssociates) * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
				businessUnitWiseHighFlightRiskParam.setPercenteOfBusinesUnit2(percente);
			}
			else if(i == 3)
			{
				int totalHighRiskBusinessUnit = dashbordDao.gettotalHighRiskBusinessUnit(i);
				BigDecimal percente = new BigDecimal(((float) totalHighRiskBusinessUnit / totalHighRiskAssociates) * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
				businessUnitWiseHighFlightRiskParam.setPercenteOfBusinesUnit3(percente);
			}
			else if(i == 4)
			{
				int totalHighRiskBusinessUnit = dashbordDao.gettotalHighRiskBusinessUnit(i);
				BigDecimal percente = new BigDecimal(((float) totalHighRiskBusinessUnit / totalHighRiskAssociates) * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
				businessUnitWiseHighFlightRiskParam.setPercenteOfBusinesUnit4(percente);
			}
		}
		businessUnitWiseHighFlightRiskParam.setTotalHighRiskAssociates(totalHighRiskAssociates);
		
		businessUnitWiseHighFlightRisk.setBusinessUnitWiseHighFlightRisk(businessUnitWiseHighFlightRiskParam);
		return businessUnitWiseHighFlightRisk;
	}

	public EnterpriseEmployeeRisk getEnterpriseEmployeeRisk() {
		EnterpriseEmployeeRisk enterpriseEmployeeRisk = new EnterpriseEmployeeRisk();
		EnterpriseEmployeeRiskParam enterpriseEmployeeRiskParam = new EnterpriseEmployeeRiskParam();
		FlightHighRisk flightHighRisk = new FlightHighRisk();
		FlightMediumRisk flightMediumRisk = new FlightMediumRisk();
		
		int totalAssociate = dashbordDao.getTotalEmployee();
		enterpriseEmployeeRiskParam.setTotalAssociate(totalAssociate);
		int totalSurveyCount = dashbordDao.getTotalSurveyCount();
		
		float  highRisk =(((float)dashbordDao.getHighRiskCount()/totalSurveyCount)*100);
		BigDecimal highRiskPercentage = new BigDecimal(highRisk).setScale(0,BigDecimal.ROUND_HALF_UP);
		flightHighRisk.setHighRiskPercentage(highRiskPercentage);
		flightHighRisk.setTotalHighRiskEmployee(dashbordDao.getTotalHighRiskEmployee());
		enterpriseEmployeeRiskParam.setFlightHighRisk(flightHighRisk);
		
		float  mediumRisk =(((float)dashbordDao.getMediumRiskCount()/totalSurveyCount)*100);
		BigDecimal mediumRiskPercentage = new BigDecimal(mediumRisk).setScale(0,BigDecimal.ROUND_HALF_UP);
		flightMediumRisk.setMediumRiskPercentage(mediumRiskPercentage);
		flightMediumRisk.setTotalMediumRiskEmployee(dashbordDao.getTotalMediumRiskEmployee());
		enterpriseEmployeeRiskParam.setFlightMediumRisk(flightMediumRisk);
		
		// Age Group Filters
		AgeGroup ageGroup = new AgeGroup();
		ageGroup.setHighRisk30Above(dashbordDao.get30Above("'Strongly disagree','Disagree'"));
		ageGroup.setHighRisk30Below(dashbordDao.get30Below("'Strongly disagree','Disagree'"));
		ageGroup.setMediumRisk30Above(dashbordDao.get30Above("'Somewhat disagree','Somewhat agree'"));
		ageGroup.setMediumRisk30Below(dashbordDao.get30Below("'Somewhat disagree','Somewhat agree'"));
		enterpriseEmployeeRiskParam.setAgeGroup(ageGroup);
		
		// Performers Filters
		Performers performers = new Performers();
		performers.setHighRisk3RatingAbove(dashbordDao.get3RatingAbove("'Strongly disagree','Disagree'"));
		performers.setHighRisk3RatingBelow(dashbordDao.get3RatingBelow("'Strongly disagree','Disagree'"));
		performers.setMediumRisk3RatingAbove(dashbordDao.get3RatingAbove("'Somewhat disagree','Somewhat agree'"));
		performers.setMediumRisk3RatingBelow(dashbordDao.get3RatingBelow("'Somewhat disagree','Somewhat agree'"));
		enterpriseEmployeeRiskParam.setPerformers(performers);
		
		// Educations Filters
		Educations educations = new Educations();
		educations.setHighRisk22YearAbove(dashbordDao.get22YearAbove("'Strongly disagree','Disagree'"));
		educations.setHighRisk22YearBelow(dashbordDao.get22YearBelow("'Strongly disagree','Disagree'"));
		educations.setMediumRisk22YearAbove(dashbordDao.get22YearAbove("'Somewhat disagree','Somewhat agree'"));
		educations.setMediumRisk22YearBelow(dashbordDao.get22YearBelow("'Somewhat disagree','Somewhat agree'"));
		enterpriseEmployeeRiskParam.setEducations(educations);
		
		// Educations Filters
		Experience experience = new Experience();
		experience.setHighRisk10YearAbove(dashbordDao.get10YearAbove("'Strongly disagree','Disagree'"));
		experience.setHighRisk10YearBelow(dashbordDao.get10YearBelow("'Strongly disagree','Disagree'"));
		experience.setMediumRisk10YearAbove(dashbordDao.get10YearAbove("'Somewhat disagree','Somewhat agree'"));
		experience.setMediumRisk10YearBelow(dashbordDao.get10YearBelow("'Somewhat disagree','Somewhat agree'"));
		enterpriseEmployeeRiskParam.setExperience(experience);
		
		// Gender Filters
		Gender gender = new Gender();
		gender.setHighRiskMale(dashbordDao.getMale("'Strongly disagree','Disagree'"));
		gender.setHighRiskFemale(dashbordDao.getFemale("'Strongly disagree','Disagree'"));
		gender.setMediumRiskMale(dashbordDao.getMale("'Somewhat disagree','Somewhat agree'"));
		gender.setMediumRiskFemale(dashbordDao.getFemale("'Somewhat disagree','Somewhat agree'"));
		enterpriseEmployeeRiskParam.setGender(gender);
		
		enterpriseEmployeeRisk.setEnterpriseEmployeeRisk(enterpriseEmployeeRiskParam);
		return enterpriseEmployeeRisk;
	}

	public CriticalEmployeeHighRisk getCriticalEmployeeHighRisk() {
		CriticalEmployeeHighRisk criticalEmployeeHighRisk = new CriticalEmployeeHighRisk();
		CriticalEmployeeHighRiskParam criticalEmployeeHighRiskParam = new CriticalEmployeeHighRiskParam();

		int totalHighRiskAssociates = dashbordDao.getTotalHighRiskAssociates();
		for(int i = 1 ; i<= 2 ; i++ )
		{
			if(i == 1)
			{
				MaleGenderCritical maleGenderCritical = new MaleGenderCritical();
				int totalMaleGenderCritical  = dashbordDao.getTotalCriticalEmployee(i);
				BigDecimal maleCriticalHighRiskPercentage = new BigDecimal(((float) totalMaleGenderCritical / (float) totalHighRiskAssociates) * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
				maleGenderCritical.setMaleCriticalHighRiskPercentage(maleCriticalHighRiskPercentage);
				maleGenderCritical.setTotalMaleCriticalHighRiskEmp(totalMaleGenderCritical);
				
				criticalEmployeeHighRiskParam.setMaleGenderCritical(maleGenderCritical);
			}	
			else if(i == 2)
			{
				FemaleGenderCritical femaleGenderCritical = new FemaleGenderCritical();
				int totalFemaleCriticalHighRisk  = dashbordDao.getTotalCriticalEmployee(i);
				BigDecimal femaleCriticalHighRiskPercentage = new BigDecimal(((float) totalFemaleCriticalHighRisk / (float) totalHighRiskAssociates) * 100).setScale(0, BigDecimal.ROUND_HALF_UP);
				femaleGenderCritical.setFemaleCriticalHighRiskPercentage(femaleCriticalHighRiskPercentage);
				femaleGenderCritical.setTotalFemaleCriticalHighRiskEmp(totalFemaleCriticalHighRisk);
				criticalEmployeeHighRiskParam.setFemaleGenderCritical(femaleGenderCritical);
			}	
		}	
		
		criticalEmployeeHighRisk.setCriticalEmployeeHighRisk(criticalEmployeeHighRiskParam);
		return criticalEmployeeHighRisk;
	}

	public RiskAnalysisEmployeeCover getRiskAnalysisEmployeeCover() {
		RiskAnalysisEmployeeCover riskAnalysisEmployeeCover = new RiskAnalysisEmployeeCover();
		RiskAnalysisEmployeeCoverParam riskAnalysisEmployeeCoverParam = new RiskAnalysisEmployeeCoverParam();
		
		HighRisk highRiskModel = new HighRisk();
		MediumRisk mediumRiskModel = new MediumRisk();
		NoRisk noRiskModel = new NoRisk();
		//List<Employee> HighRiskEmployee = new ArrayList<Employee>();
		//List<Employee> MediumRiskEmployee = new ArrayList<Employee>();
		//List<Employee> NoRiskEmployee = new ArrayList<Employee>();
		
		int totalSurveyCount = dashbordDao.getTotalSurveyCount();
		
		// Percentage of high risk
		float  highRisk =(((float)dashbordDao.getHighRiskCount()/totalSurveyCount)*100);
		BigDecimal roundHighRisk = new BigDecimal(highRisk).setScale(0,BigDecimal.ROUND_HALF_UP);
		highRiskModel.setHighRiskPercentage(roundHighRisk);
		highRiskModel.setEmployee(dashbordDao.getEmployeeList("'Strongly disagree', 'Disagree'"));
		
		// Percentage of medium risk
		float  mediumRisk =(((float)dashbordDao.getMediumRiskCount()/totalSurveyCount)*100);
		BigDecimal roundMediumRisk = new BigDecimal(mediumRisk).setScale(0,BigDecimal.ROUND_HALF_UP);
		mediumRiskModel.setMediumRiskPercentage(roundMediumRisk);
		mediumRiskModel.setEmployee(dashbordDao.getEmployeeList("'Somewhat disagree','Somewhat agree'"));
		//mediumRiskModel.setEmployee(employee);
		
		// Percentage of medium risk
		float  noRisk =(((float)dashbordDao.getNoRiskCount()/totalSurveyCount)*100);
		BigDecimal roundNoRisk = new BigDecimal(noRisk).setScale(0,BigDecimal.ROUND_HALF_UP);
		noRiskModel.setNoRiskPercentage(roundNoRisk);
		noRiskModel.setEmployee(dashbordDao.getEmployeeList("'Agree','Strongly agree'"));
		//noRiskModel.setEmployee(employee);
		
		riskAnalysisEmployeeCoverParam.setHighRisk(highRiskModel);
		riskAnalysisEmployeeCoverParam.setMediumRisk(mediumRiskModel);
		riskAnalysisEmployeeCoverParam.setNoRisk(noRiskModel);
		
		riskAnalysisEmployeeCover.setRiskAnalysisEmployeeCover(riskAnalysisEmployeeCoverParam);
		return riskAnalysisEmployeeCover;
	}
}
