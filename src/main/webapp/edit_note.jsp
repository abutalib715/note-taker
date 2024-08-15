<%@ page import="org.hibernate.Session" %>
<%@ page import="helper.FactoryProvider" %>
<%@ page import="entities.Note" %>
<%@include file="layout/header.jsp" %>

<%-- EDIT NOTE FORM--%>

<%
    int noteId = Integer.parseInt(request.getParameter("id"));

    Session s = FactoryProvider.getFactory().openSession();
    Note note = (Note) s.get(Note.class, noteId);

%>

<div class="row mt-4">
    <div class="col-md-8 offset-2">

        <h2>EDIT YOUR NOTE</h2>

        <form action="update-note" method="post">
            <input type="hidden" name="id" value="<%= note.getId() %>">
            <div class="form-group">
                <label for="title">Title</label>
                <input type="text" class="form-control" id="title" aria-describedby="emailHelp"
                       name="title" value="<%= note.getTitle() %>" placeholder="Note Title">
            </div>
            <div class="form-group">
                <label for="content">Content</label>
                <textarea class="form-control" name="content" placeholder="Content" id="content" rows="5">
                    <%= note.getContent() %>
                </textarea>
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-success">Update</button>
            </div>
        </form>
    </div>
</div>

<%@include file="layout/footer.jsp" %>
