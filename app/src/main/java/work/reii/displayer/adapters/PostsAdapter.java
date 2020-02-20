package work.reii.displayer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import work.reii.displayer.viewholders.PostsHolder;
import work.reii.displayer.R;
import work.reii.displayer.data.Post;

public class PostsAdapter extends RecyclerView.Adapter<PostsHolder>{
    private ArrayList<Post> pos;
    Context context;

    public PostsAdapter(Context c, ArrayList<Post> pos) {
        this.context = c;
        this.pos = pos;
    }

    @NonNull
    @Override
    public PostsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_posts, parent, false);
        PostsHolder vh = new PostsHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(PostsHolder holder, int position) {
        final Post post = pos.get(position);
        //Log.d("post", String.valueOf(post.getTitle()));
        holder.title.setText(post.getPostData().getTitle());
    }

    @Override
    public int getItemCount() {
        if( pos != null){
            return pos.size();
        }
        else{
            return 0;
        }
    }
}
