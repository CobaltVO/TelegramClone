package ru.cobalt.telegram.clone.frw;

import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.widget.AppCompatEditText;

class CodeWatcher implements TextWatcher {

    private AppCompatEditText nextNumber;

    public CodeWatcher(AppCompatEditText nextNumber) {
        this.nextNumber = nextNumber;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (!s.toString().equals("")) {
            if (nextNumber != null) {
                nextNumber.requestFocus();
            }
        }
    }
}
