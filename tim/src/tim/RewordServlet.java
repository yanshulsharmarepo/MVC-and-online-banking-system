package tim;

import java.io.*;
import java.lang.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class RewordServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       

        int user_name = Integer.parseInt(request.getParameter("user_name"));
     //   String password = request.getParameter("password");
     
        try {
            Class.forName("com.mysql.jdbc.Driver");
         //   Connection con = DriverManager.getConnection(
           //         "jdbc:mysql://localhost:3306/bank", "root", "admin123");
 
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "admin123");
       	 Statement state =connect.createStatement();
       	  ResultSet result = state.executeQuery("select * from acc_bank where acc_nu='"+user_name+"'");
       
               boolean status =result.next();
               
              //  ServletRequest session = null;
				//String u_name = (String)session.setAttribute("user_name");
                   //result.getInt(reword);
                   //result.getInt(change_pin); 
                
        		if(status){ String f_name = result.getString("f_name");
                String l_name = result.getString("l_name");
                int acc_nu = result.getInt("acc_nu");
                int reword =result.getInt("reword");
              
                  // result.getInt("balance");
                String email =result.getString("email");
        			out.print("WELCOME! "+f_name+ ""+l_name+"  Your reword point is "+reword);
        			RequestDispatcher rd=request.getRequestDispatcher("main.jsp");
        			rd.include(request, response);
        		}
        		else{
        			out.print("Sorry,Account NUMBER  failed. please try later");
        			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
        			rd.include(request, response);
        		}
        } catch (Exception e2) {
            System.out.println(e2);
        }
 
        out.close();
    }
 
}
