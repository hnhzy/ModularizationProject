package com.hzy.module_common.utils;

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Describe：ARouter帮助类
 */

public class ARouterUtils {


    /**
     * 根据path返回Fragment
     *
     * @param path path
     * @return fragment
     */
    public static Fragment getFragment(String path) {
        return (Fragment) ARouter.getInstance()
                .build(path)
                .navigation();
    }

//    /**
//     * 根据path返回Activity
//     *
//     * @param path path
//     * @return Activity
//     */
//    public static BaseActivity getActivity(String path) {
//        return (BaseActivity) ARouter.getInstance()
//                .build(path)
//                .navigation();
//    }
}
