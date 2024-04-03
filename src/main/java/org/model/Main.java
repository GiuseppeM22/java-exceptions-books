package org.model;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //Controllo che non venga inserito un valore sbagliato
        int booksNumber = 0;
        try {
            System.out.println("Quanti libri vuoi inserire?");
            booksNumber = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input non valido. Riprovare");
        }

        //inizializzo l'array dei books
        Book[] books = new Book[booksNumber];

        //ciclo sulla lunghezza di books
        for (int i = 0; i < books.length; i++) {
            String titolo = null;
            int numeroPagine = 0;
            String autore = null;
            String editore = null;

            try {
                while (titolo == null || titolo.isEmpty()) {
                    System.out.println("Inserisci il Titolo: ");
                    titolo = scan.nextLine();
                }

                while (numeroPagine <= 0) {
                    try {
                        System.out.println("Inserisci il numero di pagine: ");
                        numeroPagine = Integer.parseInt(scan.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Il campo numero pagine deve essere un numero");
                    }
                }

                while (autore == null || autore.isEmpty()) {
                    System.out.println("Inserisci l'autore: ");
                    autore = scan.nextLine();
                }

                while (editore == null || editore.isEmpty()) {
                    System.out.println("Inserisci l'editore: ");
                    editore = scan.nextLine();
                }

                Book newBook = new Book(titolo, numeroPagine, autore, editore);
                books[i] = newBook;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        //importiamo i libri in un file esterno
        File root = new File("./src/main/resources/data.txt");
        System.out.println(root.exists());

        //scrivo i libri sul file
        boolean exit = false;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(root);
            for (int i = 0; i < books.length; i++) {
                Book book = books[i];
                fileWriter.write("Book " + (i+1) + "\n");
                fileWriter.write("Title: " + book.getTitle() + "\n");
                fileWriter.write("Number of Pages: " + book.getNumberOfPages() + "\n");
                fileWriter.write("Author: " + book.getAuthor() + "\n");
                fileWriter.write("Publisher: " + book.getPublisher() + "\n\n");
            }
        } catch (IOException e) {
            System.out.println("Unable to open file");
            exit = true;
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Unable to close file");
                }
            }
        }

        // leggo il contenuto del file
        if (!exit) {
            try (Scanner fileReader = new Scanner(root)) {
                System.out.println("Libri inseriti: " + "\n");
                while (fileReader.hasNextLine()) {
                    String line = fileReader.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }
    }
}
