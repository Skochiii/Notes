package net.proselyte.notemanager.dao;

import net.proselyte.notemanager.model.Note;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoteDaoImpl implements NoteDao {
    private static final Logger logger = LoggerFactory.getLogger(NoteDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addNote(Note note) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(note);
        logger.info("Note successfully saved. Note details: " + note);
    }

    @Override
    public void updateNote(Note note) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(note);
        logger.info("Note successfully update. Note details: " + note);
    }

    @Override
    public void removeNote(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Note note = (Note) session.load(Note.class, new Integer(id));

        if(note !=null){
            session.delete(note);
        }
        logger.info("Note successfully removed. Note details: " + note);
    }

    @Override
    public Note getNoteById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Note note = (Note) session.load(Note.class, new Integer(id));
        logger.info("Note successfully loaded. Note details: " + note);

        return note;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Note> listNotes() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Note> NoteList = session.createQuery("from Note").list();

        for(Note note : NoteList){
            logger.info("Note list: " + note);
        }

        return NoteList;
    }
}
