package com.mynotesapp.logic;

import com.mynotesapp.utils.DateUtils;

import java.io.FileWriter;
import java.io.IOException;

public class NoteWriter {
    public static void writeNoteToFile(Note note) {
        String formattedDate = DateUtils.getFormattedDate();
        String noteText = formattedDate + " -> " + note.getText() + "\n";
        try (FileWriter fileWriter = new FileWriter("notes.txt", true)) {
            fileWriter.write(noteText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
