import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN_DELAY = 2000; // Waktu tampilan splash screen (dalam milidetik)
    private ListView userListView;
    private ImageView splashImage;

    private String[] userNames = {"John Doe", "Jane Smith", "David Johnson"};
    private String[] userEmails = {"john.doe@example.com", "jane.smith@example.com", "david.johnson@example.com"};
    private String[] userDepartments = {"Computer Science", "Electrical Engineering", "Business Administration"};
    private String[] userSemesters = {"3rd Semester", "5th Semester", "2nd Semester"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splashImage = findViewById(R.id.splashImage);
        userListView = findViewById(R.id.userListView);

        // Tampilkan tampilan splash screen selama beberapa waktu sebelum menampilkan daftar pengguna
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                splashImage.setVisibility(android.view.View.GONE);
                userListView.setVisibility(android.view.View.VISIBLE);

                // Set data pengguna ke dalam ListView
                ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,
                        android.R.layout.simple_list_item_1, userNames);
                userListView.setAdapter(adapter);
            }
        }, SPLASH_SCREEN_DELAY);
    }
}
