package layout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ruben.lp2.Prestamo;
import com.example.ruben.lp2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Prestamo} and makes a call to the
 * specified {@link ListPrestamoFragment.OnListReservaFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyReservaRecyclerViewAdapter extends RecyclerView.Adapter<MyReservaRecyclerViewAdapter.ViewHolder> {

    private List<Prestamo> mValues;
    private final List<Prestamo> todos;
    private final ListPrestamoFragment.OnListReservaFragmentInteractionListener mListener;

    public MyReservaRecyclerViewAdapter(List<Prestamo> items, ListPrestamoFragment.OnListReservaFragmentInteractionListener listener) {
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
        holder.nombreView.setText("ID: "+ mValues.get(position).getIdPrestamo());
        holder.descripcionView.setText("Fecha: "+ mValues.get(position).getFecha());
        holder.disponibilidadView.setText("Dias de prestamo: "+ mValues.get(position).getDetalle().getCantDias());
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
        public Prestamo mItem;

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


    public void setFilter(List<Prestamo> usuarios) {

                mValues.clear();
                mValues.addAll(usuarios);

            notifyDataSetChanged();
    }



}
