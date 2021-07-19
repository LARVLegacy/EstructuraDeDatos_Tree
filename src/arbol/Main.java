
package Arbol;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        
        BinaryTree bt = new BinaryTree();
        
        String menu[]={"Add", "PreOrder", "InOrder", "PostOrder", "Size", 
            "Height", "Search","Search Node", "get Father", "Successor", "Predecessor","Delete",
            "Exit"};
        int number;
        String opt;
        do{
            opt=(String)JOptionPane.showInputDialog(null,"Selected option","Main menu",
                    1, null, menu, menu[0]);
            switch(opt)
            {
                case "Add":
                                    
                    int lim = (int)(Math.random()*10);
                    for (int i = 0; i < lim; i++) {
                        number = (int)(Math.random()*500);
                        System.out.println("numero " + number);
//                         number = Integer.parseInt(JOptionPane.showInputDialog("enter number"));
                        bt.Add(number, bt.getRoot());                        
                    }
                    JOptionPane.showMessageDialog(null,"created tree");
                    break;
                        
                case "PreOrder":
                    JOptionPane.showMessageDialog(null,bt.PreOrder(bt.getRoot()));
                    break;
                    
                case "InOrder":
                    JOptionPane.showMessageDialog(null,bt.InOrder(bt.getRoot()));
                    break;
                    
                case "PostOrder":
                    JOptionPane.showMessageDialog(null,bt.PostOrder(bt.getRoot()));
                    break;
                    
                 case "Size":
                    JOptionPane.showMessageDialog(null,"the size of tree is: " + bt.Size(bt.getRoot()));
                    break;
                    
                 case "Search":
                     number=Integer.parseInt(JOptionPane.showInputDialog("Enter number"));
                     boolean res = bt.Search(number, bt.getRoot());
                     if(res)
                         JOptionPane.showMessageDialog(null,"element found");
                     else
                         JOptionPane.showMessageDialog(null,"element not found");
                     break;
                     
                 case "Height":
                      JOptionPane.showMessageDialog(null,"the heigth of tree is: "
                              + bt.Heigth(bt.getRoot()));
                      break;
                      
                  case "Search Node":
                     number=Integer.parseInt(JOptionPane.showInputDialog("Enter number"));
                     BinaryNode search = bt.SearchNode(number, bt.getRoot());
                     if(search!=null)
                         JOptionPane.showMessageDialog(null,"found");
                     else
                         JOptionPane.showMessageDialog(null,"element not found");
                     break;    
                     
                  case "get Father":
                       number=Integer.parseInt(JOptionPane.showInputDialog("Enter number"));
                       BinaryNode father = bt.getFather(number,bt.getRoot());
                       if(father!=null)
                            JOptionPane.showMessageDialog(null,"the father of " + number + "is: " 
                                    + father.getData());
                       else
                           JOptionPane.showMessageDialog(null,"number not found or number is root");
                       break;
                       
                  case "Predecessor":
                      List prede = new List();
                      number=Integer.parseInt(JOptionPane.showInputDialog("Enter number"));
                      search = bt.SearchNode(number,bt.getRoot());
                      if(search !=null)
                          JOptionPane.showMessageDialog(null, "The predeccessor are: " + 
                                  bt.Predeccessor(search,prede).toString());                          
                      else
                          JOptionPane.showMessageDialog(null,"Number not found");
                      break;
                      
                  case "Delete": 
                      number=Integer.parseInt(JOptionPane.showInputDialog("Enter number"));
                      if(bt.Delete(number))
                          JOptionPane.showMessageDialog(null, "deleted element");
                      else
                          JOptionPane.showMessageDialog(null,"Number not found");
                      break;
            }
        }while(!opt.equals("Exit"));
    }
    
}
