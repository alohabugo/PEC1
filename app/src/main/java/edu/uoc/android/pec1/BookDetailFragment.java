package edu.uoc.android.pec1;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import edu.uoc.android.pec1.Modelo.BookModel;


public class BookDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";

    private BookModel.BookItem mItem;

    public BookDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Cargar modelo según el identificador
            mItem = BookModel.MAPA_ITEMS.get(getArguments().getString(ARG_ITEM_ID));

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_book_detail, container, false);

        if (mItem != null) {
            // Toolbar en master-detail
            Toolbar toolbar = (Toolbar) v.findViewById(R.id.detail_toolbar);
            if (toolbar != null)
                toolbar.setTitle(mItem.Titulo);

            ((TextView) v.findViewById(R.id.autor)).setText(mItem.Autor);
            ((TextView) v.findViewById(R.id.fecha)).setText((CharSequence) mItem.FechaPublicacion);
            ((TextView) v.findViewById(R.id.descripcion)).setText(mItem.Descripcion);
            // imagen
        }

        return v;
    }
}