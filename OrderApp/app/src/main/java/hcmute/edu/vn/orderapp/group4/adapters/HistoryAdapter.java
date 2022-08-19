package hcmute.edu.vn.orderapp.group4.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.edu.vn.orderapp.group4.R;
import hcmute.edu.vn.orderapp.group4.database.DBhelper;
import hcmute.edu.vn.orderapp.group4.models.CartModel;
import hcmute.edu.vn.orderapp.group4.models.UserModel;
import hcmute.edu.vn.orderapp.group4.ui.history.HistoryFragment;

public class HistoryAdapter  extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>{

    List<CartModel> list;
    HistoryFragment context;

    DBhelper DB;

    public HistoryAdapter(List<CartModel> list, HistoryFragment context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {
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

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                context.DialogXoaHistory(email, food, store);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name_product, rating, price, name_store, quantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_history_item);
            name_product = itemView.findViewById(R.id.textView_name_history_item);
            price = itemView.findViewById(R.id.textView_price_history_item);
            rating = itemView.findViewById(R.id.textView_rating_history_item);
            name_store = itemView.findViewById(R.id.textView_storename_history_item);
            quantity = itemView.findViewById(R.id.textView_quantity_history_item);

        }
    }
}
