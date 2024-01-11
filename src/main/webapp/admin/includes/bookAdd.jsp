<h1 class="page-header">Add Book</h1>

<div class="form-group col-xs-12 col-md-6">
    <label for="bookISBN">ISBN</label>
    <input type="text" class="form-control" id="bookISBN" required>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="bookTitle">Title</label>
    <input type="text" class="form-control" id="bookTitle" autofocus required>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="bookAuthor">Author</label>
    <input type="text" class="form-control" id="bookAuthor" autofocus required >
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="bookDescription">Description</label>
    <input type="text" class="form-control" id="bookDescription" autofocus required >
</div>
<div class="form-group col-xs-12 col-md-6">
	 <label for="bookVisible">Visible</label>
	 <select class="form-control" id="bookVisible" name="bookVisible">
	 	<option value= "1" selected >Yes</option>
	 	<option value= "0" >No</option>
	 </select>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="categoryID">Category</label>
    <input type="text" class="form-control" id="categoryID" required>
</div>
<div class="form-group col-xs-12 col-md-6">
    <label for="bookImage">Image</label>
    <input type="text" class="form-control" id="bookImage" required >
</div>
 <div class="form-group">
 <span>
     <button class="btn btn-primary"  type="submit" onclick="addBook()" id="bookAdd" data-toggle="tooltip" title="Add Book">Add Book</button>
 </span>

 <span>
     <input class = "btn btn-link" type="button" onclick="window.history.back()" value="Cancel" data-toggle="tooltip" title="Cancel">
   </span>
</div>