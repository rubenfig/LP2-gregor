package layout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.ruben.lp2.Alumno;
import com.example.ruben.lp2.AppDatabase;
import com.example.ruben.lp2.DetallePrestamo;
import com.example.ruben.lp2.Libro;
import com.example.ruben.lp2.Prestamo;
import com.example.ruben.lp2.PrestamosDao;
import com.example.ruben.lp2.R;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ruben on 05/12/17.
 */

public class ReservaDialogFragment extends DialogFragment {
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        AppDatabase db = Room.databaseBuilder(getContext().getApplicationContext(),
                AppDatabase.class, "lp2").build();
        PrestamosDao dao = db.prestamosDao();
        // Get the layout inflater
        final LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        final View view = inflater.inflate(R.layout.dialog_reserva, null);
        builder.setView(view)
                // Add action buttons
                .setPositiveButton("Reservar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Alumno a = new Alumno(123,"Juan Alberto","Perez Gonzalez", "0971123123");
                        Libro l = new Libro(savedInstanceState.getInt("id"), savedInstanceState.getString("descripcion"),
                                savedInstanceState.getInt("disponibilidad"));
                        String cantidad = ((EditText)view.findViewById(R.id.username)).getText().toString();
                        Calendar cal = Calendar.getInstance();
                        cal.add(Calendar.DATE, Integer.parseInt(cantidad));
                        DetallePrestamo d = new DetallePrestamo(1, l, cal.getTime(), Integer.parseInt(cantidad));
                         Prestamo p = new Prestamo(1,a,new Date(), d);
                    }
                })
                ;
        return builder.create();
    }
}
