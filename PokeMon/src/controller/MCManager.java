package controller;

import java.util.Date;

import model.dao.ItemDao;
import model.dao.UserDao;
import model.vo.User;

//����
//ü��ȸ��
public class MCManager {
   //����
   //���ż���üũ->�����ݾ�üũ->���Ű��ɿ��� üũ
   private String resultNo;
   private UserDao ud = new UserDao();
   private User user = ud.getUserList().get(0);
   private ItemDao id = new ItemDao(); 
   public void useMarket(String iName, int iAmount) {
      this.user = user;
      //->MarketView���� �� ��
      //�ּҼ���, �ִ����
      
      int check = 0;//���� �ϰ� ���� �������� �� ����
      
      ItemManager im = new ItemManager();
      resultNo=null;
      for(int i=0 ; i<id.getIList().size() ; i++) {
         //������ �� ���� ���Ͽ� �����۸���Ʈ�� ���° �ε����� �ִ� �� Ȯ��
         if(id.getIList().get(i).getiName().equals(iName)) {
            //���� �ϰ� ���� �������� �� �ݾ�
            check=(id.getIList().get(i).getiPrice()) * iAmount;
            //�����κ��� �ִ� �����ݾװ� �� ��   
            //�����ݾ�<check : �����ݾ��� ���� ���Ű� �Ұ��� �մϴ� ��� : MarketView���� �ٷ� �����
            if(iAmount > 100) {
               //���� �Ұ�
               resultNo="�ִ� ���� ������ 100�� �Դϴ�.";
            }else if(iAmount < 1){
               resultNo="�ּ� ���� ������ 1�� �Դϴ�.";
            }else if(ud.getUserList().get(0).getuGold() < check){
               resultNo="��尡 �����մϴ�.";
            }else {
               
               ud.getUserList().get(0).setuGold(/*ud.getUserList().get(0)*/user.getuGold() - check);
               ud.saveUser();
               //���� ����
               //�ߺ� �������� ������ ������ �������Ѿ�
               //System.out.println("������ : "+itemName+", ���� : "+itemAmount);
               im.decreaseGold(check);
            }
            //�����ݾ�>check : ���� ���� : itemManager �� ���� ��ϰ� �����Ѿ��� ������
         }
      }
      
   }
   public String getResultNo() {
      return resultNo;
   }
   public void setResultNo(String resultNo) {
      this.resultNo = resultNo;
   }
   public void useCenter() {
      //ȸ�� �����ֱ�
      
   }

}