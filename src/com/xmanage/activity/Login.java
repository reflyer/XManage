package com.xmanage.activity;

import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.os.Bundle;
import android.R.id;
import android.app.Activity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import com.xmanage.sqlite.*;

public class Login extends Activity implements OnClickListener {

	private Button loginButton;
	private EditText editTextName;
	private EditText editTextPwd;

	public Login() {
		// TODO 自动生成的构造函数存根
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		loginButton = (Button) findViewById(R.id.signin_button);
		loginButton.setOnClickListener(this);

		editTextName = (EditText) findViewById(R.id.username_edit);
		editTextPwd = (EditText) findViewById(R.id.password_edit);

		Log.i("TEST", "sssssssssssssssssssssssss");
	}

	@Override
	public void onClick(View v) {
		// TODO 自动生成的方法存根
		String stringName = editTextName.getText().toString().trim();
		String stringPwd = editTextPwd.getText().toString().trim();

		System.out.println("name: " + stringName);
		System.out.println("pwd: " + stringPwd);

		Log.i("TEST", "Creating DataBase: ");

/*		DatabaseUtil dbUtil = new DatabaseUtil(this);
		dbUtil.open();
		Cursor cursor = dbUtil.fetchAllStudents();
		if (cursor != null) {
			while (cursor.moveToNext()) {
				Log.i("Student", "Student Name: " + cursor.getString(1)
						+ " Grade " + cursor.getString(2));
			}
		}
		dbUtil.close();*/
		
		DatabaseUtil dbUtil = new DatabaseUtil(this);
		dbUtil.open();
		dbUtil.createStudent("admin", "admin");
		dbUtil.close();

	}

}
