package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.MCManager;
import model.dao.ItemDao;
import model.dao.UserDao;
import model.vo.Item;
import model.vo.User;

//������ ���� �ϴ� ���� Ŭ����

//��ũ�Ѹ� �߰� �ϸ� list�� ������ ����...
//�ذ����� �𸣰���
public class MarketView extends JPanel {
   private MainFrame mf;
   private JPanel marketView;
   
   private JPanel listPanel;
   private Map m;
   private String itemTemp;//������ ������� ��ȣ �Űܼ� ���//���� ���� X
   private String iName;
   private String iNo;//������ ������ �ش� ��ȣ
   private int iAmount;//������ ������ ����
   private Image backButtonImage = new ImageIcon("images/back.png").getImage();
   private JButton backButton = new JButton(new ImageIcon(backButtonImage));
   
   private MCManager mc = new MCManager();
   
 //--------------------------����
   private ItemDao id = new ItemDao();
   private User user;
   public MarketView(MainFrame mf, JPanel oldPage, User user) {
	  this.user = user;
      this.mf=mf;
      this.marketView=this;
      this.m=(Map)oldPage;
      this.setLayout(null);
      this.setBounds(0, 0, 1024, 768);
      
      listPanel =new JPanel();
      
      //ArrayList<Board> list = bd.readBoardList();
      
      List<Item> itemList = id.getIList();
      
      String[] iNameList = new String[id.getIList().size()];
      for(int i=0 ; i<iNameList.length ; i++) {
         iNameList[i]=id.getIList().get(i).getiName();
      }      
      
      String[] iPriceList = new String[id.getIList().size()];
      for(int i=0 ; i<iPriceList.length ; i++) {
         iPriceList[i]=id.getIList().get(i).getiPrice() + "G";
         
      }
      
      /*JLabel[] iImageList = new JLabel[id.readItemList().size()];
      for(int i=0 ; i<iImageList.length ; i++) {
         iImageList[i] = new JLabel(new ImageIcon(id.getItemList().get(i).getiImg()));
       }*/
      
      JList itemPrice = new JList(iPriceList);
      itemPrice.setFont(new Font(getName(),Font.BOLD,17));
      itemPrice.setBounds(400, 100, 80, 250);
      itemPrice.setEnabled(false);
      itemPrice.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
      
      JList itemName = new JList(iNameList);
      itemName.setFont(new Font(getName(),Font.BOLD,17));
      itemName.setBounds(500, 100, 300, 250);
      itemName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
      
      /*JList itemImg = new JList();
      for(int i = 0; i < itemList.length; i++) {
         itemImg.add(iImageList[i]);
      }
      itemImg.setBounds(0, 100, 300, 250);
      itemImg.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
      itemImg.setVisible(true);*/
      
      
      JLabel presentGold = new JLabel("���� ���� �ݾ� : ");
      presentGold.setBounds(500, 350, 100, 50);
      presentGold.setFont(new Font(getName(),3,12));
      
      JTextField userGold = new JTextField(40);
      userGold.setText(user.getuGold() + "G");
      userGold.setLocation(600, 350);
      userGold.setSize(80,50);
      userGold.setEditable(false);
      presentGold.add(userGold);
      
      JLabel selected = new JLabel("���� �׸� : ");
      selected.setBounds(250, 400, 100, 50);
      
      
      JTextField selectedItem = new JTextField(40);
      selectedItem.setLocation(350, 400);
      selectedItem.setSize(100, 50);
      
      itemName.addListSelectionListener(new ListSelectionListener() {
         
         @Override
         public void valueChanged(ListSelectionEvent e) {
            selectedItem.setText(itemName.getSelectedValue()+"");
         }
      });
      
      JLabel amount = new JLabel("���� �Է� : ");
      amount.setBounds(470, 400, 100, 50);
      
      JTextField selectedAmount = new JTextField(40);
      selectedAmount.setLocation(550, 400);
      selectedAmount.setSize(100, 50);
      amount.add(selectedAmount);
      
      
      JButton btn = new JButton("����");
      btn.setBounds(650, 400, 60, 50);
      
      //������ �����
      JLabel sayResult = new JLabel("������ ����");
      sayResult.setBounds(250, 500, 100, 50);
      
      
      JTextField resultItem = new JTextField(40);
      resultItem.setLocation(350, 500);
      resultItem.setSize(100, 50);
      resultItem.setEditable(false);
      
      JTextField resultAmount = new JTextField(40);
      resultAmount.setLocation(450, 500);
      resultAmount.setSize(300, 50);
      resultAmount.setEditable(false);

      
      btn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {//���Ź�ư ����
            
           //���� ������ ���� MCManager�� ���� ������ �ʱⰪ ��������
            //MCManager���� ��
            iAmount = Integer.parseInt(selectedAmount.getText());
            
            mc.useMarket(iName, iAmount,user);
            
            mc.useMarket(selectedItem.getText(), iAmount,user);
            userGold.setText(user.getuGold()+"G");
            
            if(mc.getResultNo()!=null) {
                resultAmount.setText(mc.getResultNo());
                userGold.setText(user.getuGold()+"G");
            }
                
            /*if(value>100) {
               System.out.println("��");
               resultAmount.setText("�ִ� ���� ���� ������ 100 �Դϴ�.");
            }else if(value<=0) {
               
               resultAmount.setText("�ּ� ���� ������ 1�� �Դϴ�.");
               
            }else {
               
               if(mc.getResultNo()!=null) {
                  resultAmount.setText(ud.getUList().get(0).getuGold() + "G");
               }else {
                  resultItem.setText(selectedItem.getText()+"");
                  resultAmount.setText(value+"");
                  
                  mc.useMarket(selectedItem.getText(),itemAmount);
                  
               }
               
            }*/
            
            
         }
      });
      
      
      backButton.setBounds(920, 600, 70, 50);
      settingButton(backButton);
      backButton.setBorderPainted(false);
      backButton.setFocusPainted(false);
      backButton.setContentAreaFilled(false);
      
      backButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) { }
         @Override
         public void mouseExited(MouseEvent e) {}
         @Override
         public void mousePressed(MouseEvent e) {
            mf.remove(marketView);
            
            m.setVisible(true);
            mf.requestFocus();
            //((Map)m).start();
            m.setEscCtn(0);
            
         }
      });
      
      
      /*this.add(itemImg);*/
      this.add(itemName);
      this.add(itemPrice);
      this.add(selected);
      
      this.add(selectedItem);
      this.add(selectedAmount);
      
      this.add(amount);
      this.add(sayResult);
      
      this.add(resultItem);
      this.add(resultAmount);
      this.add(btn);
      
      this.add(backButton);
      
      this.add(presentGold);
      this.add(userGold);
      
   }
   public void settingButton(JButton jb) {
      jb.setBorderPainted(false);
      jb.setFocusPainted(false);
      jb.setContentAreaFilled(false);
   }
   
}