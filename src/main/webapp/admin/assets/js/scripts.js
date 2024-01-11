$(document).ready(function(){

	listBooks();
	listNavigations();
	listCategories();
	listUsers();
	view = getQueryStringVariable('view');
	
	if (view == 'bookedit'){
		bookID = getQueryStringVariable('edit');
		getBook(bookID);
	}
	if (view == 'navedit'){
		navigationID = getQueryStringVariable('edit');
		getNavigation(navigationID);
	}
	if (view == 'catedit'){
		categoryID = getQueryStringVariable('edit');
		getCategory(categoryID);
	}
	if (view == 'useredit'){
		userID = getQueryStringVariable('edit');
		getUser(userID);
	}
});
var getQueryStringVariable = function ( field, url ) {
		var href = url ? url : window.location.href;
		var reg = new RegExp( '[?&]' + field + '=([^&#]*)', 'i' );
		var string = reg.exec(href);
		return string ? string[1] : null;
	};

//Client side API call using AJAX
