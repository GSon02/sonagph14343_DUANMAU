package com.example.sonagph14343_duanmau;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sonagph14343_duanmau.DAO.ThuThuDAO;
import com.example.sonagph14343_duanmau.Database.DatabaseHelper;
import com.example.sonagph14343_duanmau.Model.ThuthuModel;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper databaseHelper;
    private ThuThuDAO thuThuDAO;
    private ThuthuModel thuthuModel;
    private Button button;
    private ImageView imageView2;
    public TextInputLayout tilPass;
    public TextInputLayout tilUser;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) (R.layout.activity_main));
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        tilUser = (TextInputLayout) findViewById(R.id.tilUser);
        tilPass = (TextInputLayout) findViewById(R.id.tilGiaThue);
        databaseHelper = new DatabaseHelper(getApplicationContext());
        button = (Button) findViewById(R.id.btnSignin);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String user = tilUser.getEditText().getText().toString();
                String pass = tilPass.getEditText().getText().toString();

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(getApplicationContext(), "Vui long dien thong tin", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkUserPass = databaseHelper.checkUserNamePass(user, pass);
                    if(checkUserPass == true){
                        Toast.makeText(getApplicationContext(), "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "Dang nhap that bai", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
