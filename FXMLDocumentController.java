/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkbook;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author GurjitKaur
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField name_id;
    @FXML
    private TextField payment_id;
    @FXML
    private TextField memo_id;
    @FXML
    private TextField signature_id;
    @FXML
    private ListView<Contact> list2;
    ObservableList<Contact> observe = FXCollections.observableArrayList(new Contact("Kanchan Gondiker","One Hundred Dollars","For being awesome","Gurjit Kaur","100.00"),
                                                                        new Contact("Amarjit Kaur","One thousand Dollars","Being my mom","Gurjit Kaur", "1000.00"));
    @FXML
    private TextField payinwords_id;
    @FXML
    private Button addbtn_id;
    @FXML
    private Button deletebtn_id;
    @FXML
    private Button reset_id;
    @FXML
    private Button validate_check;
    @FXML
    private Button clear_id;
    private static final int LIMIT = 8;
    @FXML
    private DatePicker date_id;
                                                      
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    list2.setItems(observe);
    
list2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Contact>() {
    @Override
    public void changed(ObservableValue<? extends Contact> observable,
            Contact oldValue, Contact newValue) {
             name_id.setText(newValue.getName());
        payment_id.setText(newValue.getAmount());
        memo_id.setText(newValue.getMemo());
        signature_id.setText(newValue.getSignature());
        payinwords_id.setText(newValue.getPay_inwords());
       // date_id.setText(newValue.getPay_inwords());
    } 
});
        payment_id.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    // Check if the new character is greater than LIMIT
                    if (payment_id.getText().length() >= LIMIT) {
                        payment_id.setText(payment_id.getText().substring(0, LIMIT));
                    }
                }
            }
        });

    }    

    @FXML
    private void addContact(ActionEvent event) {
        String s = name_id.getText();
        name_id.setText(s);
        String e = payment_id.getText();
        payment_id.setText(e);
        String n = memo_id.getText();
        memo_id.setText(n);
        String em = signature_id.getText();
        signature_id.setText(em); 
        String pay = payinwords_id.getText();
        payinwords_id.setText(em);        
        Contact x = new Contact(s,pay,n,em,e);
        observe.add(x);
        list2.setItems(observe);
        name_id.setText("");
        payment_id.setText("");
        memo_id.setText("");
        signature_id.setText("");
        payinwords_id.setText("");
    }

    @FXML
    private void deletecheck(ActionEvent event) {
              final int selectedIdx = list2.getSelectionModel().getSelectedIndex();
        if (selectedIdx != -1) {
          String itemToRemove = list2.getSelectionModel().getSelectedItem().toString();
 
          final int newSelectedIdx =
            (selectedIdx == list2.getItems().size() - 1)
               ? selectedIdx - 1
               : selectedIdx;
 
          list2.getItems().remove(selectedIdx);
          list2.getSelectionModel().select(newSelectedIdx);
    }
    }

    @FXML
    private void resetcheck(ActionEvent event) {
    observe = FXCollections.observableArrayList(new Contact("Kanchan Gondikar","One Hundred Dollars","For being awesome","Gurjit Kaur","100.00"),
                                                                        new Contact("Amarjit Kaur","One thousand Dollars","Being my mom","Gurjit Kaur", "1000.00"));
 
    list2.setItems(observe);

    }

    @FXML
    private void validate(ActionEvent event) {
            String payment= payment_id.getText();
    String temp = "";
    for (int i = 0; i < 8-payment.length(); i++) {
        temp+= "*";
    }
        temp+= payment;
        
        payment_id.setText(temp);
    }
    

    @FXML
    private void clearFields(ActionEvent event) {
        name_id.setText("");
        payment_id.setText("");
        memo_id.setText("");
        signature_id.setText("");
        payinwords_id.setText("");
    }

    public static class Contact {

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return the pay_inwords
         */
        public String getPay_inwords() {
            return pay_inwords;
        }

        /**
         * @param pay_inwords the pay_inwords to set
         */
        public void setPay_inwords(String pay_inwords) {
            this.pay_inwords = pay_inwords;
        }

        /**
         * @return the memo
         */
        public String getMemo() {
            return memo;
        }

        /**
         * @param memo the memo to set
         */
        public void setMemo(String memo) {
            this.memo = memo;
        }

        /**
         * @return the signature
         */
        public String getSignature() {
            return signature;
        }

        /**
         * @param signature the signature to set
         */
        public void setSignature(String signature) {
            this.signature = signature;
        }

        /**
         * @return the amount
         */
        public String getAmount() {
            return amount;
        }

        /**
         * @param amount the amount to set
         */
        public void setAmount(String amount) {
            this.amount = amount;
        }
    private String name;
    private String pay_inwords;
    private String memo;
    private String signature;
    private String amount;
    private Date date;
    
    private Contact(String name, String payment_inwords, String memo, String Sig, String payment) {
      this.name = new String(name);
      this.pay_inwords = new String(payment_inwords);
      this.memo = new String(memo);
      this.signature = new String(Sig);
      this.amount = new String(payment);
    }
           @Override
public String toString(){
    return (this.getName());
}

    
    }
}
