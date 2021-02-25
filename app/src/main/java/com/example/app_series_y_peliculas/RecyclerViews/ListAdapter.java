package com.example.app_series_y_peliculas.RecyclerViews;

import android.app.AppComponentFactory;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_series_y_peliculas.Botons_Fragment.FragmentPeliSerie;
import com.example.app_series_y_peliculas.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private List<PeliculaSerie> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<PeliculaSerie> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount(){return mData.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.item_list,null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder,final int position){
        holder.bindData(mData.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                FragmentPeliSerie fragmentPeliSerie =  new FragmentPeliSerie();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.rec,fragmentPeliSerie).addToBackStack(null).commit();
            }
        });
    }

    public void setItems(List<PeliculaSerie> items){mData = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView nombrepeli,status,tipopeli;

        ViewHolder(View itemView){
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconImageView);
            nombrepeli = itemView.findViewById(R.id.NombrePeliTextview);
            status = itemView.findViewById(R.id.StatusTextView);
            tipopeli = itemView.findViewById(R.id.tipoPeliTextView);
        }

        void bindData(final PeliculaSerie item){
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            nombrepeli.setText((item.getNombrepeli()));
            status.setText((item.getStatus()));
            tipopeli.setText((item.getTipopeli()));

        }
    }
}
