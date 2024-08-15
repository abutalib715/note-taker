<%@include file="layout/header.jsp" %>

<%-- ADD NOTE FORM--%>

<div class="row mt-4">
    <div class="col-md-8 offset-2">
        <h2>ADD NEW NOTE</h2>

        <form action="save-note" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" class="form-control" id="title" aria-describedby="emailHelp"
                       name="title" placeholder="Note Title">
            </div>
            <div class="form-group">
                <label for="content">Content</label>
                <textarea class="form-control" name="content" placeholder="Content" id="content" rows="5"></textarea>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-success">Add</button>
            </div>
        </form>
    </div>
</div>

<%@include file="layout/footer.jsp" %>
