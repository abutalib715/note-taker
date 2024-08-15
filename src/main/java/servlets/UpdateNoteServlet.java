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

public class UpdateNoteServlet extends HttpServlet {
    public UpdateNoteServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int noteId = Integer.parseInt(req.getParameter("id"));
            String title = req.getParameter("title");
            String content = req.getParameter("content");

            Session session = FactoryProvider.getFactory().openSession();
            Note note = (Note) session.get(Note.class, noteId);

            note.setTitle(title);
            note.setContent(content);

            Transaction trx = session.beginTransaction();

            trx.commit();
            session.close();

            resp.sendRedirect("all_notes.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
