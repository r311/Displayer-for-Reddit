package work.reii.displayer.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import work.reii.displayer.R;
import work.reii.displayer.adapters.PostsAdapter;
import work.reii.displayer.data.Body;
import work.reii.displayer.data.Post;
import work.reii.displayer.interfaces.JsonApiHolder;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private ArrayList<Post> gotPosts;
    private RecyclerView rvPosts;
    private RecyclerView.Adapter adapter;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.idTitleView);
        this.rvPosts = (RecyclerView)findViewById(R.id.idRecyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        this.rvPosts.setLayoutManager(mLayoutManager);

        gotPosts = new ArrayList<Post>();

        //get request
        Retrofit retrofit = new Retrofit.Builder()
                //.baseUrl("https://jsonplaceholder.typicode.com/")
                .baseUrl("https://api.reddit.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonApiHolder jsonApiHolder = retrofit.create(JsonApiHolder.class);

        //call object
        Call<Body> call = jsonApiHolder.getPosts();

        call.enqueue(new Callback<Body>() {
            @Override
            public void onResponse(Call<Body> call, Response<Body> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Body: " + response.code());
                    return;
                }
                //List<Post> posts = response.body();
                Body body = response.body();
                adapter = new PostsAdapter(context, new ArrayList<Post>(body.getData().getPosts()));
                rvPosts.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Body> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
