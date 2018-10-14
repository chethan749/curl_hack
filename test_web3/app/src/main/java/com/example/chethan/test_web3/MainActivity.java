package com.example.chethan.test_web3;

import android.bluetooth.BluetoothGatt;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.web3j.abi.datatypes.generated.Bytes20;
import org.web3j.crypto.ContractUtils;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.ens.Contracts;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Transaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.ChainId;
import org.web3j.tx.Contract;
import org.web3j.tx.FastRawTransactionManager;
import org.web3j.tx.ManagedTransaction;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;
import org.web3j.utils.Bytes;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.io.File;
import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    Web3j web3;
    String address;
    Main main;
    Credentials credentials;
    String driver_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        web3 = Web3j.build(new HttpService("http://192.168.43.138:8545"));
        address = "0x6f81eab248aac734728735febd9d32c37653f8ee37e9034e9f36d9d5c27d0942";
        try {
            credentials = Credentials.create("0x73e7ea5088d4181b8b0017706c3b95eed64a80eee12c4e19f398c11f7377dac5");
        }

        catch(Exception e)
        {

        }

        try {
            TransactionManager transactionManager = new RawTransactionManager(web3,credentials,  web3.netVersion().send().getNetVersion());
            main = Main.load(address, web3, credentials, RawTransactionManager(web3), new DefaultGasProvider());
        }
        catch (Exception e)
        {

        }
    }

    public void registerAsCustomer(android.view.View view) {
        try {
            main.register_as_customer().send();
        }
        catch (Exception e)
        {

        }
    }

    public void cancelDriver(android.view.View view) {
    }

    public void makePayment(android.view.View view) {
        BigInteger price = new BigInteger("1000000");
        try {
            main.payment(driver_address, price);
        }
        catch (Exception e)
        {

        }
    }
}
