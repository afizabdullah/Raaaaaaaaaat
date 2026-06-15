package com.phonerat.M.Hanfy;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class ViewActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private double position = 0;
	private String push_key = "";
	
	private ArrayList<HashMap<String, Object>> mapp = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> map1 = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private ScrollView vscroll1;
	private ImageView imageview1;
	private LinearLayout linear25;
	private LinearLayout linear26;
	private LinearLayout linear27;
	private TextView textview1;
	private TextView textview8;
	private LinearLayout linear3;
	private LinearLayout linear31;
	private LinearLayout linear42;
	private LinearLayout linear45;
	private LinearLayout linear28;
	private LinearLayout linear13;
	private LinearLayout linear33;
	private LinearLayout linear39;
	private LinearLayout linear36;
	private LinearLayout linear41;
	private LinearLayout linear14;
	private LinearLayout linear15;
	private LinearLayout linear23;
	private LinearLayout linear16;
	private LinearLayout linear17;
	private TextView textview12;
	private LinearLayout linear43;
	private LinearLayout linear44;
	private TextView textview21;
	private ImageView imageview20;
	private TextView Ftextview17;
	private ImageView imageview21;
	private ImageView imageview22;
	private LinearLayout linear47;
	private TextView textview18;
	private TextView textview20;
	private LinearLayout linear48;
	private TextView textview22;
	private LinearLayout linear29;
	private LinearLayout linear32;
	private ImageView imageview11;
	private TextView Ftextview10;
	private ImageView imageview12;
	private ImageView imageview13;
	private TextView textview11;
	private LinearLayout linear34;
	private LinearLayout linear35;
	private ImageView imageview14;
	private TextView Ftextview13;
	private ImageView imageview15;
	private ImageView imageview16;
	private TextView textview14;
	private LinearLayout linear37;
	private LinearLayout linear38;
	private ImageView imageview17;
	private TextView Ftextview15;
	private ImageView imageview18;
	private ImageView imageview19;
	private TextView textview16;
	private LinearLayout linear20;
	private ListView listview1;
	private TextView textview2;
	private ImageView imageview2;
	private TextView Ftextview3;
	private ImageView imageview3;
	private ImageView imageview4;
	private LinearLayout linear24;
	private LinearLayout linear18;
	private ImageView imageview8;
	private TextView Ftextview7;
	private ImageView imageview9;
	private ImageView imageview10;
	private TextView textview6;
	private LinearLayout linear19;
	private LinearLayout linear21;
	private LinearLayout linear22;
	private TextView textview4;
	private ImageView imageview5;
	private TextView Ftextview5;
	private ImageView imageview6;
	private ImageView imageview7;
	
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
	private Intent i = new Intent();
	private DatabaseReference mzk = _firebase.getReference("mzk");
	private ChildEventListener _mzk_child_listener;
	private DatabaseReference Fmt = _firebase.getReference("Fmt");
	private ChildEventListener _Fmt_child_listener;
	private DatabaseReference WPe = _firebase.getReference("WPe");
	private ChildEventListener _WPe_child_listener;
	private DatabaseReference Hg = _firebase.getReference("Hg");
	private ChildEventListener _Hg_child_listener;
	private DatabaseReference Ggg = _firebase.getReference("Ggg");
	private ChildEventListener _Ggg_child_listener;
	private DatabaseReference Dee = _firebase.getReference("Dee");
	private ChildEventListener _Dee_child_listener;
	private DatabaseReference Wee = _firebase.getReference("Wee");
	private ChildEventListener _Wee_child_listener;
	private DatabaseReference Mmm = _firebase.getReference("Mmm");
	private ChildEventListener _Mmm_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.view);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		vscroll1 = findViewById(R.id.vscroll1);
		imageview1 = findViewById(R.id.imageview1);
		linear25 = findViewById(R.id.linear25);
		linear26 = findViewById(R.id.linear26);
		linear27 = findViewById(R.id.linear27);
		textview1 = findViewById(R.id.textview1);
		textview8 = findViewById(R.id.textview8);
		linear3 = findViewById(R.id.linear3);
		linear31 = findViewById(R.id.linear31);
		linear42 = findViewById(R.id.linear42);
		linear45 = findViewById(R.id.linear45);
		linear28 = findViewById(R.id.linear28);
		linear13 = findViewById(R.id.linear13);
		linear33 = findViewById(R.id.linear33);
		linear39 = findViewById(R.id.linear39);
		linear36 = findViewById(R.id.linear36);
		linear41 = findViewById(R.id.linear41);
		linear14 = findViewById(R.id.linear14);
		linear15 = findViewById(R.id.linear15);
		linear23 = findViewById(R.id.linear23);
		linear16 = findViewById(R.id.linear16);
		linear17 = findViewById(R.id.linear17);
		textview12 = findViewById(R.id.textview12);
		linear43 = findViewById(R.id.linear43);
		linear44 = findViewById(R.id.linear44);
		textview21 = findViewById(R.id.textview21);
		imageview20 = findViewById(R.id.imageview20);
		Ftextview17 = findViewById(R.id.Ftextview17);
		imageview21 = findViewById(R.id.imageview21);
		imageview22 = findViewById(R.id.imageview22);
		linear47 = findViewById(R.id.linear47);
		textview18 = findViewById(R.id.textview18);
		textview20 = findViewById(R.id.textview20);
		linear48 = findViewById(R.id.linear48);
		textview22 = findViewById(R.id.textview22);
		linear29 = findViewById(R.id.linear29);
		linear32 = findViewById(R.id.linear32);
		imageview11 = findViewById(R.id.imageview11);
		Ftextview10 = findViewById(R.id.Ftextview10);
		imageview12 = findViewById(R.id.imageview12);
		imageview13 = findViewById(R.id.imageview13);
		textview11 = findViewById(R.id.textview11);
		linear34 = findViewById(R.id.linear34);
		linear35 = findViewById(R.id.linear35);
		imageview14 = findViewById(R.id.imageview14);
		Ftextview13 = findViewById(R.id.Ftextview13);
		imageview15 = findViewById(R.id.imageview15);
		imageview16 = findViewById(R.id.imageview16);
		textview14 = findViewById(R.id.textview14);
		linear37 = findViewById(R.id.linear37);
		linear38 = findViewById(R.id.linear38);
		imageview17 = findViewById(R.id.imageview17);
		Ftextview15 = findViewById(R.id.Ftextview15);
		imageview18 = findViewById(R.id.imageview18);
		imageview19 = findViewById(R.id.imageview19);
		textview16 = findViewById(R.id.textview16);
		linear20 = findViewById(R.id.linear20);
		listview1 = findViewById(R.id.listview1);
		textview2 = findViewById(R.id.textview2);
		imageview2 = findViewById(R.id.imageview2);
		Ftextview3 = findViewById(R.id.Ftextview3);
		imageview3 = findViewById(R.id.imageview3);
		imageview4 = findViewById(R.id.imageview4);
		linear24 = findViewById(R.id.linear24);
		linear18 = findViewById(R.id.linear18);
		imageview8 = findViewById(R.id.imageview8);
		Ftextview7 = findViewById(R.id.Ftextview7);
		imageview9 = findViewById(R.id.imageview9);
		imageview10 = findViewById(R.id.imageview10);
		textview6 = findViewById(R.id.textview6);
		linear19 = findViewById(R.id.linear19);
		linear21 = findViewById(R.id.linear21);
		linear22 = findViewById(R.id.linear22);
		textview4 = findViewById(R.id.textview4);
		imageview5 = findViewById(R.id.imageview5);
		Ftextview5 = findViewById(R.id.Ftextview5);
		imageview6 = findViewById(R.id.imageview6);
		imageview7 = findViewById(R.id.imageview7);
		auth = FirebaseAuth.getInstance();
		
		imageview21.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear44.setVisibility(View.GONE);
				imageview21.setVisibility(View.GONE);
				imageview22.setVisibility(View.VISIBLE);
				
			}
		});
		
		imageview22.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview21.setVisibility(View.VISIBLE);
				imageview22.setVisibility(View.GONE);
				linear44.setVisibility(View.VISIBLE);
				
			}
		});
		
		textview18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				push_key = Ggg.push().getKey();
				map = new HashMap<>();
				map.put("puid", textview21.getText().toString());
				Ggg.child(push_key).updateChildren(map);
				map.clear();
				SketchwareUtil.showMessage(getApplicationContext(), "جاري تنفيذ الامر 💀🦾⚡......");
			}
		});
		
		textview22.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), VimgActivity.class);
				i.putExtra("email", textview21.getText().toString());
				startActivity(i);
			}
		});
		
		imageview12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview12.setVisibility(View.GONE);
				linear32.setVisibility(View.GONE);
				imageview13.setVisibility(View.VISIBLE);
			}
		});
		
		imageview13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear32.setVisibility(View.VISIBLE);
				imageview12.setVisibility(View.VISIBLE);
				imageview13.setVisibility(View.GONE);
			}
		});
		
		textview11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				push_key = Dee.push().getKey();
				map = new HashMap<>();
				map.put("puid", textview21.getText().toString());
				Dee.child(push_key).updateChildren(map);
				map.clear();
				SketchwareUtil.showMessage(getApplicationContext(), "جاري تنفيذ الامر 💀🦾⚡......");
			}
		});
		
		imageview15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview15.setVisibility(View.GONE);
				imageview16.setVisibility(View.VISIBLE);
				linear35.setVisibility(View.GONE);
			}
		});
		
		imageview16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview15.setVisibility(View.VISIBLE);
				imageview16.setVisibility(View.GONE);
				linear35.setVisibility(View.VISIBLE);
			}
		});
		
		textview14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				push_key = Wee.push().getKey();
				map = new HashMap<>();
				map.put("puid", textview21.getText().toString());
				Wee.child(push_key).updateChildren(map);
				map.clear();
				SketchwareUtil.showMessage(getApplicationContext(), "جاري تنفيذ الامر 💀🦾⚡......");
			}
		});
		
		imageview18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview18.setVisibility(View.GONE);
				imageview19.setVisibility(View.VISIBLE);
				linear38.setVisibility(View.GONE);
			}
		});
		
		imageview19.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview18.setVisibility(View.VISIBLE);
				imageview19.setVisibility(View.GONE);
				linear38.setVisibility(View.VISIBLE);
			}
		});
		
		textview16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				push_key = Mmm.push().getKey();
				map = new HashMap<>();
				map.put("puid", textview21.getText().toString());
				Mmm.child(push_key).updateChildren(map);
				map.clear();
				SketchwareUtil.showMessage(getApplicationContext(), "جاري تنفيذ الامر 💀🦾⚡......");
			}
		});
		
		textview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				textview2.setVisibility(View.GONE);
				imageview3.setVisibility(View.GONE);
				imageview4.setVisibility(View.VISIBLE);
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview4.setVisibility(View.GONE);
				imageview3.setVisibility(View.VISIBLE);
				textview2.setVisibility(View.VISIBLE);
			}
		});
		
		imageview9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview9.setVisibility(View.GONE);
				imageview10.setVisibility(View.VISIBLE);
				textview6.setVisibility(View.GONE);
			}
		});
		
		imageview10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview9.setVisibility(View.VISIBLE);
				imageview10.setVisibility(View.GONE);
				textview6.setVisibility(View.VISIBLE);
			}
		});
		
		imageview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview6.setVisibility(View.GONE);
				imageview7.setVisibility(View.VISIBLE);
				textview4.setVisibility(View.GONE);
			}
		});
		
		imageview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview6.setVisibility(View.VISIBLE);
				imageview7.setVisibility(View.GONE);
				textview4.setVisibility(View.VISIBLE);
			}
		});
		
		_mzk_child_listener = new ChildEventListener() {
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
		mzk.addChildEventListener(_mzk_child_listener);
		
		_Fmt_child_listener = new ChildEventListener() {
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
		Fmt.addChildEventListener(_Fmt_child_listener);
		
		_WPe_child_listener = new ChildEventListener() {
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
		WPe.addChildEventListener(_WPe_child_listener);
		
		_Hg_child_listener = new ChildEventListener() {
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
		Hg.addChildEventListener(_Hg_child_listener);
		
		_Ggg_child_listener = new ChildEventListener() {
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
		Ggg.addChildEventListener(_Ggg_child_listener);
		
		_Dee_child_listener = new ChildEventListener() {
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
		Dee.addChildEventListener(_Dee_child_listener);
		
		_Wee_child_listener = new ChildEventListener() {
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
		Wee.addChildEventListener(_Wee_child_listener);
		
		_Mmm_child_listener = new ChildEventListener() {
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
		Mmm.addChildEventListener(_Mmm_child_listener);
		
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
		Ftextview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_regular.ttf"), 0);
		Ftextview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/raleway_regular.ttf"), 0);
		Ftextview10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/fnty.ttf"), 0);
		Ftextview13.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/fnty.ttf"), 0);
		Ftextview15.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/fnty.ttf"), 0);
		Ftextview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/fnty.ttf"), 0);
		Ftextview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/fnty.ttf"), 0);
		Ftextview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/fnty.ttf"), 0);
		Ftextview17.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/fnty.ttf"), 0);
		textview2.setVisibility(View.GONE);
		imageview3.setVisibility(View.GONE);
		textview4.setVisibility(View.GONE);
		textview6.setVisibility(View.GONE);
		imageview6.setVisibility(View.GONE);
		imageview9.setVisibility(View.GONE);
		linear32.setVisibility(View.GONE);
		imageview12.setVisibility(View.GONE);
		linear35.setVisibility(View.GONE);
		linear38.setVisibility(View.GONE);
		imageview15.setVisibility(View.GONE);
		imageview18.setVisibility(View.GONE);
		linear44.setVisibility(View.GONE);
		imageview21.setVisibility(View.GONE);
		_rippleRoundStroke(linear33, "#E0E0E0", "#E0E0E0", 25, 0, "#E0E0E0");
		_rippleRoundStroke(linear36, "#E0E0E0", "#E0E0E0", 25, 0, "#E0E0E0");
		_rippleRoundStroke(linear14, "#E0E0E0", "#E0E0E0", 25, 0, "#E0E0E0");
		_rippleRoundStroke(linear21, "#E0E0E0", "#E0E0E0", 25, 0, "#E0E0E0");
		_rippleRoundStroke(linear23, "#E0E0E0", "#E0E0E0", 25, 0, "#E0E0E0");
		_rippleRoundStroke(linear28, "#E0E0E0", "#E0E0E0", 25, 0, "#E0E0E0");
		_rippleRoundStroke(linear42, "#E0E0E0", "#E0E0E0", 25, 0, "#E0E0E0");
		textview2.setText(getIntent().getStringExtra("sm"));
		textview4.setText(getIntent().getStringExtra("inf"));
		textview6.setText(getIntent().getStringExtra("CoT"));
		textview21.setText(FirebaseAuth.getInstance().getCurrentUser().getUid());
		_rippleRoundStroke(textview11, "#FF0000", "#E0E0E0", 40, 0, "#E0E0E0");
		_rippleRoundStroke(textview14, "#FF0000", "#E0E0E0", 40, 0, "#E0E0E0");
		_rippleRoundStroke(textview16, "#FF0000", "#E0E0E0", 40, 0, "#E0E0E0");
		_rippleRoundStroke(textview18, "#FF0000", "#E0E0E0", 40, 0, "#E0E0E0");
		_rippleRoundStroke(textview22, "#FFFFFF", "#E0E0E0", 40, 1, "#FF0000");
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
	
	
	public void _dialog() {
		final AlertDialog dialog = new AlertDialog.Builder(ViewActivity.this).create();LayoutInflater inflater = getLayoutInflater();
		View convertView = (View) inflater.inflate(R.layout.custome, null);
		dialog.setView(convertView);
		LinearLayout l1 = (LinearLayout)convertView.findViewById(R.id.linear1);
		ListView ls = new ListView(this);
		
		ls.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT));
		ls.setAdapter(new Listview1Adapter(mapp));
		
		l1.addView(ls);
		ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {	@Override	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {		
				position = position;
			}});
		dialog.show();
	}
	//action
	private ListView ls;
	{
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
				_view = _inflater.inflate(R.layout.viewhk, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			
			textview1.setText(mapp.get((int)_position).get("body").toString());
			textview2.setText(mapp.get((int)_position).get("address").toString());
			
			return _view;
		}
	}
}