/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-10-03 09:53:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class getuserdetails_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Login page</title>\n");
      out.write("        \n");
      out.write("        <link rel=\"shortcut icon\" href=\"img/favicon.ico\" />\n");
      out.write("       \t<link href=\"css/bootstrap/bootstrap.min.css\" rel=\"stylesheet\"></link>\n");
      out.write("       \t<link href=\"css/font-awesome/webfonts/fontawesome-all.min.css\" rel=\"stylesheet\"></link>\n");
      out.write("       \t\n");
      out.write("       \t<link href=\"css/helloworld-common.css\" rel=\"stylesheet\"></link>\n");
      out.write("       \t<link href=\"css/login.css\" rel=\"stylesheet\"></link>\n");
      out.write("        \n");
      out.write("        <script src=\"js/jquery/jquery-3.2.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write(" \t\t<script src=\"js/popper/popper.min.js\" type=\"text/javascript\"></script>\n");
      out.write(" \t\t<script src=\"js/bootstrap/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("<script type=\"text/javascript\" charset=\"utf8\" src=\"https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css\"> \t\t\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("         function show_user() {\n");
      out.write("         $(document).ready( function () {\n");
      out.write("         var table = $('#myTable').DataTable();\n");
      out.write("         table.clear();\n");
      out.write("         $.get('/getAllUser', function(users) {\n");
      out.write(" \t\t for(var i=0; i<users.length;i++) {\n");
      out.write(" \t\t  table.row.add( [  i , users[i].firstName ,users[i].lastName  , users[i].email, users[i].projectName , users[i].salary , users[i].experience, users[i].age  , users[i].maritalStatus  , users[i].contactNumber , '<button type=\"button\"  class=\"delete_user\" data-id=\"' + users[i].userName + '\"  row=\"' + i + '\">Delete</button>','<button type=\"button\"  class=\"edit_user\" data-id=\"' + users[i].userName + '\"  row=\"' + i + '\" data-toggle=\"modal\" data-target=\"#myModal\">Edit</button>']);\n");
      out.write(" \t\t }\n");
      out.write(" \t\t table.draw();\n");
      out.write(" \t\t $('#myTable').dataTable();\n");
      out.write(" \t\t$(\".delete_user\").click(delete_item);\n");
      out.write(" \t\t$(\".edit_user\").click(edit_item);\n");
      out.write(" \t\t   \n");
      out.write(" \t  });\n");
      out.write("  } );\n");
      out.write("}\n");
      out.write("function delete_item()  {\n");
      out.write(" \t\t  var user = $(this).attr('data-id');\n");
      out.write(" \t\t  $.ajax({\n");
      out.write("        url: \"/deleteUser?username=\" + user,\n");
      out.write("        type: 'DELETE',\n");
      out.write("        success: function() {\n");
      out.write("       show_user();\n");
      out.write("    }\n");
      out.write("\n");
      out.write("});\n");
      out.write("}\n");
      out.write("function edit_item() {\n");
      out.write("         var user_edit = $(this).attr('data-id');\n");
      out.write("          $.get(\"/userDetails?username=\" +user_edit, function(user) {\n");
      out.write("                 $('#firstname').val(user.firstName);\n");
      out.write("                 $('#lastname').val(user.lastName);\n");
      out.write("                 $('#age').val(user.age);\n");
      out.write("                 $('#email_1').val(user.email);\n");
      out.write("                 $('#maritalstatus').val(user.maritalStatus);\n");
      out.write("                 $('#projectname').val(user.projectName);\n");
      out.write("                 $('#salary').val(user.salary);\n");
      out.write("                 $('#experience').val(user.experience);\n");
      out.write("                 $('#contactnumber').val(user.contactNumber);\n");
      out.write("                 $('#myModal').on('input change', function() {\n");
      out.write("                    $('#update').attr('disabled', false);\n");
      out.write("                   });\n");
      out.write("                            $(\"#update\").click(update_item);  \n");
      out.write("                 \n");
      out.write("                });\n");
      out.write("  function update_item() {\n");
      out.write("      var userName = user_edit;\n");
      out.write("\t\tvar firstName = $(\"#firstname\").val();\n");
      out.write("\t\tvar lastName = $(\"#lastname\").val();\n");
      out.write("\t\tvar age = $(\"#age\").val();\n");
      out.write("\t\tvar projectName = $(\"#projectname\").val();\n");
      out.write("\t\tvar salary = $(\"#salary\").val();\n");
      out.write("\t\tvar experience = $(\"#experience\").val();\n");
      out.write("\t\tvar contactNumber = $(\"#contactnumber\").val();\n");
      out.write("\t\tvar Email = $(\"#email_1\").val();\n");
      out.write("\t\tvar maritalStatus = $(\"#maritalstatus\").val();\n");
      out.write("\t\t$.post('/updateUser',jQuery.param ({username: userName, firstname: firstName, lastname : lastName, email : Email, contactnumber : contactNumber, maritalstatus : maritalStatus, age:age , projectname:projectName , salary:salary , experience:experience}),function(data){\n");
      out.write("             });\n");
      out.write("\t\t  }\n");
      out.write("}       \n");
      out.write("show_user();\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navbar/navbar.jsp", out, false);
      out.write("\n");
      out.write("      <table id=\"myTable\" class=\"display\" >\n");
      out.write("      <thead><tr><th scope=\"col\"> #</th> \n");
      out.write("      <th scope=\"col\"> FirstName</th>\n");
      out.write("      <th scope=\"col\">LastName  </th>\n");
      out.write("      <th scope=\"col\">Email</th>\n");
      out.write("      <th scope=\"col\">ProjectName</th>\n");
      out.write("      <th scope=\"col\">Salary</th>\n");
      out.write("      <th scope=\"col\">Exprience</th>\n");
      out.write("      <th scope=\"col\">Age</th>\n");
      out.write("      <th scope=\"col\"> MaritalStatus</th>\n");
      out.write("      <th scope=\"col\">ContactNumber</th>\n");
      out.write("      <th scope=\"col\">DeleteUser</th>\n");
      out.write("       <th scope=\"col\">EditUser</th></tr></thead>\n");
      out.write("      <tbody>\n");
      out.write("      </tbody>\n");
      out.write("      </table>\n");
      out.write("       <div class=\"modal fade\" id=\"myModal\">\n");
      out.write("    <div class=\"modal-dialog\">\n");
      out.write("      <div class=\"modal-content\">\n");
      out.write("      \n");
      out.write("        <!-- Modal Header -->\n");
      out.write("        <div class=\"modal-header\">\n");
      out.write("          <h4 class=\"modal-title\">Edit</h4>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <!-- Modal body -->\n");
      out.write("        <div class=\"modal-body\">\n");
      out.write("          \t<table style=\"with: 50%\" align=\"center\">\n");
      out.write("          \n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>First Name</td>\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"firstName\" id=\"firstname\" /></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>Last Name</td>\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"lastName\" id=\"lastname\" /></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>Email</td>\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"email\" id=\"email_1\" /></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>Age</td>\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"age\" id=\"age\"/></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>MaritalStatus</td>\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"maritalstatus\" id=\"maritalstatus\" /></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>ProjectName</td>\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"projectname\" id=\"projectname\" /></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>Salary</td>\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"salary\" id=\"salary\" /></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>Experience</td>\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"experience\" id=\"experience\" /></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td>ContactNumber</td>\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"contactnumber\" id=\"contactnumber\" /></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t<td></table>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <!-- Modal footer -->\n");
      out.write("        <div class=\"modal-footer\">\n");
      out.write("          <button type=\"button\" class=\"btn btn-info\"  data-toggle=\"modal\" data-target=\"#myModal_1\" data-dismiss=\"modal\" id=\"update\" disabled>Update</button>\n");
      out.write("             \n");
      out.write("             <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Cancel</button>\n");
      out.write("              </div>\n");
      out.write("        \n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  \n");
      out.write("</div>\n");
      out.write("<div class=\"modal fade\" id=\"myModal_1\">\n");
      out.write("  <div class=\"modal-dialog modal-dialog-centered modal-sm\">\n");
      out.write("    <div class=\"modal-content\">\n");
      out.write("    <!-- Modal body -->\n");
      out.write("      <div class=\"modal-body\">\n");
      out.write("      <center>\n");
      out.write("       Updated Successfully!</center>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("      <!-- Modal footer -->\n");
      out.write("      <div class=\"modal-footer\">\n");
      out.write("       <a href=\"/getuserdetails\">\n");
      out.write("        <button type=\"button\" class=\"btn btn-success\" >Ok</button></a>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("     \n");
      out.write("      </body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}