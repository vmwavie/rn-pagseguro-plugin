# React-Native-Plugin Pagseguro

## A react-native plugin to connect pagseguro to your machine credit card using react-native, machine-credit-card like a "morderninha" or other's.


## Getting started

```sh
  yarn install react-native-plug-pag-service -D
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

## Functions

| Parameter | Description                       |
| :-------- |:--------------------------------  |
| `A_VISTA_INSTALLMENT_QUANTITY` | Quantidade de parcelas padrão de uma venda à vista. |
| `AUTHENTICATION_FAILED` | Código utilizado para quando a PlugPagService não esta ativada. |
| `BUFFER_SIZE_ERROR` | Código utilizado para indicar falha na geração de mensagem da transação, ocasionado pelo tamanho do buffer.
| `COMMUNICATION_ERROR` | Código utilizado  para erros de comunicação.
| `DISABLED_FUNCTION` | Código utilizado para indicar que dada funcionalidade não está disponível para o terminal.
| `ERROR_CODE_OK` | Código utilizado para sucesso numa transação.
| `INSTALLMENT_TYPE_A_VISTA` | Forma de parcelamento: À vista.
| `INSTALLMENT_TYPE_PARC_COMPRADOR` | Forma de parcelamento: Parcelamento comprador.
| `INSTALLMENT_TYPE_PARC_VENDEDOR` | Forma de parcelamento: Parcelamento vendedor.
| `INVALID_AMOUNT_FORMAT` | Código utilizado para indicar que o valor da transação é inválido, podendo ser um erro de digitação ou formatação.
| `INVALID_BUFFER_DATA` | Código utilizado para indicar que o buffer de resposta é inválido, sendo necessário refazê-la.
| `INVALID_LENGTH_USER_REFERENCE` | Código utilizado para indicar que o código da venda ultrapassou o tamanho limite (10 caracteres).
| `MIN_PRINTER_STEPS` | Quantidade mínima de linhas impressas após a impressão finalizar.
| `MODE_PARTIAL_PAY` | Código utilizado para pagamento parcial.
| `NFC_RET_ERROR` | Código utilizado para indicar falha nas operações de NFC.
| `NFC_RET_OK` | Código utilizado para indicar sucesso nas operações de NFC.
| `NO_PRINTER_DEVICE` | Código utilizado quando não existe impressora no dispositivo.
| `NO_TRANSACTION_DATA` | Código utilizado para transação sem dados.
| `NULL_AMOUNT` | Código utilizado para indicar que o valor da transação está nulo.
| `NULL_APPLICATION_PARAMETER` | Código utilizado para inidcar que o parâmetro da aplicação está com valor nulo.
| `NULL_TOTAL_AMOUNT` | Código utilizado para indicar que o valor total da transação está nulo.
| `NULL_TRANSACTION_RESULT` | Código utilizado para inidicar que o Valor resultante da transação está nulo.
| `NULL_USER_REFERENCE` | Código utilizado para indicar que o código de venda está nulo.
| `OPERATION_ABORTED` | Código utilizado como retorno de uma transação cancelada.
| `PLUGPAG_ASYNC_CONFIRMATION` | Constante de configuração remota para confirmação assíncrona.
| `PLUGPAG_ASYNC_METRICS` | Constante de configuração remota para envio de métricas.
| `PLUGPAG_CDCVM` | Constante de configuração remota para CDCVM.
| `PLUGPAG_CRASHLOG_SENDING` | Constante de configuração remota para envio de logs de crash.
| `PLUGPAG_PRE_PRINTING` | Constante de configuração remota para pré-impressão.
| `POS_NOT_READY` | Código utilizado para indicar que o terminal não está pronto para transacionar.
| `RET_OK` | Código utilizado para indicar sucesso nas operações.
| `SHARE_MODE_NOT_ALLOWED` | Código utilizado para indicar que a transação via bluetooth não é permitida em modo compartilhado.
| `TRANSACTION_DENIED` | Código utilizado para indicar transação não realizada.
| `TYPE_CREDITO` | Tipo de pagamento: Crédito.
| `TYPE_DEBITO` | Tipo de pagamento: Débito.
| `TYPE_PIX` | Tipo de pagamento: QR Code Pix.
| `TYPE_PREAUTO_CARD` | Tipo de pagamento: Pré-autorização via cartão.
| `TYPE_PREAUTO_KEYED` | Tipo de pagamento: Pré-autorização por digitação.
| `TYPE_QRCODE` | Tipo de pagamento: QR Code débito.
| `TYPE_QRCODE_CREDITO` | Tipo de pagamento: QR Code crédito.
| `TYPE_VOUCHER` | Tipo de pagamento: Voucher (vale refeição).
| `VOID_PAYMENT` | Código utilizado para estorno de um pagamento.
| `VOID_QRCODE` | Código utilizado para um estorno via QR Code.