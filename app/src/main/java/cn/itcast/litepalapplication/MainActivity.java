package cn.itcast.litepalapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LitePal.initialize(this);
        setContentView(R.layout.activity_main);

        Button creatDB_btn = findViewById(R.id.creatDB_btn);
        creatDB_btn.setOnClickListener(this);
        Button addData_btn = findViewById(R.id.addData_btn);
        addData_btn.setOnClickListener(this);
        Button updateData_btn = findViewById(R.id.updateData_btn);
        updateData_btn.setOnClickListener(this);
        Button deleteData_btn = findViewById(R.id.deleteData_btn);
        deleteData_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.creatDB_btn:
                LitePal.getDatabase();
                break;
            case R.id.addData_btn:
                Album addData_btn = new Album();
                addData_btn.setName("The Da Vinci Code");
                addData_btn.setAuthor("Dan Brown");
                addData_btn.setPages(454);
                addData_btn.setPrice(16.69);
                addData_btn.setPress("Unknow");
                addData_btn.save();
            case R.id.updateData_btn:
                Album updateData_btn = new Album();
                updateData_btn.setPrice(20);
                updateData_btn.updateAll("name = ?","The Da Vinci Code");
            case R.id.deleteData_btn:
                LitePal.delete(Album.class,1);
            default:
                break;
        }
    }
}
