package hcmute.edu.vn.orderapp.group4.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.edu.vn.orderapp.group4.R;
import hcmute.edu.vn.orderapp.group4.database.DBhelper;
import hcmute.edu.vn.orderapp.group4.models.CartModel;
import hcmute.edu.vn.orderapp.group4.models.UserModel;
import hcmute.edu.vn.orderapp.group4.ui.cart.MyCartFragment;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{

    List<CartModel> list;
    MyCartFragment context;

    DBhelper DB;

    public CartAdapter(List<CartModel> list, MyCartFragment context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mycart_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {

        DB = new DBhelper(context.getActivity());

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name_product.setText(list.get(position).getName_food());
        holder.rating.setText(list.get(position).getRating());
        holder.price.setText(list.get(position).getPice());
        holder.name_store.setText(list.get(position).getName_store());
        holder.quantity.setText(list.get(position).getQuatity());

        UserModel user = DB.getuser("1");
        String email = user.getEmail();
        String food = holder.name_product.getText().toString().trim();
        String store = holder.name_store.getText().toString().trim();

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(holder.quantity.getText().toString().trim());
                int total = Integer.parseInt(holder.price.getText().toString().trim());
                int price = total / quantity;
                quantity++;
                total += price;
                holder.quantity.setText(String.valueOf(quantity));
                holder.price.setText(String.valueOf(total));
                DB.updateDataCart(email, food, store, String.valueOf(quantity));
                context.GetData();
            }
        });

        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(holder.quantity.getText().toString().trim());
                if (quantity == 1){
                    context.DialogXoaCart(email, food, store);
                }else {
                    int total = Integer.parseInt(holder.price.getText().toString().trim());
                    int price = total / quantity;
                    quantity--;
                    total -= price;
                    holder.quantity.setText(String.valueOf(quantity));
                    holder.price.setText(String.valueOf(total));
                    DB.updateDataCart(email, food, store, String.valueOf(quantity));
                    context.GetData();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView, plus, minus;
        TextView name_product, rating, price, name_store, quantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_mycart_item);
            name_product = itemView.findViewById(R.id.textView_name_mycart_item);
            price = itemView.findViewById(R.id.textView_price_mycart_item);
            rating = itemView.findViewById(R.id.textView_rating_mycart_item);
            name_store = itemView.findViewById(R.id.textView_storename_mycart_item);
            quantity = itemView.findViewById(R.id.textView_quantity_mycart_item);
            plus = itemView.findViewById(R.id.image_plus);
            minus = itemView.findViewById(R.id.image_minus);
        }
    }
}
