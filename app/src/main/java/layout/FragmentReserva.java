package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ruben.lp2.Alumno;
import com.example.ruben.lp2.DetallePrestamo;
import com.example.ruben.lp2.Libro;
import com.example.ruben.lp2.MainActivity;
import com.example.ruben.lp2.Prestamo;
import com.example.ruben.lp2.PrestamosDao;
import com.example.ruben.lp2.R;

import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentReserva.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentReserva#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentReserva extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Alumno a;
    Libro l;

    private OnFragmentInteractionListener mListener;

    public FragmentReserva() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentPerfil.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentReserva newInstance(Integer isbn, String param1, Integer param2) {
        FragmentReserva fragment = new FragmentReserva();
        Bundle args = new Bundle();
        args.putInt("id", isbn);
        args.putString("descripcion", param1);
        args.putInt("disponibilidad", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.a = new Alumno(123,"Juan Alberto","Perez Gonzalez", "0971123123");
            this.l = new Libro(getArguments().getInt("id"), getArguments().getString("descripcion"),
                    getArguments().getInt("disponibilidad"));
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_reserva_crear, container, false);

        TextView nombreText = (TextView) view.findViewById(R.id.nombre);
        nombreText.setText("Descripcion: " + l.getDescripcion());
        TextView apellidoText = (TextView) view.findViewById(R.id.apellido);
        apellidoText.setText("Disponibilidad: " + Integer.toString(l.getDisponibilidad()));
        TextView idAlumnoText = (TextView) view.findViewById(R.id.idAlumno);
        idAlumnoText.setText("ID: " + Integer.toString(l.getIsbnLibro()));
        Button boton = (Button) view.findViewById(R.id.reservar);
        MainActivity main = (MainActivity) getActivity();
//Below is where you get a variable from the main activity
        final PrestamosDao prestamos = main.getPrestamosDao();
//also
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = view.getRootView();
                String cantidad = ((EditText)v.findViewById(R.id.cantidad)).getText().toString();
                if(Integer.parseInt(cantidad)>l.getDisponibilidad()){
                    ((EditText)v.findViewById(R.id.cantidad)).setError("La reserva supera la disponibilidad");
                }else {
                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.DATE, Integer.parseInt(cantidad));
                    DetallePrestamo d = new DetallePrestamo(1, l, cal.getTime(), Integer.parseInt(cantidad));
                    Prestamo p = new Prestamo(1, a, new Date(), d);
                    prestamos.agregar(p);
                    closeFragment();
                }

            }
        });
        return view;

    }
    public void closeFragment(){
        getActivity().onBackPressed();
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
