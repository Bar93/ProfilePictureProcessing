import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class MainPanel extends JPanel {

    private ProfilePicture originalImage;
    private ProfilePicture processingImage;
    private JTextField firstName;
    private JTextField lastName;
    private JLabel originalPic;
    private JLabel processedPic;


    public MainPanel() {
        this.setLayout(null);
        this.setBounds(Constant.PANEL_BUTTON_X, Constant.PANEL_BUTTON_Y, Constant.PANEL_BUTTON_WIDTH, Constant.PANEL_BUTTON_HEIGHT);
        this.setBackground(Color.DARK_GRAY);
        this.originalImage = new ProfilePicture(Constant.PATH_EMPTY_IMAGE,Constant.PICTURE_X,Constant.PICTURE_Y,Constant.PICTURE_WIDTH,Constant.PICTURE_HEIGHT);
        this.processingImage = new ProfilePicture(Constant.PATH_EMPTY_IMAGE,Constant.PICTURE_X*25,Constant.PICTURE_Y,Constant.PICTURE_WIDTH,Constant.PICTURE_HEIGHT);
        this.originalPic = new JLabel();
        this.originalPic.setBounds(this.originalImage.getX(),this.originalImage.getY(),this.originalImage.getWidth(),this.originalImage.getHeight());
        ImageIcon originalIcon = new ImageIcon(this.originalImage.getImage());
        this.originalPic.setIcon(originalIcon);
        this.add(this.originalPic);
        this.processedPic = new JLabel();
        this.processedPic.setBounds(this.processingImage.getX(),this.processingImage.getY(),this.processingImage.getWidth(),this.processingImage.getHeight());
        ImageIcon processedIcon = new ImageIcon(this.processingImage.getImage());
        this.processedPic.setIcon(processedIcon);
        this.add(this.processedPic);
        addButtonAndLabel();
        this.setVisible(true);
    }

    public void addButtonAndLabel (){
        ImageIcon processedIcon = new ImageIcon(this.processingImage.getImage());
        JButton grayScaleButton = new JButton("Gray Scale");
        grayScaleButton.setBounds(Constant.BUTTON_X,Constant.BUTTON_Y,Constant.BUTTON_WIDTH,Constant.BUTTON_HEIGHT);
        grayScaleButton.addActionListener((e) -> {
            this.processingImage.grayScale();
            this.processingImage = new ProfilePicture(Constant.PATH_PROCESSING_IMAGE,Constant.PICTURE_X*25,Constant.PICTURE_Y,Constant.PICTURE_WIDTH,Constant.PICTURE_HEIGHT);
            processedIcon.setImage(this.processingImage.getImage());
            this.processedPic.setIcon(processedIcon);
            this.add(this.processedPic);
            this.repaint();
        });
        JButton colorRightButton = new JButton("Shift Color Right");
        colorRightButton.setBounds(Constant.BUTTON_X*2+Constant.BUTTON_SPACE_X,Constant.BUTTON_Y,Constant.BUTTON_WIDTH,Constant.BUTTON_HEIGHT);
        colorRightButton.addActionListener((e) -> {
            this.processingImage.colorShiftRight();
            this.processingImage = new ProfilePicture(Constant.PATH_PROCESSING_IMAGE,Constant.PICTURE_X*25,Constant.PICTURE_Y,Constant.PICTURE_WIDTH,Constant.PICTURE_HEIGHT);
            processedIcon.setImage(this.processingImage.getImage());
            this.processedPic.setIcon(processedIcon);
            this.add(this.processedPic);
            this.repaint();
        });
        JButton colorLeftButton = new JButton("Shift Color Left");
        colorLeftButton.setBounds(Constant.BUTTON_X,Constant.BUTTON_Y+Constant.BUTTON_SPACE_Y,Constant.BUTTON_WIDTH,Constant.BUTTON_HEIGHT);
        colorLeftButton.addActionListener((e) -> {
            this.processingImage.colorShiftLeft();
            this.processingImage = new ProfilePicture(Constant.PATH_PROCESSING_IMAGE,Constant.PICTURE_X*25,Constant.PICTURE_Y,Constant.PICTURE_WIDTH,Constant.PICTURE_HEIGHT);
            processedIcon.setImage(this.processingImage.getImage());
            this.processedPic.setIcon(processedIcon);
            this.add(this.processedPic);
            this.repaint();

        });
        JButton mirrorButton = new JButton("Mirror");
        mirrorButton.setBounds(Constant.BUTTON_X*2+Constant.BUTTON_SPACE_X,Constant.BUTTON_Y+Constant.BUTTON_SPACE_Y,Constant.BUTTON_WIDTH,Constant.BUTTON_HEIGHT);
        mirrorButton.addActionListener((e) -> {
            this.processingImage.mirror();
            this.processingImage = new ProfilePicture(Constant.PATH_PROCESSING_IMAGE,Constant.PICTURE_X*25,Constant.PICTURE_Y,Constant.PICTURE_WIDTH,Constant.PICTURE_HEIGHT);
            processedIcon.setImage(this.processingImage.getImage());
            this.processedPic.setIcon(processedIcon);
            this.add(this.processedPic);
            this.repaint();
        });
        JButton borderButton = new JButton("Border");
        borderButton.setBounds(Constant.BUTTON_X,Constant.BUTTON_Y+Constant.BUTTON_SPACE_Y*2,Constant.BUTTON_WIDTH,Constant.BUTTON_HEIGHT);
        borderButton.addActionListener((e) -> {
            this.processingImage.border();
            this.processingImage = new ProfilePicture(Constant.PATH_PROCESSING_IMAGE,Constant.PICTURE_X*25,Constant.PICTURE_Y,Constant.PICTURE_WIDTH,Constant.PICTURE_HEIGHT);
            processedIcon.setImage(this.processingImage.getImage());
            this.processedPic.setIcon(processedIcon);
            this.add(this.processedPic);
            this.repaint();
        });
        JButton negativeButton = new JButton("Negative");
        negativeButton.setBounds(Constant.BUTTON_X*2+Constant.BUTTON_SPACE_X,Constant.BUTTON_Y+Constant.BUTTON_SPACE_Y*2,Constant.BUTTON_WIDTH,Constant.BUTTON_HEIGHT);
        negativeButton.addActionListener((e) -> {
            this.processingImage.negative();
            this.processingImage = new ProfilePicture(Constant.PATH_PROCESSING_IMAGE,Constant.PICTURE_X*25,Constant.PICTURE_Y,Constant.PICTURE_WIDTH,Constant.PICTURE_HEIGHT);
            processedIcon.setImage(this.processingImage.getImage());
            this.processedPic.setIcon(processedIcon);
            this.add(this.processedPic);
            this.repaint();
        });
        JButton originalButton = new JButton("Original");
        originalButton.setBounds(Constant.BUTTON_X*2+Constant.BUTTON_SPACE_X,Constant.BUTTON_Y-Constant.BUTTON_SPACE_Y,Constant.BUTTON_WIDTH,Constant.BUTTON_HEIGHT);
        originalButton.addActionListener((e) -> {
            this.processingImage = new ProfilePicture(Constant.PATH_ORIGINAL_IMAGE,Constant.PICTURE_X*25,Constant.PICTURE_Y,Constant.PICTURE_WIDTH,Constant.PICTURE_HEIGHT);
            processedIcon.setImage(this.processingImage.getImage());
            this.processedPic.setIcon(processedIcon);
            this.add(this.processedPic);
            this.repaint();

        });
        JSlider brightness = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
        brightness.setBounds(Constant.BUTTON_X,Constant.BUTTON_Y+Constant.BUTTON_SPACE_Y*3,Constant.BUTTON_WIDTH*2,Constant.BUTTON_HEIGHT);
        brightness.setMinorTickSpacing(1);
        brightness.setMajorTickSpacing(10);
        brightness.setPaintTicks(true);
        brightness.setPaintLabels(true);
        brightness.addChangeListener(e -> {
                this.processingImage.setBrightness(brightness.getValue());
                this.processingImage = new ProfilePicture(Constant.PATH_PROCESSING_IMAGE,Constant.PICTURE_X*25,Constant.PICTURE_Y,Constant.PICTURE_WIDTH,Constant.PICTURE_HEIGHT);
                processedIcon.setImage(this.processingImage.getImage());
                this.processedPic.setIcon(processedIcon);
                this.add(this.processedPic);
                this.repaint();
        });
        this.firstName = new JTextField("First name");
        this.firstName.setBounds(Constant.BUTTON_X,Constant.BUTTON_Y-Constant.BUTTON_SPACE_Y*2,Constant.BUTTON_WIDTH,Constant.BUTTON_HEIGHT);
        this.add(this.firstName);
        this.lastName = new JTextField("Last name");
        this.lastName.setBounds(Constant.BUTTON_X*2+Constant.BUTTON_SPACE_X,Constant.BUTTON_Y-Constant.BUTTON_SPACE_Y*2,Constant.BUTTON_WIDTH,Constant.BUTTON_HEIGHT);
        this.add(this.lastName);
        JButton profileButton = new JButton("Get Profile");
        profileButton.setBounds(Constant.BUTTON_X,Constant.BUTTON_Y-Constant.BUTTON_SPACE_Y,Constant.BUTTON_WIDTH,Constant.BUTTON_HEIGHT);
        this.add(profileButton);
        profileButton.addActionListener((e) -> {
            if (checkUserInput()){
                ChromeDriver driver = scrapping();
                if (checkIfUserExist(driver)){
                    if (!checkIfPrivateUser(driver)){
                        getProfilePicture(driver);
                            this.add(borderButton);
                            this.add(negativeButton);
                            this.add(originalButton);
                            this.add(mirrorButton);
                            this.add(colorRightButton);
                            this.add(grayScaleButton);
                            this.add(colorLeftButton);
                            this.add(brightness);
                            this.repaint();
                    }
                    else {
                        JTextField email = new JTextField("enter email");
                        email.setBounds(Constant.BUTTON_X, Constant.BUTTON_Y, Constant.BUTTON_WIDTH, Constant.BUTTON_HEIGHT);
                        this.add(email);
                        JTextField password = new JTextField("enter password");
                        password.setBounds(Constant.BUTTON_X * 2 + Constant.BUTTON_SPACE_X, Constant.BUTTON_Y, Constant.BUTTON_WIDTH, Constant.BUTTON_HEIGHT);
                        this.add(password);
                        JButton login = new JButton("login");
                        login.setBounds(Constant.BUTTON_X, Constant.BUTTON_Y + Constant.BUTTON_SPACE_Y, Constant.BUTTON_WIDTH, Constant.BUTTON_HEIGHT);
                        this.add(login);
                        repaint();
                        login.addActionListener(e1 -> {
                           if (login(driver,email.getText(),password.getText())) {
                               getProfilePictureAfterLogin(driver);
                               email.setVisible(false);
                               password.setVisible(false);
                               login.setVisible(false);
                               this.add(borderButton);
                               this.add(negativeButton);
                               this.add(originalButton);
                               this.add(mirrorButton);
                               this.add(colorRightButton);
                               this.add(grayScaleButton);
                               this.add(colorLeftButton);
                               this.add(brightness);
                               this.repaint();
                           }

                        });
                    }
                }
            }
//            if (getProfilePicture()) {
//                this.add(borderButton);
//                this.add(negativeButton);
//                this.add(originalButton);
//                this.add(mirrorButton);
//                this.add(colorRightButton);
//                this.add(grayScaleButton);
//                this.add(colorLeftButton);
//                this.add(brightness);
//                this.repaint();
//            }
        });
    }

    public ChromeDriver scrapping (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Documents\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        String fullName = this.firstName.getText() + "." + this.lastName.getText();
        driver.get("https://www.facebook.com/" + fullName);
        return driver;
    }

    public boolean checkIfUserExist(ChromeDriver driver){
        boolean ans = true;
        try {
            WebElement checkProfile = driver.findElement(By.xpath("//i[@class=\"mvl img sp_8s3dp67SKVi sx_dc275c\"]"));
            if (checkProfile.isDisplayed()) {
                ans = false;
                driver.close();
                this.firstName.setText("user didnt found");
                this.lastName.setText("try again");
            }
        }
        catch (Exception e1){
            e1.printStackTrace();
        }

        return ans;
    }

    public boolean checkIfPrivateUser (ChromeDriver driver){
        boolean ans = false;
        try {
            WebElement privateProfile = driver.findElement(By.xpath("//i[@class=\"_585p img sp_8s3dp67SKVi sx_a7c808\"]"));
            if (privateProfile.isDisplayed()) {
                ans = true;
                this.firstName.setText("this user is private");
                this.lastName.setText("you need to login");
            }
        }catch (Exception e1){
            e1.printStackTrace();
        }
        return ans;
    }

    public void getProfilePicture(ChromeDriver driver){
        try {
                    WebElement profile = driver.findElement(By.xpath("//meta[@property=\"og:image\"]"));
                    URL url = new URL(profile.getAttribute("content"));
                    System.out.println(url);
                    BufferedImage bufferedImage = ImageIO.read(url);
                    ImageIO.write(bufferedImage, "jpg", new File(Constant.PATH_ORIGINAL_IMAGE));
                    ImageIO.write(bufferedImage, "jpg", new File(Constant.PATH_PROCESSING_IMAGE));
                    this.originalImage = new ProfilePicture(Constant.PATH_ORIGINAL_IMAGE, Constant.PICTURE_X, Constant.PICTURE_Y, Constant.PICTURE_WIDTH, Constant.PICTURE_HEIGHT);
                    ImageIcon originalIcon2 = new ImageIcon(this.originalImage.getImage());
                    this.originalPic.setIcon(originalIcon2);
                    this.processingImage = new ProfilePicture(Constant.PATH_ORIGINAL_IMAGE, Constant.PICTURE_X * 25, Constant.PICTURE_Y, Constant.PICTURE_WIDTH, Constant.PICTURE_HEIGHT);
                    ImageIcon processedIcon2 = new ImageIcon(this.processingImage.getImage());
                    this.processedPic.setIcon(processedIcon2);
                    driver.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

    public void getProfilePictureAfterLogin(ChromeDriver driver){
        try {
            WebElement profilePicture = driver.findElement(By.xpath("//a[@class=\"oajrlxb2 gs1a9yip g5ia77u1 mtkw9kbi tlpljxtp qensuy8j ppp5ayq2 goun2846 ccm00jje s44p3ltw mk2mc5f4 rt8b4zig n8ej3o3l agehan2d sk4xxmp2 rq0escxv nhd2j8a9 mg4g778l pfnyh3mw p7hjln8o kvgmc6g5 cxmmr5t8 oygrvhab hcukyx3x tgvbjcpo hpfvmrgz jb3vyjys rz4wbd8a qt6c0cv9 a8nywdso l9j0dhe7 i1ao9s8h esuyzwwr f1sip0of du4w35lb n00je7tq arfg74bv qs9ysxi8 k77z8yql btwxx1t3 abiwlrkh p8dawk7l lzcic4wl oo9gr5id q9uorilb\"]"));
            URL url1 = new URL(profilePicture.getAttribute("href"));
            System.out.println(url1);
            driver.get(String.valueOf(url1));
            profilePicture = driver.findElement(By.xpath("//link[@data-preloader=\"adp_CometPhotoRootContentQueryRelayPreloader_{N}\"]"));
            URL url2 = new URL(profilePicture.getAttribute("href"));
            BufferedImage bufferedImage = ImageIO.read(url2);
            ImageIO.write(bufferedImage, "jpg", new File(Constant.PATH_ORIGINAL_IMAGE));
            ImageIO.write(bufferedImage, "jpg", new File(Constant.PATH_PROCESSING_IMAGE));
            this.originalImage = new ProfilePicture(Constant.PATH_ORIGINAL_IMAGE, Constant.PICTURE_X, Constant.PICTURE_Y, Constant.PICTURE_WIDTH, Constant.PICTURE_HEIGHT);
            ImageIcon originalIcon2 = new ImageIcon(this.originalImage.getImage());
            this.originalPic.setIcon(originalIcon2);
            this.processingImage = new ProfilePicture(Constant.PATH_ORIGINAL_IMAGE, Constant.PICTURE_X * 25, Constant.PICTURE_Y, Constant.PICTURE_WIDTH, Constant.PICTURE_HEIGHT);
            ImageIcon processedIcon2 = new ImageIcon(this.processingImage.getImage());
            this.processedPic.setIcon(processedIcon2);
            driver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public boolean getProfilePicture (){
//        boolean ans = true;
//        if (checkUserInput()) {
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Documents\\chromedriver.exe");
//            ChromeDriver driver = new ChromeDriver();
//            String fullName = this.firstName.getText() + "." + this.lastName.getText();
//            driver.get("https://www.facebook.com/" + fullName);
//            try {
//                WebElement checkProfile = driver.findElement(By.xpath("//i[@class=\"mvl img sp_8s3dp67SKVi sx_dc275c\"]"));
//                if (checkProfile.isDisplayed()) {
//                    ans = false;
//                    driver.close();
//                    this.firstName.setText("user didnt found");
//                    this.lastName.setText("try again");
//                }
//            }
//            catch (Exception e1){
//                e1.printStackTrace();
//            }
//            try {
//                WebElement privateProfile = driver.findElement(By.xpath("//i[@class=\"_585p img sp_8s3dp67SKVi sx_a7c808\"]"));
//                if (privateProfile.isDisplayed()) {
//                    JTextField email = new JTextField("enter email");
//                    email.setBounds(Constant.BUTTON_X, Constant.BUTTON_Y - Constant.BUTTON_SPACE_Y, Constant.BUTTON_WIDTH, Constant.BUTTON_HEIGHT);
//                    this.add(email);
//                    JTextField password = new JTextField("enter password");
//                    password.setBounds(Constant.BUTTON_X * 2 + Constant.BUTTON_SPACE_X, Constant.BUTTON_Y - Constant.BUTTON_SPACE_Y, Constant.BUTTON_WIDTH, Constant.BUTTON_HEIGHT);
//                    this.add(password);
//                    WebElement emailLabel = driver.findElement(By.xpath("//input[@type=\"email\"]"));
//                    WebElement passwordLabel = driver.findElement(By.xpath("//input[@type=\"password\"]"));
//                    JButton login = new JButton("login");
//                    login.setBounds(Constant.BUTTON_X, Constant.BUTTON_Y + Constant.BUTTON_SPACE_Y, Constant.BUTTON_WIDTH, Constant.BUTTON_HEIGHT);
//                    this.add(login);
//                    login.addActionListener(e -> {
//                        emailLabel.sendKeys(email.getText());
//                        passwordLabel.sendKeys(password.getText());
//                    });
//                }
//            }
//            catch (Exception e1){
//                e1.printStackTrace();
//            }
//            if (ans)
//                try {
//                    WebElement profile = driver.findElement(By.xpath("//meta[@property=\"og:image\"]"));
//                    URL url = new URL(profile.getAttribute("content"));
//                    System.out.println(url);
//                    BufferedImage bufferedImage = ImageIO.read(url);
//                    ImageIO.write(bufferedImage, "jpg", new File(Constant.PATH_ORIGINAL_IMAGE));
//                    ImageIO.write(bufferedImage, "jpg", new File(Constant.PATH_PROCESSING_IMAGE));
//                    this.originalImage = new ProfilePicture(Constant.PATH_ORIGINAL_IMAGE, Constant.PICTURE_X, Constant.PICTURE_Y, Constant.PICTURE_WIDTH, Constant.PICTURE_HEIGHT);
//                    ImageIcon originalIcon2 = new ImageIcon(this.originalImage.getImage());
//                    this.originalPic.setIcon(originalIcon2);
//                    this.processingImage = new ProfilePicture(Constant.PATH_ORIGINAL_IMAGE, Constant.PICTURE_X * 25, Constant.PICTURE_Y, Constant.PICTURE_WIDTH, Constant.PICTURE_HEIGHT);
//                    ImageIcon processedIcon2 = new ImageIcon(this.processingImage.getImage());
//                    this.processedPic.setIcon(processedIcon2);
//                    driver.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        else ans = false;
//        return ans;
    //}

    public boolean login (ChromeDriver driver,String email,String password){
        boolean ans = true;
        WebElement emailLabel = driver.findElement(By.xpath("//input[@type=\"email\"]"));
        WebElement passwordLabel = driver.findElement(By.xpath("//input[@type=\"password\"]"));
        WebElement enterButton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        emailLabel.sendKeys(email);
        passwordLabel.sendKeys(password);
        enterButton.click();
        return ans;
    }



    public boolean checkUserInput(){
        boolean ans = true;
        if (this.firstName.getText().equals("First name") ||this.firstName.getText().equals("")||this.firstName.getText().equals("enter correct first name") ){
            this.firstName.setText("enter correct first name");
            ans = false;
        }
        if (this.lastName.getText().equals("Last name") ||this.lastName.getText().equals("")||this.lastName.getText().equals("enter correct last name") ){
            this.lastName.setText("enter correct last name");
            ans = false;
        }
        if (ans){
            for (int i=0;i<this.lastName.getText().length();i++){
                if (!Character.isUpperCase(this.lastName.getText().charAt(i)) &&!Character.isLowerCase(this.lastName.getText().charAt(i))){
                    this.lastName.setText("english only,without space");
                    ans = false;
                    break;
                }
            }
            for (int j=0;j<this.firstName.getText().length();j++){
                if (!Character.isUpperCase(this.firstName.getText().charAt(j)) &&!Character.isLowerCase(this.firstName.getText().charAt(j))){
                    this.firstName.setText("english only,without space");
                    ans = false;
                    break;
                }
            }
        }

        return ans;
    }

}
