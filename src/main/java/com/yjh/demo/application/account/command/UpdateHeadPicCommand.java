package com.yjh.demo.application.account.command;

import com.yjh.demo.application.shared.command.SharedCommand;

/**
 * Created by YJH on 2016/4/12.
 */
public class UpdateHeadPicCommand extends SharedCommand {

    private String handPic;

    public String getHandPic() {
        return handPic;
    }

    public void setHandPic(String handPic) {
        this.handPic = handPic;
    }
}
