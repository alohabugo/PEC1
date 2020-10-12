package edu.uoc.android.pec1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.uoc.android.pec1.Modelo.BookModel;

import static android.widget.Toast.LENGTH_SHORT;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private final List<BookModel.BookItem> mValues;
    private OnItemClickListener mlistener;

    public BookAdapter(List<BookModel.BookItem> items, OnItemClickListener listener) {
        mValues = items;
        this.mlistener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (viewType == 0)
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_item, parent, false);
        else
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_item_impar, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTituloView.setText(mValues.get(position).Titulo);
        holder.mAutorView.setText(mValues.get(position).Autor);
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
        //0 par y 1 impar
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    private Integer obtenerIdItem(int posicion) {
        if (posicion != RecyclerView.NO_POSITION) {
            return mValues.get(posicion).Id;
        } else {
            return null;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public final View mView;
        public final TextView mTituloView;
        public final TextView mAutorView;

        public BookModel.BookItem mItem;

        public ViewHolder(View view) {
            super(view);
            view.setClickable(true);
            mView = view;
            mTituloView = (TextView) view.findViewById(R.id.titulo);
            mAutorView = (TextView) view.findViewById(R.id.autor);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mlistener.onClick(this, obtenerIdItem(getAdapterPosition()));
        }
    }

    public interface OnItemClickListener {
        public void onClick(ViewHolder viewHolder, Integer idItem);
    }

}
