package work.reii.displayer.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Body {

    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }
}
