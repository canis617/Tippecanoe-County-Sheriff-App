package com.example.tippecanoe_county_sheriff_app.email;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.tippecanoe_county_sheriff_app.R;

import static android.util.Log.d;

public class Email extends AppCompatActivity {

    private static final int AUTHORIZATION_CODE = 1993;
    private static final int ACCOUNT_CODE = 42;
    private static final int PERMISSION_REQUEST_CODE = 1;
    private AuthPreferences authPreferences;
    private AccountManager accountManager;

    private final String SCOPE = Constant.GMAIL_COMPOSE + " " + Constant.GMAIL_MODIFY + " " + Constant.MAIL_GOOGLE_COM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        d("jun","OnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_layout);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        String UpCategory = getIntent().getStringExtra("ButtonName");
        getSupportActionBar().setTitle(UpCategory);

        accountManager = AccountManager.get(this);
        authPreferences = new AuthPreferences(this);

        Button buttonSend = findViewById(R.id.button_send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checking
                //is the account is on the authPreferences?

                boolean existingAccount = false;

                int result = ContextCompat.checkSelfPermission(Email.this, Manifest.permission.GET_ACCOUNTS);
                if (result == PackageManager.PERMISSION_GRANTED){
                    Account[] accounts = accountManager.getAccountsByType("com.google");
                    for(Account tempaccount: accounts) {
                        if(tempaccount.name.equals(authPreferences.getUser())){
                            existingAccount = true;
                            d("jun", "Account Exist!");
                        }
                    }
                    if(!existingAccount){d("jun","No Account!");}
                }
                else{
                    d("jun","Permission Failed");
                    ActivityCompat.requestPermissions(Email.this, new String[]{Manifest.permission.GET_ACCOUNTS}, PERMISSION_REQUEST_CODE);
                }

                if (authPreferences.getUser() != null
                        && authPreferences.getToken() != null && existingAccount) {
                    doCoolAuthenticatedStuff();
                } else { chooseAccount(); }
            }
        });

    }

    private void doCoolAuthenticatedStuff() {
        new senmailAsync().execute();   //uncomment to send mail

    }

    private void chooseAccount() {
        Intent intent = AccountManager.newChooseAccountIntent(null, null,
                new String[]{"com.google"}, false, null, null, null, null);
        startActivityForResult(intent, ACCOUNT_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode ==  PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = AccountManager.newChooseAccountIntent(null, null,
                        new String[]{"com.google"}, false, null, null, null, null);
                startActivityForResult(intent, ACCOUNT_CODE);
            } else {
                Toast.makeText(this,"Permission Denied.",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    private void requestToken() {
        Account userAccount = null;
        String user = authPreferences.getUser();

        Account[] accounts = accountManager.getAccountsByType("com.google");
        for(Account account: accounts) {
            if (account.name.equals(user)) {
                userAccount = account;
                break;
            }
        }

        Bundle options = new Bundle();
        accountManager.getAuthToken(userAccount, "oauth2:" + SCOPE, options, this,
                new OnTokenAcquired(), null);
    }
    /**
     * call this method if your token expired, or you want to request a new
     * token for whatever reason. call requestToken() again afterwards in order
     * to get a new token.
     */
    private void invalidateToken() {
        AccountManager accountManager = AccountManager.get(this);
        accountManager.invalidateAuthToken("com.google", authPreferences.getToken());
        authPreferences.setToken(null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == AUTHORIZATION_CODE) { requestToken(); }
            else if (requestCode == ACCOUNT_CODE) {
                String accountName = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
                authPreferences.setUser(accountName);
                // invalidate old tokens which might be cached. we want a fresh
                // one, which is guaranteed to work
                invalidateToken();
                requestToken();
            }
        }
    }
    private class OnTokenAcquired implements AccountManagerCallback<Bundle> {

        @Override
        public void run(AccountManagerFuture<Bundle> result) {
            try {
                Bundle bundle = result.getResult();
                Intent launch = (Intent) bundle.get(AccountManager.KEY_INTENT);
                if (launch != null) { startActivityForResult(launch, AUTHORIZATION_CODE); }
                else {
                    String token = bundle.getString(AccountManager.KEY_AUTHTOKEN);
                    authPreferences.setToken(token);
                    doCoolAuthenticatedStuff();
                }
            }
            catch (Exception e) { throw new RuntimeException(e); }
        }
    }

    private class senmailAsync extends AsyncTask<Void, Void, Boolean> {
        private String subject,body,recipients;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            EditText mEditTextTo = findViewById(R.id.edit_text_to);
            EditText mEditTextSubject = findViewById(R.id.edit_text_subject);
            EditText mEditTextMessage = findViewById(R.id.edit_text_message);

            subject = mEditTextSubject.getText().toString();
            body = mEditTextMessage.getText().toString();
            recipients = mEditTextTo.getText().toString();
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            GMailSender gMailSender = new GMailSender();
            Boolean msgSend = gMailSender.sendMail(subject, body, authPreferences.getUser(), authPreferences.getToken(), recipients);
            return msgSend;
        }

        @Override
        protected void onPostExecute(Boolean msgSend){
            if(msgSend){
                Toast.makeText(getApplicationContext() ,"Message Sent", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
            else{ Toast.makeText(getApplicationContext() ,"Failed to Send Message", Toast.LENGTH_SHORT).show(); }
        }


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //
                onBackPressed();
                break;
        }
        return true;
    }

}

//To Alonzo
/*
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.*;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import static android.util.Log.d;

public class Email extends AppCompatActivity {
    private EditText mEditTextTo;
    private EditText mEditTextSubject;
    private EditText mEditTextMessage;
    private String UpCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_layout);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        UpCategory = getIntent().getStringExtra("ButtonName");
        d("jun",UpCategory);
        getSupportActionBar().setTitle(UpCategory);

        mEditTextTo = findViewById(R.id.edit_text_to);
        mEditTextSubject = findViewById(R.id.edit_text_subject);
        mEditTextMessage = findViewById(R.id.edit_text_message);


        Button buttonSend = findViewById(R.id.button_send);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });
    }
    private void sendMail(){
        String recipientList = mEditTextTo.getText().toString();
        String[] recipients = recipientList.split(",");
        // example1@gmail.com, exam2@gmail.com
        String subject = mEditTextSubject.getText().toString();
        String message = mEditTextMessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }


}
*/