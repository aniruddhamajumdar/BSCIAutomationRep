package com.BSC.framework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.BSC.framework.action.BaseTest;

public class PI_Potentials extends BaseTest {

	public PI_Potentials(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "(//table/tbody/tr/th/span)[1]")
	WebElement procedureName;
	@FindBy(how = How.XPATH, using = "//span[text()='EU Procedure Ratios']/following-sibling::span")
	WebElement euProcedureRatioCount;

	@FindBy(how = How.XPATH, using = "(//table/tbody/tr[1]/td[1]/a)[1]")
	WebElement productName;
	
  public void validateProcedure_product() throws InterruptedException{

		if (procedureName.getText().equals("ATHERECTOMY")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("ATHERECTOMY")
					&& productName.getText().equals("Atherectomy")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("BALLOONS .014")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("BALLOONS .014")
					&& productName.getText().equals("Balloons .014")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("BALLOONS .018")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("BALLOONS .018")
					&& productName.getText().equals("Balloons .018")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("BALLOONS .035")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("BALLOONS .035")
					&& productName.getText().equals("Balloons .035")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("BLAND MICROSPHERES")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("BLAND MICROSPHERES")
					&& productName.getText().equals("Bland Microspheres")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("DCB")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("DCB")
					&& productName.getText().equals("DCB")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("DES SFA")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("DES SFA")
					&& productName.getText().equals("DES SFA")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("DETACHABLE COILS")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("DETACHABLE COILS")
					&& productName.getText().equals("Detachable Coils")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("DRUG L MICROSPHERES")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("DRUG L MICROSPHERES")
					&& productName.getText().equals("Drug L Microspheres")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("EMBOLIC PROTECTION")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("EMBOLIC PROTECTION")
					&& productName.getText().equals("Embolic Protection")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("GUIDEWIRES")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("GUIDEWIRES")
					&& productName.getText().equals("PI-Guidewires")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("MICROCATHETERS")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("MICROCATHETERS")
					&& productName.getText().equals("Microcatheters")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("NVI")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("NVI")
					&& productName.getText().equals("NVI")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("OTHERS IO 2")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("OTHERS IO 2")
					&& productName.getText().equals("Others IO 2")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("OTHERS VS 2")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("OTHERS VS 2")
					&& productName.getText().equals("Others VS 2")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("PUSHABLE COILS")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("PUSHABLE COILS")
					&& productName.getText().equals("Pushable Coils")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("PVA PARTICLES")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("PVA PARTICLES")
					&& productName.getText().equals("PVA Particles")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("RF ABLATION")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("RF ABLATION")
					&& productName.getText().equals("RF Ablation")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("STENTS BE")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("STENTS BE")
					&& productName.getText().equals("Stents BE")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("STENTS SE CAROTID")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("STENTS SE CAROTID")
					&& productName.getText().equals("Stents SE Carotid")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("STENTS SE NON-CAROTID")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("STENTS SE NON-CAROTID")
					&& productName.getText().equals("Stents SE Non-Carotid")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
		if (procedureName.getText().equals("THROMBECTOMY")) {
			Assert.assertEquals(euProcedureRatioCount.getText().trim(), "(1)");
			if (procedureName.getText().equals("THROMBECTOMY")
					&& productName.getText().equals("PI-Thrombectomy")) {
				System.out.println(
						"Procedure Name : " + procedureName.getText() + " Product Name : " + productName.getText());
			} else {
				Assert.assertTrue(false, "The Procedure Name and Product Name donot match");
			}
		}
  }
	

}
