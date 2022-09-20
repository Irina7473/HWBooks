package org.example;

import org.example.Controllers.ControllerCatalog;

public class Main {
    public static void main(String[] args) {
        ControllerCatalog cc = new ControllerCatalog();
        System.out.println(cc.getCatalogById(1).toString());
        cc.addCatalog("bookName", "authorName", 2000, "style", 0, "description");
        cc.addCatalog("bookName", "authorName", 2000, "style", 0, "description");
        cc.addCatalog("bookName", "authorName", 2000, "style", 0, "description");
        cc.addCatalog("bookName", "authorName", 2000, "style", 0, "description");
        cc.updateCatalogById(2, "Бесы", "Достоевский", 0, "", 0, "");
        System.out.println(cc.getCatalogByBookName("Бесы").toString());
        cc.removeCatalogById(3);


    }
}

/*
Задание 2
Создайте веб-приложение для отображения данных из первого задания. Используйте Hibernate для доступа к данным.
Задание 3
Добавьте ко второму заданию возможность добавления данных.
Задание 4
Добавьте к третьему заданию возможность удаления данных.
Задание 5
Добавьте к четвертому заданию возможность редактирования данных.
Задание 6
Добавьте к пятому заданию возможность поиска книг по таким параметрам:
■ Название книги;
■ ФИО автора;
■ Год выпуска;
■ Стиль книги;
■ Количество страниц;
■ Слово для поиска в кратком описании книги
 */