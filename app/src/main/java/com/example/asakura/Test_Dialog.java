package com.example.asakura;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class Test_Dialog extends AppCompatDialogFragment {
    //The Objects for the EditText view in the Dialog and the listener
    EditText editTextInput;
    ExampleDialogListener listener;
    Button buttonSubmit;
    Button buttonCancel;

    //
    TextView changeText;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        //Inflate the View using the layout for the AlertDialog
        View dialogView = inflater.inflate(R.layout.layout_dialog, null);

        //EditText and Button Objects for the Views in the layout
        editTextInput = dialogView.findViewById(R.id.input);
        buttonSubmit = dialogView.findViewById(R.id.buttonSubmit);
        buttonCancel = dialogView.findViewById(R.id.buttonCancel);

        //
        changeText = dialogView.findViewById(R.id.response_text);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        /*
        This is where I would use the if Statement to change the text color based on the content of the
        EditTextObject...or in this case, editTextInput
        */
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String compare = editTextInput.getText().toString();
                if (compare.equals("black"))// DO SOMETHINGS
                    buttonSubmit.setText("B");
                dismiss();
            }
        });
        
        //Use the inflated View object to build the AlertDialog
        builder.setView(dialogView).setTitle("Enter Zipcode");

        //Return the AlertDialog
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (ExampleDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

    public interface ExampleDialogListener {
        void applyTexts(String username);
    }
}