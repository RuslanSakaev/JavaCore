package com.mynotesapp;

import com.mynotesapp.logic.Note;
import com.mynotesapp.logic.NoteWriter;

import java.io.PrintStream;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите заметку: ");
        String noteText = scanner.nextLine();

        Note note = new Note(noteText);
        NoteWriter.writeNoteToFile(note);

        System.out.println("Дозапись в файл: " + note);
    }
}

