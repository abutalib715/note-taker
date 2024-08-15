package servlets;

import entities.Note;
import helper.FactoryProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class SaveNoteServlet extends HttpServlet {
    public SaveNoteServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            Note note = new Note(title, content, new Date());

            Session session = FactoryProvider.getFactory().openSession();
            Transaction trx = session.beginTransaction();

            session.save(note);
            trx.commit();

            session.close();

            // DEFINE RESPONSE
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<h1 style='text-align: center'>Note added successfully</h1>");
            out.println("<h1 style='text-align: center'><a href='all_notes.jsp'>View All Notes</a></h1>");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
