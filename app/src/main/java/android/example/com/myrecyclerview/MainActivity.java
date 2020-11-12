package android.example.com.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
// Resources for adapter
    int[] images = {
            R.drawable.australia,R.drawable.bangladesh, R.drawable.bhutan,
            R.drawable.canada,R.drawable.denmark, R.drawable.egypt,
            R.drawable.finland,R.drawable.germany, R.drawable.honduras,
            R.drawable.india,R.drawable.japan, R.drawable.kenya,
    };

    // Resources for adapter
    private String[] title, descriptions;

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference of recyclerView
        recyclerView = findViewById(R.id.recyclerViewId);

        // get data from strings folder
        title = getResources().getStringArray(R.array.country_names);
        descriptions = getResources().getStringArray(R.array.country_decs);

        // Create an Object of adapter class to sent data to the adapter class
        myAdapter = new MyAdapter(this,title,descriptions,images);


        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // set adapter to the recyclerView
        recyclerView.setAdapter(myAdapter);

        myAdapter.setOnItemClickListener(new MyAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(getApplicationContext(),"onItem Click: " + position,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(int position, View view) {
                Toast.makeText(getApplicationContext(),"onItemLong Click: " + position,Toast.LENGTH_SHORT).show();


            }
        });

    }
}