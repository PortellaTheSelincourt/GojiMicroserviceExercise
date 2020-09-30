import Constructors.Customer;
import Exceptions.EntityNotFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 * DataStore class will provide access to customers data, it will work as a dummy database.
 */

public class DataStore {
    //Map of Customers
    private Map<String, Customer> customerMap = new HashMap<>();

    //important to keep these objects as static so it only gets constructed once, adding safety.
    private static DataStore instance = new DataStore();

    public static DataStore getInstance() {
        return instance;
    }

    //Constructor to be used with getInstance()
    private DataStore() {
        //dummy data
        customerMap.put("google", new Customer("google", "google.co.uk"));
        customerMap.put("bing", new Customer("bing", "bing.co.uk"));
        customerMap.put("yahoo", new Customer("yahoo", "yahoo.co.uk"));
    }

    public Customer getCustomer(String name) throws EntityNotFoundException {
        Customer customer = customerMap.get(name);
        if (customer != null) {
            return customer;
        } else {
            //would rather send a http response status message for this exception
            throw new EntityNotFoundException("DataStore.Customer name not found!");
        }
    }

    public void putCustomer(Customer customer) {
        customerMap.put(customer.getName(), customer);
    }
}
