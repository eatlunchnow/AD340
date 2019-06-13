package com.zoom.kiki.outofline;

import android.support.annotation.NonNull;
import android.text.TextUtils;

public class ValidationTest {

    public ValidationTest() {

    }

    public boolean isEmailValid(@NonNull String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                .matches();
    }


    public boolean isPasswordValid(@NonNull String password) {
        return !TextUtils.isEmpty(password);
    }

    public boolean isNameValid(@NonNull String name) {
        return !TextUtils.isEmpty(name);
    }
}
