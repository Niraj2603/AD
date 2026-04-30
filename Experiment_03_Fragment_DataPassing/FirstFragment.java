package com.example.fragmentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {
    EditText etMessage;
    Button btnSend;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        etMessage = view.findViewById(R.id.etMessage);
        btnSend = view.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = etMessage.getText().toString();
                SecondFragment secondFragment = new SecondFragment();
                Bundle bundle = new Bundle();
                bundle.putString("message_key", message);
                secondFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, secondFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}
//STEP 5: Create FirstFragment.java
//Right-click java/com.example.fragmentdemo
//New → Java Class
//Name: FirstFragment → Enter
//Clear all → Paste:
