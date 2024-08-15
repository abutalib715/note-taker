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

public class DeleteNoteServlet extends HttpServlet {
    public DeleteNoteServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int noteId = Integer.parseInt(req.getParameter("id"));

            Session session = FactoryProvider.getFactory().openSession();
            Note note = (Note) session.get(Note.class, noteId);

            Transaction trx = session.beginTransaction();
            session.delete(note);
            trx.commit();

            session.close();

            resp.sendRedirect("all_notes.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
