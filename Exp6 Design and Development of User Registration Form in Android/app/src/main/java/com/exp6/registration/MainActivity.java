package com.exp6.registration;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

/**
 * Experiment 6: User Registration Form
 * Contains name, email, password, gender (RadioButton), course (Spinner), and submit button.
 */
public class MainActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPassword, etPhone;
    private RadioGroup rgGender;
    private Spinner spinnerCourse;
    private CheckBox cbTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etPhone = findViewById(R.id.etPhone);
        rgGender = findViewById(R.id.rgGender);
        spinnerCourse = findViewById(R.id.spinnerCourse);
        cbTerms = findViewById(R.id.cbTerms);

        // Set up spinner with course options
        String[] courses = {"Select Course", "B.Tech CSE", "B.Tech IT", "BCA", "MCA", "MBA", "B.Sc CS"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCourse.setAdapter(adapter);

        Button btnSubmit = findViewById(R.id.btnSubmit);
        Button btnReset = findViewById(R.id.btnReset);

        btnSubmit.setOnClickListener(v -> validateAndSubmit());
        btnReset.setOnClickListener(v -> resetForm());
    }

    private void validateAndSubmit() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        int selectedGenderId = rgGender.getCheckedRadioButtonId();
        int coursePosition = spinnerCourse.getSelectedItemPosition();

        if (name.isEmpty()) { etName.setError("Name is required"); return; }
        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) { etEmail.setError("Valid email required"); return; }
        if (password.length() < 6) { etPassword.setError("Password must be 6+ characters"); return; }
        if (phone.isEmpty()) { etPhone.setError("Phone is required"); return; }
        if (selectedGenderId == -1) { Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show(); return; }
        if (coursePosition == 0) { Toast.makeText(this, "Please select a course", Toast.LENGTH_SHORT).show(); return; }
        if (!cbTerms.isChecked()) { Toast.makeText(this, "Please accept terms & conditions", Toast.LENGTH_SHORT).show(); return; }

        RadioButton selectedGender = findViewById(selectedGenderId);
        String gender = selectedGender.getText().toString();
        String course = spinnerCourse.getSelectedItem().toString();

        String summary = "Registration Successful!\n\nName: " + name + "\nEmail: " + email + "\nPhone: " + phone + "\nGender: " + gender + "\nCourse: " + course;
        Toast.makeText(this, summary, Toast.LENGTH_LONG).show();
    }

    private void resetForm() {
        etName.setText(""); etEmail.setText(""); etPassword.setText(""); etPhone.setText("");
        rgGender.clearCheck();
        spinnerCourse.setSelection(0);
        cbTerms.setChecked(false);
        Toast.makeText(this, "Form Reset", Toast.LENGTH_SHORT).show();
    }
}
