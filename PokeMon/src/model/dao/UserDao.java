package model.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.vo.User;

public class UserDao{
   private List<User> userList = new ArrayList<>();

   
   
   public UserDao() {
      User user = new User();
      userList.add(user);
   }
   public void saveUser() {
      try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("user.dat",true))){
         objOut.writeObject(userList);

      } catch(Exception e) {
         e.printStackTrace();
      }
   }
   public void loadUser() {
      try {
         ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"));
         userList = (List<User>) ois.readObject();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   public List<User> getUserList() {
	  System.out.println(userList);
      return userList;
   }
   public void setUserList(ArrayList<User> userList) {
      this.userList = userList;
   }
   

}