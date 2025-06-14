// Generated by view binder compiler. Do not edit!
package com.nutriflex.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.nutriflex.app.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityProfileBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final MaterialButton btnLogout;

  @NonNull
  public final MaterialButton btnSave;

  @NonNull
  public final TextInputEditText etAge;

  @NonNull
  public final TextInputEditText etEmail;

  @NonNull
  public final TextInputEditText etHeight;

  @NonNull
  public final TextInputEditText etName;

  @NonNull
  public final TextInputEditText etPhone;

  @NonNull
  public final TextInputEditText etWeight;

  private ActivityProfileBinding(@NonNull LinearLayout rootView, @NonNull MaterialButton btnLogout,
      @NonNull MaterialButton btnSave, @NonNull TextInputEditText etAge,
      @NonNull TextInputEditText etEmail, @NonNull TextInputEditText etHeight,
      @NonNull TextInputEditText etName, @NonNull TextInputEditText etPhone,
      @NonNull TextInputEditText etWeight) {
    this.rootView = rootView;
    this.btnLogout = btnLogout;
    this.btnSave = btnSave;
    this.etAge = etAge;
    this.etEmail = etEmail;
    this.etHeight = etHeight;
    this.etName = etName;
    this.etPhone = etPhone;
    this.etWeight = etWeight;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnLogout;
      MaterialButton btnLogout = ViewBindings.findChildViewById(rootView, id);
      if (btnLogout == null) {
        break missingId;
      }

      id = R.id.btnSave;
      MaterialButton btnSave = ViewBindings.findChildViewById(rootView, id);
      if (btnSave == null) {
        break missingId;
      }

      id = R.id.etAge;
      TextInputEditText etAge = ViewBindings.findChildViewById(rootView, id);
      if (etAge == null) {
        break missingId;
      }

      id = R.id.etEmail;
      TextInputEditText etEmail = ViewBindings.findChildViewById(rootView, id);
      if (etEmail == null) {
        break missingId;
      }

      id = R.id.etHeight;
      TextInputEditText etHeight = ViewBindings.findChildViewById(rootView, id);
      if (etHeight == null) {
        break missingId;
      }

      id = R.id.etName;
      TextInputEditText etName = ViewBindings.findChildViewById(rootView, id);
      if (etName == null) {
        break missingId;
      }

      id = R.id.etPhone;
      TextInputEditText etPhone = ViewBindings.findChildViewById(rootView, id);
      if (etPhone == null) {
        break missingId;
      }

      id = R.id.etWeight;
      TextInputEditText etWeight = ViewBindings.findChildViewById(rootView, id);
      if (etWeight == null) {
        break missingId;
      }

      return new ActivityProfileBinding((LinearLayout) rootView, btnLogout, btnSave, etAge, etEmail,
          etHeight, etName, etPhone, etWeight);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
