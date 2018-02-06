package net.proselyte.notemanager.dao;

import net.proselyte.notemanager.model.Note;

import java.util.List;

public interface NoteDao {
    public void addNote(Note note);

    public void updateNote(Note note);

    public void removeNote(int id);

    public Note getNoteById(int id);

    public List<Note> listNotes();
}
