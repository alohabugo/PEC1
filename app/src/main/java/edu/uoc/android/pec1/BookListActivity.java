package edu.uoc.android.pec1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import edu.uoc.android.pec1.Modelo.BookModel;

public class BookListActivity extends AppCompatActivity
        implements BookListFragment.FragmentListener {

    // Dos paneles
    public boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        // Verificación: ¿Existe el detalle en el layout?
        if (findViewById(R.id.detail_container) != null) {
            // Si es asi, entonces confirmar modo Master-Detail
            mTwoPane = true;
            //se carga el fragmento detalle
            loadDetailFragment(BookModel.ITEMS.get(0).Id);
        }

        // Agregar fragmento de lista
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.list_container, new BookListFragment())
                .commit();
    }

    private void loadDetailFragment(Integer id) {
        Bundle arguments = new Bundle();
        arguments.putInt(BookDetailFragment.ARG_ITEM_ID, id);
        BookDetailFragment fragment = new BookDetailFragment();
        fragment.setArguments(arguments);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.detail_container, fragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void alSeleccionarItem(Integer idBook) {
        Toast.makeText(this, "Seleccionado Item " + idBook, Toast.LENGTH_SHORT).show();
        if (mTwoPane) {
            loadDetailFragment(idBook);
        } else {
            Intent intent = new Intent(this, BookDetailActivity.class);
            intent.putExtra(BookDetailFragment.ARG_ITEM_ID, idBook);

            startActivity(intent);
        }

    }
}