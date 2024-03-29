function listCategories(){
	
	$.ajax({
		url: "../../FinalSpring/categories",
		type: 'GET',
		dataType : "json",
        contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	$.each(response, function(key, value) {
			
			
			
    		var lstResults = "<tr><td><a href ='./index.jsp?view=catedit&edit="+value.categoryID+"' data-toggle='tooltip' title='View & Edit'><span class='fa fa-pencil-alt fa-fw' aria-hidden='true'></span><span class='sr-only'>View and Edit</span></a>" +
    			"<a href = '#' onclick=deleteCatModal('"+value.categoryID+"','"+encodeURIComponent(value.categoryName)+"') data-toggle='tooltip' title='Delete'><span class='fa fa-trash-alt' aria-hidden='true'></span><span class='sr-only'>Delete</span></a></td>" +
	            "<td>"+value.categoryID+"</td><td>"+value.navigationID+"</td><td>"+value.categoryName+"</td><td>"+value.categoryImage+"</td><td>"+value.categoryDescription+"</td><td>"+value.categoryOrder+"</td>"+
	    		"<td>"+value.categoryVisible+"</td></tr>";
       		
    		if($("#categoryBody").text()){
    				document.getElementById('categoryBody').innerHTML += lstResults;
    		}
    	});
	});
}
function addCategory(){
	
	var navigationID = $("#navigationID").val();
	var categoryName = $("#categoryName").val();
	var categoryImage = $("#categoryImage").val();
	var categoryDescription = $("#categoryDescription").val();
	var categoryOrder = $("#categoryOrder").val();
	var categoryVisible = $("#categoryVisible").val();
	
	
	var parms = { navigationID: navigationID, categoryName: categoryName,categoryImage:categoryImage, categoryDescription:categoryDescription,categoryOrder:categoryOrder,categoryVisible:categoryVisible};
	$.ajax({
		url: "../../FinalSpring/categories",
		type: 'POST',
		dataType : "json",
        contentType: "application/json",
        data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	window.location.reload(true);
    	});

}

function getCategory(categoryID){
		
		$.ajax({
			url: "../../FinalSpring/categories/"+categoryID,
			type: 'GET',
			dataType : "json",
	        contentType: "application/json",
		}).fail(function(response) {
			console.log(JSON.stringify(response));
	
	    }).done(function(response){
	    	
	    	$("#navigationID").val(response.navigationID);
	    	$("#categoryName").val(response.categoryName);
			$("#categoryImage").val(response.categoryImage);
			$("#categoryDescription").val(response.categoryDescription);
	    	$("#categoryOrder").val(response.categoryOrder);
	    	$("#categoryVisible").val(response.categoryVisible);
	    	

		});
}
function updateCategory(){
	
	var navigationID = $("#navigationID").val();
	var categoryName = $("#categoryName").val();
	var categoryImage = $("#categoryImage").val();
	var categoryDescription = $("#categoryDescription").val();
	var categoryOrder = $("#categoryOrder").val();
	var categoryVisible = $("#categoryVisible").val();
	
	
	var parms = { categoryID: categoryID, navigationID: navigationID, categoryName: categoryName,categoryImage:categoryImage, categoryDescription:categoryDescription,categoryOrder:categoryOrder,categoryVisible:categoryVisible};
	$.ajax({
		url: "../../FinalSpring/categories",
		type: 'PUT',
		dataType : "json",
        contentType: "application/json",
        data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	window.location="./index.jsp?view=categorylist"
    	});

}
function deleteCatModal(catID,catName){
	
	$("#deleteCatModal").modal('show');
	
	$("#catID").text(catID);
	$("#catName").text(decodeURIComponent(catName));
	
}
function deleteCategory(){
	
	var categoryID = $("#catID").text();
	
	
	
	var parms = { categoryID: categoryID};
	$.ajax({
		url: "../../FinalSpring/categories",
		type: 'DELETE',
		dataType : "json",
        contentType: "application/json",
        data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));

    }).done(function(response){

    	window.location="./index.jsp?view=categorylist"
    	});

}