package com.example.chethan.test_web3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class Main extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060008054600160a060020a0319163317808255600160a060020a03168152600160208190526040909120556102798061004b6000396000f30060806040526004361061006c5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166340be5df0811461007157806367a09c2314610094578063e5bc706f146100b8578063f9e2253c146100cd578063fc111987146100ee575b600080fd5b34801561007d57600080fd5b50610092600160a060020a0360043516610103565b005b3480156100a057600080fd5b50610092600160a060020a0360043516602435610134565b3480156100c457600080fd5b5061009261015e565b3480156100d957600080fd5b50610092600160a060020a0360043516610173565b3480156100fa57600080fd5b506100926101ad565b600054600160a060020a0316331461011a57600080fd5b600160a060020a0316600090815260016020526040812055565b3360009081526001602052604090205460021461015057600080fd5b61015a82826101c2565b5050565b33600090815260016020526040902060039055565b336000908152600160208190526040909120541461019057600080fd5b600160a060020a0316600090815260016020819052604090912055565b33600090815260016020526040902060029055565b80622dc6c0810133311061020c57604051600160a060020a0384169083156108fc029084906000818181858888f19350505050158015610206573d6000803e3d6000fd5b50610248565b604080513380825231602082015281517f59f096dfb667a915551dd72f3d67ebb2b0e56621b9965e40b0daa179fcc13d7b929181900390910190a15b5050505600a165627a7a7230582083ca29b4f6c0d2f36598d691a1e5f1020188ec3c3c2fd1658946142bfe94bdb60029";

    public static final String FUNC_REMOVE_ADMIN = "remove_admin";

    public static final String FUNC_PAYMENT = "payment";

    public static final String FUNC_REGISTER_AS_DRIVER = "register_as_driver";

    public static final String FUNC_MAKE_ADMIN = "make_admin";

    public static final String FUNC_REGISTER_AS_CUSTOMER = "register_as_customer";

    public static final Event NOTENOUGHBALANCE_EVENT = new Event("notEnoughBalance",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}), Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected Main(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    /*protected Main(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }*/

    @Deprecated
    protected Main(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Main(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> remove_admin(String x) {
        final Function function = new Function(
                FUNC_REMOVE_ADMIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(x)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> payment(String x, BigInteger price) {
        final Function function = new Function(
                FUNC_PAYMENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(x), 
                new org.web3j.abi.datatypes.generated.Uint256(price)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> register_as_driver() {
        final Function function = new Function(
                FUNC_REGISTER_AS_DRIVER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> make_admin(String x) {
        final Function function = new Function(
                FUNC_MAKE_ADMIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(x)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> register_as_customer() {
        final Function function = new Function(
                FUNC_REGISTER_AS_CUSTOMER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    /*public static RemoteCall<Main> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Main.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<Main> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Main.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }*/

    @Deprecated
    public static RemoteCall<Main> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Main.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Main> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Main.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public List<NotEnoughBalanceEventResponse> getNotEnoughBalanceEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(NOTENOUGHBALANCE_EVENT, transactionReceipt);
        ArrayList<NotEnoughBalanceEventResponse> responses = new ArrayList<NotEnoughBalanceEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            NotEnoughBalanceEventResponse typedResponse = new NotEnoughBalanceEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.customer = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.balance = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<NotEnoughBalanceEventResponse> notEnoughBalanceEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, NotEnoughBalanceEventResponse>() {
            @Override
            public NotEnoughBalanceEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(NOTENOUGHBALANCE_EVENT, log);
                NotEnoughBalanceEventResponse typedResponse = new NotEnoughBalanceEventResponse();
                typedResponse.log = log;
                typedResponse.customer = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.balance = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<NotEnoughBalanceEventResponse> notEnoughBalanceEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(NOTENOUGHBALANCE_EVENT));
        return notEnoughBalanceEventObservable(filter);
    }

    @Deprecated
    public static Main load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Main(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Main load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Main(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    /*public static Main load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Main(contractAddress, web3j, credentials, contractGasProvider);
    }*/

    public static Main load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Main(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class NotEnoughBalanceEventResponse {
        public Log log;

        public String customer;

        public BigInteger balance;
    }
}
