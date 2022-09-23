package org.example.Models;
import jakarta.persistence.*;

@Entity
@Table(name = "Catalog")
public class Catalog {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "year_issue")
    private int yearIssue;

    @Column(name = "style")
    private String style;

    @Column(name = "pages")
    private int pages;

    @Column(name = "description")
    private String description;

    public Catalog(int id, String bookName, String authorName, int yearIssue, String style, int pages, String description){
        this.id = id; this.bookName=bookName; this.authorName=authorName;
        this.yearIssue=yearIssue; this.style=style; this.pages=pages; this.description=description;
    }

    public Catalog(String bookName, String authorName, int yearIssue, String style, int pages, String description){
        this.bookName=bookName; this.authorName=authorName; this.yearIssue=yearIssue;
        this.style=style; this.pages=pages; this.description=description;
    }

    public Catalog(){
        bookName="noName";
        authorName="noName";
        pages=0;
    }

    public String toString (){
        return "bookName: " + bookName + " authorName: " + authorName + " yearIssue: " + yearIssue +
                " style: " + style + " pages: " + pages+ " description: " + description + "\n";
    }

    public void setBookName(String name) {this.bookName=name;}
    public void setAuthorName(String name) {this.authorName=name;}
    public void setYearIssue(int num) {this.yearIssue=num;}
    public void setStyle(String name) {this.style=name;}
    public void setPages(int num) {this.pages=num;}
    public void setDescription(String name) {this.description=name;}


}


/*
 `id` INT NOT NULL AUTO_INCREMENT,
  `book_name` VARCHAR(45) NOT NULL,
  `author_name` VARCHAR(45) NOT NULL,
  `year_issue` INT NULL,
  `style` VARCHAR(45) NULL,
  `pages` INT NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
 */