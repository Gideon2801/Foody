package hcmute.edu.vn.orderapp.group4.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.List;

import hcmute.edu.vn.orderapp.group4.MainActivity;
import hcmute.edu.vn.orderapp.group4.R;
import hcmute.edu.vn.orderapp.group4.activities.DetailHomeActivity;
import hcmute.edu.vn.orderapp.group4.activities.DetailProductActivity;
import hcmute.edu.vn.orderapp.group4.models.DetailHomeModel;

public class DetailHomeAdapter extends RecyclerView.Adapter<DetailHomeAdapter.ViewHolder> {

    List<DetailHomeModel> list;
    Context context;

    public DetailHomeAdapter(List<DetailHomeModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DetailHomeAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_home_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DetailHomeAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getFood_name());
        holder.price.setText(list.get(position).getPrice());
        holder.rating.setText(list.get(position).getRating());
        holder.description.setText(list.get(position).getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailProductActivity.class);
                intent.putExtra("food_name",list.get(position).getFood_name());
                intent.putExtra("store_name",list.get(position).getStore_name());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, price, description, rating;
        Button AddToCart;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.detail_home_image);
            name = itemView.findViewById(R.id.detail_home_name_product);
            description = itemView.findViewById(R.id.detail_home_des);
            rating = itemView.findViewById(R.id.detail_home_rating);
            price = itemView.findViewById(R.id.detail_home_price);
        }
    }
}
