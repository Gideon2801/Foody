package hcmute.edu.vn.orderapp.group4.ui.home;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.orderapp.group4.MainActivity;
import hcmute.edu.vn.orderapp.group4.R;
import hcmute.edu.vn.orderapp.group4.adapters.HomeAdapter;
import hcmute.edu.vn.orderapp.group4.database.DBhelper;
import hcmute.edu.vn.orderapp.group4.models.HomeModel;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    List<HomeModel> homeModelList;
    HomeAdapter homeAdapter;
    DBhelper DB;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home,container,false);

        DB = new DBhelper(getActivity());

        recyclerView = root.findViewById(R.id.daily_meal_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        homeModelList = new ArrayList<>();
        Cursor cursor = DB.getListstore();
        homeModelList.clear();
        for(int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            String store = cursor.getString(0);
            String time = cursor.getString(1);
            String address = cursor.getString(2);

            int image = 0;

            if (store != null && store.equalsIgnoreCase("Pizza Hut")){
                image = R.drawable.pizzahut;
            }else if (store != null && store.equalsIgnoreCase("KFC")){
                image = R.drawable.kfc;
            }else if (store != null && store.equalsIgnoreCase("Ngô Quyền")){
                image = R.drawable.ngoquyen;
            }else
            if (store != null && store.equalsIgnoreCase("KOI")){
                image = R.drawable.koi;
            }else
            if (store != null && store.equalsIgnoreCase("Koreno")){
                image = R.drawable.koreno;
            }else
            {
                image = R.drawable.tra_sua;
            }

            homeModelList.add(new HomeModel(image, store, address, time));
        }

        homeAdapter = new HomeAdapter(homeModelList, getContext());
        recyclerView.setAdapter(homeAdapter);
        homeAdapter.notifyDataSetChanged();
        return root;
    }

}