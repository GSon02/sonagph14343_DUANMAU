package com.example.sonagph14343_duanmau;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sonagph14343_duanmau.DAO.SachDAO;
import com.example.sonagph14343_duanmau.Model.SachModel;
import com.google.android.material.textfield.TextInputLayout;

public class AddSachActivity extends AppCompatActivity {
    private TextInputLayout tilSachName;
    private TextInputLayout tilGiaThue;
    private TextInputLayout tilMaLoai;
    private Button button;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sach);

        tilSachName = (TextInputLayout) findViewById(R.id.tilSachName);
        tilGiaThue = (TextInputLayout) findViewById(R.id.tilGiaThue);
        tilMaLoai = (TextInputLayout) findViewById(R.id.tilMaLoai);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SachModel sachModel = new SachModel();
                sachModel.setSachName(tilSachName.getEditText().getText().toString());
                sachModel.setGiaThue(tilGiaThue.getEditText().getText().toString());
                sachModel.setMaLoai(tilMaLoai.getEditText().getText().toString());
                SachDAO sachDAO = new SachDAO(AddSachActivity.this);
                sachDAO.InsertSach(sachModel);
            }
        });
    }
}
