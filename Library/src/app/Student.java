package app;

public class Student {
    String name, book, author;
    Student(String n, String b, String a) {
        this.name = n;
        this.book = b;
        this.author = a;
    }
    public String toString() {
        return("Name: "+name+"\tBook: "+book+"\tAuthor: "+author);
    }
}