package com.phonerat.M.Hanfy;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class VimgActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> mapp = new ArrayList<>();
	private ArrayList<String> s = new ArrayList<>();
	
	private LinearLayout linear11;
	private LinearLayout linear12;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private TextView textview29;
	private TextView textview30;
	private ListView listview1;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear7;
	private LinearLayout linear9;
	private TextView textview25;
	private TextView textview26;
	private TextView textview27;
	private LinearLayout linear10;
	private TextView textview28;
	private TextView textview1;
	private EditText edittext3;
	
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	private DatabaseReference passimg = _firebase.getReference("passimg");
	private ChildEventListener _passimg_child_listener;
	private Intent i = new Intent();
	private SharedPreferences spg;
	private DatabaseReference HKIMG = _firebase.getReference("HKIMG");
	private ChildEventListener _HKIMG_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.vimg);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear11 = findViewById(R.id.linear11);
		linear12 = findViewById(R.id.linear12);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		textview29 = findViewById(R.id.textview29);
		textview30 = findViewById(R.id.textview30);
		listview1 = findViewById(R.id.listview1);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		linear7 = findViewById(R.id.linear7);
		linear9 = findViewById(R.id.linear9);
		textview25 = findViewById(R.id.textview25);
		textview26 = findViewById(R.id.textview26);
		textview27 = findViewById(R.id.textview27);
		linear10 = findViewById(R.id.linear10);
		textview28 = findViewById(R.id.textview28);
		textview1 = findViewById(R.id.textview1);
		edittext3 = findViewById(R.id.edittext3);
		auth = FirebaseAuth.getInstance();
		spg = getSharedPreferences("spg", Activity.MODE_PRIVATE);
		
		textview25.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext3.getText().toString().equals(textview26.getText().toString())) {
					linear3.setVisibility(View.GONE);
					linear2.setVisibility(View.VISIBLE);
					spg.edit().putString("pas", textview26.getText().toString()).commit();
				} else {
					edittext3.setError("error password 💀🤦‍♂️❌");
				}
			}
		});
		
		textview28.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse(textview27.getText().toString()));
				startActivity(i);
			}
		});
		
		_passimg_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				textview26.setText(_childValue.get("passimg").toString());
				textview27.setText(_childValue.get("link").toString());
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		passimg.addChildEventListener(_passimg_child_listener);
		
		_HKIMG_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.get("Puid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					HKIMG.addListenerForSingleValueEvent(new ValueEventListener() {
						@Override
						public void onDataChange(DataSnapshot _dataSnapshot) {
							mapp = new ArrayList<>();
							try {
								GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
								for (DataSnapshot _data : _dataSnapshot.getChildren()) {
									HashMap<String, Object> _map = _data.getValue(_ind);
									mapp.add(_map);
								}
							} catch (Exception _e) {
								_e.printStackTrace();
							}
							Collections.reverse(mapp);
							listview1.setAdapter(new Listview1Adapter(mapp));
							((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						}
						@Override
						public void onCancelled(DatabaseError _databaseError) {
						}
					});
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		HKIMG.addChildEventListener(_HKIMG_child_listener);
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		_ColorShadow_SDK28(linear4, "#FF0000", 30);
		_ColorShadow_SDK28(textview25, "#FF0000", 30);
		_rippleRoundStroke(textview25, "#000000", "#FF0000", 40, 2, "#FF0000");
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/station.ttf"), 0);
		textview25.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_regular.ttf"), 0);
		textview29.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hacked.ttf"), 0);
		textview30.setText(getIntent().getStringExtra("email"));
		if (spg.getString("pas", "").equals(textview26.getText().toString())) {
			linear2.setVisibility(View.VISIBLE);
			linear3.setVisibility(View.GONE);
		} else {
			linear2.setVisibility(View.GONE);
			linear3.setVisibility(View.VISIBLE);
		}
	}
	
	public void _ColorShadow_SDK28(final View _view, final String _color, final double _number) {
		_view.setElevation((float)_number);
		
		_view.setOutlineAmbientShadowColor(Color.parseColor(_color));
		_view.setOutlineSpotShadowColor(Color.parseColor(_color));
	}
	
	
	public void _rippleRoundStroke(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _Downloader(final String _url, final String _path) {
		FileUtil.makeDir(FileUtil.getPackageDataDir(getApplicationContext()));
		android.net.ConnectivityManager connMgr = (android.net.ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		android.net.NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected()) {
			
			
			final String urlDownload = _url;
			
			DownloadManager.Request request = new DownloadManager.Request(Uri.parse(urlDownload));
			
			final String fileName = URLUtil.guessFileName(urlDownload, null, null);
			
			request.setDescription("Download Processing...");
			
			request.setTitle(fileName);
			
			request.allowScanningByMediaScanner();
			
			request.setDestinationInExternalPublicDir(_path, fileName);
			
			final DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
			
			final long downloadId = manager.enqueue(request);
			
			final ProgressDialog prog = new ProgressDialog(this);
			prog.setMax(100);
			prog.setIndeterminate(true);
			prog.setCancelable(false);
			prog.setCanceledOnTouchOutside(false);
			prog.setTitle("Start Downloading");
			
			new Thread(new Runnable() {
				@Override
				public void run() {
					
					boolean downloading = true;
					
					while (downloading) {
						
						DownloadManager.Query q = new DownloadManager.Query();
						
						q.setFilterById(downloadId);
						
						android.database.Cursor cursor = manager.query(q);
						
						cursor.moveToFirst();
						
						int bytes_downloaded = cursor.getInt(cursor .getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
						
						int bytes_total = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
						
						if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
							
							downloading = false;
							
						}
						
						final int dl_progress = (int) ((bytes_downloaded * 100l) / bytes_total);
						
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								
								prog.setTitle("Download Processing.");
								prog.setMessage("Start " + dl_progress + "/100 ");
								prog.show();
								if (dl_progress == 100) {
									prog.dismiss();
									showMessage("Download Complete.");
								}
							} });
					} } }).start();
			
		} else {
			showMessage("Check internet connection...");
		}
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.imgg, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			
			Glide.with(getApplicationContext()).load(Uri.parse(mapp.get((int)_position).get("pathimg").toString())).into(imageview1);
			Animation animation;
			animation = AnimationUtils.loadAnimation(
			getApplicationContext(), android.R.anim.slide_in_left
			);
			animation.setDuration(300); linear1.startAnimation(animation); animation = null;
			_ColorShadow_SDK28(textview2, "#FF0000", 30);
			_rippleRoundStroke(textview2, "#000000", "#FF0000", 40, 1, "#FF0000");
			_rippleRoundStroke(linear1, "#000000", "#FF0000", 20, 1, "#FF0000");
			textview2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					_Downloader(mapp.get((int)_position).get("pathimg").toString(), FileUtil.getExternalStorageDir().concat(FileUtil.getPublicDir(Environment.DIRECTORY_DCIM)));
				}
			});
			
			return _view;
		}
	}
}