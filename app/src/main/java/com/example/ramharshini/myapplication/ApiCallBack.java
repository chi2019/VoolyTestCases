package com.example.ramharshini.myapplication;

import java.util.ArrayList;

public interface ApiCallBack
{
        void onSuccess(ArrayList<? extends Object> result, String tag);
        void onError(Throwable e, String tag);
}

