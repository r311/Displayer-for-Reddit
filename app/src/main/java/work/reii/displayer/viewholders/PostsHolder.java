package work.reii.displayer.viewholders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import work.reii.displayer.R;

public class PostsHolder extends RecyclerView.ViewHolder {
    public View view;
    public TextView title;

    public PostsHolder(View view){
        super(view);
        this.view = view;
        title = view.findViewById(R.id.idTitleView);
    }
    /*@NonNull
    public PostsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_posts, parent, false);
        return new PostsHolder(view);
    }
    public  void onBindViewHolder(@NonNull PostsHolder holder, int position) {
    }*/
}
