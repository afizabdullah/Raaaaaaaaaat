package com.phonerat.M.Hanfy;

import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.media.MediaPlayer;
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
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.webkit.*;
import android.widget.*;
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
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> upd = new HashMap<>();
	
	private LinearLayout Background;
	private TextView textview1;
	private LinearLayout WhiteBackground;
	private TextView textview2;
	private ImageView Logo;
	
	private TimerTask timer;
	private ObjectAnimator ob = new ObjectAnimator();
	private ObjectAnimator ob2 = new ObjectAnimator();
	private Intent intent = new Intent();
	private MediaPlayer m;
	private OnCompleteListener message_onCompleteListener;
	private DatabaseReference up = _firebase.getReference("up");
	private ChildEventListener _up_child_listener;
	private Notification noti;
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	private SharedPreferences passw;
	private AlertDialog.Builder d;
	private DatabaseReference papp = _firebase.getReference("papp");
	private ChildEventListener _papp_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		Background = findViewById(R.id.Background);
		textview1 = findViewById(R.id.textview1);
		WhiteBackground = findViewById(R.id.WhiteBackground);
		textview2 = findViewById(R.id.textview2);
		Logo = findViewById(R.id.Logo);
		net = new RequestNetwork(this);
		passw = getSharedPreferences("passw", Activity.MODE_PRIVATE);
		d = new AlertDialog.Builder(this);
		
		WhiteBackground.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		message_onCompleteListener = new OnCompleteListener<InstanceIdResult>() {
			@Override
			public void onComplete(Task<InstanceIdResult> task) {
				final boolean _success = task.isSuccessful();
				final String _token = task.isSuccessful() ? task.getResult().getToken() : "";
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_up_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		up.addChildEventListener(_up_child_listener);
		
		_net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				if (textview2.getText().toString().equals(passw.getString("pW", ""))) {
					intent.setClass(getApplicationContext(), HomeActivity.class);
					startActivity(intent);
					m = MediaPlayer.create(getApplicationContext(), R.raw.hello);
					m.start();
					SketchwareUtil.showMessage(getApplicationContext(), "(\"Hello Friend 🙂🖤🍂\")");
					finish();
				} else {
					intent.setClass(getApplicationContext(), HostActivity.class);
					startActivity(intent);
					finish();
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				d.setMessage("انت غير متصل بالانترنت 🚫🤦‍♂️");
				d.setCancelable(false);
				d.setPositiveButton("ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						finishAffinity();
					}
				});
				d.create().show();
			}
		};
		
		_papp_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.get("pW").toString().equals("")) {
					
				} else {
					textview2.setText(_childValue.get("pW").toString());
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
		papp.addChildEventListener(_papp_child_listener);
	}
	
	private void initializeLogic() {
		WhiteBackground.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)500, 0xFFFFFFFF));
		// Set You Logo //
		Logo.setImageResource(R.drawable.logo);
		// Animation //
		_Scale(WhiteBackground, ob, ob2, 0, 3, 1000);
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						_Scale(Logo, ob, ob2, 0, 0.45d, 500);
						timer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										_Scale(Logo, ob, ob2, 0.45d, 0.35d, 500);
										timer = new TimerTask() {
											@Override
											public void run() {
												runOnUiThread(new Runnable() {
													@Override
													public void run() {
														net.startRequestNetwork(RequestNetworkController.GET, "https://api.db-ip.com/v2/free/self", "", _net_request_listener);
													}
												});
											}
										};
										_timer.schedule(timer, (int)(1500));
									}
								});
							}
						};
						_timer.schedule(timer, (int)(500));
					}
				});
			}
		};
		_timer.schedule(timer, (int)(1000));
	}
	
	public void _Scale(final View _view, final ObjectAnimator _ob1, final ObjectAnimator _ob2, final double _from, final double _to, final double _duration) {
		_ob1.setTarget(_view);
		_ob1.setPropertyName("scaleX");
		_ob1.setFloatValues((float)(_from), (float)(_to));
		_ob1.setDuration((int)(_duration));
		_ob1.start();
		_ob2.setTarget(_view);
		_ob2.setPropertyName("scaleY");
		_ob2.setFloatValues((float)(_from), (float)(_to));
		_ob2.setDuration((int)(_duration));
		_ob2.start();
	}
	
	
	public void _TransY(final View _view, final ObjectAnimator _ob, final double _from, final double _to, final double _duration) {
		_ob.setTarget(_view);
		_ob.setPropertyName("translationY");
		_ob.setFloatValues((float)(_from), (float)(_to));
		_ob.setDuration((int)(_duration));
		_ob.start();
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
	
	
	public void _radius(final String _color1, final String _color2, final double _str, final double _n1, final double _n2, final double _n3, final double _n4, final View _view) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_color1));
		
		gd.setStroke((int)_str, Color.parseColor(_color2));
		
		gd.setCornerRadii(new float[]{(int)_n1,(int)_n1,(int)_n2,(int)_n2,(int)_n3,(int)_n3,(int)_n4,(int)_n4});
		
		_view.setBackground(gd);
	}
	
	
	public void _radius_4(final String _color1, final String _color2, final double _str, final double _n1, final double _n2, final double _n3, final double _n4, final View _view) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_color1));
		
		gd.setStroke((int)_str, Color.parseColor(_color2));
		
		gd.setCornerRadii(new float[]{(int)_n1,(int)_n1,(int)_n2,(int)_n2,(int)_n3,(int)_n3,(int)_n4,(int)_n4});
		
		_view.setBackground(gd);
		
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#FFFFFF")}), gd, null);
		_view.setBackground(RE);
	}
	
}