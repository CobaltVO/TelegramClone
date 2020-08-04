package ru.cobalt.telegram.clone;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public abstract class BasicFragment extends Fragment {

    private final int layout;

    public BasicFragment(int layoutId) {
        layout = layoutId;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(layout, container, false);
    }

    protected void changeFragment(Fragment newFragment) {
        getParentFragmentManager().beginTransaction()
                .replace(R.id.main_container, newFragment)
                .commit();
    }

    protected void changeFragment(Fragment newFragment, String addToBackStackName) {
        getParentFragmentManager().beginTransaction()
                .replace(R.id.main_container, newFragment)
                .addToBackStack(addToBackStackName)
                .commit();
    }

    protected void showKeyboard(@NonNull View fragmentView, View editTextView) {
        editTextView.requestFocus();

        InputMethodManager imm = (InputMethodManager) fragmentView.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.showSoftInput(editTextView, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    protected void goToPreviousFragment() {
        getParentFragmentManager().popBackStack();
    }

    protected void setToolbarName(@NonNull View view, String toolbarName) {
        AppCompatTextView title = view.findViewById(R.id.toolbar_title);
        title.setText(toolbarName);
    }

    protected Toolbar addBackButtonToToolbar(@NonNull View view) {
        Toolbar toolbar = view.findViewById(R.id.frw_layout_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        return toolbar;
    }

    protected void removeBackButtonToToolbar(@NonNull View view) {
        Toolbar toolbar = view.findViewById(R.id.frw_layout_toolbar);
        toolbar.setNavigationIcon(null);
    }
}
