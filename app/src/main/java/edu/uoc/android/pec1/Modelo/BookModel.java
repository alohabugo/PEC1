package edu.uoc.android.pec1.Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookModel {

    public static final List<BookItem> ITEMS = new ArrayList<BookItem>();

    public static final Map<Integer, BookItem> MAPA_ITEMS = new HashMap<Integer, BookItem>();

    static {
        // Añadir elementos de ejemplo
        agregarItem(new BookItem(1, "Title1", "Author1", new Date(), "Description1",null));
        agregarItem(new BookItem(2, "Title2", "Author2", new Date(), "Description2", null));
        agregarItem(new BookItem(3, "Title3", "Author3", new Date(), "Description3",null));
        agregarItem(new BookItem(4, "Title4", "Author4", new Date(), "Description4", null));
    }



    private static void agregarItem(BookItem item) {
        ITEMS.add(item);
        MAPA_ITEMS.put(item.Id, item);
    }


    public static class BookItem {

        public Integer Id;

        public String Titulo;

        public String Autor;

        public Date FechaPublicacion;

        public String Descripcion;

        public String URLimagen;

        public BookItem(Integer id, String titulo, String autor,
                        Date fecha, String descripcion, String urlImg) {
            this.Id = id;
            this.Titulo = titulo;
            this.Autor = autor;
            this.FechaPublicacion = fecha;
            this.Descripcion = descripcion;
            this.URLimagen = urlImg;
        }

    }
}
