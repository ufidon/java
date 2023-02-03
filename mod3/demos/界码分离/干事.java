import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class 干事 {
    @FXML
    private Text idState;
    @FXML
    private TextField 名框;
    @FXML
    private PasswordField 密框;

    @FXML
    protected void 干登入(ActionEvent event) {
        System.out.println("户名:" + 名框.getText() + ",密码:" + 密框.getText());
        if (名框.getText().equals("张三")  && 密框.getText().equals("321456")) {
            idState.setText("登录成功！");
        } else {
            idState.setText("无此人或密码错！");
        }
    }
}
