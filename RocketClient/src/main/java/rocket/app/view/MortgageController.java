package rocket.app.view;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	@FXML TextField txtCreditScore;
	@FXML TextField txtMortgageAmt;
	@FXML Label CalculatedPay;
	@FXML TextField txtIncome;
	@FXML TextField txtExpenses;
	@FXML TextField txtHouseCost;
	@FXML ComboBox cmbTerm;
	private TextField txtNew;
	
	private MainApp mainApp;
	

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Message Here...");
		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText(txtNew.getText());
		alert.showAndWait().ifPresent(rs -> {
		    if (rs == ButtonType.OK) {
		        System.out.println("Pressed OK.");
		    }
		});
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		CalculatedPay.setText(lRequest.getdPayment());
		txtCreditScore.setText(lRequest.getiCreditScore());
		txtMortgageAmt.setText(lRequest.getdAmount() - lRequest.getiDownPayment());
		txtIncome.setText(lRequest.getIncome());
		txtExpenses.setText(lRequest.getExpenses());
		txtHouseCost.setText(lRequest.getdAmount());
		cmbTerm.setTooltip(lRequest.getiTerm());
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		
		
	}
}
