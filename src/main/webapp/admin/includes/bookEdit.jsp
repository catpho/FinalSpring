<h1 class="page-header">Edit Book</h1>

<div class="form-group col-xs-12 col-md-6">
    <label for="bookISBN">ISBN</label>
    <input type="text" class="form-control" id="bookISBN" readonly>
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
<div class="form-group col-xs-12">
    <span>
        <button class="btn btn-primary" type="submit" onclick=updateBook(); data-toggle="tooltip" title="Save Changes">Save Changes</button>
    </span>
    <span>
        <button class = "btn btn-link" type="button" onclick="window.history.back()" data-toggle="tooltip" title="Cancel">Cancel</button>
    </span>
</div>