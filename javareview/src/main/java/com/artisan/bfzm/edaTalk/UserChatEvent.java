package com.artisan.bfzm.edaTalk;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/1/11 16:04
 * @mark: show me the code , change the world
 */
public class UserChatEvent extends UserOnlineEvent{

    /**
     * ChatEvent需要有聊天的信息
     */
    private final String message;

    public UserChatEvent(User user,String message) {
        super(user);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
    