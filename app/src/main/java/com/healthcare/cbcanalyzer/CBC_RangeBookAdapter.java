package com.healthcare.cbcanalyzer;
import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;
        import java.util.ArrayList;

public class CBC_RangeBookAdapter extends RecyclerView.Adapter<CBC_RangeBookAdapter.Viewholder> {

    private Context context;
    private ArrayList<CBC_BookModal> CBC_BookModalArrayList;

    // Constructor
    public CBC_RangeBookAdapter(Context context, ArrayList<CBC_BookModal> courseModelArrayList) {
        this.context = context;
        this.CBC_BookModalArrayList = courseModelArrayList;
    }

    @NonNull
    @Override
    public CBC_RangeBookAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CBC_RangeBookAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        CBC_BookModal model = CBC_BookModalArrayList.get(position);
        holder.cbcVariableTV.setText(model.getLabel());
        holder.cbcDescriptionTV.setText("" + model.getDescription());
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return CBC_BookModalArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView cbcVariableTV, cbcDescriptionTV;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            cbcVariableTV = itemView.findViewById(R.id.label);
            cbcDescriptionTV = itemView.findViewById(R.id.description);
        }
    }
}
