package com.example.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class NuevaAveriaDialogo extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.dialogonuevaveria, null));
        builder.setTitle("Nueva Avería")
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // START THE GAME!
                        Toast.makeText(getActivity(), "Guardada", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

}
