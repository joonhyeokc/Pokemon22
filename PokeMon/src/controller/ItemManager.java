package controller;

import model.dao.ItemDao;
import model.dao.UserDao;
import model.vo.User;

public class ItemManager {
   
   private ItemDao id = new ItemDao();

   private User user;
   public void decreaseGold(int check, User user) {
	   this.user = user;
      System.out.println("ItemMamager�� ��");
      //���� �Ѿ�, ���� ���� ���� �ݾ��� �����ͼ� �� ����ִ�
      System.out.println("�����Ѿ� : " + check);
      //System.out.println("�� �� :"+um.getUserGold());
      //dG = um.getUserGold() - check; 
      //um.setUserGold(dG);
      
      user.setuGold(user.getuGold() - check);
      
      System.out.println("���� �ݾ� : " + user.getuGold());
   }
   
   public void addInven(int iNo, int iAmount) {
      
      System.out.println("���� �κ��丮 �߰� ����");
      System.out.println("������ ������ ��ȣ : " + iNo + " / ���� : " + iAmount);
      
      /*id.getItemList().get(iNo).setiAmount(iAmount);
      User.getUi_list().add(id.getItemList().get(iNo));
      
      for(int i = 0; i < User.getUi_list().size(); i++) {
         System.out.println(User.getUi_list().get(i).getiName());
         System.out.println(User.getUi_list().get(i).getiAmount());
      }*/
      
      /*System.out.println("�κ��丮�� �߰��� ���� : " + User.getUi_list().get(iNo).getiName()
            + " / " + User.getUi_list().get(iNo).getiAmount());*/
      
      
   }
   
   
   //��Ʋ���� �޾ƿ;� ��
   public void useStone() {
      
   }
   public void useBall() {
      
   }
   public void Recovery() {
      
   }
}