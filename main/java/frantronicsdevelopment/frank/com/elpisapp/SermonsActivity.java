package frantronicsdevelopment.frank.com.elpisapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Response;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SermonsActivity extends AppCompatActivity {



   // private List<Track> mListItems;
   // private SCTrackAdapter mAdapter;

    private TextView mSelectedTrackTitle;
    private ImageView mSelectedTrackImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sermons_main_activity);

       // mListItems = new ArrayList<Track>();
        ListView listView = findViewById(R.id.track_list_view);
       // mAdapter = new SCTrackAdapter(this, mListItems);
       // listView.setAdapter(mAdapter);

        mSelectedTrackTitle = findViewById(R.id.selected_track_title);
        mSelectedTrackImage = findViewById(R.id.selected_track_image);

        /**
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Track track = mListItems.get(position);

                mSelectedTrackTitle.setText(track.getTitle());
                Picasso.with(SermonsActivity.this).load(track.getArtworkURL()).into(mSelectedTrackImage);

            }
        });
        SCService scService = SoundCloud.getService();

        scService.getRecentTracks("last_week").enqueue(new Callback<List<Track>>() {
            @Override
            public void onResponse(Call<List<Track>> call, Response<List<Track>> response) {
                if (response.isSuccessful()) {
                    List<Track> tracks = response.body();
                    loadTracks(tracks);
                } else {
                    showMessage("Error code " + response.code());
                }
            }


            @Override
            public void onFailure(Call<List<Track>> call, Throwable t) {
                showMessage("Network Error: " +  t.getMessage());
            }
        });
        */

    }

    private void showMessage(String message) {
        Toast.makeText(SermonsActivity.this, message, Toast.LENGTH_LONG).show();
    }

//    private void loadTracks(List<Track> tracks) {
//        mListItems.clear();
//        mListItems.addAll(tracks);
//        mAdapter.notifyDataSetChanged();
//    }
}
