package com.example.rxandroid_demo_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RVCustomAdapter extends RecyclerView.Adapter<RVCustomAdapter.MyViewHolder> {


    private final List<Entry> entries = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Entry entry = entries.get(position);
        holder.setTxtName(entry.getEntryName());
        holder.setTxtPrice(entry.getEntryPrice());
        holder.setTxtDate(entry.getEntryDate());

    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    public void addStringToList(Entry value) {

        entries.add(value);
        notifyItemInserted(entries.size() - 1);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtName)
        TextView txtName;
        @BindView(R.id.txtPrice)
        TextView txtPrice;
        @BindView(R.id.txtDate)
        TextView txtDate;

        private final NumberFormat ENTRY_PRICE_FORMAT = new DecimalFormat("$#0.00");

        public void setTxtName(String entryName) {
            this.txtName.setText(entryName);
        }

        public void setTxtPrice(BigDecimal entryPrice) {
            this.txtPrice.setText(ENTRY_PRICE_FORMAT.format(entryPrice.doubleValue()));
        }

        public void setTxtDate(Date entryDate) {
            this.txtDate.setText(android.text.format.DateFormat.format("dd-mm-yyyy hh:mm", entryDate));
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
