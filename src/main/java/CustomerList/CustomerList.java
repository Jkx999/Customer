package CustomerList;

import Customer.Customer;

public class CustomerList {
    private Customer customers[];
    private int total = 0;

    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }
    public boolean addCustomer(Customer customer){
        if(total >= customers.length){
            return false;
        }
        customers[total++] = customer;
        return true;
    }

    public boolean replaceCustomer(int index,Customer customer){
        if(index < 0 || index >= total){
            return false;
        }
        customers[index] = customer;
        return true;
    }

    public boolean deleteCustomer(int index){
        if(index < 0 || index >= total){
            return false;
        }
        for (int i = index; i < customers.length - 1; i++){
            customers[i] = customers[i+1];
        }
        return true;
    }

    public Customer[] getAllCustomer(){
        Customer customer[] = new Customer[total];
        for(int i = 0; i < total; i++){
            customer[i] = customers[i];
        }
        return customer;
    }

    public Customer getCustomer(int index){
        if(index < 0 || index >= total){
            return null;
        }
        return customers[index];
    }

    public int getTotal(){
        return total;
    }
}