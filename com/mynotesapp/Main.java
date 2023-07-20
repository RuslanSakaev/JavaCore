package com.mynotesapp;

import com.mynotesapp.logic.Note;
import com.mynotesapp.logic.NoteWriter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите заметку: ");
        String noteText = scanner.nextLine();

        Note note = new Note(noteText);
        NoteWriter.writeNoteToFile(note);

        System.out.println("Дозапись в файл: " + note);
    }
}

