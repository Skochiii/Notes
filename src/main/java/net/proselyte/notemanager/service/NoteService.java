package net.proselyte.notemanager.service;

import net.proselyte.notemanager.model.Note;

import java.util.List;

public interface NoteService {
    public void addNote(Note note);

    public void updateNote(Note note);

    public void removeNote(int id);

    public Note getNoteById(int id);

    public List<Note> listNotes();
}
