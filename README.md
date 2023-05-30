# React-Native-Plugin Pagseguro

## A react-native plugin to connect pagseguro to your machine credit card using react-native, machine-credit-card like a "morderninha" or other's.


## Getting started

```sh
  npm install react-native-plug-pag-service --save
```

### Mostly automatic installation

```sh
  react-native link react-native-plug-pag-service
```

### Manual installation

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.reactlibrary.PlugPagServicePackage;` to the imports at the top of the file
  - Add `new PlugPagServicePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-plug-pag-service'
  	project(':react-native-plug-pag-service').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-plug-pag-service/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-plug-pag-service')
  	```
4. AndroidManifest.xml
  - Permissions
	To integrate the library with the PlugPagService library in Android applications you must add the following permission to AndroidManifest.xml.
	```
	<uses-permission android:name="br.com.uol.pagseguro.permission.MANAGE_PAYMENTS"/>
	```

	This permission allows the library to bind to PlugPagService , Moderninha Smart's embedded service , which manages all payment transactions.

  - Intent-filter
	In order for your app to be chosen as the default payment app and receive Card Insertion Intents, you need to add the following code to your AndroidManifest.xml within your main Activity.
	```
	<intent-filter>
	      <action android:name="br.com.uol.pagseguro.PAYMENT"/>
	      <category android:name="android.intent.category.DEFAULT"/>
	</intent-filter>
	```

## Usage
```javascript
import PlugPagService, { PlugPag, PlugPagPaymentData, PlugPagActivationData } from 'rn-pagseguro-plugin';
```

## Enums

| Parameter | Description                       |
| :-------- |:--------------------------------  |
| `A_VISTA_INSTALLMENT_QUANTITY` | Default installment quantity for cash sales. |
| `AUTHENTICATION_FAILED` | Code used when PlugPagService is not enabled. |
| `BUFFER_SIZE_ERROR` | Code used to indicate transaction message generation failure due to buffer size. |
| `COMMUNICATION_ERROR` | Code used for communication errors. |
| `DISABLED_FUNCTION` | Code used to indicate that a given functionality is not available for the terminal. |
| `ERROR_CODE_OK` | Code used for successful transaction. |
| `INSTALLMENT_TYPE_A_VISTA` | Installment type: Cash. |
| `INSTALLMENT_TYPE_PARC_COMPRADOR` | Installment type: Buyer installment. |
| `INSTALLMENT_TYPE_PARC_VENDEDOR` | Installment type: Seller installment. |
| `INVALID_AMOUNT_FORMAT` | Code used to indicate that the transaction amount is invalid, possibly due to a typing or formatting error. |
| `INVALID_BUFFER_DATA` | Code used to indicate that the response buffer is invalid and needs to be reestablished. |
| `INVALID_LENGTH_USER_REFERENCE` | Code used to indicate that the sale code exceeds the size limit (10 characters). |
| `MIN_PRINTER_STEPS` | Minimum number of lines printed after the printing process finishes. |
| `MODE_PARTIAL_PAY` | Code used for partial payment. |
| `NFC_RET_ERROR` | Code used to indicate NFC operation failure. |
| `NFC_RET_OK` | Code used to indicate success in NFC operations. |
| `NO_PRINTER_DEVICE` | Code used when no printer is available on the device. |
| `NO_TRANSACTION_DATA` | Code used for transaction without data. |
| `NULL_AMOUNT` | Code used to indicate that the transaction amount is null. |
| `NULL_APPLICATION_PARAMETER` | Code used to indicate that the application parameter is null. |
| `NULL_TOTAL_AMOUNT` | Code used to indicate that the total transaction amount is null. |
| `NULL_TRANSACTION_RESULT` | Code used to indicate that the transaction result value is null. |
| `NULL_USER_REFERENCE` | Code used to indicate that the sale code is null. |
| `OPERATION_ABORTED` | Code used as a return for a canceled transaction. |
| `PLUGPAG_ASYNC_CONFIRMATION` | Remote configuration constant for asynchronous confirmation. |
| `PLUGPAG_ASYNC_METRICS` | Remote configuration constant for sending metrics. |
| `PLUGPAG_CDCVM` | Remote configuration constant for CDCVM. |
| `PLUGPAG_CRASHLOG_SENDING` | Remote configuration constant for sending crash logs. |
| `PLUGPAG_PRE_PRINTING` | Remote configuration constant for pre-printing. |
| `POS_NOT_READY` | Code used to indicate that the terminal is not ready for transaction. |
| `RET_OK` | Code used to indicate success in operations. |
| `SHARE_MODE_NOT_ALLOWED` | Code used to indicate that Bluetooth transaction is not allowed in shared mode. |
| `TRANSACTION_DENIED` | Code used to indicate unsuccessful transaction. |
| `TYPE_CREDITO` | Payment type: Credit. |
| `TYPE_DEBITO` | Payment type: Debit. |
| `TYPE_PIX` | Payment type: Pix QR Code. |
| `TYPE_PREAUTO_CARD` | Payment type: Pre-authorization via card. |
| `TYPE_PREAUTO_KEYED` | Payment type: Pre-authorization via manual entry. |
| `TYPE_QRCODE` | Payment type: Debit QR Code. |
| `TYPE_QRCODE_CREDITO` | Payment type: Credit QR Code. |
| `TYPE_VOUCHER` | Payment type: Voucher (meal voucher). |
| `VOID_PAYMENT` | Code used for payment reversal. |
| `VOID_QRCODE` | Code used for QR Code reversal. |
