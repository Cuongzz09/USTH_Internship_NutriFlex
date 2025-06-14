// Generated by view binder compiler. Do not edit!
package com.nutriflex.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.nutriflex.app.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMeBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final ImageView ivEditWeight;

  @NonNull
  public final SeekBar seekBarWeight;

  @NonNull
  public final TextView tvWeightValue;

  private FragmentMeBinding(@NonNull ScrollView rootView, @NonNull ImageView ivEditWeight,
      @NonNull SeekBar seekBarWeight, @NonNull TextView tvWeightValue) {
    this.rootView = rootView;
    this.ivEditWeight = ivEditWeight;
    this.seekBarWeight = seekBarWeight;
    this.tvWeightValue = tvWeightValue;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_me, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ivEditWeight;
      ImageView ivEditWeight = ViewBindings.findChildViewById(rootView, id);
      if (ivEditWeight == null) {
        break missingId;
      }

      id = R.id.seekBarWeight;
      SeekBar seekBarWeight = ViewBindings.findChildViewById(rootView, id);
      if (seekBarWeight == null) {
        break missingId;
      }

      id = R.id.tvWeightValue;
      TextView tvWeightValue = ViewBindings.findChildViewById(rootView, id);
      if (tvWeightValue == null) {
        break missingId;
      }

      return new FragmentMeBinding((ScrollView) rootView, ivEditWeight, seekBarWeight,
          tvWeightValue);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
