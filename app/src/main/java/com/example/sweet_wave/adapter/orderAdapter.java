package com.example.sweet_wave.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sweet_wave.R;
import com.example.sweet_wave.firebase.*;
import com.example.sweet_wave.fragements.cart_frag;

import java.util.ArrayList;

public class orderAdapter extends RecyclerView.Adapter<com.example.sweet_wave.adapter.orderAdapter.ViewHolder> {


        Context context;
        ArrayList<orderStructure> arrl;

        public orderAdapter(Context context, ArrayList<orderStructure> arrl) {
            this.context = context;
            this.arrl = arrl;
        }

        @NonNull
        @Override
        public com.example.sweet_wave.adapter.orderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.order_design, parent, false);
            return new com.example.sweet_wave.adapter.orderAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull com.example.sweet_wave.adapter.orderAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

            holder.order.setText(arrl.get(position).Order);
            holder.date.setText(""+arrl.get(position).Date);
            holder.address.setText(""+arrl.get(position).Address);
            holder.total.setText(""+(arrl.get(position).Total));
            holder.cancle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addToFirebase a=new addToFirebase();
                    Toast.makeText(context, "remove", Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return arrl.size();
        }


        public static class ViewHolder extends RecyclerView.ViewHolder {

            TextView order,date,address,total;
            Button cancle;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                order = itemView.findViewById(R.id.order);
                date = itemView.findViewById(R.id.date);
                address = itemView.findViewById(R.id.address);
                total = itemView.findViewById(R.id.total);
                cancle = itemView.findViewById(R.id.cancle);


            }
        }

}
