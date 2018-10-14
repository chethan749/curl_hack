var express = require('express');
var Web3 = require('web3');
var morgan = require('morgan');
var bodyParser = require('body-parser');

var app = express();
app.use(bodyParser.json());

if(Web3 !== undefined)
    web3 = new Web3(Web3.currentProvider);
else {
    web3 = new Web3(new Web3.providers.HttpProvider("http://127.0.0.1:8545"));
}

web3.eth.defaultAccount = web3.eth.accounts[0];
console.log(web3.eth.accounts[0]);

var contract = new web3.eth.Contract([
	{
		"constant": false,
		"inputs": [
			{
				"name": "driver",
				"type": "address"
			},
			{
				"name": "price",
				"type": "uint256"
			}
		],
		"name": "cancel_customer",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [
			{
				"name": "customer",
				"type": "address"
			}
		],
		"name": "cancel_driver",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [
			{
				"name": "x",
				"type": "address"
			}
		],
		"name": "make_admin",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"anonymous": false,
		"inputs": [
			{
				"indexed": false,
				"name": "customer",
				"type": "address"
			},
			{
				"indexed": false,
				"name": "balance",
				"type": "uint256"
			}
		],
		"name": "notEnoughBalance",
		"type": "event"
	},
	{
		"constant": false,
		"inputs": [
			{
				"name": "driver",
				"type": "address"
			},
			{
				"name": "price",
				"type": "uint256"
			}
		],
		"name": "payment",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [],
		"name": "register_as_customer",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [],
		"name": "register_as_driver",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [
			{
				"name": "x",
				"type": "address"
			}
		],
		"name": "remove_admin",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"inputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "constructor"
	}
]);

contract.options.address = '0x168b9aa655b97263ff202acc99caabc6901126c9';

var driver_count = 0, customer_count = 0;

app.post('/request-ride', function(req, res) {
    var address = req.body.address;
    var location = req.body.location;
    var source = req.body.source;
    var dest = req.body.dest;

    var notEnoughBalanceEvent = contract.notEnoughBalance();
    notEnoughBalanceEvent.watch(function(error, result) {
        if(!error)
            result.send("notEnoughBalance");
    })
})

app.post('/cancel-customer', function(req, res) {
    var address = req.body.address;
    var driver = req.body.driver;
    var price = req.body.price;

    var meth = contract.methods.cancel_customer(driver);
    meth.call({from: address, to: contract.options.address}, function(err, result) {});
})

app.post('/cancel-driver', function(req, res) {
    var address = req.body.address;
    var customer = req.body.customer;

    var meth = contract.methods.cancel_driver(customer);
    meth.call({from: address, to: contract.options.address}, function(err, result) {});
})

app.get('/register-customer', function(req, res) {
    var address = req.body.address;

    var meth = contract.methods.register_as_customer();
    meth.call({from: address, to: contract.options.address}, function(err, result) {});
})

app.get('/register-driver', function(req, res) {
    var address = req.body.address;

    var meth = contract.methods.register_as_driver();
    meth.call({from: address, to: contract.options.address}, function(err, result) {});
})

app.get('/pay', function(req, res) {
    var address = req.body.address;
    var drvier = req.body.driver;
    var price = req.body.price;

    var meth = contract.methods.payment(driver);
    meth.call({from: address, to: contract.options.address}, function(err, result) {});
})

app.listen(process.env.PORT || 8080, function() {
    console.log('Server running on port 8080!!');
});
