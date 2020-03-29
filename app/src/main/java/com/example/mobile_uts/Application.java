package com.example.mobile_uts;

import com.example.mobile_uts.Models.Account;
import com.example.mobile_uts.Models.Session;

public class Application extends android.app.Application{
    private static Account account;
    private static Session session;

    @Override
    public void onCreate() {
        super.onCreate();
        account = new Account();
        session = new Session(this);
    }

    public static Account getAccount() {
        return account;
    }
    public static Session getSession() {
        return session;
    }
}
