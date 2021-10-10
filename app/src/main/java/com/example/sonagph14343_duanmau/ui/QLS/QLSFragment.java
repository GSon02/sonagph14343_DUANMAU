package com.example.sonagph14343_duanmau.ui.QLS;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sonagph14343_duanmau.Adapter.SachAdapter;
import com.example.sonagph14343_duanmau.AddSachActivity;
import com.example.sonagph14343_duanmau.DAO.SachDAO;
import com.example.sonagph14343_duanmau.Database.DatabaseHelper;
import com.example.sonagph14343_duanmau.Model.SachModel;
import com.example.sonagph14343_duanmau.R;
import com.example.sonagph14343_duanmau.databinding.FragmentQlsBinding;

import java.util.ArrayList;
import java.util.List;

public class QLSFragment extends Fragment {
    private Button btnAddSach;
    private RecyclerView recyclerView;
    DatabaseHelper databaseHelper;
    SachAdapter sachAdapter;
    List<SachModel> sachModellist;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_qls, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnAddSach = (Button) view.findViewById(R.id.btnAddSach);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        btnAddSach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),AddSachActivity.class);
                startActivity(intent);
            }
        });
        databaseHelper = new DatabaseHelper(getContext());
        SachDAO sachDAO = new SachDAO(getContext());
        sachModellist = sachDAO.getAllsach();
        sachAdapter = new SachAdapter(getContext(),sachModellist);
        recyclerView.setAdapter(sachAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
