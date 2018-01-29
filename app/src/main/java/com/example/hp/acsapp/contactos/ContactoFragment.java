package com.example.hp.acsapp.contactos;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.acsapp.R;
import com.example.hp.acsapp.datasource.model.Contacto;


import java.util.List;

import static android.app.Activity.RESULT_OK;

public class ContactoFragment extends Fragment implements ContactoContract.View{

    private OnFragmentInteractionListener mListener;
    private ContactoContract.Presenter presentador;
    private TextView tv_amigo1, tv_amigo2, tv_amigo3;
    private ImageView btn_amigo1,btn_amigo2,btn_amigo3;
    static final int PICK_CONTACT_REQUEST = 1;

    public ContactoFragment() {
        // Required empty public constructor
    }

    public static ContactoFragment newInstance() {
        return new ContactoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_contactos, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_amigo1 = (TextView) view.findViewById(R.id.name_amigo1);
        btn_amigo1 = (ImageView) view.findViewById(R.id.foto_amigo1);

        btn_amigo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectContact();
            }
        });

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void viewContact(Uri contactUri) {
        Intent intent = new Intent(Intent.ACTION_VIEW, contactUri);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void selectContact() {
        Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
        pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
        startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request it is that we're responding to
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // Get the URI that points to the selected contact
                Uri contactUri = data.getData();
                // We only need the NUMBER column, because there will be only one row in the result
                String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};

                // Perform the query on the contact to get the NUMBER column
                // We don't need a selection or sort order (there's only one result for the given URI)
                // CAUTION: The query() method should be called from a separate thread to avoid blocking
                // your app's UI thread. (For simplicity of the sample, this code doesn't do that.)
                // Consider using CursorLoader to perform the query.
                Cursor cursor = getActivity().getApplicationContext().getContentResolver()
                        .query(contactUri, projection, null, null, null);
                cursor.moveToFirst();

                // Retrieve the phone number from the NUMBER column
                int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(column);

                // Do something with the phone number...

                tv_amigo1.setText(number);
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void setPresenter(ContactoContract.Presenter presenter) {
        presentador = presenter;
    }
    

    @Override
    public void showAddContacto() {

    }

    @Override
    public void showContactoDetail(String contactoId) {

    }

    @Override
    public void showCallingState() {

    }

    @Override
    public void showContactos(List<Contacto> contactos) {

    }

    @Override
    public void showSuccesfullySaved() {

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
