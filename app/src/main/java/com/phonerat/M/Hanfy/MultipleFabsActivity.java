package com.phonerat.M.Hanfy;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class MultipleFabsActivity extends AppCompatActivity {
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout fab_default;
	private ImageView imageview1;
	private ImageView imageview2;
	private ImageView imageview3;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.multiple_fabs);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		fab_default = findViewById(R.id.fab_default);
		imageview1 = findViewById(R.id.imageview1);
		imageview2 = findViewById(R.id.imageview2);
		imageview3 = findViewById(R.id.imageview3);
	}
	
	private void initializeLogic() {
	}
	
}