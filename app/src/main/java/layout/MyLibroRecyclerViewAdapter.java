package layout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ruben.lp2.Libro;
import com.example.ruben.lp2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Libro} and makes a call to the
 * specified {@link ListFragment.OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyLibroRecyclerViewAdapter extends RecyclerView.Adapter<MyLibroRecyclerViewAdapter.ViewHolder> {

    private List<Libro> mValues;
    private final List<Libro> todos;
    private final ListFragment.OnListFragmentInteractionListener mListener;

    public MyLibroRecyclerViewAdapter(List<Libro> items, ListFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        todos = new ArrayList<>(items);
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_libro, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.nombreView.setText("ID: "+ mValues.get(position).getIsbnLibro());
        holder.descripcionView.setText("Descripción: "+ mValues.get(position).getDescripcion());
        holder.disponibilidadView.setText("Disponibilidad: "+ mValues.get(position).getDisponibilidad());


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView nombreView;
        public final TextView descripcionView;
        public final TextView disponibilidadView;
        public Libro mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            nombreView = (TextView) view.findViewById(R.id.list_nombre);
            descripcionView = (TextView) view.findViewById(R.id.list_descripcion);
            disponibilidadView = (TextView) view.findViewById(R.id.list_disponibilidad);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + nombreView.getText() + "'";
        }
    }


    public void setFilter(List<Libro> usuarios) {

                mValues.clear();
                mValues.addAll(usuarios);

            notifyDataSetChanged();
    }



}
