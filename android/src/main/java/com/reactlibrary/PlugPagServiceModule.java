package com.reactlibrary;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import br.com.uol.pagseguro.plugpagservice.wrapper.PlugPag;
import br.com.uol.pagseguro.plugpagservice.wrapper.PlugPagActivationData;
import br.com.uol.pagseguro.plugpagservice.wrapper.PlugPagAppIdentification;
import br.com.uol.pagseguro.plugpagservice.wrapper.PlugPagInitializationResult;
import br.com.uol.pagseguro.plugpagservice.wrapper.PlugPagPaymentData;
import br.com.uol.pagseguro.plugpagservice.wrapper.PlugPagTransactionResult;

public class PlugPagServiceModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private ArrayList<PlugPagAppIdentificationWrapper> appIdentifications;
    private ArrayList<PlugPagWrapper> plugPags;

    public PlugPagServiceModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;

        appIdentifications = new ArrayList<>();
        plugPags = new ArrayList<>();
    }

    @Override
    public String getName() {
        return "PlugPagService";
    }


    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put("PlugPag", Collections.unmodifiableMap(new HashMap<String, Object>() {{
            put("NFC_RET_OK", PlugPag.NFC_RET_OK);
            put("A_VISTA_INSTALLMENT_QUANTITY", PlugPag.A_VISTA_INSTALLMENT_QUANTITY);
            put("AUTHENTICATION_FAILED", PlugPag.AUTHENTICATION_FAILED);
            put("BUFFER_SIZE_ERROR", PlugPag.BUFFER_SIZE_ERROR);
            put("DISABLED_FUNCTION", PlugPag.DISABLED_FUNCTION);
            put("INSTALLMENT_TYPE_A_VISTA", PlugPag.INSTALLMENT_TYPE_A_VISTA);
            put("INSTALLMENT_TYPE_PARC_COMPRADOR", PlugPag.INSTALLMENT_TYPE_PARC_COMPRADOR);
            put("INSTALLMENT_TYPE_PARC_VENDEDOR", PlugPag.INSTALLMENT_TYPE_PARC_VENDEDOR);
            put("INVALID_AMOUNT_FORMAT", PlugPag.INVALID_AMOUNT_FORMAT);
            put("INVALID_BUFFER_DATA", PlugPag.INVALID_BUFFER_DATA);
            put("INVALID_LENGTH_USER_REFERENCE", PlugPag.INVALID_LENGTH_USER_REFERENCE);
            put("MODE_PARTIAL_PAY", PlugPag.MODE_PARTIAL_PAY);
            put("NFC_RET_ERROR", PlugPag.NFC_RET_ERROR);
            put("NULL_AMOUNT", PlugPag.NULL_AMOUNT);
            put("NULL_APPLICATION_PARAMETER", PlugPag.NULL_APPLICATION_PARAMETER);
            put("NULL_TOTAL_AMOUNT", PlugPag.NULL_TOTAL_AMOUNT);
            put("NULL_TRANSACTION_RESULT", PlugPag.NULL_TRANSACTION_RESULT);
            put("NULL_USER_REFERENCE", PlugPag.NULL_USER_REFERENCE);
            put("PLUGPAG_ASYNC_CONFIRMATION", PlugPag.PLUGPAG_ASYNC_CONFIRMATION);
            put("PLUGPAG_ASYNC_METRICS", PlugPag.PLUGPAG_ASYNC_METRICS);
            put("PLUGPAG_CDCVM", PlugPag.PLUGPAG_CDCVM);
            put("PLUGPAG_CRASHLOG_SENDING", PlugPag.PLUGPAG_CRASHLOG_SENDING);
            put("PLUGPAG_PRE_PRINTING", PlugPag.PLUGPAG_PRE_PRINTING);
            put("POS_NOT_READY", PlugPag.POS_NOT_READY);
            put("RET_OK", PlugPag.RET_OK);
            put("SHARE_MODE_NOT_ALLOWED", PlugPag.SHARE_MODE_NOT_ALLOWED);
            put("TRANSACTION_DENIED", PlugPag.TRANSACTION_DENIED);
            put("TYPE_CREDITO", PlugPag.TYPE_CREDITO);
            put("TYPE_DEBITO", PlugPag.TYPE_DEBITO);
            put("TYPE_PIX", PlugPag.TYPE_PIX);
            put("TYPE_PREAUTO_CARD", PlugPag.TYPE_PREAUTO_CARD);
            put("TYPE_PREAUTO_KEYED", PlugPag.TYPE_PREAUTO_KEYED)
            put("TYPE_QRCODE", PlugPag.TYPE_QRCODE);
            put("TYPE_QRCODE_CREDITO", PlugPag.TYPE_QRCODE_CREDITO);
            put("TYPE_VOUCHER", PlugPag.TYPE_VOUCHER);
            put("VOID_PAYMENT", PlugPag.VOID_PAYMENT);
            put("VOID_QRCODE", PlugPag.VOID_QRCODE);
            put("OPERATION_ABORT", PlugPag.OPERATION_ABORT);
            put("OPERATION_ABORTED", PlugPag.OPERATION_ABORTED);
            put("OPERATION_ACTIVATE", PlugPag.OPERATION_ACTIVATE);
            put("OPERATION_CALCULATE_INSTALLMENTS", PlugPag.OPERATION_CALCULATE_INSTALLMENTS);
            put("OPERATION_CHECK_AUTHENTICATION", PlugPag.OPERATION_CHECK_AUTHENTICATION);
            put("OPERATION_DEACTIVATE", PlugPag.OPERATION_DEACTIVATE);
            put("OPERATION_GET_APPLICATION_CODE", PlugPag.OPERATION_GET_APPLICATION_CODE);
            put("OPERATION_GET_LIB_VERSION", PlugPag.OPERATION_GET_LIB_VERSION);
            put("OPERATION_GET_READER_INFOS", PlugPag.OPERATION_GET_READER_INFOS);
            put("OPERATION_GET_USER_DATA", PlugPag.OPERATION_GET_USER_DATA);
            put("OPERATION_HAS_CAPABILITY", PlugPag.OPERATION_HAS_CAPABILITY);
            put("OPERATION_INVALIDATE_AUTHENTICATION", PlugPag.OPERATION_INVALIDATE_AUTHENTICATION);
            put("OPERATION_NFC_ABORT", PlugPag.OPERATION_NFC_ABORT);
            put("OPERATION_NFC_READ", PlugPag.OPERATION_NFC_READ);
            put("OPERATION_NFC_WRITE", PlugPag.OPERATION_NFC_WRITE);
            put("OPERATION_PAYMENT", PlugPag.OPERATION_PAYMENT);
            put("OPERATION_PRINT", PlugPag.OPERATION_PRINT);
            put("OPERATION_QUERY_LAST_APPROVED_TRANSACTION", PlugPag.OPERATION_QUERY_LAST_APPROVED_TRANSACTION);
            put("OPERATION_REFUND", PlugPag.OPERATION_REFUND);
            put("OPERATION_REPRINT_CUSTOMER_RECEIPT", PlugPag.OPERATION_REPRINT_CUSTOMER_RECEIPT);
            put("OPERATION_REPRINT_STABLISHMENT_RECEIPT", PlugPag.OPERATION_REPRINT_STABLISHMENT_RECEIPT);
            put("ACTION_POST_OPERATION", PlugPag.ACTION_POST_OPERATION);
            put("ACTION_PRE_OPERATION", PlugPag.ACTION_PRE_OPERATION);
            put("ACTION_UPDATE", PlugPag.ACTION_UPDATE);
            put("APN_SERVICE_CLASS_NAME", PlugPag.APN_SERVICE_CLASS_NAME);
            put("APN_SERVICE_PACKAGE_NAME", PlugPag.APN_SERVICE_PACKAGE_NAME);
            put("AUTHENTICATION_FAILED", PlugPag.AUTHENTICATION_FAILED);
            put("COMMUNICATION_ERROR", PlugPag.COMMUNICATION_ERROR);
            put("ERROR_CODE_OK", PlugPag.ERROR_CODE_OK);
            put("MIN_PRINTER_STEPS", PlugPag.MIN_PRINTER_STEPS);
            put("NFC_SERVICE_CLASS_NAME", PlugPag.NFC_SERVICE_CLASS_NAME);
            put("NFC_SERVICE_PACKAGE_NAME", PlugPag.NFC_SERVICE_PACKAGE_NAME);
            put("NO_PRINTER_DEVICE", PlugPag.NO_PRINTER_DEVICE);
            put("NO_TRANSACTION_DATA", PlugPag.NO_TRANSACTION_DATA);
            put("SERVICE_CLASS_NAME", PlugPag.SERVICE_CLASS_NAME);
            put("SERVICE_PACKAGE_NAME", PlugPag.SERVICE_PACKAGE_NAME);
            put("SMART_RECHARGE_SERVICE_CLASS_NAME", PlugPag.SMART_RECHARGE_SERVICE_CLASS_NAME);
            put("SMART_RECHARGE_SERVICE_PACKAGE_NAME", PlugPag.SMART_RECHARGE_SERVICE_PACKAGE_NAME);
            put("RET_OK", PlugPag.RET_OK);
        }}));

        return constants;
    }

    // Cria a identificação do aplicativo
    @ReactMethod
    public void getAppIdendification(String name, String version, Callback callback) {
        PlugPagAppIdentificationWrapper appIdentification = new PlugPagAppIdentificationWrapper(name, version);
        appIdentifications.add(appIdentification);
        callback.invoke(appIdentification.tag);
    }

    // Cria a referência do PlugPag
    @ReactMethod
    public void getPlugPag(String appId, Callback successCallback, Callback errorCallback) {
        PlugPagAppIdentificationWrapper appIdWrapper = null;
        for (PlugPagAppIdentificationWrapper appIdentification: appIdentifications) {
            if (appIdentification.equals(appId)) {
                appIdWrapper = appIdentification;
                break;
            }
        }
        if (appIdWrapper != null) {
            PlugPagWrapper plugpag = new PlugPagWrapper(reactContext, appIdWrapper.appIdentification);
            this.plugPags.add(plugpag);
            successCallback.invoke(plugpag.tag);
        } else {
            errorCallback.invoke("Can't find app Identification");
        }
    }

    // Ativa terminal e faz o pagamento
    @ReactMethod
    public void initializeAndActivatePinpad(String plugPagId, String jsonStr, Callback successCallback, Callback errorCallback) {
        PlugPagActivationData activationData = JsonParseUtils.getPlugPagActivationDataFromJson(jsonStr);
        if (activationData != null) {

            PlugPagWrapper plugPagWrapper = null;

            for (PlugPagWrapper wrapper: plugPags) {
                if (wrapper.equals(plugPagId)) {
                    plugPagWrapper = wrapper;
                    break;
                }
            }

            if (plugPagWrapper != null) {
                PlugPagInitializationResult initResult = plugPagWrapper.plugPag.initializeAndActivatePinpad(activationData);
                successCallback.invoke(initResult.getResult());
            } else {
                errorCallback.invoke("Can't find plugPag");
            }
        } else {
            errorCallback.invoke("PlugPagActivationData error");
        }
    }

    @ReactMethod
    public void doPayment(String plugPagId, String jsonStr, Callback successCallback, Callback errorCallback) {
        PlugPagPaymentData paymentData = JsonParseUtils.getPlugPagPaymentDataFromJson(jsonStr);
        if (paymentData != null) {

            PlugPagWrapper plugPagWrapper = null;

            for (PlugPagWrapper wrapper: plugPags) {
                if (wrapper.equals(plugPagId)) {
                    plugPagWrapper = wrapper;
                    break;
                }
            }

            if (plugPagWrapper != null) {
                PlugPagTransactionResult transactionResult = plugPagWrapper.plugPag.doPayment(paymentData);
                successCallback.invoke(transactionResult.getResult());
            } else {
                errorCallback.invoke("Can't find plugPag");
            }
        } else {
            errorCallback.invoke("PlugPagPaymentData error");
        }
    }

}
