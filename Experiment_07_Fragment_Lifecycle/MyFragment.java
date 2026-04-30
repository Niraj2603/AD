package com.example.fragmentlifecycle;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {

    // TAG used for Logcat filtering
    private static final String TAG = "FragmentDemo";

    Button btnShow;
    TextView tvStatus;

    // ============================================================
    // 1. onAttach() — Fragment is attached to Activity
    //    Called FIRST. Activity is now available.
    // ============================================================
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "1. onAttach() called → Fragment attached to Activity");
    }

    // ============================================================
    // 2. onCreate() — Fragment is being created
    //    Initialize data here (NOT views — views not ready yet)
    // ============================================================
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "2. onCreate() called → Fragment initializing");
    }

    // ============================================================
    // 3. onCreateView() — CREATE AND RETURN the Fragment's UI
    //    This is where we inflate XML and find views
    //    Most important method!
    // ============================================================
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "3. onCreateView() called → Fragment UI created");

        // Inflate the fragment layout
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        // Find views
        btnShow  = view.findViewById(R.id.btnShow);
        tvStatus = view.findViewById(R.id.tvStatus);

        // Button click
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),
                    "Fragment is Active! ✅\nCheck Logcat for lifecycle!",
                    Toast.LENGTH_LONG).show();
            }
        });

        return view; // MUST return view
    }

    // ============================================================
    // 4. onActivityCreated() — Host Activity's onCreate() done
    // ============================================================
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "4. onActivityCreated() → Activity fully created");
    }

    // ============================================================
    // 5. onStart() — Fragment becomes VISIBLE to user
    // ============================================================
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "5. onStart() → Fragment is now VISIBLE");
    }

    // ============================================================
    // 6. onResume() — Fragment is ACTIVE and INTERACTIVE
    //    User can now interact with the fragment
    // ============================================================
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "6. onResume() → Fragment is ACTIVE and INTERACTIVE ✅");
    }

    // ============================================================
    // 7. onPause() — Fragment no longer interactive
    //    Called when user navigates away / another fragment shown
    // ============================================================
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "7. onPause() → Fragment is PAUSED");
    }

    // ============================================================
    // 8. onStop() — Fragment no longer visible
    // ============================================================
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "8. onStop() → Fragment is STOPPED (not visible)");
    }

    // ============================================================
    // 9. onDestroyView() — Fragment's view is destroyed
    //    Clean up view resources here
    // ============================================================
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "9. onDestroyView() → Fragment View DESTROYED");
    }

    // ============================================================
    // 10. onDestroy() — Fragment is being destroyed
    // ============================================================
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "10. onDestroy() → Fragment DESTROYED");
    }

    // ============================================================
    // 11. onDetach() — Fragment detached from Activity
    //     Called LAST. Activity reference is gone.
    // ============================================================
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "11. onDetach() → Fragment DETACHED from Activity");
    }
}
