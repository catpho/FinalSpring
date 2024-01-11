function listBooks(){
	
	$.ajax({
		url: "../../FinalSpring/books",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	$.each(response, function(key, value) {
    		
    	
    		var lstResults = "<tr><td><a href ='./index.jsp?view=bookedit&edit="+value.bookID+"' data-toggle='tooltip' title='View & Edit'><span class='fa fa-pencil-alt fa-fw' aria-hidden='true'></span><span class='sr-only'>View and Edit</span></a></td>" +
    		"</td><td>"+value.bookISBN+"</td><td>"+value.bookTitle+"</td><td>"+value.bookAuthor+"</td><td>"+value.bookDescription+"</td><td>"+value.categoryID+"</td><td>"+value.bookImage+"</td></tr>";
       		
    		document.getElementById('postBody').innerHTML += lstResults;
    	});
	});
}
function addBook(){
	
	var bookISBN = $("#bookISBN").val();
	var bookTitle = $("#bookTitle").val();
	var bookAuthor = $("#bookAuthor").val();
	var bookDescription = $("#bookDescription").val();
	var bookVisible = $("#bookVisible").val();
	var categoryID = $("#categoryID").val();
	var bookImage = $("#bookImage").val();
	
	var parms = {bookISBN:bookISBN, bookTitle: bookTitle,bookAuthor:bookAuthor,bookDescription:bookDescription,bookVisible:bookVisible,categoryID:categoryID,bookImage:bookImage};
	$.ajax({
		url: "../../FinalSpring/books",
		type: 'POST',
		dataType : "json",
        contentType: "application/json",
        data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	alert(response.message);
    	});

}
function updateBook(){
	
	
	var bookTitle = $("#bookTitle").val();
	var bookAuthor = $("#bookAuthor").val();
	var bookDescription = $("#bookDescription").val();
	var bookVisible = $("#bookVisible").val();
	var categoryID = $("#categoryID").val();
	var bookImage = $("#bookImage").val();
	
	var parms = {bookID:bookID, bookTitle: bookTitle,bookAuthor:bookAuthor,bookDescription:bookDescription,bookVisible:bookVisible,categoryID:categoryID,bookImage:bookImage};
	$.ajax({
		url: "../../FinalSpring/books",
		type: 'PUT',
		dataType : "json",
        contentType: "application/json",
        data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	window.location="./index.jsp?view=booklist"
    	});

}
function getBook(bookID){
		
		$.ajax({
			url: "../../FinalSpring/books/"+bookID,
			type: 'GET',
			dataType : "json",
	        contentType: "application/json",
		}).fail(function(response) {
			console.log(JSON.stringify(response));
	
	    }).done(function(response){
	    	
	    	$("#bookISBN").val(response.bookISBN);
	    	$("#bookTitle").val(response.bookTitle);
	    	$("#bookAuthor").val(response.bookAuthor);
	    	$("#bookDescription").val(response.bookDescription);
	    	$("#bookVisible").val(response.bookVisible);
	    	$("#categoryID").val(response.categoryID);
	    	$("#bookImage").val(response.bookImage);

		});
		}
