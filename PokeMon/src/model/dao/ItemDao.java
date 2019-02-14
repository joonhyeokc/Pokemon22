package model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.vo.Ball;
import model.vo.Item;
import model.vo.Recovery;
import model.vo.Stone;

public class ItemDao {
   
   private List<Item> iList = new ArrayList<Item>();
   
   public ItemDao() {
	   outputItem();
      /*iList.add(new Ball("������ ��", 0, 50, 0, 0, 70, 0));
      iList.add(new Ball("���� ��", 1, 30, 0, 0, 50, 1));
      iList.add(new Ball("���� ��", 2, 10, 0, 0, 20, 2));
      iList.add(new Recovery("��� ��ó��", 3, 30, 1, 0, 0, 100));
      iList.add(new Recovery("�߱� ��ó��", 4, 20, 1, 0, 1, 50));
      iList.add(new Recovery("�ʱ� ��ó��", 5, 10, 1, 0, 2, 30));
      iList.add(new Stone("ȭ���� ��", 6, 200, 2, 0));
      iList.add(new Stone("�ٴ��� ��", 7, 200, 2, 0));
      iList.add(new Stone("������ ��", 8, 200, 2, 0));*/
   }
   
   public void inputItem() {
      try {
         ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("item.dat", true));
         oos.writeObject(iList);
         
      } catch (IOException e) {}
   }
   
   public void outputItem() {
      
      ObjectInputStream ois;
      try {
         ois = new ObjectInputStream(new FileInputStream("item.dat"));
         iList = (List<Item>) ois.readObject();
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }
   
   public List<Item> getIList() {
      return iList;
   }
   
   public void setIList(List<Item> iList) {
      this.iList = iList;
   }
}