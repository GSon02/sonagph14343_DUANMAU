package com.example.sonagph14343_duanmau.ui.QLLS;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sonagph14343_duanmau.Adapter.LoaiSachAdapter;
import com.example.sonagph14343_duanmau.DAO.LoaiSachDAO;
import com.example.sonagph14343_duanmau.Database.DatabaseHelper;
import com.example.sonagph14343_duanmau.Model.LoaiSachModel;
import com.example.sonagph14343_duanmau.R;
import com.example.sonagph14343_duanmau.databinding.FragmentQllsBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class QLLSFragment extends Fragment {
    private AlertDialog alertDialog;
    private FragmentQllsBinding binding;
    private RecyclerView rcvLoaiSach;
    private FloatingActionButton fabAddLoaiSach;
    List<LoaiSachModel> loaiSachModelList;
    DatabaseHelper databaseHelper;
    LoaiSachDAO loaiSachDAO;
    LoaiSachAdapter loaiSachAdapter;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_qlls,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcvLoaiSach = (RecyclerView) view.findViewById(R.id.rcvLoaiSach);
        fabAddLoaiSach = (FloatingActionButton) view.findViewById(R.id.fabAddLoaiSach);
        databaseHelper = new DatabaseHelper(getContext());
        loaiSachDAO = new LoaiSachDAO(getContext());
        loaiSachModelList = loaiSachDAO.GetAllLoaiSach();
        loaiSachAdapter = new LoaiSachAdapter(getContext(),loaiSachModelList);
        rcvLoaiSach.setAdapter(loaiSachAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcvLoaiSach.setLayoutManager(linearLayoutManager);
        fabAddLoaiSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogAddLS();
            }
        });

    }
    public void openDialogAddLS(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.them_loai_sach_rows,null);
        builder.setView(view);
        ImageView imageView5;
        Button btnCancel;
        Button btnThemLS;
        EditText edtNameLS;
        TextView textView3;

        imageView5 = (ImageView) view.findViewById(R.id.imageView5);
        btnCancel = (Button) view.findViewById(R.id.btnCancel);
        btnThemLS = (Button) view.findViewById(R.id.btnThemLS);
        edtNameLS = (EditText) view.findViewById(R.id.edtNameLS);
        textView3 = (TextView) view.findViewById(R.id.textView3);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        btnThemLS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoaiSachModel loaiSachModel = new LoaiSachModel();
                loaiSachModel.setTenLoai(edtNameLS.getText().toString());
                long check = loaiSachDAO.InsertLoaiSach(loaiSachModel);
                if(check > 0){
                    Toast.makeText(getContext(), "Them Thanh Cong!", Toast.LENGTH_SHORT).show();
                    loaiSachAdapter.notifyDataSetChanged();
                    loaiSachModelList.clear();
                    loaiSachModelList.addAll(loaiSachDAO.GetAllLoaiSach());
                }else{
                    Toast.makeText(getContext(), "Them That bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }
}
