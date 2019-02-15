package controller;

import model.dao.ItemDao;
import model.dao.UserDao;
import model.vo.User;

public class ItemManager {
   
   private ItemDao id = new ItemDao();

   private User user;
   public void decreaseGold(int check, User user) {
	   this.user = user;
      System.out.println("ItemMamager로 옴");
      //구매 총액, 현재 유저 소지 금액을 가져와서 돈 깍아주는
      System.out.println("구매총액 : " + check);
      //System.out.println("내 돈 :"+um.getUserGold());
      //dG = um.getUserGold() - check; 
      //um.setUserGold(dG);
      
      user.setuGold(user.getuGold() - check);
      
      System.out.println("현재 금액 : " + user.getuGold());
   }
   
   public void addInven(int iNo, int iAmount) {
      
      System.out.println("유저 인벤토리 추가 실행");
      System.out.println("선택한 아이템 번호 : " + iNo + " / 수량 : " + iAmount);
      
      //id.getIList().get(iNo).setiAmount(iAmount);
      //System.out.println("구매 수량 : "+id.getIList().get(iNo).getiAmount());
      //user.setUi_list(id.getIList());
      //System.out.println(user.getUi_list().get(0).getiName());
      //System.out.println(user.getUi_list().get(1).getiName());
      
      
      /*id.getItemList().get(iNo).setiAmount(iAmount);
      User.getUi_list().add(id.getItemList().get(iNo));
      
      for(int i = 0; i < User.getUi_list().size(); i++) {
         System.out.println(User.getUi_list().get(i).getiName());
         System.out.println(User.getUi_list().get(i).getiAmount());
      }*/
      
      /*System.out.println("인벤토리에 추가한 내용 : " + User.getUi_list().get(iNo).getiName()
            + " / " + User.getUi_list().get(iNo).getiAmount());*/
      
      
   }
   
   
   //배틀에서 메소드 호출 시 유저 인벤토리에 있는 수량 깍임
   public void useStone() {
      
   }
   public void useBall() {
      
   }
   public void Recovery() {
      
   }
}