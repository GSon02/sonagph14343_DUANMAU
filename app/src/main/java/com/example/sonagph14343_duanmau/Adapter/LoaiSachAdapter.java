package com.example.sonagph14343_duanmau.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sonagph14343_duanmau.DAO.LoaiSachDAO;
import com.example.sonagph14343_duanmau.DAO.ThanhVienDAO;
import com.example.sonagph14343_duanmau.Model.LoaiSachModel;
import com.example.sonagph14343_duanmau.R;

import java.util.List;

public class LoaiSachAdapter extends RecyclerView.Adapter<LoaiSachAdapter.ViewHolder> {
    List<LoaiSachModel> loaiSachModelList;
    LoaiSachDAO loaiSachDAO;
    Context context;
    AlertDialog alertDialog;


    public LoaiSachAdapter(Context context, List<LoaiSachModel> loaiSachModelList) {
        this.context = context;
        this.loaiSachModelList = loaiSachModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.loaisach_rows,parent,false);
        return new ViewHolder(view);
    }

    public LoaiSachAdapter(List<LoaiSachModel> loaiSachModelList, LoaiSachDAO loaiSachDAO) {
        this.loaiSachModelList = loaiSachModelList;
        this.loaiSachDAO = loaiSachDAO;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final LoaiSachModel loaiSachModel = loaiSachModelList.get(position);
        holder.tvMaLoai.setText("Ma Loai Sach: " + String.valueOf(loaiSachModel.getMaLoai()));
        holder.tvTenLoai.setText(String.valueOf(loaiSachModel.getTenLoai()));
        holder.imbDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Xóa").setMessage("Bạn có muốn xóa Loai Sach này không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        LoaiSachDAO loaiSachDAO = new LoaiSachDAO(view.getContext());
                        int check = loaiSachDAO.DeleteLoaiSach(String.valueOf(loaiSachModel.getMaLoai()));
                        if(check > 0){
                            Toast.makeText(view.getContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();
                            loaiSachModelList.remove(loaiSachModel);
                            notifyDataSetChanged();
                            notifyItemRemoved(holder.getAdapterPosition());
                        }else{
                            Toast.makeText(view.getContext(), "Lỗi xóa", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
    public void openDialogChangeLS(){

    }

    @Override
    public int getItemCount() {
        return loaiSachModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView6;
        private TextView tvMaLoai;
        private Button button2;
        private ImageButton imbDelete;
        private TextView tvTenLoai;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView6 = (ImageView) itemView.findViewById(R.id.imageView6);
            tvMaLoai = (TextView) itemView.findViewById(R.id.tvMaLoai);
            button2 = (Button) itemView.findViewById(R.id.btnSua);
            imbDelete = (ImageButton) itemView.findViewById(R.id.imbDelete);
            tvTenLoai = (TextView) itemView.findViewById(R.id.tvTenLoai);
        }
    }
}
