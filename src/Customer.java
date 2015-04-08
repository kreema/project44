/**
 * JAVADOC COMMENTS
 *
 * @author
 */
public class Customer
{
    // Customer name, email, and phone. This is all we need for now.
    private String first_name;
    private String last_name;
    private String cust_email;
    private String cust_phone;

    /*
    methods:
    update_customer_info
     */

    // TBD - this method will call an interface to update customer info as entered by user
    public updateCustomerInfo()
    {
        // Create
    }

    public Customer(String first, String last, String email, String phone)
    {
        first_name = first;
        last_name = last;
        cust_email = email;
        cust_phone = phone;
    }

    /* Add'l constructors - if we need

    public Customer(String first, String last)
    {
        this(first, last, "jane.doe@email.com", "1234567890");
    }

    public Customer(String first, String last, String phone)
    {
        this(first, last, "jane.doe@email.com", phone);
    }

    public Customer(String first, String last, String email)
    {
        this(first, last, email, "1234567890");
    }

     */

    public Customer()
    {
        this("Jane", "Doe", "jane.doe@email.com", "1234567890");
    }

    public String toString()
    {
        return String.format("%s, %s Email: %s Phone: %s",
                first_name, last_name, cust_email, cust_phone);
    }

    public String getFirst_name()
    {
        return first_name;
    }

    public void setFirst_name(String first)
    {
        first_name = first;
    }

    public String getLast_name()
    {
        return last_name;
    }

    public void setLast_name(String last)
    {
        last_name = last;
    }

    public String getEmail()
    {
        return cust_email;
    }

    public void setEmail(String new_email)
    {
        cust_email = new_email;
    }

    public String getPhone()
    {
        return cust_phone;
    }

    public void setPhone(String phone)
    {
        cust_phone = phone;
    }

}
