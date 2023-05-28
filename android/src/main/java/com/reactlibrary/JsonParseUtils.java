package com.reactlibrary;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.uol.pagseguro.plugpagservice.wrapper.PlugPagActivationData;
import br.com.uol.pagseguro.plugpagservice.wrapper.PlugPagPaymentData;

public class JsonParseUtils {
    public static PlugPagActivationData getPlugPagActivationDataFromJson(String jsonStr) {
        try {
            JSONObject object = new JSONObject(jsonStr);
            String activationCode = object.getString("activationCode");

            PlugPagActivationData activationData = new PlugPagActivationData(activationCode);
            return activationData;
        } catch (JSONException e) {
            Log.d("Json Parse", "PlugPagActivationData parse error");
            return null;
        }
    }

    public static PlugPagPaymentData getPlugPagPaymentDataFromJson(String jsonStr) {
        try {
            JSONObject object = new JSONObject(jsonStr);
            int amount = object.getInt("amount");
            int installmentType = object.getInt("installmentType");
            int installments = object.getInt("installments");
            int type = object.getInt("type");
            String userReference = object.getString("userReference");

            PlugPagPaymentData paymentData = new PlugPagPaymentData(type, amount, installmentType, installments, userReference);
            return paymentData;
        } catch (JSONException e) {
            Log.d("Json Parse", "PlugPagPaymentData parse error");
            return null;
        }
    }
}
