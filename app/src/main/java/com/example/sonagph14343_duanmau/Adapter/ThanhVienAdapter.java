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

import com.example.sonagph14343_duanmau.DAO.ThanhVienDAO;
import com.example.sonagph14343_duanmau.Database.DatabaseHelper;
import com.example.sonagph14343_duanmau.Model.ThanhVienModel;
import com.example.sonagph14343_duanmau.R;

import java.util.List;

public class ThanhVienAdapter extends RecyclerView.Adapter<ThanhVienAdapter.MyViewHolder> {
    List<ThanhVienModel> thanhVienModelList;
    Context context;
    AlertDialog alertDialog;
    DatabaseHelper databaseHelper;
    ThanhVienDAO thanhVienDAO;
    ThanhVienModel thanhVienModel;
    ThanhVienAdapter thanhVienAdapter;
    private ImageView imageView5;
    private Button btnCancel;
    private Button btnSuaTV;
    private EditText edtNamSinh;
    private EditText edtNameTV;
    private TextView textView3;
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.thanhvien_rows,parent,false);
        return new MyViewHolder(view);
    }

    public ThanhVienAdapter(Context context, List<ThanhVienModel> thanhVienModelList) {
        this.context = context;
        this.thanhVienModelList = thanhVienModelList;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ThanhVienModel thanhVienModel = thanhVienModelList.get(position);
        holder.tvMaTV.setText("Mã Thành Viên: " + String.valueOf(thanhVienModel.getMaThanhVien()));
        holder.tvTenTV.setText("Tên: " + String.valueOf(thanhVienModel.getTenThanhVien()));
        holder.tvNamSinh.setText("Năm Sinh: " + String.valueOf(thanhVienModel.getNamSinh()));
        holder.imbDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Xóa").setMessage("Bạn có muốn xóa thành viên này không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ThanhVienDAO thanhVienDAO = new ThanhVienDAO(view.getContext());
                        int check = thanhVienDAO.DeleteThanhVien(String.valueOf(thanhVienModel.getMaThanhVien()));
                        if(check > 0){
                            Toast.makeText(view.getContext(), "Xóa thành công", Toast.LENGTH_SHORT).show();
                            thanhVienModelList.remove(thanhVienModel);
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
        holder.btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialogChangeTV();

            }
        });
    }
    public void openDialogChangeTV(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(builder.getContext()).inflate(R.layout.sua_thanhvien_dialog,null);
        builder.setView(view);

        imageView5 = (ImageView) view.findViewById(R.id.imageView5);
        btnCancel = (Button) view.findViewById(R.id.btnCancel);
        btnSuaTV = (Button) view.findViewById(R.id.btnThemLS);
        edtNamSinh = (EditText) view.findViewById(R.id.edtNamSinh);
        edtNameTV = (EditText) view.findViewById(R.id.edtNameLS);
        textView3 = (TextView) view.findViewById(R.id.textView3);
        btnSuaTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper = new DatabaseHelper(builder.getContext());
                thanhVienDAO = new ThanhVienDAO(builder.getContext());
                thanhVienModelList = thanhVienDAO.getAllThanhVien();
                thanhVienAdapter = new ThanhVienAdapter(builder.getContext(), thanhVienModelList);
                thanhVienModel = new ThanhVienModel();
                thanhVienModel.setTenThanhVien(edtNameTV.getText().toString());
                thanhVienModel.setNamSinh(edtNamSinh.getText().toString());
                thanhVienDAO.UpdateTV(thanhVienModel);
                long check = thanhVienDAO.UpdateTV(thanhVienModel);
                if(check >= 0){
                    Toast.makeText(builder.getContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    thanhVienModelList.clear();
                    thanhVienModelList.addAll(thanhVienDAO.getAllThanhVien());
                    thanhVienAdapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(builder.getContext(), "Thêm Thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public int getItemCount() {
        return thanhVienModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTenTV;
        private ImageView imageView6;
        private TextView tvMaTV;
        private TextView tvNamSinh;
        private Button btnSua;
        private ImageButton imbDelete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenTV = (TextView) itemView.findViewById(R.id.tvTenTV);
            imageView6 = (ImageView) itemView.findViewById(R.id.imageView6);
            tvMaTV = (TextView) itemView.findViewById(R.id.tvMaTV);
            tvNamSinh = (TextView) itemView.findViewById(R.id.tvNamSinh);
            btnSua = (Button) itemView.findViewById(R.id.btnSua);
            imbDelete = (ImageButton) itemView.findViewById(R.id.imbDelete);

        }
    }
}
