package edu.uoc.android.pec1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import edu.uoc.android.pec1.Modelo.BookModel;

/**
 * Fragment para el listado
 */
public class BookListFragment extends Fragment
        implements BookAdapter.OnItemClickListener {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    private BookListActivity mParentActivity;
    private FragmentListener listener; //interface

    public BookListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book_list, container, false);

        View recyclerView = view.findViewById(R.id.recycler);
        assert recyclerView != null;
        setupRecView((RecyclerView) recyclerView);

        return view;
    }

    private void setupRecView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new BookAdapter(BookModel.ITEMS, this));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof FragmentListener) {
            listener = (FragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " debes implementar FragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        listener = null;
    }

    @Override
    public void onClick(BookAdapter.ViewHolder viewHolder, Integer idItem) {
        loadDetail(idItem);
    }

    public void loadDetail(Integer idItem) {
        if (listener != null) {
            listener.alSeleccionarItem(idItem);
        }
    }

    public interface FragmentListener {
        void alSeleccionarItem(Integer idItem);
    }
}