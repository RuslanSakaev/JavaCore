package com.mynotesapp.logic;

import com.mynotesapp.utils.DateUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class NoteWriter {
    public static void writeNoteToFile(Note note) {
        String formattedDate = DateUtils.getFormattedDate();
        String noteText = formattedDate + " -> " + note.getText() + "\n";
        try (PrintWriter printWriter = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream("notes.txt", true), StandardCharsets.UTF_8))) {
            printWriter.print(noteText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



