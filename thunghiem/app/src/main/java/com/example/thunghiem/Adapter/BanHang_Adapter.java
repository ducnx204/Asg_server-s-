package com.example.thunghiem.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thunghiem.Model.BanHang;
import com.example.thunghiem.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
//String imageUri = "http:///192.168.1.2:3001/images/products/";
public class BanHang_Adapter extends RecyclerView.Adapter<BanHang_Adapter.banhang_Viewholder> {

    String imageUri = "http:///10.28.0.68:3001/images/products/";

    // xem chi tiet//

    private OnItemClickListen mListener;

    public interface  OnItemClickListen{
        void onItemClick(int position);
    }
    public void setOnItemCickListener(OnItemClickListen listener){
        mListener = listener;

    }
    // xem chi tiet//

    private Context mContext;
    ArrayList<BanHang>mBanHang;

    public BanHang_Adapter(Context context, ArrayList<BanHang> banHangs) {
        mContext = context;
        mBanHang = banHangs;
    }

    @NonNull
    @Override
    public banhang_Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false);
        return new banhang_Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull  BanHang_Adapter.banhang_Viewholder holder, int position) {
        BanHang currentItem = mBanHang.get(position);

        String image = currentItem.getImage();
        String name = currentItem.getName();
        int price1 = currentItem.getPrice1();
        holder.text_view_creator_1.setText(" "+name);
        holder.text_view_likes_1.setText("" + price1 +" ₫");
        Picasso.with(mContext).load(imageUri+image).fit().centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.image_view_1);
    }

    @Override
    public int getItemCount() {
        return mBanHang.size();

    }


    public class banhang_Viewholder extends RecyclerView.ViewHolder{
        ImageView image_view_1;
        TextView text_view_creator_1,text_view_likes_1;

        public banhang_Viewholder(View itemView) {
            super(itemView);
            image_view_1 = itemView.findViewById(R.id.image_view_1);
            text_view_creator_1 = itemView.findViewById(R.id.text_view_creator_1);
            text_view_likes_1 = itemView.findViewById(R.id.text_view_likes_1);

            itemView.setOnClickListener(view -> {
                if (mListener != null){
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        mListener.onItemClick(position);
                    }
                }
            });

        }
    }
}
