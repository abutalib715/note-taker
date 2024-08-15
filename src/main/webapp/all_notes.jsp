<%@ page import="org.hibernate.Session" %>
<%@ page import="helper.FactoryProvider" %>
<%@ page import="org.hibernate.query.Query" %>
<%@ page import="entities.Note" %>
<%@ page import="java.util.List" %>
<%@include file="layout/header.jsp" %>


<h1 class="mt-4">ALL NOTES:</h1>

<div class="row">

    <%
        Session s = FactoryProvider.getFactory().openSession();
        Query q = s.createQuery("from Note ");

        List<Note> notes = q.list();
        for (Note note : notes) {
    %>

    <div class="col-4">
        <div class="card" style="width: 18rem;">
            <img src="img/notepad.png" style="max-width: 80px" class="card-img-top pl-4 pt-4" alt="notepad">
            <div class="card-body">
                <h5 class="card-title"><%= note.getTitle() %>
                </h5>
                <p class="card-text"><%= note.getContent() %>
                </p>
                <a href="#" class="btn btn-danger">Delete</a>
            </div>
        </div>
    </div>


    <%
        }

        s.close();
    %>
</div>

<%@include file="layout/footer.jsp" %>
