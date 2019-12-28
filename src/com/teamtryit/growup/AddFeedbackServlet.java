package com.teamtryit.growup;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class AddFeedbackServlet
 */
//@WebServlet("/AddFeedbackServlet")
public class AddFeedbackServlet extends GenericServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public AddFeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		/*Connection con;
		PreparedStatement pst;*/
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		//"jdbc:mysql://127.0.0.1:3306/GrowUp?useSSL=false","root","root"
		//get the data from html page
		String cname=request.getParameter("cname");
		//String idate=request.getParameter("idate");
		//java.util.Date date = null;
		
		try {
			java.util.Date date = null;
			date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("idate"));
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		
		String place=request.getParameter("place");
		String city=request.getParameter("city");
		String rounds=request.getParameter("rounds");
		int irounds=Integer.parseInt(rounds);
		String firstround=request.getParameter("firstround");
		String firstroundmessage=request.getParameter("firstroundmessage");
		String secondround=request.getParameter("secondround");
		String secondroundmessage=request.getParameter("secondroundmessage");
		String thirdround=request.getParameter("thirdround");
		String thirdroundmessage=request.getParameter("thirdroundmessage");
		String fourthround=request.getParameter("fourthround");
		String fourthroundmessage=request.getParameter("fourthroundmessage");
		String improve=request.getParameter("improve");
		
		//provide jdbc connection
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/growup?useSSL=false","root","root");
			// (`CompanyName`,`InterviewDate`,`City`,`Rounds`,`FirstRound`,`FirstRoundQuestions`,`SecondRound`,`SecondRoundQuestions`,`ThirdRound`,`ThirdRoundQuestions`,`FourthRound`,`FourthRoundQuestions`,`NeedToImprove`)
			PreparedStatement pst=con.prepareStatement("INSERT INTO feedback(`CompanyName`,`InterviewDate`,`City`,`Rounds`,`FirstRound`,`FirstRoundQuestions`,`SecondRound`,`SecondRoundQuestions`,`ThirdRound`,`ThirdRoundQuestions`,`FourthRound`,`FourthRoundQuestions`,`NeedToImprove`,`Place`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, cname);
			pst.setDate(2, sqlDate);
			pst.setString(3, city);
			pst.setInt(4, irounds);
			pst.setString(5, firstround);
			pst.setString(6, firstroundmessage);
			pst.setString(7, secondround);
			pst.setString(8, secondroundmessage);
			pst.setString(9, thirdround);
			pst.setString(10, thirdroundmessage);
			pst.setString(11, fourthround);
			pst.setString(12, fourthroundmessage);
			pst.setString(13, improve);
			pst.setString(14, place);
			int x=pst.executeUpdate();
			if(x==1){
				pw.print("Feedback inserted");

			}
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
		pw.println("servlet success");
	}
	/*DEFAULT false DEFAULT CURRENT_TIMESTAMP*/
}
