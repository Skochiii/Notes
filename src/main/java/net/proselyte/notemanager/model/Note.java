package net.proselyte.notemanager.model;

import javax.persistence.*;

@Entity
@Table(name = "Tnotes")
public class Note {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "caption")
    private String noteCaption;

    @Column(name = "note")
    private String noteNote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoteCaption() {
        return noteCaption;
    }

    public void setNoteCaption(String noteCaption) {
        this.noteCaption = noteCaption;
    }

    public String getNoteNote() {
        return noteNote;
    }

    public void setNoteNote(String noteNote) {
        this.noteNote = noteNote;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", noteCaption='" + noteCaption + '\'' +
                ", noteNote='" + noteNote + '\'' +
                '}';
    }
}
