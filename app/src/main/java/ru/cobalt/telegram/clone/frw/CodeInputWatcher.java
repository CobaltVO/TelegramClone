package ru.cobalt.telegram.clone.frw;

import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;

class CodeInputWatcher implements TextWatcher {

    private AppCompatEditText nextNumber;
    private Fragment context;

    public CodeInputWatcher(AppCompatEditText nextNumber, Fragment context) {
        this.nextNumber = nextNumber;
        this.context = context;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!s.toString().equals("")) {
            if (nextNumber != null) {
                nextNumber.requestFocus();
            } else {
                if (context instanceof CodeInputCompletedListener) {
                    ((CodeInputCompletedListener) context).onCodeInputCompleted();
                }
            }
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}
