package butchjgo.com.save2text;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private String fileName = "test.txt";
    String txtInput, savedData = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void prepareData() {
        EditText editText = findViewById(R.id.txtInput);
        txtInput = editText.getText().toString();
    }

    void save2Internal(View view) {
        prepareData();
        try {

            FileOutputStream fileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
            fileOutputStream.write(txtInput.getBytes());
            fileOutputStream.close();

            Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readFromInternal(View view) {
        try {
            FileInputStream fileInputStream = openFileInput(fileName);
            InputStreamReader reader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            savedData = bufferedReader.readLine();
            Toast.makeText(this, savedData, Toast.LENGTH_LONG).show();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
