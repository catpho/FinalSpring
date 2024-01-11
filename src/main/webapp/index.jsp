<%@include file = ".\includes\clientHeader.jsp" %>

  <!-- Page Content -->
        <section class="py-5">

<%
	if(view == null){
		view = "";
	}

	if(view.equals("booklist")){%>
		<%@include file=".\includes\bookList.jsp"%>
	<%}else if(view.equals("book")){ %>
		<%@include file=".\includes\book.jsp"%>
	<%}else if(view.equals("categorylist")){ %>
		<%@include file=".\includes\categoryList.jsp"%>
	<%}else{%>
	<%@include file=".\includes\bookList.jsp" %>
		<%}%>


        </section>

 <%@include file = ".\includes\clientFooter.jsp" %>