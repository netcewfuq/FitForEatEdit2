package fitforeat.fitforeat_2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>{

    private Context context;
    private List<String> titleStringList, detailStrings;
    private List<Integer> iconInts;
    private LayoutInflater layoutInflater;

    public RecycleViewAdapter(Context context,
                              List<String> titleStringList,
                              List<String> detailStrings,
                              List<Integer> iconInts) {
        this.layoutInflater = LayoutInflater.from(context);
        this.titleStringList = titleStringList;
        this.detailStrings = detailStrings;
        this.iconInts = iconInts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.layout_recycleview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.titleTextView.setText(titleStringList.get(position));
        holder.detailTextView.setText(detailStrings.get(position));
        holder.iconImageView.setImageResource(iconInts.get(position));
    }

    @Override
    public int getItemCount() {
        return titleStringList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView titleTextView, detailTextView;
        private ImageView iconImageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.txtTitle);
            detailTextView = itemView.findViewById(R.id.txtDetail);
            iconImageView = itemView.findViewById(R.id.imvIcon);

        }
    }
}
