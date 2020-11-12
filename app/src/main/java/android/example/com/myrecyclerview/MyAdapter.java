package android.example.com.myrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private static ClickListener clickListener;
    // (1) Declare variable for all items that need to be received from MainActivity.
    Context context;
    String[] title, desc;
    int[] images;

    // (2)Create a constructor to receive data from MainActivity
    public MyAdapter(Context context, String[] title, String[] desc, int[] images) {
        this.context = context;
        this.title = title;
        this.desc = desc;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // (3) First convert the sample_layout xml file to java object and sent it to MyhViewHolder class
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.sample_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //
    // (7) Now we can set all item to the view that we received from MainActivity through above
        // constructor by taking help of holder(MyViewHolder) object
        holder.titleTextView.setText(title[position]);
        holder.descTextView.setText(desc[position]);
        holder.flagImageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }
    // For click event need to implement OnClickListener & OnLongClickListener
    public class MyViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        // (4) Declare variable to hold every item from the sample_layout (converted to view)
        TextView titleTextView;
        TextView descTextView;
        ImageView flagImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // (6) Now we have the converted layout (view) and need to find every item of the view
            titleTextView = itemView.findViewById(R.id.title_textView_id);
            descTextView = itemView.findViewById(R.id.description_textView_id);
            flagImageView = itemView.findViewById(R.id.my_view_id);
            // set listener to the view
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(),view);

        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onItemLongClick(getAdapterPosition(),view);
            return false;
        }
    }
    // create an interface for click event
    public interface ClickListener{
        void onItemClick(int position, View view);
        void onItemLongClick(int position, View view);
    }
    public void setOnItemClickListener(ClickListener clickListener){
        MyAdapter.clickListener = clickListener;

    }
}
