package com.example.onafe.bmt.settaggi;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Spinner;

import com.example.onafe.bmt.Configurazione;
import com.example.onafe.bmt.R;
import com.example.onafe.bmt.TimePicker;

/**
 * Created by onafe on 23/03/2017.
 */

public class Settaggio extends Fragment {
    EditText denominazione,pausa;
    TextView entrata,uscita;
    Spinner assenze;
    ImageView cancel;

    public Settaggio() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.settings, container, false);
        denominazione = (EditText) v.findViewById(R.id.editTextDenominazione);
        entrata = (TextView) v.findViewById(R.id.idEntrata);
        pausa = (EditText) v.findViewById(R.id.editTextPausa);
        cancel = (ImageView) v.findViewById(R.id.imageViewCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pausa.setText("");
            }
        });
        assenze = (Spinner) v.findViewById(R.id.spinnerAssenze);
        entrata.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               showTimePickerDialog(view);
           }
       }
        );
        uscita = (TextView) v.findViewById(R.id.idUscita);
        uscita.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               showTimePickerDialogUscita(view);
           }
       }
        );

        Intent intent = getActivity().getIntent();
        Bundle extras = intent.getExtras();
        Configurazione  config = extras.getParcelable("Configurazione");
        onChange(config);
        return v;
    }


    public void onChange(Configurazione config){
        denominazione.setText(config.getDenominazione());
    }

    public void showTimePickerDialog(View v) {
        FragmentManager fm = getActivity().getFragmentManager();
        TimePicker newFragment = new TimePicker(R.id.idEntrata);
        newFragment.show(fm, "timePicker");
    }

    public void showTimePickerDialogUscita(View v) {
        FragmentManager fm = getActivity().getFragmentManager();
        DialogFragment newFragment = new TimePicker(R.id.idUscita);
        newFragment.show(fm, "timePicker");
    }


}
