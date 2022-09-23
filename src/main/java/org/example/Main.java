package org.example;

import org.example.Controllers.ControllerCatalog;
import org.example.Models.Catalog;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ControllerCatalog cc = new ControllerCatalog();
        /*System.out.println(cc.getCatalogById(1).toString());
        cc.addCatalog(new Catalog(0,"bookName", "authorName", 2000, "style", 0, "description"));
        cc.addCatalog("Идиот", "Достоевский", 1873, "роман", 500, "");
        cc.removeCatalogById(2);
        cc.updateCatalogById(5, "Бесы", "Достоевский", 1872, "роман", 500, "");
        System.out.println(cc.getCatalogById(5).toString());*/
        String bookName =  "Идиот";
        List <Catalog> resultsBookName = cc.getCatalogByBookName(bookName);
        if (resultsBookName.size() > 0 || resultsBookName !=null) {
            for (Catalog c : resultsBookName) {
                System.out.println(c.toString());
            }
        }
        else {System.out.println("Книги с названием " + bookName + " не найдены");}

        String word =  "esc";
        List <Catalog> resultsSearchWord = cc.getCatalogBySearchWord(word);
        if (resultsSearchWord.size() > 0 || resultsSearchWord !=null) {
            for (Catalog c : resultsSearchWord) {
                System.out.println(c.toString());
            }
        }
        else {System.out.println("Книги, содержащие в описании слово " + word + " не найдены");}



    }
}
