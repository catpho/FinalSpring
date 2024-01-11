<%@include file=".\includes\header.jsp" %>

<%@include file=".\includes\navigation.jsp" %>

<div class="container-fluid">
	<% if(view == null){
		view = "";
		}
			if(view.equals("booklist")){ %>
			<%@include file=".\includes\bookList.jsp" %>	
			<%}else if(view.equals("bookadd")){ %>
			<%@include file=".\includes\bookAdd.jsp" %>	
			<%}else if(view.equals("bookedit")){ %>
			<%@include file=".\includes\bookEdit.jsp" %>
			<%}else if(view.equals("navigationlist")){ %>
			<%@include file=".\includes\navigationList.jsp" %>
			<%}else if(view.equals("navedit")){ %>
			<%@include file=".\includes\navigationEdit.jsp" %>
			<%}else if(view.equals("categorylist")){ %>
			<%@include file=".\includes\categoryList.jsp" %>	
			<%}else if(view.equals("catedit")){ %>
			<%@include file=".\includes\categoryEdit.jsp" %>
			<%}else if(view.equals("userlist")){ %>
			<%@include file=".\includes\userList.jsp" %>	
			<%}else if(view.equals("useredit")){ %>
			<%@include file=".\includes\userEdit.jsp" %>
			<%}else if(view.equals("useradd")){ %>
			<%@include file=".\includes\userAdd.jsp" %>
			<%}else{ %>
			<%@include file=".\includes\dashboard.jsp" %>
			<% }%>
   </div>
      
<%@include file=".\includes\footer.jsp" %>