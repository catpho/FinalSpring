$(document).ready(function(){
	listNavigations();
	
	view = getQueryStringVariable('view');
		
		if (view == 'book'){
			bookID = getQueryStringVariable('bookID');
			getBook(bookID);
		}else if (view == "booksbycat"){
			categoryID = getQueryStringVariable('categoryID');
			getCategory(categoryID);
			listBooksByCategory(categoryID);
		}else{		
			listBooks();
		}
});
var getQueryStringVariable = function ( field, url ) {
		var href = url ? url : window.location.href;
		var reg = new RegExp( '[?&]' + field + '=([^&#]*)', 'i' );
		var string = reg.exec(href);
		return string ? string[1] : null;
	};
function listBooks(){
	var heading = "<h1 class='my-4'>Come Read with Us!</h1>";
	
	$("#PageHeading").append(heading);
	$.ajax({
	url: "../FinalSpring/books",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {

    }).done(function(response) {
    	
    	$.each(response, function(key, value) {
			

    		var books = "<div class='col mb-5'>"+
                        "<div class='card h-100'>"+
                            "<img id='imageID_"+value.bookID+"' class= card-img-top' src='./uploads/"+value.bookImage+"' alt='...'/>"+                        
			"<div class='card-body p-4'>"+
                                "<div class='text-center'>"+
                                    "<h5 class='fw-bolder'>"+value.bookTitle+"</h5>"+
                                "</div>"+
                            "</div>"+
                            "<div class='card-footer p-4 pt-0 border-top-0 bg-transparent'>"+
                  " <div class='text-center'><a class='btn btn-outline-dark mt-auto' href='./index.jsp?view=book&bookID="+value.bookID+"'>Read More &rarr;</a></div>"+
                            "</div>"+
                        "</div>"+
                    "</div>";
    	
    		$("#bookBody").append(books);
    		
    	});
	});
}
function getBook(bookID){
		
		$.ajax({
			url: "../FinalSpring/books/"+bookID,
			type: 'GET',
			dataType : "json",
	        contentType: "application/json",
		}).fail(function(response) {
			console.log(JSON.stringify(response));
	
	    }).done(function(response){
	    	
	    	$("#bookISBN").text(response.bookISBN);
	    	$("#bookTitle").text(response.bookTitle);
	    	$("#bookAuthor").text(response.bookAuthor);
	    	$("#bookDescription").text(response.bookDescription);
	    	$("#bookVisible").text(response.bookVisible);
	    	$("#categoryID").text(response.categoryID);
	    	$("#bookImage").attr("src","./uploads/"+response.bookImage);

		});
	}
	function listNavigations(){

	$.ajax({
	url: "../FinalSpring/navigations/listvisible",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {

    }).done(function(response) {
    	
    	$.each(response, function(key, value) {

    			    if(value.hasOwnProperty('categories')){
	    			
	    			navigations = "<li class='nav-item dropdown'><a class='nav-link dropdown-toggle' href='"+value.navigationURL+"' role='button' data-toggle='dropdown'>"+value.navigationName+"</a>";
	    			navigations += "<div class='dropdown-menu'>";
	    			
	    			$.each(value.categories, function(k, v){
		    			navigations += "<a class='dropdown-item' href='index.jsp?view=booksbycat&categoryID="+v.categoryID+"'>"+v.categoryName+"</a>";
	    			});
	    	
	    			navigations += "</div></li>";
	    			
	    		}else{
	
	    			navigations = "<li class='nav-item'><a class='nav-link' href='"+value.navigationURL+"'>"+value.navigationName+"</a></li>";
	    		}
	    		$("#navigationUL").append(navigations);
    	});
	});
}
	function getCategory(categoryID){
		
		$.ajax({
			url: "../FinalSpring/categories/"+categoryID,
			type: 'GET',
			dataType : "json",
	        contentType: "application/json",
		}).fail(function(response) {
			console.log(JSON.stringify(response));
	
	    }).done(function(response){
	    	
	    	var heading = "<h1 class='my-4'>"+response.categoryName+"</h1><hr>"+
	    	"<div class='row'><div><img class='img-responsive img-thumbnail img-rounded artImage' src='./uploads/"+response.categoryImage+"'>"+
	    	response.categoryContent+"</div></div><hr>";
	    	
	    	$("#PageHeading").append(heading);
		});
}
	function listBooksByCategory(categoryID){

	$.ajax({
	url: "../FinalSpring/books/listByCategory/"+categoryID,
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {

    }).done(function(response) {
    	
    	$.each(response, function(key, value) {
			
    		var books = "<div class='col mb-5'>"+
                        "<div class='card h-100'>"+
                            "<img id='imageID_"+value.bookID+"' class= card-img-top' src='./uploads/"+value.bookImage+"' alt='...'/>"+                        
			"<div class='card-body p-4'>"+
                                "<div class='text-center'>"+
                                    "<h5 class='fw-bolder'>"+value.bookTitle+"</h5>"+
                                "</div>"+
                            "</div>"+
                            "<div class='card-footer p-4 pt-0 border-top-0 bg-transparent'>"+
                  " <div class='text-center'><a class='btn btn-outline-dark mt-auto' href='./index.jsp?view=book&bookID="+value.bookID+"'>Read More &rarr;</a></div>"+
                            "</div>"+
                        "</div>"+
                    "</div>";
    	
    		$("#bookBody").append(books);
    		
    	});
	});
}
