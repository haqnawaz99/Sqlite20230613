package haqnawaz.org.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText etName, etRollNo;
    CheckBox cbEnroll;
    Button btnSave, btnEdit, btnDelete;

    DbHelper db;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etRollNo = findViewById(R.id.et_roll_no);
        cbEnroll = findViewById(R.id.cb_enroll);
        btnSave = findViewById(R.id.btn_save);
        btnEdit = findViewById(R.id.btn_edit);
        btnDelete = findViewById(R.id.btn_delete);

        db = new DbHelper(this);
        listView = findViewById(R.id.list_view);
        RefreshGrid();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String rollNo = etRollNo.getText().toString();
                boolean isEnroll = cbEnroll.isChecked();

                if (name.isEmpty() || rollNo.isEmpty()) {
                    //Toast.makeText(MainActivity.this, "Please enter valid data", Toast.LENGTH_SHORT).show();
                    //return;
                }
                Student student = new Student(name, rollNo, isEnroll);
                db.insertStudent(student);
                RefreshGrid();
            }
        });


    }

    public void RefreshGrid() {
        List<Student> students = db.selectAllStudents();

        ArrayAdapter arrayAdapter = new ArrayAdapter<Student>(MainActivity.this, android.R.layout.simple_list_item_1, students);
        listView.setAdapter(arrayAdapter);
    }
}