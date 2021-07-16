package CustomerView;

import Customer.Customer;
import CustomerList.CustomerList;
import Utility.Utility;

public class CustomerView {
    CustomerList customerlist = new CustomerList(2);

    public void enterMainMenu(){
        boolean condition = true;
        do {
            System.out.println("\n----------------客户信息管理软件----------------\n");
            System.out.println("\t\t\t\t  1.添加用户");
            System.out.println("\t\t\t\t  2.修改用户");
            System.out.println("\t\t\t\t  3.删除用户");
            System.out.println("\t\t\t\t  4.用户列表");
            System.out.println("\t\t\t\t  5.退   出\n");
            System.out.print("\t\t\t\t 请选择(1-5):");
            char key = Utility.readMainMenu();
            switch (key){
                case '1' :
                    addNewCustomer();
                    break;
                case '2' :
                    modifyCustomer();
                    break;
                case '3' :
                    deleteCustomer();
                    break;
                case '4' :
                    listAllCustomer();
                    break;
                case '5' :
                    System.out.print("是否确认退出(Y/N):");
                    char confirm = Utility.readConfirm();
                    if(confirm == 'Y'){
                        condition = false;
                        break;
                    }
            }
        }while (condition);
    }

    private void addNewCustomer(){
        System.out.println("\n--------------------添加客户--------------------");
        System.out.print("姓名:");
        String name = Utility.readString(3);
        System.out.print("性别:");
        char gender = Utility.readChar();
        System.out.print("年龄:");
        int age = Utility.readInt();
        System.out.print("电话:");
        String phone = Utility.readString(11);
        System.out.print("邮箱:");
        String email = Utility.readString(18);
        Customer customer = new Customer(name,gender,age,phone,email);
        boolean flag = customerlist.addCustomer(customer);
        if(flag){
            System.out.println("--------------------添加完成--------------------");
        }else{
            System.out.println("--------------记录已满，无法添加!-----------------");
        }
    }

    private void modifyCustomer(){
        System.out.println("\n--------------------修改客户--------------------");
        int index;
        Customer customer;
        for ( ; ; ) {
            System.out.print("请选择待修改客户编号(-1退出)：");
            index = Utility.readInt();
            if (index == -1){
                return;
            }
            customer = customerlist.getCustomer(index - 1);
            if(customer == null){
                System.out.println("没有此用户");
            }else {
                break;
            }
        }
        System.out.print("姓名(" + customer.getName() + "):");
        String name = Utility.readString(3,customer.getName());
        System.out.print("性别(" + customer.getGender() + "):");
        char gender = Utility.readChar(customer.getGender());
        System.out.print("年龄(" + customer.getAge() + "):");
        int age = Utility.readInt(customer.getAge());
        System.out.print("电话(" + customer.getPhone() + "):");
        String phone = Utility.readString(11,customer.getPhone());
        System.out.print("邮箱(" + customer.getEmail() + "):");
        String email = Utility.readString(18,customer.getEmail());
        customer = new Customer(name,gender,age,phone,email);
        boolean flag = customerlist.replaceCustomer(index - 1,customer);
        if(flag){
            System.out.println("--------------------修改完成--------------------");
        }else {
            System.out.println("--------------------修改失败--------------------");
        }
    }

    public void deleteCustomer(){
        System.out.println("\n--------------------删除客户--------------------");
        int index;
        Customer customer;
        for ( ; ; ){
            System.out.print("请选择待修改客户编号(-1退出)：");
            index = Utility.readInt();
            if (index == -1){
                return;
            }
            customer = customerlist.getCustomer(index - 1);
            if(customer == null){
                System.out.println("没有此用户");
            }else {
                break;
            }
        }
        System.out.println("确认是否删除(Y/N)：");
        char confirm = Utility.readConfirm();
        if(confirm == 'N'){
            return;
        }
        boolean flag = customerlist.deleteCustomer(index - 1);
        if(flag){
            System.out.println("--------------------删除完成--------------------");
        }else {
            System.out.println("--------------------删除失败--------------------");
        }
    }

    private void listAllCustomer(){
        System.out.println("\n-----------------------客户列表-----------------------");
        Customer customer[] = customerlist.getAllCustomer();
        if(customer.length == 0) {
            System.out.println("没有客户");
        }else {
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t邮箱");
            for (int i = 0; i < customer.length; i++) {
                System.out.println((i + 1) + "\t" + customer[i].getDetails());
            }
        }
        System.out.println("---------------------客户列表完成---------------------");
    }

    public static void main(String[] args) {
        CustomerView customerview = new CustomerView();
        customerview.enterMainMenu();
    }
}
