/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ca.sait.lab6.servlets;

import ca.sait.lab6.models.Role;
import ca.sait.lab6.models.User;
import ca.sait.lab6.services.RoleService;
import ca.sait.lab6.services.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Scott
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService userService = new UserService();
        
        String action = request.getParameter("action");
        String email = request.getParameter("email");
        if(request.getParameter("email")!=null){
            email = email.replaceAll(" ", "+");
        }
        System.out.println(email + action);
        if(action != null && action.equals("edit")){
            request.setAttribute("test",email+" "+action);
            try{
                User eUser = userService.get(email);
                System.out.println(eUser.getFirstName());
                request.setAttribute("eUser", eUser);
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        if(action != null && action.equals("delete")){
            request.setAttribute("test",email+" "+action);
            try{
                userService.delete(email);
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        try{
            List<User> users = userService.getActive(); 
            request.setAttribute("users",users);

        } catch(Exception ex){
            System.out.println(ex);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService userService = new UserService();
        RoleService roleService = new RoleService();
        String action = request.getParameter("action");
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAA "+action+" AAAAAAAAAAAAAAAAAAA");
        if(action != null && action.equals("edit")){
            try{
                String email = request.getParameter("eEmail");
                String fName = request.getParameter("eFName");
                String lName = request.getParameter("eLName");
                String password = request.getParameter("ePassword");
                String roleName = request.getParameter("eRole");
                if(email!=null && fName!=null && lName!=null && password!=null && roleName!=null){
                    int roleId= roleService.getRoleID(roleName);
                    if(roleId == -1){
                        throw new Exception("Invalid Role");
                    }
                    userService.update(email, true, fName, lName, password, new Role(roleId,roleName));                    
                }else{
                    throw new Exception("Empty Inputs");
                }
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        if(action != null && action.equals("add")){
            try{
                String email = request.getParameter("aEmail");
                String fName = request.getParameter("aFName");
                String lName = request.getParameter("aLName");
                String password = request.getParameter("aPassword");
                String roleName = request.getParameter("aRole");
                if(email!=null && fName!=null && lName!=null && password!=null && roleName!=null){
                    int roleId= roleService.getRoleID(roleName);
                    if(roleId == -1){
                        throw new Exception("Invalid Role");
                    }
                    userService.insert(email, true, fName, lName, password, new Role(roleId,roleName));                    
                }else{
                    throw new Exception("Empty Inputs");
                }
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        try{
            List<User> users = userService.getActive(); 
            request.setAttribute("users",users);

        } catch(Exception ex){
            System.out.println(ex);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }
}