package com.example.sonagph14343_duanmau.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sonagph14343_duanmau.Model.SachModel;
import com.example.sonagph14343_duanmau.R;

import java.util.List;

public class SachAdapter extends RecyclerView.Adapter<SachAdapter.ViewHolder> {
    List<SachModel> sachModels;
    Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sach_rows,parent,false);
        return new ViewHolder(view);
    }
    public SachAdapter(Context context, List<SachModel> sachModels){
        this.context = context;
        this.sachModels = sachModels;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final SachModel sachModel = sachModels.get(position);
        holder.tvTenSach.setText(String.valueOf(sachModel.getSachName()));
        holder.tvMaSach.setText("Mã Sách: " + String.valueOf(sachModel.getSachID()));
        holder.tvGiaThue.setText("Giá Thuê: " + String.valueOf(sachModel.getGiaThue()));
        holder.tvMaLoai.setText("Mã Loại Sách: " + String.valueOf(sachModel.getMaLoai()));
    }

    @Override
    public int getItemCount() {
        return sachModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTenSach;
        private ImageView imageView6;
        private TextView tvMaSach;
        private TextView tvGiaThue;
        private TextView tvMaLoai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTenSach = (TextView) itemView.findViewById(R.id.tvTenTV);
            imageView6 = (ImageView) itemView.findViewById(R.id.imageView6);
            tvMaSach = (TextView) itemView.findViewById(R.id.tvMaTV);
            tvGiaThue = (TextView) itemView.findViewById(R.id.tvNamSinh);
            tvMaLoai = (TextView) itemView.findViewById(R.id.tvMaLoai);

        }
    }
}
