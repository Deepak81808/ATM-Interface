/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package amstack.atminterface;
import java.util.*;
/**
 *
 * @author Asus
 */
public class OperationImplementaion implements OperationInterface  {
     User user=new User();
     Map<Double,String>ministmt=new HashMap<>();
     @Override
     public void ViewBalance()
     {
         System.out.println("Available balance is ....."+user.getBalance());
     }

    /**
     *
     * @param withdrawAmount
     */
    @Override
     public void withdrawAmount(double withdrawAmount)
     {
         if(withdrawAmount%500==0)
         {
             if(withdrawAmount<=user.getBalance())
             {
                 ministmt.put(withdrawAmount,"Amount Withdraw");
                 System.out.println("Collect the Case" +withdrawAmount);
                 user.setBalance(user.getBalance()-withdrawAmount);
                 ViewBalance();
             }
             else{
                 System.out.println("Insufficient Balance !!");
             }
         }
         else{
             System.out.println("Please enter the amount in multipal of 500");
         }
     }
     
     @Override
     public void depositAmount(double depositeAmount)
     {
         ministmt.put(depositeAmount, "amount deposited");
         System.out.println(depositeAmount+" deposite successfully !!");
         user.setBalance(user.getBalance()+depositeAmount);
         ViewBalance();
     }
     
     @Override
     public void Transaction(){
           for(Map.Entry<Double,String> m:ministmt.entrySet()){
            System.out.println(m.getKey()+""+m.getValue());
        }
     }
}
