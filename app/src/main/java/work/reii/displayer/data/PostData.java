package work.reii.displayer.data;

import com.google.gson.annotations.SerializedName;

public class PostData {

    @SerializedName("title")
    private String title;


    public String getTitle() {
        return title;
    }
}
