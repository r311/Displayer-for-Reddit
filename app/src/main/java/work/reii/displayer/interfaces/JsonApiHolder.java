package work.reii.displayer.interfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import work.reii.displayer.data.Body;
import work.reii.displayer.data.Post;

public interface JsonApiHolder {

    @GET("hot")
    Call<Body> getPosts();
}
