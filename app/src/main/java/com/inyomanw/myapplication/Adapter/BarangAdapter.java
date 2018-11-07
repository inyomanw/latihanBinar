package com.inyomanw.myapplication.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;
import com.inyomanw.myapplication.R;
import com.inyomanw.myapplication.models.Barang;

import java.util.ArrayList;
import java.util.List;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Barang> mList;
    private ItemListener itemListener;
    RequestOptions options ;

    public BarangAdapter(Context context, ArrayList<Barang> list, ItemListener itemListener)
    {
        mContext=context;
        mList=list;
        this.itemListener = itemListener;

        //Request option for Glide
        //options = new RequestOptions().centerCrop().placeholder(R.drawable.ic_loading).error(R.drawable.ic_loading);
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.rv_barang_item,parent,false);

        ViewHolder viewHolder = new ViewHolder(view,itemListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Barang barang = mList.get(position);
        ImageView image = holder.item_image;
        TextView name,rating,price;

        name = holder.item_name;
        rating=holder.item_rating;
        price=holder.item_price;

        image.setImageResource(barang.getGambar());

        name.setText(barang.getNamabarang());
        rating.setText(String.valueOf(barang.getTerjual()));
        price.setText(String.valueOf(barang.getHarga()));

        //Glide.with(mContext).load(mList.get(position).getImage_url()).apply(options).into(image);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public List<Barang> getBarangList(){
        return mList;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private View rootView;
        private ItemListener itemListener;

        private ImageView item_image;
        private TextView item_name, item_rating,item_price;

        public  ViewHolder(View itemView, ItemListener itemListener)
        {
            super((itemView));

            this.rootView = itemView;
            item_image= itemView.findViewById(R.id.imgBarang);
            item_name= itemView.findViewById(R.id.tvProdukName);
            item_price=itemView.findViewById(R.id.tvPrice);
            item_rating=itemView.findViewById(R.id.tvRating);

            rootView.setOnClickListener(this);
            this.itemListener = itemListener;
        }

        @Override
        public void onClick(View view) {
            itemListener.onItemClick(getAdapterPosition());

        }
    }

    public interface ItemListener
    {
        void onItemClick(int position);
    }
}