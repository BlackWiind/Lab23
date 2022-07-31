package com.example.lab23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String PREF_FILE = "SETTINGS";
    private static final String PREF_LOGIN = "Login";
    private static final String PREF_PASS = "Password";
    private static final String PREF_ID = "Id";
    private static final String PREF_PRIORITY = "Priority";
    private static final String PREF_SPEC1 = "Spec_1";
    SharedPreferences settings;
    SharedPreferences.Editor prefEditor;

    EditText loginText, passText, idText, prioText, spec1Text;
    Button exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginText = findViewById(R.id.editLogin);
        passText = findViewById(R.id.editPass);
        idText = findViewById(R.id.editId);
        prioText = findViewById(R.id.editPriority);
        spec1Text = findViewById(R.id.editSpec1);
        exitBtn = findViewById(R.id.btnExit);
        settings = getSharedPreferences(PREF_FILE, MODE_PRIVATE);
    }


    @Override
    protected void onPause(){

        super.onPause();

        prefEditor = settings.edit();
        String login = loginText.getText().toString();
        prefEditor.putString(PREF_LOGIN, login);
        String pass = passText.getText().toString();
        prefEditor.putString(PREF_PASS, pass);
        int id = Integer.parseInt(idText.getText().toString());
        prefEditor.putInt(PREF_ID, id);
        int priority = Integer.parseInt(prioText.getText().toString());
        prefEditor.putInt(PREF_PRIORITY, priority);
        float spec1 = Float.parseFloat(spec1Text.getText().toString());
        prefEditor.putFloat(PREF_SPEC1, spec1);
        prefEditor.apply();

    }

    @Override
    protected void onResume() {

        super.onResume();

        String login = settings.getString(PREF_LOGIN, "");
        loginText.setText(login);
        String pass = settings.getString(PREF_PASS, "");
        passText.setText(pass);
        int id = settings.getInt(PREF_ID, 0);
        idText.setText(String.valueOf(id));
        int priority = settings.getInt(PREF_PRIORITY, 3);
        prioText.setText(String.valueOf(priority));
        float spec1 = settings.getFloat(PREF_SPEC1, 1);
        spec1Text.setText(String.valueOf(spec1));
        
    }

    public void onExitPress(View view) {
        finish();
    }
}