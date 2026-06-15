package com.phonerat.M.Hanfy;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.Editable;
import android.text.TextWatcher;
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

public class CommentActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map_like = new HashMap<>();
	private HashMap<String, Object> put_like = new HashMap<>();
	private HashMap<String, Object> map_feed = new HashMap<>();
	private String push_key = "";
	private double likes = 0;
	private double num_like = 0;
	private double n = 0;
	private double n_ls_like = 0;
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lm_like = new ArrayList<>();
	private ArrayList<String> ls_like = new ArrayList<>();
	
	private LinearLayout linear3;
	private LinearLayout linear2;
	private ListView listview1;
	private LinearLayout linear1;
	private TextView textview1;
	private EditText edittext1;
	private LinearLayout linear4;
	private ImageView imageview1;
	
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
	private DatabaseReference feed = _firebase.getReference("feed");
	private ChildEventListener _feed_child_listener;
	private DatabaseReference Like = _firebase.getReference("Like_key");
	private ChildEventListener _Like_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.comment);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear3 = findViewById(R.id.linear3);
		linear2 = findViewById(R.id.linear2);
		listview1 = findViewById(R.id.listview1);
		linear1 = findViewById(R.id.linear1);
		textview1 = findViewById(R.id.textview1);
		edittext1 = findViewById(R.id.edittext1);
		linear4 = findViewById(R.id.linear4);
		imageview1 = findViewById(R.id.imageview1);
		auth = FirebaseAuth.getInstance();
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (edittext1.getText().toString().length() > 30) {
					edittext1.setText(edittext1.getText().toString().substring((int)(0), (int)(30)));
					edittext1.setError("لا بمكن كتابة أكثر من ٣٠ حرف");
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext1.getText().toString().equals("")) {
					
				} else {
					push_key = feed.push().getKey();
					map_feed.put("push key", push_key);
					map_feed.put("message", edittext1.getText().toString());
					map_feed.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					map_feed.put(FirebaseAuth.getInstance().getCurrentUser().getUid(), "uid");
					feed.child(push_key).updateChildren(map_feed);
					put_like = new HashMap<>();
					put_like.put(push_key, "push key");
					Like.child(push_key).updateChildren(put_like);
					edittext1.setText("");
				}
			}
		});
		
		_feed_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				feed.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								listmap.add(_map);
							}
						} catch (Exception _e) {
							_e.printStackTrace();
						}
						_SortMap(listmap, "push key", false, false);
						listview1.setAdapter(new Listview1Adapter(listmap));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
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
		feed.addChildEventListener(_feed_child_listener);
		
		_Like_child_listener = new ChildEventListener() {
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
		Like.addChildEventListener(_Like_child_listener);
		
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
		Window w = this.getWindow();w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(Color.parseColor("#CFD8DC"));
		w.setNavigationBarColor(Color.parseColor("#CFD8DC"));
		feed.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot _dataSnapshot) {
				listmap = new ArrayList<>();
				try {
					GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
					for (DataSnapshot _data : _dataSnapshot.getChildren()) {
						HashMap<String, Object> _map = _data.getValue(_ind);
						listmap.add(_map);
					}
				} catch (Exception _e) {
					_e.printStackTrace();
				}
				_SortMap(listmap, "push key", false, false);
				listview1.setAdapter(new Listview1Adapter(listmap));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
			}
			@Override
			public void onCancelled(DatabaseError _databaseError) {
			}
		});
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/fnty.ttf"), 0);
		_exit(linear2, "#CFD8DC", "#CFD8DC", 0, 0, "#CFD8DC");
		_bott(linear1, "#CFD8DC", "#CFD8DC", 0, 0, "#CFD8DC");
		_rippleRoundStroke(edittext1, "#ECEFF1", "#ECEFF1", 40, 0, "#ECEFF1");
		_rippleRoundStroke(linear4, "#ECEFF1", "#ECEFF1", 50, 0, "#ECEFF1");
	}
	
	public void _SortMap(final ArrayList<HashMap<String, Object>> _listMap, final String _key, final boolean _isNumber, final boolean _Ascending) {
		Collections.sort(_listMap, new Comparator<HashMap<String,Object>>(){
			public int compare(HashMap<String,Object> _compareMap1, HashMap<String,Object> _compareMap2){
				if (_isNumber) {
					int _count1 = Integer.valueOf(_compareMap1.get(_key).toString());
					int _count2 = Integer.valueOf(_compareMap2.get(_key).toString());
					if (_Ascending) {
						return _count1 < _count2 ? -1 : _count1 < _count2 ? 1 : 0;
					} else {
						return _count1 > _count2 ? -1 : _count1 > _count2 ? 1 : 0;
					}
				} else {
					if (_Ascending) {
						return (_compareMap1.get(_key).toString()).compareTo(_compareMap2.get(_key).toString());
					} else {
						return (_compareMap2.get(_key).toString()).compareTo(_compareMap1.get(_key).toString());
					}
				}
			}});
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
	
	
	public void _exit(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		
		
		
		GG.setCornerRadii(new float[] { 0, 0, 0, 0, 50, 50, 50, 50 }); //LeftTop, //RightTop, //RightBottom, //LeftBottom,
		
		
		
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _bott(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		
		
		
		GG.setCornerRadii(new float[] { 50, 50, 50, 50, 0, 0, 0, 0 }); //LeftTop, //RightTop, //RightBottom, //LeftBottom,
		
		
		
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
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
				_view = _inflater.inflate(R.layout.post, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			
			textview1.setText(listmap.get((int)_position).get("message").toString());
			Animation animation;
			animation = AnimationUtils.loadAnimation(
			getApplicationContext(), android.R.anim.slide_in_left
			);
			animation.setDuration(300); linear1.startAnimation(animation); animation = null;
			imageview1.setColorFilter(0xFF607D8B, PorterDuff.Mode.MULTIPLY);
			Like.addListenerForSingleValueEvent(new ValueEventListener() {
				@Override
				public void onDataChange(DataSnapshot _dataSnapshot) {
					lm_like = new ArrayList<>();
					try {
						GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
						for (DataSnapshot _data : _dataSnapshot.getChildren()) {
							HashMap<String, Object> _map = _data.getValue(_ind);
							lm_like.add(_map);
						}
					} catch (Exception _e) {
						_e.printStackTrace();
					}
					textview2.setText(String.valueOf((long)(0)));
					map_like.clear();
					ls_like.clear();
					num_like = 0;
					for(int _repeat26 = 0; _repeat26 < (int)(lm_like.size()); _repeat26++) {
						if (lm_like.get((int)num_like).containsKey(listmap.get((int)_position).get("push key").toString())) {
							map_like = lm_like.get((int)num_like);
							SketchwareUtil.getAllKeysFromMap(map_like, ls_like);
							likes = 0;
							n_ls_like = 0;
							if (map_like.containsKey(FirebaseAuth.getInstance().getCurrentUser().getUid()) && map_like.get(FirebaseAuth.getInstance().getCurrentUser().getUid()).toString().equals("true")) {
								imageview1.setColorFilter(0xFF2196F3, PorterDuff.Mode.MULTIPLY);
								imageview1.setImageResource(R.drawable.ic_thumb_up_white);
							}
							for(int _repeat47 = 0; _repeat47 < (int)(ls_like.size()); _repeat47++) {
								if (map_like.get(ls_like.get((int)(n_ls_like))).toString().equals("true")) {
									likes++;
									textview2.setText(String.valueOf((long)(likes)));
								}
								n_ls_like++;
							}
							if (!map_like.containsKey(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
								imageview1.setColorFilter(0xFF607D8B, PorterDuff.Mode.MULTIPLY);
								imageview1.setImageResource(R.drawable.ic_thumb_up_white);
							}
						}
						num_like++;
					}
				}
				@Override
				public void onCancelled(DatabaseError _databaseError) {
				}
			});
			imageview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					Like.addListenerForSingleValueEvent(new ValueEventListener() {
						@Override
						public void onDataChange(DataSnapshot _dataSnapshot) {
							lm_like = new ArrayList<>();
							try {
								GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
								for (DataSnapshot _data : _dataSnapshot.getChildren()) {
									HashMap<String, Object> _map = _data.getValue(_ind);
									lm_like.add(_map);
								}
							} catch (Exception _e) {
								_e.printStackTrace();
							}
							num_like = 0;
							for(int _repeat69 = 0; _repeat69 < (int)(lm_like.size()); _repeat69++) {
								if (lm_like.get((int)num_like).containsKey(listmap.get((int)_position).get("push key").toString())) {
									map_like = lm_like.get((int)num_like);
									SketchwareUtil.getAllKeysFromMap(map_like, ls_like);
									likes = 0;
									n_ls_like = 0;
									for(int _repeat81 = 0; _repeat81 < (int)(ls_like.size()); _repeat81++) {
										if (map_like.get(ls_like.get((int)(n_ls_like))).toString().equals("true")) {
											likes++;
										}
										n_ls_like++;
									}
									if (map_like.containsKey(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
										if (map_like.get(FirebaseAuth.getInstance().getCurrentUser().getUid()).toString().equals("true")) {
											put_like.put(FirebaseAuth.getInstance().getCurrentUser().getUid(), "false");
											put_like.put(listmap.get((int)_position).get("push key").toString(), "post id");
											Like.child(listmap.get((int)_position).get("push key").toString()).updateChildren(put_like);
											likes--;
											textview2.setText(String.valueOf((long)(likes)));
											imageview1.setColorFilter(0xFF607D8B, PorterDuff.Mode.MULTIPLY);
											imageview1.setImageResource(R.drawable.ic_thumb_up_white);
										} else {
											if (map_like.get(FirebaseAuth.getInstance().getCurrentUser().getUid()).toString().equals("false")) {
												imageview1.setColorFilter(0xFF2196F3, PorterDuff.Mode.MULTIPLY);
												imageview1.setImageResource(R.drawable.ic_thumb_up_white);
												put_like.put(FirebaseAuth.getInstance().getCurrentUser().getUid(), "true");
												put_like.put(listmap.get((int)_position).get("push key").toString(), "post id");
												Like.child(listmap.get((int)_position).get("push key").toString()).updateChildren(put_like);
												likes++;
												textview2.setText(String.valueOf((long)(likes)));
											}
										}
									} else {
										imageview1.setColorFilter(0xFF2196F3, PorterDuff.Mode.MULTIPLY);
										imageview1.setImageResource(R.drawable.ic_thumb_up_white);
										put_like.put(FirebaseAuth.getInstance().getCurrentUser().getUid(), "true");
										put_like.put(listmap.get((int)_position).get("push key").toString(), "post id");
										Like.child(listmap.get((int)_position).get("push key").toString()).updateChildren(put_like);
										likes++;
										textview2.setText(String.valueOf((long)(likes)));
									}
								}
								num_like++;
							}
							put_like.clear();
						}
						@Override
						public void onCancelled(DatabaseError _databaseError) {
						}
					});
				}
			});
			textview3.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", textview3.getText().toString()));
					SketchwareUtil.showMessage(getApplicationContext(), "copied  تم التسخ");
				}
			});
			
			return _view;
		}
	}
}