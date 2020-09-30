package Constructors;

/**
 * Simple Constructor class.
 * Creates Customer's class attributes, name & callback.
 */
public class Customer {
    private String name;
    private String callback;

    public Customer(String name, String callback) {
        this.name = name;
        this.callback = callback;
    }

    /**
     * Gets customer name information when name is initialized.
     *
     * @return customer's name value.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets callback information when callback is initialized.
     *
     * @return callback value
     */
    public String getCallback() {
        return callback;
    }

}
