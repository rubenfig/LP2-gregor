package layout;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ruben.lp2.MainActivity;
import com.example.ruben.lp2.Prestamo;
import com.example.ruben.lp2.PrestamosDao;
import com.example.ruben.lp2.R;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListReservaFragmentInteractionListener}
 * interface.
 */
public class ListPrestamoFragment extends Fragment{
    MyReservaRecyclerViewAdapter adapter;
    SearchView searchView;
    ArrayList<Prestamo> prestamos;
    PrestamosDao dao;
    RecyclerView recyclerView;
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListReservaFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListPrestamoFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ListPrestamoFragment newInstance(int columnCount) {
        ListPrestamoFragment fragment = new ListPrestamoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.busqueda, menu);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(getActivity().SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setIconifiedByDefault(false);
        adapter = (MyReservaRecyclerViewAdapter) recyclerView.getAdapter();
        SearchView.OnQueryTextListener textChangeListener = new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (adapter!=null && query !=null) {
                    if(query.equals(""))
                        adapter.setFilter(dao.findAll());
                    else
                        adapter.setFilter(dao.getByFilter(query));
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                if (adapter!=null && query !=null) {
                    if(query.equals(""))
                        adapter.setFilter(dao.findAll());
                    else

                        adapter.setFilter(dao.getByFilter(query));
               }
                return false;
            }
        };
        searchView.setOnQueryTextListener(textChangeListener);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reserva_list, container, false);

        this.dao = ((MainActivity) getActivity()).getPrestamosDao();
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            prestamos = dao.findAll();
            recyclerView.setAdapter(new MyReservaRecyclerViewAdapter(prestamos, mListener));

        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListReservaFragmentInteractionListener) {
            mListener = (OnListReservaFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListReservaFragmentInteractionListener {
        // TODO: Update argument type and name

        void onListReservaFragmentInteraction(Prestamo mItem);
    }


}
