package com.artisan.group;

import javax.validation.groups.Default;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2022/2/21 23:03
 * @mark: show me the code , change the world
 */

public interface CustomValidateGroup extends Default {

    interface Crud extends CustomValidateGroup {
        interface Create extends Crud {

        }

        interface Update extends Crud {

        }

        interface Query extends Crud {

        }

        interface Delete extends Crud {

        }
    }
}
    