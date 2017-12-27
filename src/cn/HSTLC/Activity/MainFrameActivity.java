package cn.HSTLC.Activity;

import cn.HSTLC.ToolConst.Const;
import cn.HSTLC.UI.MainFrame;

public class MainFrameActivity implements Runnable {

    private MainFrame mainFrame;
    private String tempStaffInfoToAvoidMainFrameExecuteRepeat = Const.NoResult;  //创建临时储存员工数据的字符串，作为避免主窗体界面内容重复刷新的重要判断标志

    public MainFrameActivity(){
        mainFrame = new MainFrame();
    }

    @Override
    public void run() {
        while (true) {      //循环执行两项监听
            while (true){   //监听用户是否点击运行
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(mainFrame.isRun()){
                    MainActivity.mainFrameIsClickRunButton = true;
                    break;
                }
            }
            while (true) {  //监听用户是否点击停止
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!mainFrame.isRun()) {
                    MainActivity.mainFrameIsClickRunButton = false;
                    break;
                }
                if(!tempStaffInfoToAvoidMainFrameExecuteRepeat.equals(MainActivity.staffInfo_From_DBActivity)){
                    tempStaffInfoToAvoidMainFrameExecuteRepeat = MainActivity.staffInfo_From_DBActivity;
                    mainFrame.haveCardUI(tempStaffInfoToAvoidMainFrameExecuteRepeat);       //调用有卡时的UI，并装载员工信息
                }
            }
        }
    }
}
