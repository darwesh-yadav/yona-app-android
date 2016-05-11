/*
 *  Copyright (c) 2016 Stichting Yona Foundation
 *
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  License, v. 2.0. If a copy of the MPL was not distributed with this
 *  file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 *
 */

package nu.yona.app.ui.profile;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import nu.yona.app.R;
import nu.yona.app.YonaApplication;
import nu.yona.app.api.manager.APIManager;
import nu.yona.app.customview.YonaFontEditTextView;
import nu.yona.app.customview.YonaPhoneWatcher;
import nu.yona.app.utils.AppConstant;

/**
 * Created by kinnarvasa on 10/05/16.
 */
public class EditDetailsProfileFragment extends BaseProfileFragment {
    private YonaFontEditTextView name, nickName, mobileNumber;
    private TextInputLayout nameLayout, nickNameLayout, mobileNumberLayout;
    private ImageView profileImage, updateProfileImage;
    private View.OnClickListener listener;
    private TextWatcher textWatcher;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.edit_profile_detail_fragment, null);


        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageChooser();
            }
        };
        textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                hideErrorMessages();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        inflateView(view);

        activity.getRightIcon().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNext();
            }
        });

        return view;
    }

    private void inflateView(View view) {

        nameLayout = (TextInputLayout) view.findViewById(R.id.name_layout);
        nickNameLayout = (TextInputLayout) view.findViewById(R.id.nick_name_layout);
        mobileNumberLayout = (TextInputLayout) view.findViewById(R.id.mobile_number_layout);

        name = (YonaFontEditTextView) view.findViewById(R.id.name);
        name.addTextChangedListener(textWatcher);

        nickName = (YonaFontEditTextView) view.findViewById(R.id.nick_name);
        nickName.addTextChangedListener(textWatcher);

        mobileNumber = (YonaFontEditTextView) view.findViewById(R.id.mobile_number);
        mobileNumber.setText(R.string.country_code_with_zero);
        mobileNumber.requestFocus();
        activity.showKeyboard(mobileNumber);
        mobileNumber.setNotEditableLength(getString(R.string.country_code_with_zero).length());
        mobileNumber.addTextChangedListener(new YonaPhoneWatcher(mobileNumber, getString(R.string.country_code_with_zero), getActivity(), mobileNumberLayout));

        nickName.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    goToNext();
                }
                return false;
            }
        });

        profileImage = (ImageView) view.findViewById(R.id.profileImage);
        profileImage.setOnClickListener(listener);

        updateProfileImage = (ImageView) view.findViewById(R.id.updateProfileImage);
        updateProfileImage.setOnClickListener(listener);
    }

    @Override
    public void onResume() {
        super.onResume();
        setTitleAndIcon();
        profileViewMode();
    }

    private void goToNext() {
        if (validateFields()) {
            updateUserProfile();
        }
    }

    private void setTitleAndIcon() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                activity.getLeftIcon().setVisibility(View.GONE);
                activity.updateTitle(R.string.edit_profile);
                activity.getRightIcon().setVisibility(View.VISIBLE);
                activity.getRightIcon().setImageDrawable(activity.getDrawable(R.drawable.icn_create));
            }
        }, AppConstant.TIMER_DELAY_HUNDRED);

    }

    private void profileViewMode() {
        profileImage.setBackground(getImage(true));

        name.setText(getString(R.string.full_name, YonaApplication.getUser().getFirstName(), YonaApplication.getUser().getLastName()));
        nickName.setText(YonaApplication.getUser().getNickname());
        int NUMBER_LENGTH = 9;

        String number = YonaApplication.getUser().getMobileNumber();
        if (!TextUtils.isEmpty(number)) {
            number = number.substring(number.length() - NUMBER_LENGTH);
            number = number.substring(0, 3) + getString(R.string.space) + number.substring(3, 6) + getString(R.string.space) + number.substring(6, 9);
            mobileNumber.setText(getString(R.string.country_code_with_zero) + number);
        }
        activity.showKeyboard(name);
        name.requestFocus();
    }


    private void openImageChooser() {
        //TODO open camera or allow to choose from device memory
    }

    private boolean validateFields() {
        String number = getString(R.string.country_code) + mobileNumber.getText().toString().substring(getString(R.string.country_code_with_zero).length());
        String phonenumber = number.replace(" ", "");
        if (!APIManager.getInstance().getAuthenticateManager().validateText(name.getText().toString())) {
            nameLayout.setErrorEnabled(true);
            nameLayout.setError(getString(R.string.enternamevalidation));
            activity.showKeyboard(name);
            name.requestFocus();
            return false;
        } else if (!APIManager.getInstance().getAuthenticateManager().validateText(nickName.getText().toString())) {
            nickNameLayout.setErrorEnabled(true);
            nickNameLayout.setError(getString(R.string.enternicknamevalidation));
            activity.showKeyboard(nickName);
            nickName.requestFocus();
            return false;
        } else if (!APIManager.getInstance().getAuthenticateManager().validateMobileNumber(phonenumber)) {
            mobileNumberLayout.setErrorEnabled(true);
            mobileNumberLayout.setError(getString(R.string.enternumbervalidation));
            activity.showKeyboard(mobileNumber);
            mobileNumber.requestFocus();
            return false;
        }
        return true;
    }

    private void hideErrorMessages() {
        nameLayout.setError(null);
        nickNameLayout.setError(null);
        mobileNumberLayout.setError(null);
    }

    private void updateUserProfile() {
        //TODO API Call of PUT /user via AuthenticateManager
    }
}