package ru.mirea.zavarzin.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final String SAVED_NAME = "SAVED_NAME";
    final String SAVED_NOTE = "SAVED_NOTE";

    private EditText nameEditText;
    private EditText noteEditText;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        noteEditText = findViewById(R.id.noteEditText);
        preferences = getPreferences(MODE_PRIVATE);
        String name = preferences.getString(SAVED_NAME, "EMPTY");
        nameEditText.setText(name);
        String note = preferences.getString(SAVED_NOTE, "EMPTY");
        noteEditText.setText(note);
    }
    public void onClickSave(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(SAVED_NAME, nameEditText.getText().toString());
        editor.putString(SAVED_NOTE, noteEditText.getText().toString());
        editor.apply();
        Toast.makeText(this, "Note and text saved", Toast.LENGTH_SHORT).show();
    }
}