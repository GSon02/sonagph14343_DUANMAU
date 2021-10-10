package com.example.sonagph14343_duanmau.ui.QLTV;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sonagph14343_duanmau.Adapter.ThanhVienAdapter;
import com.example.sonagph14343_duanmau.DAO.ThanhVienDAO;
import com.example.sonagph14343_duanmau.Database.DatabaseHelper;
import com.example.sonagph14343_duanmau.Model.ThanhVienModel;
import com.example.sonagph14343_duanmau.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class QLTVFragment extends Fragment {
    private RecyclerView rcvThanhVien;
    private FloatingActionButton flbAddTV;
    private DatabaseHelper databaseHelper;
    List<ThanhVienModel> thanhVienModellist;
    ThanhVienAdapter thanhVienAdapter;
    ThanhVienDAO thanhVienDAO;
    AlertDialog alertDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_qltv, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcvThanhVien = (RecyclerView) view.findViewById(R.id.rcvThanhVien);
        flbAddTV = (FloatingActionButton) view.findViewById(R.id.flbAddTV);
        databaseHelper = new DatabaseHelper(getContext());
        thanhVienDAO = new ThanhVienDAO(getContext());
        thanhVienModellist = thanhVienDAO.getAllThanhVien();
        thanhVienAdapter = new ThanhVienAdapter(getContext(),thanhVienModellist);
        rcvThanhVien.setAdapter(thanhVienAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcvThanhVien.setLayoutManager(linearLayoutManager);
        flbAddTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddTVDialog();
            }
        });

    }
    public void openAddTVDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.themthanhvien_dialog,null);
        builder.setView(view);

        Button btnCancel;
        Button btnAddTV;
        EditText edtNamSinh;
        EditText edtNameTV;

        btnCancel = (Button) view.findViewById(R.id.btnCancel);
        btnAddTV = (Button) view.findViewById(R.id.btnThemLS);
        edtNamSinh = (EditText) view.findViewById(R.id.edtNamSinh);
        edtNameTV = (EditText) view.findViewById(R.id.edtNameLS);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        btnAddTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ThanhVienModel thanhVienModel = new ThanhVienModel();
                String tenTV = edtNameTV.getText().toString();
                String namsinhTV = edtNamSinh.getText().toString();
                thanhVienModel.setTenThanhVien(tenTV);
                thanhVienModel.setNamSinh(namsinhTV);
                long check = thanhVienDAO.InsertThanhVien(thanhVienModel);
                if(check > 0){
                    Toast.makeText(getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    thanhVienAdapter.notifyDataSetChanged();
                    thanhVienModellist.clear();
                    thanhVienModellist.addAll(thanhVienDAO.getAllThanhVien());
                }else{
                    Toast.makeText(getContext(), "Thêm Thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }
}