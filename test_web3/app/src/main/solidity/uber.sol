pragma solidity ^0.4.25;

contract main{
    address admin;

    mapping(address => int) addresses;

    constructor() public{
        admin = msg.sender;
        addresses[admin] = 1;
    }

    function register_as_customer() public {
        addresses[msg.sender] = 2;
    }

    function register_as_driver() public{
        addresses[msg.sender] = 3;
    }

    event notEnoughBalance(address customer, uint256 balance);

    modifier only_admins {
        require(addresses[msg.sender] == 1);
        _;
    }

    modifier only_admin {
        require(msg.sender == admin);
        _;
    }

    modifier only_customer {
        require(addresses[msg.sender] == 2);
        _;
    }

    modifier only_driver {
        require(addresses[msg.sender] == 3);
        _;
    }

    modifier check_balance(uint256 price) {
        if(msg.sender.balance >= price + 3000000)
            _;
        else
            emit notEnoughBalance(msg.sender, msg.sender.balance);
    }

    function make_admin(address x) public only_admins {
        addresses[x] = 1;
    }

    function remove_admin(address x) public only_admin {
        addresses[x] = 0;
    }

    function pay(address driver, uint256 price) private check_balance(price) {
        driver.transfer(price);
    }

    function payment(address driver, uint256 price) public only_customer {
        pay(driver, price);
    }
    
    function cancel_customer(address driver, uint256 price) public only_customer {
        pay(driver, price / 20);
    }
    
    function cancel_driver(address customer) public only_driver {
        pay(customer, 0);
    }
}
