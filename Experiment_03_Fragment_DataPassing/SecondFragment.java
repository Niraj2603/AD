package com.example.fragmentdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {
    TextView tvReceivedMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        tvReceivedMessage = view.findViewById(R.id.tvReceivedMessage);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String msg = bundle.getString("message_key");
            tvReceivedMessage.setText("Received: " + msg);
        }
        return view;
    }
}
//STEP 6: Create SecondFragment.java
//Same way → New Java Class → SecondFragment → Paste:
