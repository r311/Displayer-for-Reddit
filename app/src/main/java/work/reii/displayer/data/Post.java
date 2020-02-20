package work.reii.displayer.data;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("data")
    private PostData postData;

    public PostData getPostData() {
        return postData;
    }
}
