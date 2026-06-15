package com.phonerat.M.Hanfy;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blogspot.atifsoftwares.animatoolib.*;
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
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class PassActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String s = "";
	private double n = 0;
	private double number = 0;
	private HashMap<String, Object> mapp = new HashMap<>();
	
	private LinearLayout linear1;
	private TextView passW;
	private TextView link;
	private ImageView imageview1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private TextView textview28;
	private LinearLayout linear5;
	private TextView textview29;
	private TextView textview1;
	private EditText edittext1;
	
	private TimerTask t;
	private Intent i = new Intent();
	private TimerTask tt;
	private DatabaseReference papp = _firebase.getReference("papp");
	private ChildEventListener _papp_child_listener;
	private SharedPreferences passw;
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
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.pass);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		passW = findViewById(R.id.passW);
		link = findViewById(R.id.link);
		imageview1 = findViewById(R.id.imageview1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		textview28 = findViewById(R.id.textview28);
		linear5 = findViewById(R.id.linear5);
		textview29 = findViewById(R.id.textview29);
		textview1 = findViewById(R.id.textview1);
		edittext1 = findViewById(R.id.edittext1);
		passw = getSharedPreferences("passw", Activity.MODE_PRIVATE);
		auth = FirebaseAuth.getInstance();
		
		textview28.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.hideKeyboard(getApplicationContext());
				imageview1.setVisibility(View.VISIBLE);
				linear2.setVisibility(View.GONE);
				tt = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								if (edittext1.getText().toString().equals(passW.getText().toString())) {
									if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
										i.setClass(getApplicationContext(), HomeActivity.class);
										passw.edit().putString("pW", passW.getText().toString()).commit();
										startActivity(i);
										finish();
									} else {
										i.setClass(getApplicationContext(), HostActivity.class);
										passw.edit().putString("pW", passW.getText().toString()).commit();
										startActivity(i);
										finish();
									}
								} else {
									imageview1.setVisibility(View.GONE);
									linear2.setVisibility(View.VISIBLE);
									SketchwareUtil.showMessage(getApplicationContext(), "error password ❌....");
								}
							}
						});
					}
				};
				_timer.schedule(tt, (int)(800));
			}
		});
		
		textview29.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse(link.getText().toString()));
				startActivity(i);
			}
		});
		
		_papp_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.get("pW").toString().equals("")) {
					
				} else {
					passW.setText(_childValue.get("pW").toString());
				}
				link.setText(_childValue.get("link").toString());
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
		papp.addChildEventListener(_papp_child_listener);
		
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
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hacked.ttf"), 0);
		textview28.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/station.ttf"), 0);
		textview29.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/station.ttf"), 0);
		number = 0;
		imageview1.setVisibility(View.GONE);
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						number++;
						imageview1.setRotation((float)(number));
						if ((number == 360) || (number > 360)) {
							number = 0;
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(t, (int)(0), (int)(3));
		_rippleRoundStroke(linear2, "#FFFFFF", "#FFFFFF", 20, 0, "#FFFFFF");
		_ColorShadow_SDK28(linear2, "#FF0000", 30);
		_ColorShadow_SDK28(textview28, "#FF0000", 30);
		_rippleRoundStroke(textview28, "#FF0000", "#FFFFFF", 40, 0, "#FFFFFF");
		_rippleRoundStroke(textview29, "#FFFFFF", "#FFFFFF", 40, 1, "#FF0000");
		_ColorShadow_SDK28(textview29, "#FF0000", 30);
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
	
	
	public void _ColorShadow_SDK28(final View _view, final String _color, final double _number) {
		_view.setElevation((float)_number);
		
		_view.setOutlineAmbientShadowColor(Color.parseColor(_color));
		_view.setOutlineSpotShadowColor(Color.parseColor(_color));
	}
	
}