package work.reii.displayer.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Data {
    @SerializedName("children")
    private ArrayList<Post> posts;

    public ArrayList<Post> getPosts() {
        return posts;
    }
}
